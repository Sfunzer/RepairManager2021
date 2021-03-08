package nl.furusupport.basic;

import java.util.ArrayList;

public class PartsWarehouse {
    private ArrayList<Part> buildingPartsWarehouse;
    private final Randomnator IdGenerator;

    private int newRandomID;
    private Part newPart;



    public PartsWarehouse () {
        buildingPartsWarehouse = new ArrayList<>();
        IdGenerator = new Randomnator();
    }

    public void addPart(String partName, String partSupplierNumber, String partInfo){

        newRandomID = IdGenerator.RandomnizerInt();
        newPart = new Part(partName, newRandomID, partSupplierNumber, partInfo);
        buildingPartsWarehouse.add(newPart);
    }


    public ArrayList<Part> getBuildingPartsWarehouse() {
        return buildingPartsWarehouse;
    }


}
