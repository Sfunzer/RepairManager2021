package nl.furusupport.basic.mocks;

import nl.furusupport.basic.DataExporter_Device;
import nl.furusupport.basic.Device;

import java.util.List;

public class deviceListWriterMock implements DataExporter_Device {
    private List<Device> storeTest;

    @Override
    public void writeDataToExternal(List<Device> dataStore) {
        storeTest = dataStore;
    }

    public List<Device> getStoreTest() {
        return storeTest;
    }
}
