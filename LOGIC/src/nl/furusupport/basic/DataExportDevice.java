package nl.furusupport.basic;

import java.io.IOException;
import java.util.List;

public interface DataExportDevice {

    void writeCSVFile(List<Device> dataStore) throws IOException;
}


