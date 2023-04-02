import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserService {

    private DB db = new DB();

    public int save(User user) {
        int status = 0;
        Connection conn = db.connect();
        try {
            String sql = "insert into users values( null, ?, ?, ?, ?, ?, ?, now() )";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, user.getName());
            pre.setString(2, user.getSurname());
            pre.setString(3, user.getEmail());
            pre.setString(4, user.getPassword());
            pre.setBoolean(5, user.getStatus());
            pre.setInt(6, user.getAge());
            status = pre.executeUpdate();
        }catch (Exception ex) {
            System.err.println("Save Error : " + ex);
        }finally {
            db.close();
        }
        return status;
    }

    public int delete(int uid) {
        int status = 0;
        Connection conn = db.connect();
        try {
            String sql = "delete from users where uid = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, uid);
            status = pre.executeUpdate();
        }catch (Exception ex) {
            System.err.println("Delete Error : " + ex);
        }finally {
            db.close();
        }
        return status;
    }

    public int delete(int... uids) {
        int status = 0;
        Connection conn = db.connect();
        try {
            for ( int item : uids ) {
                String sql = "delete from users where uid = ? ";
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setInt(1, item);
                status = pre.executeUpdate();
            }
        }catch (Exception ex) {
            System.err.println("Delete Error : " + ex);
        }finally {
            db.close();
        }
        return status;
    }


    public int update( User user ) {
        int status = 0;
        Connection con = db.connect();
        try {
            String sql = "update users set name = ?, surname = ?, email = ?, password = ?, status = ?, age = ? where uid = ?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, user.getName());
            pre.setString(2, user.getSurname());
            pre.setString(3, user.getEmail());
            pre.setString(4, user.getPassword());
            pre.setBoolean(5, user.getStatus());
            pre.setInt(6, user.getAge());
            pre.setInt(7, user.getUid());
            status = pre.executeUpdate();
        }catch (Exception ex) {
            System.err.println("Update Error : " + ex);
        }finally {
            db.close();
        }
        return status;
    }

    public List<User> allList() {
        List<User> ls = new ArrayList<>();
        Connection conn = db.connect();
        try {
            String sql = "select * from users";
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            parseTable(ls, rs);
        }catch (Exception ex) {
            System.err.println("AllList Error : " + ex);
        }finally {
            db.close();
        }
        return ls;
    }

    public List<User> userSearch( String data, int page ) {
        List<User> ls = new ArrayList<>();
        Connection conn = db.connect();
        try {
            data = "%"+data+"%";
            String sql = "select * from users where name like ? or surname like ? or email like ? limit ?, 10";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, data);
            pre.setString(2, data);
            pre.setString(3, data);
            pre.setInt(4, page);
            ResultSet rs = pre.executeQuery();
            parseTable(ls, rs);
        }catch (Exception ex) {
            System.err.println("AllList Error : " + ex);
        }finally {
            db.close();
        }
        return ls;
    }

    public boolean userLogin( String email, String password ) {
        boolean status = false;
        Connection conn = db.connect();
        try {
            String sql = "select uid from users where email = ? and password = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, email);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            status = rs.next();
        }catch (Exception ex) {
            System.err.println("UserLogin Error : " + ex);
        }finally {
            db.close();
        }
        return status;
    }


    public void parseTable(List<User> ls, ResultSet rs) throws SQLException {
        while (rs.next()) {
            int uid = rs.getInt("uid");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String email = rs.getString("email");
            String password = rs.getString("password");
            Boolean status = rs.getBoolean("status");
            Integer age = rs.getInt("age");
            Date date = rs.getDate("date");

            User u = new User(name,surname, email, password, status, age);
            u.setUid(uid);
            u.setDate(date);
            ls.add(u);
        }
    }


}
