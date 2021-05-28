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

    private final DataImporter_Device readData;
    private final DataExporter_Device writeData;

    private PropertyChecker serialCheck;
    private PropertyChecker eolCheck;
    private PropertyChecker lifeSpanCheck;

      public Building(String buildingName, Integer buildingID, PartsWarehouse buildingPartsWarehouse, DataImporter_Device readData, DataExporter_Device writeData) throws IOException {

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
            buildingDeviceStore.addAll(readData.importDataFromExternal());
            return DataState.IMPORT_SUCCEEDED;
        } else {
            return DataState.DATABASE_NOT_EMPTY;
        }
    }

    public DeviceState addDeviceToStore(Device newDevice) {

          //TODO: Create a class to instantiate a complete checkList.
          List<PropertyChecker> checkList = new ArrayList();
          checkList.add(serialCheck);
          checkList.add(eolCheck);
          checkList.add(lifeSpanCheck);

        for (PropertyChecker deviceCheck:checkList) {
            if (!deviceCheck.check(newDevice).equals(DeviceState.DEVICETEST_PASSED)){
                return deviceCheck.check(newDevice);
            }
        }
        buildingDeviceStore.add(newDevice);
        return DeviceState.ADDED;
    }

    public DataState exportData() throws IOException {
          writeData.writeDataToExternal(buildingDeviceStore);
          return DataState.DATAEXPORT_SUCCESFULL;
      }

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

    public void setDeviceCheckers(PropertyChecker serialCheck, PropertyChecker eolCheck, PropertyChecker lifeSpanCheck) {
          this.serialCheck = serialCheck;
          this.eolCheck = eolCheck;
          this.lifeSpanCheck = lifeSpanCheck;

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