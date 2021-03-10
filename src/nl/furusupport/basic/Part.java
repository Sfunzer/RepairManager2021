package nl.furusupport.basic;

//A part is a piece that can be used to repair certain devices.
public class Part {
    private final String partName;
    private final int partNumber;
    private final String partSupplierNumber;
    private final String partInfo;

    private final Randomnator IdGenerator;


    public Part (String partName, String partSupplierNumber, String partInfo){
        IdGenerator = new Randomnator();



        this.partName = partName;
        this.partNumber = IdGenerator.RandomnizerInt();
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
