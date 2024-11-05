package New;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var stack = new MyStack<String>();

        for (var i = 0; i < 5; i++) {
            System.out.print("Введите строчку номер " + (i + 1) + ": ");
            stack.push(scanner.next());
        }

        System.out.println("Структура выглядит так: " + stack.toString());
        System.out.println("\n\nПолученный текст:");

        while (!stack.isEmpty()) {
            var el = stack.pop();
            System.out.println(el);
        }
    }
}