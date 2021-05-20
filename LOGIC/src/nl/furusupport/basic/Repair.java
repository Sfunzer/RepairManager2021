package nl.furusupport.basic;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Repair {
    private final String repairCause;
    private String repairSolution;
    private final String repairInformation;
    private final LocalDate repairStartDate;
    private LocalDate repairFinishedDate;
    private Long repairDuration;
    private final String repairRepairman;
    private boolean repairFinished;
    private final List reservedParts;
    private final List usedParts;

        public Repair(String repairCause, String repairInformation, LocalDate repairStartDate, String repairRepairman){

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

    public void setRepairFinished(LocalDate repairFinishedDate) {
        this.repairFinishedDate = repairFinishedDate;
        repairDuration = ChronoUnit.DAYS.between(repairStartDate, this.repairFinishedDate);
        repairFinished = true;
    }

    @Override
    public String toString() {
        return "Repair{" +
                ", repairCause='" + repairCause + '\'' +
                ", repairSolution='" + repairSolution + '\'' +
                ", repairInformation='" + repairInformation + '\'' +
                ", repairStartDate=" + repairStartDate +
                ", repairFinishedDate=" + repairFinishedDate +
                ", repairDuration=" + repairDuration +
                ", repairRepairman='" + repairRepairman + '\'' +
                ", repairFinished=" + repairFinished +
                '}';
    }
}


