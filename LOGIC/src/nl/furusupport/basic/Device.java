package nl.furusupport.basic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Device {

    private final String deviceName;
    private final String deviceSerial;

    private final int deviceAgeDays;
    private final int deviceLifeSpan;
    private final LocalDate deviceEOL;

    private final String deviceLocation;
    private final List<Repair> deviceRepairs;

    public Device(String deviceName, String deviceSerial, int deviceAgeDays, int deviceLifeSpan, LocalDate deviceEOL,  String deviceLocation){

        this.deviceName = deviceName;
        this.deviceSerial = deviceSerial;

        this.deviceAgeDays = deviceAgeDays;
        this.deviceLifeSpan = deviceLifeSpan;
        this.deviceEOL = deviceEOL;

        this.deviceLocation = deviceLocation;

        deviceRepairs = new ArrayList<>();
    }
    //TODO: Insert devicecheckers over here.
    public DeviceState addRepair(Repair newRepair) {
        LocalDate dateCheck = LocalDate.now();

        if (deviceEOL.isBefore(dateCheck) || deviceAgeDays >= deviceLifeSpan){
                return DeviceState.LIFESPANPASSED;
            }
        if (deviceRepairs.size() != 0){
            deviceRepairs.add(newRepair);
            return DeviceState.OTHERREPAIRS;
        }
        deviceRepairs.add(newRepair);
        return DeviceState.ADDED;
    }


    public Repair getLastRepair() {
        return deviceRepairs.get(deviceRepairs.size() - 1);
    }

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public List<Repair> getDeviceRepairs() { return Collections.unmodifiableList(deviceRepairs); }

    public int getDeviceAgeDays() { return deviceAgeDays; }

    public int getDeviceLifeSpan() {
        return deviceLifeSpan;
    }

    public LocalDate getDeviceEOL() {
        return deviceEOL;
    }


    @Override
    public String toString() {
        return deviceName + ',' +
                deviceSerial + ',' +
                deviceAgeDays + ',' +
                deviceLifeSpan + ',' +
                deviceEOL + ',' +
                deviceLocation
                ;
    }

}
