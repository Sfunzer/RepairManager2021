package nl.furusupport.basic.mocks;

import nl.furusupport.basic.DataImporter_Device;
import nl.furusupport.basic.Device;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class deviceListReaderMock implements DataImporter_Device {
    private final List<Device> mockDeviceList;

    public deviceListReaderMock() {
        mockDeviceList = new ArrayList<>();

        mockDeviceList.add(new Device ("Xerox Altalink B8100", "43563456", 100, 150, LocalDate.of(2022,1,1),  "CopyRoom"));
        mockDeviceList.add(new Device("Iphone 6", "xyz", 0, 200, LocalDate.of(2020,1,1),"Home"));
        mockDeviceList.add(new Device ("Cisco Telephone", "aklj789", 40, 140, LocalDate.of(2023,1,1), "Reception"));
        mockDeviceList.add(new Device("Apple MacMini M1", "XGA678", 0, 800, LocalDate.of(2025, 1, 1), "SoundOffice"));
    }

    @Override
    public List<Device> importDataFromExternal() {
        return Collections.unmodifiableList(mockDeviceList);
    }
}

