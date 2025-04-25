package com.ibm.test;

import java.sql.*;

public class TestJDBC2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "123456");

        Statement stmt = conn.createStatement();
        String sql = "select * from user";

        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "\t" +rs.getString(2) + "\t" + rs.getString(3));
        }

        rs.close();
        stmt.close();
        conn.close();

    }
}
