package vehicles;

public class ElectricCar extends Car implements ElectricVehicle {
    private int _batteryCapacity;
    
    public int getBatteryCapacity() { return _batteryCapacity; }
    public void setBatteryCapacity(int batteryCapacity) { _batteryCapacity = batteryCapacity; }
    
    public ElectricCar() {
        super();
        _engineType = "Electric";
    }
    
    public String vehicleType() {
        return "Electric Car";
    }

    public String toString() {
        return
                "Model: " + getModel() + "\n" +
                "License: " + getLicense() + "\n" +
                "Color: " + getColor() + "\n" +
                "Year: " + getYear() + "\n" +
                "--------------------------\n" +
                "Owner Name: " + getOwnerName() + "\n" +
                "Insurance Number: " + getInsuranceNumber() + "\n" +
                "Engine Type: " + _engineType + "\n" +
                "--------------------------\n" +
                "Vehicle Type: " + vehicleType() + "\n" +
                "--------------------------\n" +
                "Battery Capacity: " + _batteryCapacity;
    }
}
