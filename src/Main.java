public class Main {
    public static void main(String[] args) {
        Car car = new Car("Kamaz", "Not", "White", 2077);
        car.To_String();
        
        car = new Car();
        car.To_String();
        
        car = new Car("Audi", 2021);
        car.To_String();
        
        System.out.println("\n");
        System.out.println("---[Old values]---");
        System.out.println("Model: " + car.getModel());
        System.out.println("License: " + car.getLicense());
        System.out.println("Color: " + car.getColor());
        System.out.println("Year: " + car.getYear());
        
        car.setModel("Audi A7");
        car.setLicense("Lol");
        car.setColor("Non");
        car.setYear(1997);

        System.out.println("\n");
        System.out.println("---[New values]---");
        System.out.println("Model: " + car.getModel());
        System.out.println("License: " + car.getLicense());
        System.out.println("Color: " + car.getColor());
        System.out.println("Year: " + car.getYear());
        
        System.out.println("\n\nAge car: " + car.getAge());
    }
}

