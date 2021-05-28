package nl.furusupport.basic;


import nl.furusupport.csvtools.CSV_Reader;
import nl.furusupport.csvtools.CSV_Writer;

import java.io.IOException;

public class Main {
    static Building plazaTheatre;
    static PartsWarehouse plazaParts;
    static repairManagerMainCLUI baseUI;

    static PropertyChecker serialCheck;
    static PropertyChecker eolCheck;
    static PropertyChecker lifeSpanCheck;


    public static void main(String[] args) throws IOException {
        plazaParts = new PartsWarehouse();


        plazaTheatre = new Building("Plaza Theatre",12598, plazaParts, new CSV_Reader("plazatest"), new CSV_Writer("plazatest"));

        serialCheck = new SerialChecker(plazaTheatre.getBuildingDeviceStore());
        eolCheck = new EOLChecker();
        lifeSpanCheck = new LifeSpanChecker();

        plazaTheatre.setDeviceCheckers(serialCheck, eolCheck, lifeSpanCheck);



        baseUI = new repairManagerMainCLUI(plazaTheatre);


        baseUI.startUI();

       //plazaTheatre.exportData();

    }

/*
       private static void dataPrinter(List printableList){

        int number = 0;
        if (printableList.isEmpty()){ //TODO this isn't doing what i want.
            System.out.println("Objectlist doesn't exsist");
        } else

        for (Object dataPrinter : printableList) {
            System.out.println(number + ". " + dataPrinter.toString());
            number = number + 1;
        }
    } */
}
