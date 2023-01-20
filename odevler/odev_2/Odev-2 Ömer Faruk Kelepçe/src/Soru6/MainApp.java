package Soru6;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen tersini alacağımız sayıyı girin: ");
        int number = input.nextInt();

        ReversedNumber reversedNumber = new ReversedNumber();
        System.out.println(reversedNumber.reverseNumber(number));
    }
}
