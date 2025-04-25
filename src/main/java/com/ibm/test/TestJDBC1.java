package com.ibm.test;

import java.sql.*;

public class TestJDBC1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "123456");

        Statement stmt = conn.createStatement();
        String sql = "insert into user values (5,'user5','exo5')";
        int row = stmt.executeUpdate(sql);
        System.out.println("row = " + row);

        stmt.close();
        conn.close();

    }
}
