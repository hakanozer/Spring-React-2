package useAbstract;

public class MainAbstract {
    public static void main(String[] args) {

        Customer customer = new Customer();
        System.out.println( customer.userName() );
        System.out.println( customer.userStatus() );

    }
}
