package nl.furusupport.basic;


import java.io.IOException;
import java.util.List;



public interface DataImportDevice {

    List<Device> importCSV() throws IOException;
}