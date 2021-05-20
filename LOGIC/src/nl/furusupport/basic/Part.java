package nl.furusupport.basic;

public class Part {
    private final String partName;
    private final String partNumber;
    private final String partInfo;


    public Part (String partName, String partSupplierNumber, String partInfo){
        this.partName = partName;
        this.partNumber = partSupplierNumber;
        this.partInfo = partInfo;
    }

    @Override
    public String toString() {
        return "Part{" +
                "partName='" + partName + '\'' +
                ", partSupplierNumber='" + partNumber + '\'' +
                ", partInfo='" + partInfo + '\'' +
                '}';
    }
}
