package Soru5;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen kilonuzu kg cinsinden girin: ");
        double kilo = input.nextDouble();
        System.out.print("Lütfen boyunuzu metre cinsinden(nokta değil virgül kullanarak) girin: ");
        double boy = input.nextDouble();

        BMICalculator bmiCalculator = new BMICalculator();
        double bmi = bmiCalculator.calculateBMI(kilo, boy);
        System.out.println(bmi);
    }
}
