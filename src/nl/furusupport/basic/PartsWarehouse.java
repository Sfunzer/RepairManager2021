package nl.furusupport.basic;

//PartsWarehouse contains the available parts for repairs.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartsWarehouse {
    private final List<Part> buildingPartsWarehouse;

    public PartsWarehouse () {
        buildingPartsWarehouse = new ArrayList<>();
    }

    public void addPart(Part newPart){
        buildingPartsWarehouse.add(newPart);
    }


    public List<Part> getBuildingPartsWarehouse() {
        return Collections.unmodifiableList(buildingPartsWarehouse);
    }

}
