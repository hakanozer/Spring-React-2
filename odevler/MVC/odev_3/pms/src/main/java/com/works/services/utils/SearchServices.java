package com.works.services.utils;

import com.works.props.Products;
import com.works.props.Products;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SearchServices {

    public List<Products> search(String q){
        DB db=new DB();
        List<Products> ls=new ArrayList<>();
        try {
            String sql="select * from products where title like ? or price like ? or detail like ? or stock like ?";
            PreparedStatement pre=db.connect().prepareStatement(sql);
            pre.setString(1,"%"+q+"%");
            pre.setString(2,"%"+q+"%");
            pre.setString(3,"%"+q+"%");
            pre.setString(4,"%"+q+"%");
            ResultSet rs=pre.executeQuery();
            while (rs.next()){
               Products products=new Products();
                products.setPid(rs.getInt("pid"));
                products.setTitle(rs.getString("title"));
                products.setPrice(rs.getInt("price"));
                products.setDetail(rs.getString("detail"));
                products.setStock(rs.getInt("stock"));
                ls.add(products);
            }
        }catch (Exception ex){
            System.err.println("Search Products Error"+ex);
        }finally {
            db.close();
        }return ls;
    }


}
