package Soru9;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Arrayde kaç adet değer olacak: ");
        int arrLength = input.nextInt();
        int[] arr = new int[arrLength];
        System.out.print(arrLength + " adet sayı giriniz: ");

        for (int i = 0; i < arrLength; i++) {
            arr[i] = input.nextInt();
        }

        System.out.print("Kontrol edilecek değeri girin: ");
        int controlNumber = input.nextInt();

       IsIncludesInteger isIncludesInteger = new IsIncludesInteger();
        System.out.println(isIncludesInteger.isIncludesInteger(arr, controlNumber));
    }
}
