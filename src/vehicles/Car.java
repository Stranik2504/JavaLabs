package vehicles;

public class Car {
    private String _ownerName;
    private String _insuranceNumber;
    
    protected String _engineType;

    public String getOwnerName() { return _ownerName; }
    public void setOwnerName(String ownerName) { _ownerName = ownerName; }
    
    public String getInsuranceNumber() { return _insuranceNumber; }
    public void setInsuranceNumber(String insuranceNumber) { _insuranceNumber = insuranceNumber; }
    
    public String getEngineType() { return _engineType; }
    public void setEngineType(String engineType) { _engineType = engineType; }
}
