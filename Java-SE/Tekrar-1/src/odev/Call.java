package odev;

import java.util.Scanner;

public class Call extends Action{

    @Override
    int getParam() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sayı giriniz");
        int say = scanner.nextInt();
        return say;
    }

}
