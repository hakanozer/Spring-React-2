package Soru7;

public class Palindrome {

    public static boolean isPalindrome(int number) {
        int startingNumber = 0;
        int temperatureNumber = number;
        while (temperatureNumber != 0) {
            startingNumber = (startingNumber * 10) + (temperatureNumber % 10);
            temperatureNumber = temperatureNumber / 10;
        }
        if (startingNumber == number) {
            return true;
        }
        return false;
    }
}
