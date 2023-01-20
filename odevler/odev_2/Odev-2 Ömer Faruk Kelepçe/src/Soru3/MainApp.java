package Soru3;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        TekCiftMethod tekCiftMethod = new TekCiftMethod();
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen ilk değeri girin: ");
        int number1 = input.nextInt();
        System.out.print("Lütfen ikinci değeri girin: ");
        int number2 = input.nextInt();
        System.out.println(tekCiftMethod.tekCiftKontrol(number1, number2));

    }
}
