package nl.furusupport.basic;

//A part is a piece that can be used to repair certain devices.
public class Part {
    private final String partName;
    private final String partSupplierNumber;
    private final String partInfo;


    public Part (String partName, String partSupplierNumber, String partInfo){

        this.partName = partName;
        this.partSupplierNumber = partSupplierNumber;
        this.partInfo = partInfo;

    }

    @Override
    public String toString() {
        return "Part{" +
                "partName='" + partName + '\'' +
                ", partSupplierNumber='" + partSupplierNumber + '\'' +
                ", partInfo='" + partInfo + '\'' +
                '}';
    }
}
