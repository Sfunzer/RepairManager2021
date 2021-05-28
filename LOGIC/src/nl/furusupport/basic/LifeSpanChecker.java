package nl.furusupport.basic;

public class LifeSpanChecker implements PropertyChecker {

    @Override
    public DeviceState check(Device checkableDevice) {
        if (!(checkableDevice.getDeviceAgeDays() >= checkableDevice.getDeviceLifeSpan())) {
            return DeviceState.DEVICETEST_PASSED;
        } return DeviceState.LIFESPANPASSED;

    }

}
