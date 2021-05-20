package nl.furusupport.csvtools;

import nl.furusupport.basic.Device;
import nl.furusupport.basic.DataImportDevice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class CSV_Reader implements DataImportDevice {
    private final ArrayList<Device> importedDataList;
    private final String fileName;

    public CSV_Reader(String fileName) {
        this.fileName = fileName + ".csv";
        importedDataList = new ArrayList<>();
    }

        public ArrayList<Device> importCSV() throws IOException {
        String row;
        String[] data;
        Device dataInput;

        File csvFile = new File(fileName);

        if (csvFile.isFile()) {
            BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
            while ((row = csvReader.readLine()) != null) {
                data = row.split(",");

                dataInput = new Device(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), LocalDate.parse(data[4]), data[5]);

                importedDataList.add(dataInput);
            }
            csvReader.close();
        }
        return importedDataList;
    }
}
