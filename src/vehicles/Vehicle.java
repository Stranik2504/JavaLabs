package vehicles;

public abstract class Vehicle {
    private String _model;
    private String _license;
    private String _color;
    private int _year;

    private String _ownerName;
    private String _insuranceNumber;

    protected String _engineType;

    public String getModel() { return _model; }
    public void setModel(String model) { _model = model; }

    public String getLicense() { return _license; }
    public void setLicense(String license) { _license = license; }

    public String getColor() { return _color; }
    public void setColor(String color) { _color = color; }

    public int getYear() { return _year; }
    public void setYear(int year) { _year = year; }

    public String getOwnerName() { return _ownerName; }
    public void setOwnerName(String ownerName) { _ownerName = ownerName; }

    public String getInsuranceNumber() { return _insuranceNumber; }
    public void setInsuranceNumber(String insuranceNumber) { _insuranceNumber = insuranceNumber; }

    public String getEngineType() { return _engineType; }
    public void setEngineType(String engineType) { _engineType = engineType; }
    
    public abstract String vehicleType();

    public String toString() {
        return 
            "Model: " + _model + "\n" + 
            "License: " + _license + "\n" + 
            "Color: " + _color + "\n" + 
            "Year: " + _year + "\n" +
            "--------------------------\n" +
            "Owner Name: " + _ownerName + "\n" + 
            "Insurance Number: " + _insuranceNumber + "\n" + 
            "Engine Type: " + _engineType + "\n" +
            "--------------------------\n" +
            "Vehicle Type: " + vehicleType();
    } 
}
