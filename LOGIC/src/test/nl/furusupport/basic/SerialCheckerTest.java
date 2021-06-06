package nl.furusupport.basic;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SerialCheckerTest {

    @Test
    void SerialTest() {
        List<Device> mockDeviceList = new ArrayList<>();

        mockDeviceList.add(new Device ("Xerox Altalink B8100", "43563456", 100, 150, LocalDate.of(2022,1,1),  "CopyRoom"));
        mockDeviceList.add(new Device("Iphone 6", "xyz", 0, 200, LocalDate.of(2020,1,1),"Home"));
        mockDeviceList.add(new Device ("Cisco Telephone", "aklj789", 40, 140, LocalDate.of(2023,1,1), "Reception"));
        mockDeviceList.add(new Device("Apple MacMini M1", "XGA678", 0, 800, LocalDate.of(2025, 1, 1), "SoundOffice"));

        Device mockDevice = new Device("Iphone 6", "xyz", 0, 200, LocalDate.of(2020,1,1),"Home");
        PropertyChecker testSerial = new SerialChecker(mockDeviceList);

                assertEquals(DeviceState.DUPLICATESERIAL,testSerial.check(mockDevice));
    }

}