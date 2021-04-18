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
        System.out.println(plazaTheatre.addDeviceToStore(new Device ("Xerox Altalink B8100", "4356345", 100, 50, LocalDate.of(2022,1,1),  "CopyRoom")));
        System.out.println(plazaTheatre.addDeviceToStore(new Device("Apple MacMini M1", "XGA678", 0, 800, LocalDate.of(2025, 1, 1), "SoundOffice")));
        System.out.println(plazaTheatre.addDeviceToStore(new Device("Logitech Magic Mouse", "$%FGJ", 0, 10, LocalDate.of(2022, 4, 1), "Boardroom")));
        System.out.println(plazaTheatre.addDeviceToStore(new Device("Logitech Magic Mouse", "$%GJ", 0, 10, LocalDate.of(2020, 4, 1), "Boardroom")));


        //adding some parts
        plazaTheatre.addPartToWarehouse(new Part("Screw", "Xo7987", "only if you're screwed"));
        plazaTheatre.addPartToWarehouse(new Part("Cat5 cable", "C5-EX", "Basically just the stuff!"));


        //Printing out some overviews from stuff available within the application.
        System.out.println("\nDevices:");
        dataPrinter(1, null);

        System.out.println("\nParts:");
        dataPrinter(2, null);

        System.out.println("\nBuilding Overview:");
        System.out.println(plazaTheatre.toString());


        //Adding a few repairs, some to the same device. The system will let you know if there have been previous repairs, so you can factcheck. In a later iteration the system should
        //suggest what parts you need based on the information you put in.
        System.out.println("\n Time to add repairs:\n");
        System.out.println(plazaTheatre.addRepairToDevice("43563456", new Repair("Tray broke off", "Because someone was standing on in.", LocalDate.of(2021,4,18), "Dude")));
        System.out.println(plazaTheatre.addRepairToDevice("XGA678", new Repair("There's no parallel port for my mouse", "Mouse is to old for this stuff", LocalDate.of(2021,4,18), "Dude")));
        System.out.println(plazaTheatre.addRepairToDevice("XGA678", new Repair("I can't conncet my VGA screen", "needs a few thunderbolt adapters.", LocalDate.of(2021,4,18), "Dude")));

        //printout of repairs linked to given serial number.
        System.out.println("\nAnd see if we succeeded:\n");
        dataPrinter(3, "43563456");

        //and another one.
        System.out.println("\nAnd see if we succeeded with the serial:\n");
        dataPrinter(3, "XGA678");

    }

    private static void dataPrinter(int whichList, String deviceSerial){
        for (Object dataPrinter : plazaTheatre.getOverview(whichList, deviceSerial)) {
            System.out.println(dataPrinter.toString());
        }
    }
}

