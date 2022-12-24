package com.works;

public class UseIF {

    public static void main(String[] args) {

        // Karar Kontrol
        // if
        // if (boolean) { // koşul sağlandığında çalışan gövde }

        int num1 = 10;
        int num2 = 11;
        boolean status = num1 > num2; // büyükse
        status = num1 < num2; // küçükse
        status = num1 == num2; // eşitse
        status = num1 >= num2; // büyük veya eşit
        status = num1 <= num2; // küçük veya eşit
        // logic
        // &&, ||
        // && -> iki veya birden fazla koşulun sağlanması
        status = num1 > 9 && num1 < num2;
        // || -> iki veya birden fazla koşuldan birinin sağlanması
        status = num1 > num2 || num1 > 5;

        if (status) {
            System.out.println("Koşul Sağlanıyor.");
        }else {
            System.out.println("Koşul Sağlanmıyor.");
        }

    }

}
