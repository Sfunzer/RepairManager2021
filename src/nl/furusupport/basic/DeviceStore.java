package nl.furusupport.basic;

import java.util.ArrayList;

public class DeviceStore {
    private final ArrayList<Device> buildingDevices;

    public DeviceStore() {
        buildingDevices = new ArrayList<>();
    }


    //Adds a new device to the system. This enables you to track repairs on it.
    public void addDevice(Device newDevice){
        buildingDevices.add(newDevice);
    }

    public ArrayList<Device> getBuildingDevices() {
        return buildingDevices;
    }
}
