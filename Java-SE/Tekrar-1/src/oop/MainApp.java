package oop;

public class MainApp {

    public static void main(String[] args) {

        Action action = new Action();
        Action action1 = new Action(50);

        Settings settings = new Settings();
        Action action2 = new Action(  settings );

        action.a = 5;
        action1.a = 20;
        action2.a = 30;

        System.out.println( action.call() ); // 25

        int minus = Settings.minus(40,5);
        System.out.println(minus);

        final String a;
        a = "";

        Settings.Profile profile = new Settings().new Profile();
        System.out.println( profile.age );

    }

}
