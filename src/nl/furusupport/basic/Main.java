package nl.furusupport.basic;


import java.time.LocalDate;

public class Main {
    static Building plazaTheatre;

    public static void main(String[] args) {
	    //Starting with initialising a new building.
        plazaTheatre = new Building("Plaza Theatre");
        System.out.println("RepairManager 2021\n");


        //Adding some already existing devices, and showing store-status.
        System.out.println(plazaTheatre.addDeviceToStore(new Device ("Xerox Altalink B8100", "43563456", 100, 150, LocalDate.of(2022,1,1),  "CopyRoom")));
        System.out.println(plazaTheatre.addDeviceToStore(new Device ("Cisco Telephone", "aklj789", 40, 140, LocalDate.of(2023,1,1), "Reception")));
        System.out.println(plazaTheatre.addDeviceToStore(new Device ("Xerox Altalink B8100", "43563456", 100, 50, LocalDate.of(2022,1,1),  "CopyRoom")));
        System.out.println(plazaTheatre.addDeviceToStore(new Device("Apple MacMini M1", "XGA678", 0, 800, LocalDate.of(2025, 1, 1), "SoundOffice")));
        System.out.println(plazaTheatre.addDeviceToStore(new Device("Logitech Magic Mouse", "$%FGJ", 0, 10, LocalDate.of(2022, 4, 1), "Boardroom")));
        System.out.println(plazaTheatre.addDeviceToStore(new Device("Logitech Magic Mouse", "$%GJ", 0, 10, LocalDate.of(2022, 4, 1), "Boardroom")));


        //adding some parts
        plazaTheatre.addPartToWarehouse(new Part("Screw", "Xo7987", "only if you're screwed"));
        plazaTheatre.addPartToWarehouse(new Part("Cat5 cable", "C5-EX", "Basically just the stuff!"));



        //Printing out some overviews from stuff available within the application.
        System.out.println("\nDevices:");
        dataPrinter(1);

        System.out.println("\nParts:");
        dataPrinter(2);

        System.out.println("\nBuilding Overview:");
        System.out.println(plazaTheatre.toString());
    }

    private static void dataPrinter(int whichList){
        for (Object dataPrinter : plazaTheatre.getOverview(whichList)) {
            System.out.println(dataPrinter.toString());
        }
    }
}

