package com.works;

public class MainApp {

    public static void main(String[] args) {

        // tek satırlı açıklama
        /*
        çok
        satırlı
        açıklama birimis
         */

        // Değişken oluşturma
        // DeğişkenTürü DeğişkenAdı = DeğişkenDeğeri;

        // String
        // Karakter Katarı
        String name = "Ali";
        String surname = "Bilmem";
        String team = "Fenerbahçe";
        String nick = "01Ali";
        String st1 = "100";
        String st2 = "200";
        String stSum = st1 + st2;
        System.out.println(stSum);

        String city = "Ankara";
        String ankaMall = "Ankara";

        // Tam Sayı Türleri
        // long
        int intSpace = 923423423;
        long space = 923423423423423l;

        // int
        int age = 30;
        int year = 2022;
        int between = year - age;
        System.out.println(between);

        //  short
        short area = 32000;

        // byte
        byte userClass = 127;
        userClass = -128;

        // ondalıklı değerler
        // double
        double ondalik1 = 45656.5234;
        double ondalik2 = 23534.62342342;
        double ondalikSum = ondalik1 + ondalik2;
        System.out.println("ondalikSum :" + (ondalik1 + ondalik2) );

        // float
        float user_F1 = 99.97f;

        // char
        char c1 = 'c';

        // boolean
        // true - false
        boolean status1 = false;
        status1 = true;
        System.out.println(status1);

    }


}