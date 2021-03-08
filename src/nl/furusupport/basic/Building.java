package nl.furusupport.basic;

//A building contains everything related to repairs: The devices that may be broken, the parts needed to repair them. and the information about the repair itself

import java.util.ArrayList;

public class Building {
    private final String buildingName;
    private final int buildingID;
    private final Randomnator IdGenerator;
    // private ArrayList buildingRooms;


    private ArrayList<Device> buildingDevices;  //move?
    //private ArrayList<Part> buildingPartsWarehouse;     //move?


    private ArrayList returnList;


    private int newRandomID;
    private Device newDevice;       //needed for initiation?



    public Building(String buildingName) {
        IdGenerator = new Randomnator();

        buildingDevices = new ArrayList<>();
        //buildingPartsWarehouse = new ArrayList<>();
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


    public ArrayList getOverview (int whichList) {

        if (whichList == 1) {
            returnList = buildingDevices;
        } else if (whichList == 2) {
            returnList = ;
        }
        return returnList;
    }

        //method to generate a custom integer which can be used as an ID number.
    public int generateID() {
        newRandomID = IdGenerator.RandomnizerInt();
        return newRandomID;
    }
}