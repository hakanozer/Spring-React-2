package oop;

public class Settings {

    public Settings() {
        System.out.println("oop.Settings Call");
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public static int minus(int a, int b) {
        return a - b;
    }

    class Profile {
        int age = 30;
    }

}
