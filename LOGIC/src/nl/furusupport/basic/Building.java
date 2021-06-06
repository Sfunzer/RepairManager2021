package nl.furusupport.basic;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Building {
    private final String buildingName;
    private final int buildingID;

    private final List<Device> buildingDeviceStore;
    private final PartsWarehouse buildingPartsWarehouse;
    private List<PropertyChecker> checkList;

    private final DataImporter_Device readerData;
    private final DataExporter_Device writerData;



      public Building(String buildingName, Integer buildingID, PartsWarehouse buildingPartsWarehouse, DataImporter_Device readerData, DataExporter_Device writerData) throws IOException {

        buildingDeviceStore = new ArrayList<>();
        this.buildingPartsWarehouse = buildingPartsWarehouse;

        this.buildingName = buildingName;
        this.buildingID = buildingID;

        this.readerData = readerData;
        this.writerData = writerData;

          importDeviceData();

    }

    private void importDeviceData () throws IOException { buildingDeviceStore.addAll(readerData.importDataFromExternal()); }

    public DeviceState addDeviceToStore(Device newDevice) {
        for (PropertyChecker deviceCheck:checkList) {
            if (!deviceCheck.check(newDevice).equals(DeviceState.DEVICETEST_PASSED)){
                return deviceCheck.check(newDevice);
            }
        }
        newDevice.setCheckList(checkList);
        buildingDeviceStore.add(newDevice);
        return DeviceState.ADDED;
    }

    public DataState exportData() throws IOException {
          writerData.writeDataToExternal(buildingDeviceStore);
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

    public void setDeviceChecklist(List<PropertyChecker> checkList) {
         this.checkList = checkList;

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