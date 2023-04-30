package com.works.services;

import com.works.props.User;
import com.works.utils.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SearchService {

    public List<User> search( String q ) {
        List<User> ls = new ArrayList<>();
        DB db = new DB();
        try {
            String sql = "select * from users where name like ? or surname like ? or email like ?";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setString(1, "%"+q+"%");
            pre.setString(2, "%"+q+"%");
            pre.setString(3, "%"+q+"%");
            ResultSet rs = pre.executeQuery();
            while(rs.next()) {
                User u = new User();
                u.setUid( rs.getInt("uid") );
                u.setName( rs.getString("name") );
                u.setSurname( rs.getString("surname") );
                u.setEmail( rs.getString("email") );
                u.setDate( rs.getString("date") );
                ls.add(u);
            }
        }catch (Exception ex) {
            System.err.println("Users Error : " + ex);
        }finally {
            db.close();
        }
        return ls;
    }


}
