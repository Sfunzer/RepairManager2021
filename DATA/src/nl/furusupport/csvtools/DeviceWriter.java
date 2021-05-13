package nl.furusupport.csvtools;


import nl.furusupport.basic.writeCSV;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DeviceWriter implements writeCSV {

    public DeviceWriter(){

    }

    public void writeCSVFile(String fileName, List dataStore) throws IOException {
        fileName = fileName + ".csv";

        FileWriter csvWriter = new FileWriter(fileName);

        for (Object dataInserter : dataStore) {
            csvWriter.append(dataInserter.toString());
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();

    }
}
