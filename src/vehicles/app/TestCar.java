package vehicles.app;

import vehicles.Car;
import vehicles.ElectricCar;
import vehicles.Vehicle;

public final class TestCar {
    public static void Test() {
        Vehicle Car = new Car();
        Vehicle ElectricCar = new ElectricCar();

        // ---[Car]---
        System.out.println("---[Car]---");
        Car.setModel("Genericss");
        Car.setLicense("gfchj");
        Car.setColor("White");
        Car.setYear(1000);
        
        // Car.getColor();
        // Car._color;

        Car.setOwnerName("John Does");
        Car.setInsuranceNumber("123");

        System.out.println(Car.getModel());
        System.out.println(Car.getLicense());
        System.out.println(Car.getColor());
        System.out.println(Car.getYear());
        
        
        System.out.println(Car.getOwnerName());
        System.out.println(Car.getInsuranceNumber());
        System.out.println(Car.getEngineType());
        
        System.out.println(Car.toString());

        // ---[ElectricCar]---
        System.out.println("---[ElectricCar]---");
        ElectricCar.setModel("sdf");
        ElectricCar.setLicense("None");
        ElectricCar.setColor("Yellow");
        ElectricCar.setYear(2000);

        ElectricCar.setOwnerName("Mes");
        ElectricCar.setInsuranceNumber("12365656");

        System.out.println(ElectricCar.getModel());
        System.out.println(ElectricCar.getLicense());
        System.out.println(ElectricCar.getColor());
        System.out.println(ElectricCar.getYear());


        System.out.println(ElectricCar.getOwnerName());
        System.out.println(ElectricCar.getInsuranceNumber());
        System.out.println(ElectricCar.getEngineType());

        System.out.println(ElectricCar.toString());
    }
}
