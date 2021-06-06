package nl.furusupport.basic;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class repairManagerMainCLUI {
    private Scanner inputScan;

    private Integer menuChoice;

    private final Building currentBuilding;

    private final List<String> menuFields;

    public repairManagerMainCLUI(Building currentBuilding){

        this.currentBuilding = currentBuilding;

        menuChoice = 0;

        menuFields = new ArrayList<>();
        menuFields.add("Quit");
        menuFields.add("View Building");
        menuFields.add("View all Devices");
        menuFields.add("Add Device");
        menuFields.add("Save DeviceList");
        menuFields.add("Add Repair to Device");
        menuFields.add("Show specific Device Repairs");
        }



    public void startUI() throws IOException {
        setUpUI();
        selectOption();
    }

    private void setUpUI(){
        System.out.println("RepairManager 2021\n\n");
    }

    private void selectOption() throws IOException {
        System.out.println("Please select a menu-option:");
        dataPrinter(menuFields);

        inputScan = new Scanner(System.in);

            menuChoice = inputScan.nextInt();

            switch (menuChoice){
                case 0:
                    System.out.println("Thanks");
                    System.exit(0);
                case 1:
                    System.out.println(currentBuilding);
                    afterSelection();
                case 2:
                    dataPrinter(currentBuilding.getBuildingDeviceStore());
                    afterSelection();
                case 3:
                    enterDeviceData();
                    afterSelection();
                case 4:
                    System.out.println(currentBuilding.exportData());
                    afterSelection();
                case 5:
                    addRepairToDevice();
                    afterSelection();
                case 6:
                    showDeviceRepairs();
                    afterSelection();

                default:
                    System.out.println("That's not an option!");
                    afterSelection();
            }
    }

    private void afterSelection() throws IOException {
        inputScan = new Scanner(System.in);
        System.out.println("\nPress enter to return to menu.");
        inputScan.nextLine();
        selectOption();
    }

    private void enterDeviceData (){
        inputScan = new Scanner(System.in);

        System.out.println("Name & type:");
        String name = inputScan.nextLine();
        System.out.println("SerialNumber:");
        String serial = inputScan.nextLine();
        System.out.println("Current age days of device:");
        int ageDays = inputScan.nextInt();
        System.out.println("How many days should the device last?");
        int lifeSpan = inputScan.nextInt();
        inputScan.nextLine();
        System.out.println("On which date does the device life expectancy end? Dateformat is: YYYY-MM-DD");
        String eol = inputScan.nextLine();
        System.out.println("Location");
        String location = inputScan.nextLine();

        System.out.println(currentBuilding.addDeviceToStore(new Device(name, serial, ageDays, lifeSpan, LocalDate.parse(eol), location)));
    }


    private void addRepairToDevice(){
        inputScan = new Scanner(System.in);
        System.out.println("Please enter the Device serialnumber:");
        String nextSerial = inputScan.nextLine();

        System.out.println("Enter Cause");
        String cause = inputScan.nextLine();
        System.out.println("Enter info:");
        String info = inputScan.nextLine();
        System.out.println("Enter date of repair start: Dateformat is: YYYY-MM-DD");
        String startDate = inputScan.nextLine();
        System.out.println("Enter your name:");
        String name = inputScan.nextLine();

        System.out.println(currentBuilding.getDevice(nextSerial).addRepair(new Repair(cause, info, LocalDate.parse(startDate), name)));
    }

    private void showDeviceRepairs() {
        inputScan = new Scanner(System.in);

        System.out.println("Enter device serial");
        String nextSerial = inputScan.nextLine();

        System.out.println(currentBuilding.getDevice(nextSerial).getDeviceName() + "\n");

        dataPrinter(currentBuilding.getDevice(nextSerial).getDeviceRepairs());
    }

    private void dataPrinter(List printableList){
        int number = 0;
            for (Object dataPrinter : printableList) {
                System.out.println(number + ". " + dataPrinter.toString());
                number ++;
            }
    }
}


