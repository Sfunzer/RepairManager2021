package nl.furusupport.basic;

//A building contains everything related to repairs: The devices that may be broken, the parts needed to repair them. and the information about the repair itself

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Building {
    private final String buildingName;
    private final int buildingID;
    private final Randomnator IdGenerator;

    private LocalDate dateCheck;

    private final List<Device> plazaDeviceStore;
    private final PartsWarehouse plazaPartsWarehouse;

    private List returnList;


    public Building(String buildingName) {
        IdGenerator = new Randomnator();

        plazaDeviceStore  = new ArrayList<>();
        plazaPartsWarehouse = new PartsWarehouse();
        returnList = new ArrayList();

        this.buildingName = buildingName;
        this.buildingID = IdGenerator.RandomnizerInt();

    }

    public void addPartToWarehouse(Part newPart){
        plazaPartsWarehouse.addPart(newPart);
    }


    public void addDeviceToStore(Device newDevice){
        dateCheck = java.time.LocalDate.now();

        for (Device deviceChecker:plazaDeviceStore) {
            if(deviceChecker.)
        }



                plazaDeviceStore.add(newDevice);
    }

    public List getOverview (int whichList) {

        if (whichList == 1) {
            returnList = plazaDeviceStore;
        } else if (whichList == 2) {
            returnList = plazaPartsWarehouse.getBuildingPartsWarehouse();
        }
        return Collections.unmodifiableList(returnList);
    }

    @Override
    public String toString() {
        return "Building{" +
                "buildingName='" + buildingName + '\'' +
                ", buildingID=" + buildingID +
                ", IdGenerator=" + IdGenerator +
                ", plazaDeviceStore=" + plazaDeviceStore +
                ", plazaPartsWarehouse=" + plazaPartsWarehouse +
                ", returnList=" + returnList +
                '}';
    }
}