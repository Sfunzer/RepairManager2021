package nl.furusupport.basic;

import java.util.ArrayList;

// a device can be anything that you can find in a building and can break.
public class Device {
    private final String deviceName;
    private final int deviceID;
    private final String deviceLocation;
    private final ArrayList<Repair> deviceRepairs;

    private final Randomnator IdGenerator;

    public Device(String deviceName, String deviceLocation){
        IdGenerator = new Randomnator();

        this.deviceName = deviceName;
        this.deviceID = IdGenerator.RandomnizerInt();
        this.deviceLocation = deviceLocation;

        deviceRepairs = new ArrayList<>();
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
