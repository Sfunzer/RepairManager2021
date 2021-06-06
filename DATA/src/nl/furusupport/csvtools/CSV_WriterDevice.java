package nl.furusupport.csvtools;


import nl.furusupport.basic.DataExporter_Device;
import nl.furusupport.basic.Device;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSV_WriterDevice implements DataExporter_Device {
    public final String fileName;

    public CSV_WriterDevice(String fileName){
        this.fileName = fileName + ".csv";

    }

    public void writeDataToExternal(List<Device> dataStore) throws IOException {

        FileWriter csvWriter = new FileWriter(fileName);

        for (Object dataInserter : dataStore) {
            csvWriter.append(dataInserter.toString());
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();

    }
}
