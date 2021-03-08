package nl.furusupport.basic;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

//A repair is basically a report about a defect device. besides information on what happened, it also contains the needed spare parts.
public class Repair {
    protected final Integer repairID;
    //protected final int deviceID;
    protected final String repairCause;
    protected String repairSolution;
    protected final String repairInformation;
    protected final LocalDate repairStartDate;
    protected LocalDate repairFinishedDate;
    protected Long repairDuration;
    protected String repairRepairman;
    protected boolean repairFinished;
    protected ArrayList reservedParts;
    protected ArrayList usedParts;

        public Repair(Integer repairID, String repairCause, String repairInformation, String repairStartDate, String repairRepairman){
            this.repairID = repairID;
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
