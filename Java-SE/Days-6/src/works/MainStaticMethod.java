package works;

public class MainStaticMethod {
    public static void main(String[] args) {

        // static method call
        Settings.action();

        String address = "Antalya";
        System.out.println(address);

        // static object using
        System.out.println( Settings.user.hashCode() );
        Settings.user.getEmail();
        Settings.user.email = "erkan@mail.com";
        Settings.user.getEmail();

        // Settings.user = new User();
        System.out.println( Settings.user.hashCode() );
        Settings.user.getEmail();

        MainStaticMethod mainStaticMethod = new MainStaticMethod();
        mainStaticMethod.read();

    }

    public void read() {
        System.out.println("Read Call");
    }

}
