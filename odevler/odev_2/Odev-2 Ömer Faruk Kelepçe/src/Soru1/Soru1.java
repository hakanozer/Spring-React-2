package Soru1;

import java.util.Scanner;

public class Soru1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen asal olup olmadığını kontrol edeceğimiz sayıyı girin: ");
        int number = input.nextInt();
        System.out.println(isPrime(number));
    }

    public static boolean isPrime(int number){
        boolean isPrime = true;
        if (number == 2){}
        for (int i = 2; i < number; i++){
            if (number % i == 0 ) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

}
