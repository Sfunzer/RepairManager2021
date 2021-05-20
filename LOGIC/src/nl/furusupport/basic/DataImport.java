package nl.furusupport.basic;


import java.io.IOException;
import java.util.List;



public interface DataImport {

    public List importCSV () throws IOException;
}