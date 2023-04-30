package com.works.services;

import com.works.props.User;
import com.works.utils.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public List<User> users(int p) {
        List<User> ls = new ArrayList<>();
        DB db = new DB();
        try {
            p = p - 1;
            p = p * 50;
            String sql = "select * from users where status = 1 order by uid desc limit ? ,50";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setInt(1, p);
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

    public int totalCount() {
        int count = 0;
        DB db = new DB();
        try {
            String sql = "select count(uid) as count  from users where status = 1";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            if ( rs.next() ) {
                count = rs.getInt("count");
            }
        }catch (Exception ex) {
            System.err.println("totalCount Error : " + ex);
        }finally {
            db.close();
        }
        return count;
    }

    public int deleteUser(int uid, int dbStatus) {
        int status = 0;
        DB db = new DB();
        try {
            //String sql = "delete from users where uid = ?";
            String sql = "update users set status = ? where uid = ?";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setInt(1,dbStatus);
            pre.setInt(2,uid);
            status = pre.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            db.close();
        }
        return status;
    }

    public int userSave( User user ) {
        int status = 0;
        DB db = new DB();
        try {
            String sql = "insert into users values(null, ?, ?, ?, ?, 1, ?, now())";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setString(1, user.getName());
            pre.setString(2, user.getSurname());
            pre.setString(3, user.getEmail());
            pre.setString(4, user.getPassword());
            pre.setInt(5,user.getAge());
            status = pre.executeUpdate();
        }catch (Exception ex) {
            System.err.println("userSave Error : " + ex);
        }finally {
            db.close();
        }
        return status;
    }


    public User single( int uid ) {
        DB db = new DB();
        User u = new User();
        try {
            String sql = "select * from users where uid = ?";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setInt(1,uid);
            ResultSet rs = pre.executeQuery();
            if ( rs.next() ) {
                u.setUid( rs.getInt("uid") );
                u.setName( rs.getString("name") );
                u.setSurname( rs.getString("surname") );
                u.setEmail( rs.getString("email") );
                u.setPassword(rs.getString("password"));
                u.setAge(rs.getInt("age"));
                u.setDate( rs.getString("date") );
            }
        }catch (Exception ex) {
            System.err.println("single Error : " + ex);
        }finally {
            db.close();
        }
        return u;
    }

}