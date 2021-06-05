package nl.furusupport.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChecklistBuilder {



    private final List<PropertyChecker> internalChecklist;
    private final List<Device> internalDeviceList;

    public ChecklistBuilder(List<Device> deviceList){

        internalChecklist = new ArrayList<>();
        internalDeviceList = deviceList;

        internalChecklist.add(new SerialChecker(internalDeviceList));
        internalChecklist.add(new EOLChecker());
        internalChecklist.add(new LifeSpanChecker());

    }

    public List<PropertyChecker> getChecklist() {
        return Collections.unmodifiableList(internalChecklist);
    }
}
