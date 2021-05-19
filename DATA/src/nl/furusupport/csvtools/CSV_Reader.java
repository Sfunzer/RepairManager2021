package nl.furusupport.csvtools;

import nl.furusupport.basic.Device;
import nl.furusupport.basic.DataImport;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class CSV_Reader implements DataImport {
    private final ArrayList importedDataList;
    private final String fileName;
    //private DeviceBlock dataInput;

    public CSV_Reader(String fileName) {
        this.fileName = fileName + ".csv";
        importedDataList = new ArrayList();

    }

        public ArrayList importCSV() throws IOException {
        //fileName = fileName + ".csv";

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
