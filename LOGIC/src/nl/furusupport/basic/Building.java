package nl.furusupport.basic;

//A building contains all devices installed. Repairs are kept within a device.

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Building {
    private final String buildingName;
    private final int buildingID;

    private final List<Device> buildingDeviceStore;
    private final PartsWarehouse buildingPartsWarehouse;

    private final DataImportDevice readData;
    private final DataExportDevice writeData;

      public Building(String buildingName, Integer buildingID, PartsWarehouse buildingPartsWarehouse, DataImportDevice readData, DataExportDevice writeData) throws IOException {

        buildingDeviceStore = new ArrayList<>();
        this.buildingPartsWarehouse = buildingPartsWarehouse;

        this.buildingName = buildingName;
        this.buildingID = buildingID;

        this.readData = readData;
        this.writeData = writeData;

          importDeviceData();
    }

    //TODO Return value isn't used. Lets see if we can fix that.
    private DataState importDeviceData () throws IOException {
        if (buildingDeviceStore.size() == 0){
            buildingDeviceStore.addAll(readData.importCSV());
            return DataState.IMPORT_SUCCEEDED;
        } else {
            return DataState.DATABASE_NOT_EMPTY;
        }
    }

    //TODO Method contains duplicate code which i'm quite sure is not necessary. Next step is getting rid of the multiple if-else statements.
    public DeviceState addDeviceToStore(Device newDevice) {
        if (buildingDeviceStore.size() == 0) {

            if (newDevice.checkDeviceEOL_status()) {
                return DeviceState.ENDOFLIFE;
            } else if (newDevice.checkDeviceLifeSpan()){
                return DeviceState.LIFESPANPASSED;
            }
        } else {
            for (Device deviceChecker : buildingDeviceStore) {
                if (deviceChecker.getDeviceSerial().equals(newDevice.getDeviceSerial())) {
                    return DeviceState.DUPLICATESERIAL;
                } else if (newDevice.checkDeviceEOL_status()){
                    return DeviceState.ENDOFLIFE;
                } else if (newDevice.checkDeviceLifeSpan()){
                    return DeviceState.LIFESPANPASSED;
                }
            }
        }
        buildingDeviceStore.add(newDevice);
        return DeviceState.ADDED;
    }

    public void exportData() throws IOException { writeData.writeCSVFile(buildingDeviceStore); }

    public List<Device> getBuildingDeviceStore() {
        return  Collections.unmodifiableList(buildingDeviceStore);
    }

    public Device getDevice (String serialNumber) {
        for (Device searchedDevice : buildingDeviceStore) {
            if (searchedDevice.getDeviceSerial().equals(serialNumber)){
                return searchedDevice;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Building{" +
                "buildingName='" + buildingName + '\'' +
                ", buildingID=" + buildingID +
                ", plazaDeviceStore=" + buildingDeviceStore +
                ", plazaPartsWarehouse=" + buildingPartsWarehouse +
                '}';
    }
}