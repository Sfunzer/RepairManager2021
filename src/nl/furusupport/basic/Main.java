package nl.furusupport.basic;


public class Main {
    static Building plazaTheatre;

    public static void main(String[] args) {
	plazaTheatre = new Building("Plaza Theatre");

        //plazaTheatre.addDeviceToStore(new Device ("Xerox Altalink B8100", "ReproRoom"));
        //plazaTheatre.addDeviceToStore(new Device ("Cisco Telephone", "Reception"));

        plazaTheatre.addPartToWarehouse(new Part("Screw", "Xo7987", "only if you're screwed"));
        plazaTheatre.addPartToWarehouse(new Part("Cat5 cable", "C5-EX", "Basically just the stuff!"));

        System.out.println("RepairManager 2021\n");

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

