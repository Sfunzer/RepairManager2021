package nl.furusupport.basic;


import nl.furusupport.csvtools.CSV_Reader;
import nl.furusupport.csvtools.CSV_Writer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    static Building plazaTheatre;
    static PartsWarehouse plazaParts;
    static repairManagerMainUI baseUI;

    //static CSV_Reader CSVReader;
    //static CSV_Writer CSVWriter;


    public static void main(String[] args) throws IOException {
	   //Starting with initialising a new building.
        plazaParts = new PartsWarehouse();
        plazaTheatre = new Building("Plaza Theatre",12598, plazaParts, new CSV_Reader("plazatest"), new CSV_Writer("plazatest"));

        baseUI = new repairManagerMainUI(plazaTheatre);
        baseUI.startUI();


        //From here on out we need to remove stuff, as this is now only used for testing.

        //CSVReader = new CSV_Reader(plazaTheatre.getBuildingName());
        //CSVWriter = new CSV_Writer(plazaTheatre.getBuildingName());

        /*
        System.out.println(plazaTheatre.getDevice("XGA678").addRepair(new Repair("Some dude did something", "needs to be reinstalled", LocalDate.of(2022,02,01),"Dude26")));

        dataPrinter(plazaTheatre.getDevice("XGA678").getDeviceRepairs());

        plazaTheatre.getDevice("XGA678").getLastrepair().setRepairFinished(LocalDate.now());

        dataPrinter(plazaTheatre.getDevice("XGA678").getDeviceRepairs());


         */





        //System.out.println(plazaTheatre.importDeviceData(CSVReader.importCSV()));

        //Adding new devices, and some already existing devices. After that, we're and showing store-status. This part is only enabled at the first run of the application as from there on
        //out it will read from a .csv file.

        /*
        System.out.println("RepairManager 2021\n");
        System.out.println(plazaTheatre.addDeviceToStore(new Device ("Xerox Altalink B8100","43563456", 149, 150, LocalDate.of(2022,1,1),  "CopyRoom")));
        System.out.println(plazaTheatre.addDeviceToStore(new Device ("Cisco Telephone", "aklj789", 40, 140, LocalDate.of(2023,1,1), "Reception")));
        System.out.println(plazaTheatre.addDeviceToStore(new Device ("Xerox Altalink B8100","4356345", 100, 50, LocalDate.of(2022,1,1),  "CopyRoom")));
        System.out.println(plazaTheatre.addDeviceToStore(new Device("Apple MacMini M1","XGA678", 0, 800, LocalDate.of(2025, 1, 1), "SoundOffice")));
        System.out.println(plazaTheatre.addDeviceToStore(new Device("Logitech Magic Mouse","$%FGJ", 0, 10, LocalDate.of(2022, 4, 1), "Boardroom")));
        System.out.println(plazaTheatre.addDeviceToStore(new Device("Logitech Magic Mouse","$%GJ", 0, 10, LocalDate.of(2023, 4, 1), "Boardroom")));
        System.out.println(plazaTheatre.addDeviceToStore(new Device("RME Digiface Dante","6464564XHT", 366, 3654, LocalDate.of(2035, 1, 1), "Sven's BackPack")));

        //adding some parts
        plazaTheatre.addPartToWarehouse(new Part("Screw", "Xo7987", "only if you're screwed"));
        plazaTheatre.addPartToWarehouse(new Part("Cat5 cable", "C5-EX", "Basically just the stuff!"));

        //Printing out some overviews from stuff available within the application.
        System.out.println("\nDevices:");
        dataPrinter(plazaTheatre.getBuildingDeviceStore());
        System.out.println("\nParts:");
        dataPrinter(plazaParts.getBuildingPartsStore());
        System.out.println("\nBuilding Overview:");
        System.out.println(plazaTheatre.toString());

        System.out.println("\n Time to add repairs:\n");
        System.out.println(plazaTheatre.addRepairToDevice("43563456", new Repair("Tray broke off", "Because someone was standing on in.", LocalDate.of(2021,4,18), "Dude")));
        System.out.println(plazaTheatre.addRepairToDevice("XGA678", new Repair("There's no parallel port for my mouse", "Mouse is to old for this stuff", LocalDate.of(2021,4,18), "Dude")));
        System.out.println(plazaTheatre.addRepairToDevice("XGA678", new Repair("I can't connect my VGA screen", "needs a few thunderbolt adapters.", LocalDate.of(2021,4,18), "Dude")));

        //printout of repairs linked to given serial number.
        System.out.println("\nRepairstest 1:\n");
        Device printOutDevice = plazaTheatre.getDevice("43563456");
        dataPrinter(printOutDevice.getDeviceRepairs());

        System.out.println("\nRepairstest 2:\n");
        printOutDevice = plazaTheatre.getDevice("XGA678");
        dataPrinter(printOutDevice.getDeviceRepairs());

         */



        //function testing for another device. not in use atm.
        /*
        System.out.println("\ngetDevicetest:\n");
        System.out.println(plazaTheatre.getDevice("XGA678"));
        System.out.println(plazaTheatre.setUpdatableDevice("HFDKUIK"));
         */


       //Using the interface-implementation from the datalayer to export an .CSV file.
        //CSVWriter.writeCSVFile(plazaTheatre.getBuildingDeviceStore());

        plazaTheatre.exportData();


    }

    private static void dataPrinter(List printableList){
        int number = 0;
        if (printableList.isEmpty()){ //TODO this isn't doing what i want.
            System.out.println("Objectlist doesn't exsist");
        } else

        for (Object dataPrinter : printableList) {
            System.out.println(number + ". " + dataPrinter.toString());
            number = number + 1;
        }
    }
}

//ToDo Check all toString outputs for CSV in