package vehicles.app;

import vehicles.Car;
import vehicles.ElectricCar;
import vehicles.ElectricVehicle;
import vehicles.Vehicle;

public final class TestCar {
    public static void Test() {
        Vehicle Car = new Car();
        Vehicle ElectricCar = new ElectricCar();

        // ---[Car]---
        System.out.println("---[Car (Pre)]---");
        System.out.println(Car.toString());
        
        System.out.println();
        System.out.println();
        
        System.out.println("---[Car (Post)]---");
        Car.setModel("Genericss");
        Car.setLicense("gfchj");
        Car.setColor("White");
        Car.setYear(1000);
        Car.setOwnerName("John Does");
        Car.setInsuranceNumber("123");
        System.out.println(Car.toString());

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        // ---[ElectricCar]---
        System.out.println("---[ElectricCar(Pre)]---");
        System.out.println(ElectricCar.toString());

        System.out.println();
        System.out.println();
        
        System.out.println("---[ElectricCar(Post)]---");
        ElectricCar.setModel("sdf");
        ElectricCar.setLicense("None");
        ElectricCar.setColor("Yellow");
        ElectricCar.setYear(2000);
        ElectricCar.setOwnerName("Mes");
        ElectricCar.setInsuranceNumber("12365656");
        ((ElectricVehicle)ElectricCar).setBatteryCapacity(23);
        System.out.println(ElectricCar.toString());
    }
}
