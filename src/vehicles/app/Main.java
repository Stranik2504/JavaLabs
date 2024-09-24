package vehicles.app;

import vehicles.Car;
import vehicles.ElectricCar;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        
        car.setOwnerName("Me");
        car.setInsuranceNumber("1234567890");
        car.setEngineType("Simple");
        
        System.out.println(car.getOwnerName());
        System.out.println(car.getInsuranceNumber());
        System.out.println(car.getEngineType());
        
        // ----------------------------------
        System.out.println("[----------------------------------]");

        Car electricCar = new ElectricCar();
        
        electricCar.setOwnerName("Mes");
        electricCar.setInsuranceNumber("0987654321");
        
        System.out.println(electricCar.getOwnerName());
        System.out.println(electricCar.getInsuranceNumber());
        System.out.println(electricCar.getEngineType());
    }
}

