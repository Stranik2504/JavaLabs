import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var queue = new MyQueue<>();

        for (var i = 0; i < 5; i++) {
            System.out.print("Введите строчку номер " + (i + 1) + ": ");
            queue.enqueue(scanner.next());
        }

        System.out.println("Структура выглядит так: " + queue.toString());
        System.out.println("\n\nПолученный текст:");

        while (!queue.isEmpty()) {
            var el = queue.dequeue();
            System.out.println(el);
        }
    }
}