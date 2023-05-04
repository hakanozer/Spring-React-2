package com.works.product.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/java_se";
    private final String username = "root";
    private final String password = "";

    private Connection conn = null;

    public Connection connect() {
        try {
            if ( conn == null || conn.isClosed() ) {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, username, password);
                System.out.println("Connection Success");
            }
        }catch (Exception ex) {
            System.err.println("Connection Error: " + ex);
        }
        return conn;
    }

    public void close() {
        try {
            if ( conn != null && !conn.isClosed() ) {
                conn.close();
                System.out.println("Connection Close");
            }
        }catch (Exception ex) {
            System.err.println("Close Error : " + ex);
        }
    }

}
