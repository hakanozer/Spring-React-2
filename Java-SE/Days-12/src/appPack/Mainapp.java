package appPack;

import java.util.Scanner;

public class Mainapp {
    public static void main(String[] args) {

        // İstisnalar
        // Hata olma olasılığında kullanılan bir tekniktir.
        // Hata olduğunda uygulamanın durmasını engeller.

        try {
            String stNum = "30a";
            int num = Integer.parseInt(stNum);
            int i = 1 / 0;
            System.out.println("Code block Success");
        }catch ( NumberFormatException | ArithmeticException ex) {
            ex.printStackTrace();
            System.err.println("Code block Fail");
            //System.exit(0);
        }


        Action action = new Action();
        try {
            action.call(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("This line call");

        // Kullanıcıdan bir string sayısal değer alın
        // Kullanıcının sayısal bir değer girip girmediğini öğrenin
        // Tam sayı girene kadar kullanıcıya "Tam sayı giriniz" şeklinde soru sormaya devam edin.

        Scanner scanner = new Scanner(System.in);
        int num = 0;
        while (true) {
            System.out.println("Bir sayı giriniz");
            String stNum = scanner.nextLine();
            try {
                num = Integer.parseInt(stNum);
                System.out.println("Sayısal değer girdiniz");
                break;
            }catch (Exception ex) {
                System.err.println("Lütfen sayısal değer giriniz!");
            }
        }

        num = num * 10;
        System.out.println("Total : " + num);

        try {
            System.out.println("DB Open");
            System.out.println("Insert DB");
            System.out.println("DB Close");
            System.out.println("This Line Action");
        }catch (Exception ex) {
            System.out.println("DB Close");
        }
        System.out.println("Her türlü çalıştım");


        try {
            System.out.println("DB Open");
            System.out.println("Insert DB");
        }catch (Exception ex) {

        }finally {
            System.out.println("DB Close");
            System.out.println("Her türlü çalıştım");
        }

    }
}
