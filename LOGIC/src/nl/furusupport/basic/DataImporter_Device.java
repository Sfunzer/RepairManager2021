package nl.furusupport.basic;


import java.io.IOException;
import java.util.List;

public interface DataImporter_Device {

    List<Device> importDataFromExternal() throws IOException;
}