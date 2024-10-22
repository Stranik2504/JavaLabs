import java.util.Scanner;

public class TestExClasses2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Введите номер месяца от 1 до 12: ");
            int month = input.nextInt();

            String[] months = {"январь", "февраль", "март", "апрель", "май",
                    "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};

            int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            
            if (month != 2) {
                System.out.println("Количество дней: " + months[month] + " " + dom[month]);
                return;
            }

            System.out.print("Введите номер года: ");
            int year = input.nextInt();
            
            if (isLeapYear(year))
                System.out.println("Количество дней: " + months[1] + " 29");
            else
                System.out.println("Количество дней: " + months[1] + " 28");
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Введен недопустимый месяц");
        }
        catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static boolean isLeapYear(int year) throws IllegalArgumentException {
        if (year <= 0)
            throw new IllegalArgumentException("Введен недопустимый год");
        
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
