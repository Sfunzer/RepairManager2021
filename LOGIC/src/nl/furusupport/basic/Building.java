package nl.furusupport.basic;

//A building contains all devices installed. Repairs are kept within a device.

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Building {
    private final String buildingName;
    private final int buildingID;

    private final List<Device> buildingDeviceStore;
    private final PartsWarehouse buildingPartsWarehouse;

    private final DataImport readData;
    private final DataExport writeData;

    private Device updatableDevice;
    private int updatableDevicePosition;

      public Building(String buildingName, Integer buildingID, PartsWarehouse buildingPartsWarehouse, DataImport readData, DataExport writeData) throws IOException {

        buildingDeviceStore = new ArrayList<>();
        this.buildingPartsWarehouse = buildingPartsWarehouse;

        this.buildingName = buildingName;
        this.buildingID = buildingID;

        this.readData = readData;
        this.writeData = writeData;

        importDeviceData();

    }

    private DataState importDeviceData () throws IOException {
        if (buildingDeviceStore.size() == 0){
            buildingDeviceStore.addAll(readData.importCSV());
            return DataState.IMPORT_SUCCEEDED;
        } else {
            return DataState.DATABASE_NOT_EMPTY;
        }
    }


    /*Adding a device to the digital device storage. When adding a device, the system checks if the device isn't already in the system, of if it's life expectations are already exceeded.
    if so, the system will return a string message which will inform you of what is wrong.

    TODO Method contains duplicate code which i'm quite sure is not necessary. also: move the check to device itself
     */
    public DeviceState addDeviceToStore(Device newDevice) {

        if (buildingDeviceStore.size() == 0) {

            if (newDevice.checkDeviceEOLstatus()) { //Now with enum!
                return DeviceState.ENDOFLIFE;
            } else if (newDevice.checkDeviceLifeSpan()){ //Now with enum!
                return DeviceState.LIFESPANPASSED;
            }


        } else {

            for (Device deviceChecker : buildingDeviceStore) {
                if (deviceChecker.getDeviceSerial().equals(newDevice.getDeviceSerial())) {
                    return DeviceState.DUPLICATESERIAL;
                } else if (newDevice.checkDeviceEOLstatus()){
                    return DeviceState.ENDOFLIFE;
                } else if (newDevice.checkDeviceLifeSpan()){
                    return DeviceState.LIFESPANPASSED;
                }
            }
        }
        buildingDeviceStore.add(newDevice);
        return DeviceState.ADDED;
    }


    public void exportData() throws IOException { writeData.writeCSVFile(buildingDeviceStore); }


    public List<Device> getBuildingDeviceStore() {
        return  Collections.unmodifiableList(buildingDeviceStore);
    }

    public Device getDevice (String serialNumber) { //needed?
        for (Device searchedDevice : buildingDeviceStore) {
            if (searchedDevice.getDeviceSerial().equals(serialNumber)){
                return searchedDevice;
            }
        }
        return null;
    }


       /* public void getUpdatableDevice (String serialNumber) { //TODO perhaps we can recode this to get/store a serialnumber with simple integer selection.
        for (Device searchedDevice : buildingDeviceStore) {
            if (searchedDevice.getDeviceSerial().equals(serialNumber)){

                //updatableDevice = searchedDevice;
                //updatableDevicePosition = buildingDeviceStore.indexOf(searchedDevice);

                //return updatableDevice.toString() + "\n position in array: " + updatableDevicePosition;
            }
        }
        return "no match";
    }
    */


    public String getBuildingName() { return buildingName; }

    public int getBuildingID() { return buildingID; }

    @Override
    public String toString() {
        return "Building{" +
                "buildingName='" + buildingName + '\'' +
                ", buildingID=" + buildingID +
                ", plazaDeviceStore=" + buildingDeviceStore +
                ", plazaPartsWarehouse=" + buildingPartsWarehouse +
                '}';
    }
}