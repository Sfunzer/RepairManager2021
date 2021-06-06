package nl.furusupport.basic;
import nl.furusupport.basic.mocks.deviceListReaderMock;
import nl.furusupport.basic.mocks.deviceListWriterMock;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BuildingTest {
    deviceListWriterMock writeMock = new deviceListWriterMock();
    deviceListReaderMock readMock = new deviceListReaderMock();

    @Test
    void BuildingDeviceReadListTest() throws IOException {


        Building testPlaza = new Building("testPlaza", 2, new PartsWarehouse(), readMock, writeMock);

        ArrayList<Device> mockDeviceList = new ArrayList<>();
        mockDeviceList.add(new Device ("Xerox Altalink B8100", "43563456", 100, 150, LocalDate.of(2022,1,1),  "CopyRoom"));
        mockDeviceList.add(new Device("Iphone 6", "xyz", 0, 200, LocalDate.of(2020,1,1),"Home"));
        mockDeviceList.add(new Device ("Cisco Telephone", "aklj789", 40, 140, LocalDate.of(2023,1,1), "Reception"));
        mockDeviceList.add(new Device("Apple MacMini M1", "XGA678", 0, 800, LocalDate.of(2025, 1, 1), "SoundOffice"));

                assertEquals(mockDeviceList.get(3).toString(),testPlaza.getBuildingDeviceStore().get(3).toString());

    }

    @Test
    void BuildingDeviceWriteListTest() throws IOException {
        Building testPlaza2 = new Building("testPlaza2", 3, new PartsWarehouse(), readMock, writeMock);
        testPlaza2.exportData();

        assertEquals(writeMock.getStoreTest().get(2).toString(), testPlaza2.getBuildingDeviceStore().get(2).toString());

    }
}