package works;

public class Settings {

    // final anahtar kelimesi
    // değişken yada nesnelerin değerlerini sabit tutmak için kullanlır.
    final static User user = new User();

    public void userNameSet() {
        System.out.println("userNameSet: " + BankCustomer.name );
        BankCustomer customer = new BankCustomer();
        System.out.println("userNameSet: " + customer.city );
        System.out.println( customer.hashCode() );
        final String email = "zehra@mail.com";
        final int num;
        num = 10;
    }

    // Static Method
    public static void action() {
        String status = "a10";
        System.out.println(status);
        int age = 100;
        System.out.println(age);
    }

}
