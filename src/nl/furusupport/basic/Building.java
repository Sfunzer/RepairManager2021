package nl.furusupport.basic;

//A building contains everything related to repairs: The devices that may be broken, the parts needed to repair them. and the information about the repair itself

import java.util.ArrayList;

public class Building {
    private final String buildingName;
    private final int buildingID;
    private final Randomnator IdGenerator;

    private final DeviceStore plazaDeviceStore;
    private final PartsWarehouse plazaPartsWarehouse;

    private ArrayList returnList;


    public Building(String buildingName) {
        IdGenerator = new Randomnator();

        plazaDeviceStore  = new DeviceStore();
        plazaPartsWarehouse = new PartsWarehouse();
        returnList = new ArrayList();

        this.buildingName = buildingName;
        this.buildingID = IdGenerator.RandomnizerInt();

    }

    public void addPartToWarehouse(Part newPart){
        plazaPartsWarehouse.addPart(newPart);
    }


    public void addDeviceToStore(Device newDevice){
        plazaDeviceStore.addDevice(newDevice);
    }

    public ArrayList getOverview (int whichList) {

        if (whichList == 1) {
            returnList = plazaDeviceStore.getBuildingDevices();
        } else if (whichList == 2) {
            returnList = plazaPartsWarehouse.getBuildingPartsWarehouse();
        }
        return returnList;
    }

    @Override
    public String toString() {
        return "Building{" +
                "buildingName='" + buildingName + '\'' +
                ", buildingID=" + buildingID +
                ", IdGenerator=" + IdGenerator +
                ", plazaDeviceStore=" + plazaDeviceStore +
                ", plazaPartsWarehouse=" + plazaPartsWarehouse +
                ", returnList=" + returnList +
                '}';
    }
}