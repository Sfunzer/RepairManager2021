package nl.furusupport.basic;

//A part is a piece that can be used to repair certain devices.
public class Part {
    private final String partName;
    private final int partNumber;
    private final String partSupplierNumber;
    private final String partInfo;


    public Part (String partName, int partNumber, String partSupplierNumber, String partInfo){
        this.partName = partName;
        this.partNumber = partNumber;
        this.partSupplierNumber = partSupplierNumber;
        this.partInfo = partInfo;

    }

    @Override
    public String toString() {
        return "Part{" +
                "partName='" + partName + '\'' +
                ", partNumber=" + partNumber +
                ", partSupplierNumber='" + partSupplierNumber + '\'' +
                ", partInfo='" + partInfo + '\'' +
                '}';
    }
}
