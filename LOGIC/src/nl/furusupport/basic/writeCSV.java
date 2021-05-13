package nl.furusupport.basic;

import java.io.IOException;
import java.util.List;

public interface writeCSV {

    void writeCSVFile(String fileName, List dataStore) throws IOException;
}

//ToDo make seperate file preperation method thingy?
