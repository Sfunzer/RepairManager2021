package nl.furusupport.csvtools;

import nl.furusupport.basic.Device;
import nl.furusupport.basic.importCSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class DeviceImport implements importCSV {
    private final ArrayList importedDataList;
    //private DeviceBlock dataInput;

    public DeviceImport() {
        importedDataList = new ArrayList();

    }

        public ArrayList importCSV(String fileName) throws IOException {
        fileName = fileName + ".csv";

        String row;
        String[] data;
        Device dataInput;

        File csvFile = new File(fileName);
        if (csvFile.isFile()) {
            // create BufferedReader and read data from csv
            BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
            while ((row = csvReader.readLine()) != null) {
                data = row.split(",");

                dataInput = new Device(
                        data[0],
                        data[1],
                        Integer.parseInt(data[2]),
                        Integer.parseInt(data[3]),
                        LocalDate.parse(data[4]),
                        data[5]);

                importedDataList.add(dataInput);

            }
            csvReader.close();
        }
        return importedDataList;
    }
}
