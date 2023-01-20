package Soru4;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen rakamları toplayacağımız long değerini girin: ");
        long number = input.nextLong();

        LongSum longSum = new LongSum();
        System.out.println(longSum.longSum(number));
    }
}
