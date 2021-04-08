package nl.furusupport.basic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// a device can be anything that you can find in a building and can break.
public class Device {
    private final String deviceName;
    private final int deviceID;
    private final String deviceSerial;

    private final int deviceLifeSpan;
    private final LocalDate deviceEOL;

    private final String deviceLocation;
    private final List<Repair> deviceRepairs;

    public Device(String deviceName, String deviceSerial, int deviceLifeSpan, LocalDate deviceEOL,  String deviceLocation){
        Randomnator idGenerator = new Randomnator();

        this.deviceName = deviceName;
        this.deviceSerial = deviceSerial;
        this.deviceLifeSpan = deviceLifeSpan;
        this.deviceEOL = deviceEOL;
        this.deviceID = idGenerator.RandomnizerInt();
        this.deviceLocation = deviceLocation;

        deviceRepairs = new ArrayList<>();
    }

    public void addRepair(Repair newRepair) {
        deviceRepairs.add(newRepair);

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
