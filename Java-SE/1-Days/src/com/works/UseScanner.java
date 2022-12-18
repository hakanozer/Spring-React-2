package com.works;

import java.util.Scanner;

public class UseScanner {

    public static void main(String[] args) {

        // Scanner Sınıfı
        // Kullanıcıdan veri alımı için kullanılır.
        // Verileri console'da alır.

        Scanner read = new Scanner(System.in);
        System.out.println("1. Sayıyı Giriniz!");
        int num1 = read.nextInt();
        System.out.println("2. Sayıyı Giriniz!");
        int num2 = read.nextInt();

        int sum = num1 + num2;
        System.out.println(sum);

        Scanner stringRead = new Scanner(System.in);
        //read.nextLine();
        System.out.println("Adınız!");
        String name = stringRead.nextLine();
        System.out.println("Soyadınız!");
        String surname = stringRead.nextLine();
        System.out.println(name +" "+surname);

        read.close();
        stringRead.close();

    }

}
