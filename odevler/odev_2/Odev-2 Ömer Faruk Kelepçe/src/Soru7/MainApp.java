package Soru7;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen palindrome olup olmadığını kontrol edeceğimiz değeri girin: ");
        int number = input.nextInt();

        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(number));
    }
}
