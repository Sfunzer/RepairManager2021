package nl.furusupport.basic;

//A building contains all devices installed. Repairs are kept within a device.

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Building {
    private final String buildingName;
    private final int buildingID;
    private final Randomnator IdGenerator;

    private final List<Device> buildingDeviceStore;
    private final PartsWarehouse buildingPartsWarehouse;

    private List returnList;

    //Class constructor
    public Building(String buildingName) {
        IdGenerator = new Randomnator();

        buildingDeviceStore = new ArrayList<>();
        buildingPartsWarehouse = new PartsWarehouse();
        returnList = new ArrayList();

        this.buildingName = buildingName;
        this.buildingID = IdGenerator.RandomnizerInt();

    }

    //Adding parts to partswarehouse
    public void addPartToWarehouse(Part newPart){
        buildingPartsWarehouse.addPart(newPart);
    }

    /*Adding a device to the digital device storage. When adding a device, the system checks if the device isn't already in the system, of if it's life expectations are already exceeded.
    if so, the system will return a string message which will inform you of what is wrong.

    TODO Method contains duplicate code which i'm quite sure is not necessary.
     */
    public String addDeviceToStore(Device newDevice) {
        LocalDate dateCheck = LocalDate.now();

        String returnMessage;
        if (buildingDeviceStore.size() == 0){

            if (newDevice.getDeviceEOL().isBefore(dateCheck)) {
                returnMessage = "device passed E.O.L.";
                return returnMessage;
            } else if (newDevice.getDeviceAgeDays() >= newDevice.getDeviceLifeSpan()){
                returnMessage = "device passed LifeSpan.";
                return returnMessage;
            }

            buildingDeviceStore.add(newDevice);
            returnMessage = "device stored";


        } else {

            for (Device deviceChecker : buildingDeviceStore) {
                if (deviceChecker.getDeviceSerial().equals(newDevice.getDeviceSerial())) {
                    returnMessage = "serial Already in system";
                    return returnMessage;
                } else if (newDevice.getDeviceEOL().isBefore(dateCheck)){
                    returnMessage = "device passed E.O.L.";
                    return returnMessage;
                } else if (newDevice.getDeviceAgeDays() >= newDevice.getDeviceLifeSpan()){
                    returnMessage = "device passed LifeSpan.";
                    return returnMessage;
                }

            }
            returnMessage = "device stored";
            buildingDeviceStore.add(newDevice);
        }

        return returnMessage;
    }



    //method to add a repair. Repairs are stored within devices, so they are always linked.
    public String addRepairToDevice( String deviceSerial, Repair newDevicerepair) {
        String returnMessage = "nothing happened yet";
        for (Device whichDevice:buildingDeviceStore) {
            if (whichDevice.getDeviceSerial().equals(deviceSerial)) {
                returnMessage = whichDevice.addRepair(newDevicerepair);
            }
        }
        return  returnMessage;
    }



    //a simple method to choose which list you want to return for viewing.
    public List getOverview (int whichList, String deviceSerial) {

        if (whichList == 1) {
            returnList = buildingDeviceStore;
        } else if (whichList == 2) {
            returnList = buildingPartsWarehouse.getBuildingPartsWarehouse();
        } else if (whichList == 3) {

            for (Device storedDevice:buildingDeviceStore) {
                /*returnList = new ArrayList();
                TODO find a way to erase list when starting this part of the method

                 */
                if (storedDevice.getDeviceSerial().equals(deviceSerial)){
                    returnList = storedDevice.getDeviceRepairs();
                }
            }
        }
        return Collections.unmodifiableList(returnList);
    }


    @Override
    public String toString() {
        return "Building{" +
                "buildingName='" + buildingName + '\'' +
                ", buildingID=" + buildingID +
                ", IdGenerator=" + IdGenerator +
                ", plazaDeviceStore=" + buildingDeviceStore +
                ", plazaPartsWarehouse=" + buildingPartsWarehouse +
                ", returnList=" + returnList +
                '}';
    }
}