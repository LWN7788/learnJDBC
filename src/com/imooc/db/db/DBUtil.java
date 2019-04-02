package com.imooc.db.db;

import java.sql.*;

public class DBUtil {
    private static final String URL="jdbc:mysql://localhost:3306/imooc";
    private static final String NAME="root";
    private static final String PASSWORD="ggsddu";
    private static Connection conn=null;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(URL,NAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return conn;
    }

}
