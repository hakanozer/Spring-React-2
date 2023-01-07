package works;

public class MainApp {
    public static void main(String[] args) {

        BankCustomer customer = new BankCustomer();
        String name = customer.userName(38444326486l);
        System.out.println(name);
        System.out.println("This Line Call");

        // normal değişken
        System.out.println( customer.city );
        customer.city = "Ankara";
        System.out.println( customer.city );
        System.out.println( customer.hashCode() );

        // statis using
        Settings settings = new Settings();
        settings.userNameSet();

        System.out.println( BankCustomer.name );
        BankCustomer.name = "Serkan Bil";
        System.out.println( BankCustomer.name );

    }
}
