package nl.furusupport.basic;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

//A repair is basically a report about a defect device. besides information on what happened, it also contains the needed and/or used spare parts.
public class Repair {
    private final Integer repairID;
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

        public Repair(String repairCause, String repairInformation, LocalDate repairStartDate, String repairRepairman){
            Randomnator idGenerator = new Randomnator();

            this.repairID = idGenerator.RandomnizerInt();
            this.repairCause = repairCause;
            this.repairInformation = repairInformation;
            this.repairStartDate = repairStartDate;
            this.repairRepairman = repairRepairman;

            repairFinished = false;

            reservedParts = new ArrayList();
            usedParts = new ArrayList();

        }


    public void setRepairSolution(String repairSolution) {
        this.repairSolution = repairSolution;
    }

    public void setRepairFinished(LocalDate repairFinishedDate) {  //TODO rework so the boolean will set as well
        this.repairFinishedDate = repairFinishedDate;
        repairDuration = ChronoUnit.HOURS.between(repairStartDate, this.repairFinishedDate);
    }

    @Override
    public String toString() {
        return "Repair{" +
                "repairID=" + repairID +
                ", repairCause='" + repairCause + '\'' +
                ", repairSolution='" + repairSolution + '\'' +
                ", repairInformation='" + repairInformation + '\'' +
                ", repairStartDate=" + repairStartDate +
                ", repairFinishedDate=" + repairFinishedDate +
                ", repairDuration=" + repairDuration +
                ", repairRepairman='" + repairRepairman + '\'' +
                ", repairFinished=" + repairFinished +
                ", reservedParts=" + reservedParts +
                ", usedParts=" + usedParts +
                '}';
    }
}

//TODO Class needs further functional implementation.


