import models.User;

import java.sql.Connection;
import java.util.List;

public class AppMain {

    public static void main(String[] args) {
        UserService service = new UserService();
        /*
        DB db = new DB();
        Connection con1 = db.connect();
        Connection con2 = db.connect();
        Connection con3 = db.connect();

        System.out.println( con1.hashCode() );
        System.out.println( con2.hashCode() );
        System.out.println( con3.hashCode() );
         */
        /*
        User u = new User("Sultan", "Bilirim", "sultanx@mail.com", "12345", true, 32);

        int statusInsert = service.save(u);
        if ( statusInsert > 0 ) {
            System.out.println("Insert Success");
        }else {
            System.out.println("Duplicate Email entry Problem");
        }

        int statusDelete = service.delete(103);
        System.out.println("statusDelete : " + statusDelete);


        //int statusDeleteAll = service.delete(105);
        //System.out.println("statusDeleteAlls : " + statusDeleteAll);

        User u = new User("Sultan", "Bilirim", "sultany@mail.com", "12345", true, 32);
        u.setUid(150);
        int statusUpdate = service.update(u);
        System.out.println("statusUpdate : " + statusUpdate);


        List<User> ls = service.allList();
        for ( User item : ls ) {
            System.out.println( item.getUid() );
        }

        List<User> ls = service.userSearch("a", 20);
        for ( User item : ls ) {
            System.out.println( item );
        }
         */
        boolean loginStatus = service.userLogin("zehra@mail.com","6lXYqe");
        System.out.println(loginStatus);

        ProductService productService = new ProductService();
        productService.list();

    }

}
