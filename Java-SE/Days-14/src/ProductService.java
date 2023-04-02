import models.ProductJoin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductService {

    private DB db = new DB();

    public void list() {
        Connection conn = db.connect();
        try {
            String sql = "select p.pid, p.title, p.price, c.ctitle from product as p\n" +
                    "inner join product_category pc on p.pid = pc.pid\n" +
                    "inner join category c on pc.cid = c.cid";
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while( rs.next() ) {
                int pid = rs.getInt("pid");
                String title = rs.getString("title");
                int price = rs.getInt("price");
                String cTitle = rs.getString("cTitle");

                ProductJoin p = new ProductJoin(pid, title, price, cTitle);
                System.out.println( p );
            }
        }catch (Exception ex) {
            System.err.println("List error : " + ex);
        }finally {
            db.close();
        }
    }

}
