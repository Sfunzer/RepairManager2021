package nl.furusupport.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartsWarehouse {
    private final List<Part> buildingPartsStore;

    public PartsWarehouse () { buildingPartsStore = new ArrayList<>(); }

    public void addPart(Part newPart){ buildingPartsStore.add(newPart); }

    public List<Part> getBuildingPartsStore() { return Collections.unmodifiableList(buildingPartsStore); }

}
