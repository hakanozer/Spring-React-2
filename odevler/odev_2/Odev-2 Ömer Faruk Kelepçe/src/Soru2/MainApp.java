package Soru2;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Soru2 soru2 = new Soru2();
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen küçük olan sayıyı girin: ");
        int num1 = input.nextInt();
        System.out.print("Lütfen büyük olan sayıyı girin: ");
        int num2 = input.nextInt();
        System.out.println(soru2.sumOfTwoNumbers(num1, num2));
    }


}
