package Soru8;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Kaç elemanlı bir dizi gireceksiniz: ");
        int arrLength = input.nextInt();
        int[] arr = new int[arrLength];
        System.out.print(arrLength + " adet sayı giriniz: ");

        for(int i = 0; i < arrLength; i++){
            arr[i]= input.nextInt();
        }

        MinMaxSumArray minMaxSumArray = new MinMaxSumArray();
        System.out.println("En küçük ve en büyük değerler toplamı: " + minMaxSumArray.minMaxSumOfArray(arr));
    }

}
