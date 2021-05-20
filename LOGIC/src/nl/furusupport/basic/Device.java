package nl.furusupport.basic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// a device can be anything that you can find in a building and can break.
public class Device {

    private final String deviceName;
    private final String deviceSerial;

    private final int deviceAgeDays;
    private final int deviceLifeSpan;
    private final LocalDate deviceEOL;

    private final String deviceLocation;
    private final List<Repair> deviceRepairs;

    public Device(String deviceName, String deviceSerial, int deviceAgeDays, int deviceLifeSpan, LocalDate deviceEOL,  String deviceLocation){

        //basic device details
        this.deviceName = deviceName;
        this.deviceSerial = deviceSerial;

        //lifecycle info for this device
        this.deviceAgeDays = deviceAgeDays;
        this.deviceLifeSpan = deviceLifeSpan;
        this.deviceEOL = deviceEOL;

        //storage data for this device
        this.deviceLocation = deviceLocation;

        //List with device repairs.
        deviceRepairs = new ArrayList<>();
    }

    //method used for adding a repair. Before adding, it checks device EOL date and Lifespan statistic, so if device is better of replacing, it'll let you know.
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


    public boolean checkDeviceEOL_status() { //is true when EOL has passed || EOL = true
        LocalDate dateCheck = LocalDate.now();
        return deviceEOL.isBefore(dateCheck);
    }

    public boolean checkDeviceLifeSpan() { // is true when max lifespan has passed
        return deviceAgeDays >= deviceLifeSpan;
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

    public List<Repair> getDeviceRepairs() {
        return Collections.unmodifiableList(deviceRepairs);
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
