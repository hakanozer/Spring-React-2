package works;

import java.util.Scanner;

public class MainObject {
    public static void main(String[] args) {

        // Object Türü
        // Her türlü veriyi içerisine alabilen türdür.

        Object obj = null;
        obj = 10;
        obj = "İstanbul";
        obj = true;
        obj = new Scanner(System.in);
        obj = "Kaan Bilsin";
        obj = 66;

        if ( obj instanceof String ) {
            String st = String.valueOf(obj);
            System.out.println("String : " + st);
        }

        if ( obj instanceof Integer ) {
            int num = (int) obj;
            System.out.println("Int: " +num);
        }


        Object num1 = 10;
        Object num2 = 50;

        int sum = (int) num1 + (int) num2;
        System.out.println(sum);

        int[] numbers = {30,56,65,45,43};
        Object[] objects = { 30, "Ali", 45, true, 21, 'A', false, 77, 21, 9 };
        int sumx = 0;
        for ( Object item : objects ) {
            if ( item instanceof Integer ) {
                int num = (int) item;
                sumx = sumx + num;
            }
        }
        System.out.println( "Sumx : " + sumx );
    }
}
