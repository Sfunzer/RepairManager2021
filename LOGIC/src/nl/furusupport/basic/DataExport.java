package nl.furusupport.basic;

import java.io.IOException;
import java.util.List;

public interface DataExport {

    void writeCSVFile(List dataStore) throws IOException;
}

//ToDo make seperate file preperation method thingy?
