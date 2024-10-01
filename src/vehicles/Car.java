package vehicles;

public class Car extends Vehicle {
    
    public Car() {
        setModel("Generic");
        setLicense("ABC123");
        setColor("Black");
        setYear(2020);
        
        setOwnerName("John Doe");
        setInsuranceNumber("1234567890");
        
        _engineType = "Combustion";
    }
    
    public String vehicleType() {
        return "Car";
    }
}
