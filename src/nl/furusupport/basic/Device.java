package nl.furusupport.basic;

import java.util.ArrayList;

// a device can be anything that you can find in a building and can break.
public class Device {
    private final String deviceName;
    private final int deviceID;
    private final String deviceLocation;
    private ArrayList<Repair> deviceRepairs;

    public Device(String deviceName, int deviceID, String deviceLocation){
        this.deviceName = deviceName;
        this.deviceID = deviceID;
        this.deviceLocation = deviceLocation;

        deviceRepairs = new ArrayList<Repair>();
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceName='" + deviceName + '\'' +
                ", deviceID=" + deviceID +
                ", deviceLocation='" + deviceLocation + '\'' +
                '}';
    }
}
