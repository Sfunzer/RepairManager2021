package nl.furusupport.basic;

import java.time.LocalDate;

public class EOLChecker implements PropertyChecker {

    @Override
    public DeviceState check(Device checkableDevice) {
        if (!checkableDevice.getDeviceEOL().isBefore(LocalDate.now())){
            return DeviceState.DEVICETEST_PASSED;
        } return DeviceState.ENDOFLIFEREACHED;
    }
}
