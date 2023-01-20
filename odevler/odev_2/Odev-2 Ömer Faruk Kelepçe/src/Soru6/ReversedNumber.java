package Soru6;

public class ReversedNumber {

    public static int reverseNumber(int number){
        int reversedNumber = 0;
        while (number != 0) {
            int excluded = number % 10;
            reversedNumber = reversedNumber * 10 + excluded;
            number = number / 10;
    }
        return reversedNumber;
    }
}
