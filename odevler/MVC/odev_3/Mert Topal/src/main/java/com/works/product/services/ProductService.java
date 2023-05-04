package com.works.product.services;

import com.works.product.props.Products;
import com.works.product.utils.DB;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    List<Products> ls = new ArrayList<>();
    DB db = new DB();
    public List<Products> products() {
        List<Products> ls = new ArrayList<>();
        DB db = new DB();
        try {
            int p = 0;
            p = p-1;
            p = p*50;
            String sql = "select * from Products ";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()) {
                Products products = new Products();
                products.setPid( rs.getInt("pid") );
                products.setTitle( rs.getString("title") );
                products.setPrice( rs.getInt("price") );
                products.setDetail( rs.getString("detail") );
                products.setStock( rs.getInt("stock") );
                ls.add(products);
            }
        }catch (Exception ex) {
            System.err.println("Users Error : " + ex);
        }finally {
            db.close();
        }
        return ls;
    }

    public Products product(int pid){
        Products products = new Products();
        int status =0;
        DB db = new DB();
        try {
            String sql = "select * from users where pid = ?";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setInt(1, pid);
            ResultSet rs = pre.executeQuery();
            if (rs.next()){
                products.setPid(rs.getInt("pid"));
                products.setTitle( rs.getString("title") );
                products.setPrice( rs.getInt("price") );
                products.setDetail( rs.getString("detail") );
                products.setStock( rs.getInt("stock") );
            }

        }catch (Exception e){
            System.err.println(e);
        }finally {
            db.close();
        }
        return products;
    }
    public int saveProduct(Products products) {
        System.out.println(products);
        int status = 0;
        DB db = new DB();
        try {
            String sql = "insert into products (pid,title,price, detail,stock) values (null,?, ?, ?,?)";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setString(1, products.getTitle());
            pre.setInt(2, products.getPrice());
            pre.setString(3, products.getDetail());
            pre.setInt(4, products.getStock());
            status = pre.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            db.close();
        }
        return status;
    }


}
