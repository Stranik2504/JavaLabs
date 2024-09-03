import java.util.Scanner;

public class Main {
    private static final double ROUBLES_PER_YUAN = 11.91; // курс покупки
    
    public static void main(String[] args) {
        int yuan; // сумма денег в китайских юанях

        // Вывод тестовых данных для проверки правильности печати окончания кол-ва юаней
        testYuanPrint();
        
        Scanner input = new Scanner(System.in);
        
        // Получение количества юаней
        System.out.print("Введите число юаней: ");
        yuan = input.nextInt();
        
        printTextYuan(yuan);
        
        double roubles = ROUBLES_PER_YUAN * yuan; // сумма денег в российских рублях
        
        System.out.println(roubles);
    }
    
    private static void printTextYuan(int yuan) {
        String endText = "";
        
        if (yuan != 11 & yuan % 10 == 1) 
            endText = "китайский юань";
        else if ((2 <= yuan % 10 && yuan % 10 <= 4) &&
            (yuan < 10 || yuan > 20)) 
            endText = "китайских юаня";
        else 
            endText = "китайских юаней";
        
        System.out.println(yuan + " " + endText);
    }
    
    private static void testYuanPrint() {
        printTextYuan(0);
        printTextYuan(1);
        printTextYuan(3);
        printTextYuan(5);
        printTextYuan(11);
        printTextYuan(100);
    }
}