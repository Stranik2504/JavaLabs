import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var builder = new OrderBuilder();
        
        System.out.print("Введите название основного блюда: ");
        var mainDish = scanner.nextLine();

        System.out.print("Введите название гарнира: ");
        var garnish = scanner.nextLine();

        System.out.print("Введите название напитка: ");
        var drink = scanner.nextLine();

        System.out.print("Введите название десерта: ");
        var dessert = scanner.nextLine();

        builder
            .addMainDish(mainDish)
            .addGarnish(garnish)
            .addDrink(drink)
            .addDessert(dessert);
        
        var order = builder.build();
        System.out.println(order);
    }
}