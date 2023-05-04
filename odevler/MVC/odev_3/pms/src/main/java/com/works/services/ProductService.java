package com.works.services;

import com.works.props.Products;
import com.works.services.utils.DB;
import org.apache.catalina.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    public List<Products> products() {
        List<Products> ls = new ArrayList<>();
        DB db = new DB();
        try {
            String sql = "select * from products";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()) {
                Products products=new Products();
                products.setPid( rs.getInt("pid") );
                products.setTitle( rs.getString("title") );
                products.setPrice( rs.getInt("price") );
                products.setDetail( rs.getString("detail") );
                products.setStock(rs.getInt("stock"));

                ls.add(products);
            }
        }catch (Exception ex) {
            System.err.println("Users Err or : " + ex);
        }finally {
            db.close();
        }
        return ls;
    }


    public int addProduct (Products products){
        DB db = new DB();
        int status = 0;
        try{
            String sql = "insert into products values( null,?,?,?,? )";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setString(1, products.getTitle());
            pre.setInt(2, products.getPrice());
            pre.setString(3, products.getDetail());
            pre.setInt(4, products.getStock());

            status = pre.executeUpdate();
        } catch (Exception ex) {
            System.err.println("Product Save Exception : " +ex);
        } finally {
            db.close();
        }
        return status;
    }

}
