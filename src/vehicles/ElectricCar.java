package vehicles;

public class ElectricCar extends Car {
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
}
