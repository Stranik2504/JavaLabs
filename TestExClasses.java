import java.util.Scanner;

public class TestExClasses {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        try {
            System.out.print("Введите номер месяца от 1 до 12: ");
            int numMonth = input.nextInt();

            String[] months = {"январь", "февраль", "март", "апрель", "май",
                    "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};

            int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            
            System.out.println("Количество дней: " + months[numMonth] + " " + dom[numMonth]);
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Введен недопустимый месяц");
        }
    }
}
