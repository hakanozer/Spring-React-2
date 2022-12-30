package works;

import java.util.Date;
import java.util.Scanner;

public class MainArrSample {
    public static void main(String[] args) {

        Action action = new Action();
        Settings settings = new Settings();
        action.useSetting(settings);

        action.noReturn("Ali", 30);

        // Kullanıcının stok girişi
        // kaç kalem ürün olduğunu kullanıcı belirler:

        // 1. Aşama -> Kaç ürününüz var
        // 2. Aşama -> 6
        // 3. Aşama -> 1.Ürünün Adet sayısı giriniz
        // 4. Aşama -> 25
        //
        // Toplam Adet Sayınız: 1677 Dir;

        Scanner read = new Scanner(System.in);
        while(true) {
            System.out.println("Kaç Ürün Grubu Mevcut?");
            int section = read.nextInt();
            if (section > 0) {
                int[] arr = new int[section];
                for (int i = 0; i < arr.length; i++) {
                    System.out.println((i + 1) + ". Ürünün Stok Miktarı Kaçtır");
                    arr[i] = read.nextInt();
                }

                int sum = 0;
                for (int item : arr) {
                    sum = sum + item;
                }
                System.out.println("Toplam Stok Adet :" + sum);
                break;
            } else {
                System.out.println("Lütfen sadece pozitif değer giriniz!");
            }
        }

    }
}
