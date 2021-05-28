package nl.furusupport.basic;

import java.util.List;

public class SerialChecker implements PropertyChecker {
    List<Device> deviceList;

    public SerialChecker(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    @Override
    public DeviceState check(Device checkableDevice) {
        for (Device deviceFromList:deviceList) {
            if (checkableDevice.getDeviceSerial().equals(deviceFromList.getDeviceSerial())){
                return DeviceState.DUPLICATESERIAL;
            }

        }
      return DeviceState.DEVICETEST_PASSED;
    }
    //TODO This doesn't work. Why?!
    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }
}

