package nl.furusupport.basic;

import java.io.IOException;
import java.util.List;

public interface DataExporter_Device {

    void writeDataToExternal(List<Device> dataStore) throws IOException;
}


