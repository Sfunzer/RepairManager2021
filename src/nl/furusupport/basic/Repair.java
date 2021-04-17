package nl.furusupport.basic;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

//A repair is basically a report about a defect device. besides information on what happened, it also contains the needed and/or used spare parts.
public class Repair {
    private final Integer repairID;
    //private final int deviceID;
    private final String repairCause;
    private String repairSolution;
    private final String repairInformation;
    private final LocalDate repairStartDate;
    private LocalDate repairFinishedDate;
    private Long repairDuration;
    private String repairRepairman;
    private boolean repairFinished;
    private List reservedParts;
    private List usedParts;

        public Repair(String repairCause, String repairInformation, String repairStartDate, String repairRepairman){
            Randomnator idGenerator = new Randomnator();

            this.repairID = idGenerator.RandomnizerInt();
            this.repairCause = repairCause;
            this.repairInformation = repairInformation;
            this.repairStartDate = LocalDate.parse(repairStartDate);
            this.repairRepairman = repairRepairman;

            repairFinished = false;

            reservedParts = new ArrayList();
            usedParts = new ArrayList();

        }


    public void setRepairSolution(String repairSolution) {
        this.repairSolution = repairSolution;
    }

    public void setRepairFinished(String repairFinishedDate) {  //rework so the boolean will set as well
        this.repairFinishedDate = LocalDate.parse(repairFinishedDate);
        repairDuration = ChronoUnit.HOURS.between(repairStartDate, this.repairFinishedDate);
    }




}

//TODO Class is not implemented yet.
