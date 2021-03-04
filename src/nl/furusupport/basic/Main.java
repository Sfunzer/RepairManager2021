package nl.furusupport.basic;

import java.util.ArrayList;

public class Main {
    static Building plazaTheatre;
    static ArrayList printLister;


    public static void main(String[] args) {
	plazaTheatre = new Building("Plaza Theatre");

        System.out.println("RepairManager 2021");

        plazaTheatre.addDevice("Xerox Altalink B8100", "ReproRoom");
        plazaTheatre.addDevice("Cisco Telephone", "Reception");

        printLister = plazaTheatre.getOverview(1);

        for (Object dataPrinter : printLister) {
            System.out.println(dataPrinter.toString());
        }

        System.out.println("Parts\n");

        plazaTheatre.addPart("Screw", "Xo7987", "only if you're screwed");
        plazaTheatre.addPart("Cat5 cable", "C5-EX", "Basically just the stuff!");

        printLister = plazaTheatre.getOverview(2);

        for (Object dataPrinter : printLister) {
            System.out.println(dataPrinter.toString());
        }





    }
}