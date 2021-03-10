package nl.furusupport.basic;

import java.util.ArrayList;

public class PartsWarehouse {
    private final ArrayList<Part> buildingPartsWarehouse;

    public PartsWarehouse () {
        buildingPartsWarehouse = new ArrayList<>();
    }

    public void addPart(Part newPart){
        buildingPartsWarehouse.add(newPart);
    }


    public ArrayList<Part> getBuildingPartsWarehouse() {
        return buildingPartsWarehouse;
    }


}
