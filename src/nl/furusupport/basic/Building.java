package nl.furusupport.basic;

//A building contains everything related to repairs: The devices that may be broken, the parts needed to repair them. and the information about the repair itself

import java.util.ArrayList;

public class Building {
    private final String buildingName;
    private final int buildingID;
    private final Randomnator IdGenerator;
    // private ArrayList buildingRooms;
    private ArrayList<Device> buildingDevices;
    private ArrayList<Part> buildingPartsWarehouse;
    private ArrayList returnList;

    private int newRandomID;
    private Device newDevice;
    private Part newPart;


    public Building(String buildingName) {
        IdGenerator = new Randomnator();

        buildingDevices = new ArrayList<>();
        buildingPartsWarehouse = new ArrayList<>();
        returnList = new ArrayList();

        this.buildingName = buildingName;
        this.buildingID = generateID();

    }
        //Adds a new device to the system. This enables you to track repairs on it.
    public void addDevice(String deviceName, String deviceLocation){

        newRandomID = IdGenerator.RandomnizerInt();
        newDevice = new Device(deviceName, newRandomID, deviceLocation);
        buildingDevices.add(newDevice);
    }

    public void addPart(String partName, String partSupplierNumber, String partInfo){

        newRandomID = IdGenerator.RandomnizerInt();
        newPart = new Part(partName, newRandomID, partSupplierNumber, partInfo);
        buildingPartsWarehouse.add(newPart);
    }

    public ArrayList getOverview (int whichList) {

        if (whichList == 1) {
            returnList = buildingDevices;
        } else if (whichList == 2) {
            returnList = buildingPartsWarehouse;
        }
        return returnList;
    }

        //method to generate a custom integer which can be used as an ID number.
    public int generateID() {
        newRandomID = IdGenerator.RandomnizerInt();
        return newRandomID;
    }
}