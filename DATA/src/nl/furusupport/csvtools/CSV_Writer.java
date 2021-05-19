package nl.furusupport.csvtools;


import nl.furusupport.basic.DataExport;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSV_Writer implements DataExport {
    public final String fileName;

    public CSV_Writer(String fileName){
        this.fileName = fileName + ".csv";

    }

    public void writeCSVFile(List dataStore) throws IOException {
        //fileName = fileName + ".csv";

        FileWriter csvWriter = new FileWriter(fileName);

        for (Object dataInserter : dataStore) {
            csvWriter.append(dataInserter.toString());
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();

    }
}
