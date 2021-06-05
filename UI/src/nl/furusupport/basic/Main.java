package nl.furusupport.basic;


import nl.furusupport.csvtools.CSV_ReaderDevice;
import nl.furusupport.csvtools.CSV_WriterDevice;

import java.io.IOException;

public class Main {
    private static Building plazaTheatre;
    private static PartsWarehouse plazaParts;

    private static ChecklistBuilder checkListGenerator;

    private static repairManagerMainCLUI baseUI;

    public static void main(String[] args) throws IOException {
        plazaParts = new PartsWarehouse();
        plazaTheatre = new Building("Plaza Theatre",12598, plazaParts, new CSV_ReaderDevice("plazatest"), new CSV_WriterDevice("plazatest"));

        checkListGenerator = new ChecklistBuilder(plazaTheatre.getBuildingDeviceStore());

        plazaTheatre.setDeviceChecklist(checkListGenerator.getChecklist());

        baseUI = new repairManagerMainCLUI(plazaTheatre);

        baseUI.startUI();



    }
}
