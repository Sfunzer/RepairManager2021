package nl.furusupport.basic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// a device can be anything that you can find in a building and can break.
public class Device {
    private final String deviceName;
    private final int deviceID;
    private final String deviceSerial;

    private int deviceAgeDays;
    private final int deviceLifeSpan;
    private final LocalDate deviceEOL;

    private final String deviceLocation;
    private final List<Repair> deviceRepairs;

    public Device(String deviceName, int deviceID, String deviceSerial, int deviceAgeDays, int deviceLifeSpan, LocalDate deviceEOL,  String deviceLocation){
        //DeviceID generator.

        //basic device details
        this.deviceName = deviceName;
        this.deviceSerial = deviceSerial;

        //lifecycle info for this device
        this.deviceAgeDays = deviceAgeDays;
        this.deviceLifeSpan = deviceLifeSpan;
        this.deviceEOL = deviceEOL;

        //storage data for this device
        this.deviceID = deviceID;
        this.deviceLocation = deviceLocation;

        //List with device repairs.
        deviceRepairs = new ArrayList<>();
    }

    //method used for adding a repair. Before adding, it checks device EOL date and Lifespan statistic, so if device is better of replacing, it'll let you know.
    public String addRepair(Repair newRepair) {
        LocalDate dateCheck = LocalDate.now();
        String returnMessage;
        if (deviceEOL.isBefore(dateCheck) || deviceAgeDays >= deviceLifeSpan){
                returnMessage = "Device is not viable anymore. please replace!";
                return returnMessage;
            }
        if (deviceRepairs.size() != 0){
            returnMessage = "there are " + deviceRepairs.size() + " repairs linked to this device. Please check these while we add your repair for now";
            deviceRepairs.add(newRepair);
            return returnMessage;
        }
        deviceRepairs.add(newRepair);
        returnMessage = "repair added";
        return returnMessage;
    }

    public int getDeviceID() {
        return deviceID;
    }

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public int getDeviceAgeDays() {
        return deviceAgeDays;
    }

    public int getDeviceLifeSpan() {
        return deviceLifeSpan;
    }

    public LocalDate getDeviceEOL() {
        return deviceEOL;
    }

    public List<Repair> getDeviceRepairs() {
        return Collections.unmodifiableList(deviceRepairs);
    }

    @Override
    public String toString() {

        //ToDo rework toString format so it will nicely work with .csv read/write
        /*return "Device{" +
                "deviceName='" + deviceName + '\'' +
                ", deviceID=" + deviceID +
                ", deviceSerial='" + deviceSerial + '\'' +
                ", deviceAgeDays=" + deviceAgeDays +
                ", deviceLifeSpan=" + deviceLifeSpan +
                ", deviceEOL=" + deviceEOL +
                ", deviceLocation='" + deviceLocation + '\'' +
                //", deviceRepairs=" + deviceRepairs +
                '}';


         */
       // return deviceName + " " + deviceID  + ""

        return deviceName + ',' +
                deviceID + ',' +
                deviceSerial + ',' +
                deviceAgeDays + ',' +
                deviceLifeSpan + ',' +
                deviceEOL + ',' +
                deviceLocation
                ;
    }

}
