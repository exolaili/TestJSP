package com.ibm.test;

import java.sql.*;

public class TestJDBC1p {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "123456");

        String sql = "insert into user values (6,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, "zhangsan");
        pstmt.setString(2, "123456");

        int row = pstmt.executeUpdate();
        System.out.println("row = " + row);
        pstmt.close();
        conn.close();

    }
}
