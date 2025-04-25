package com.ibm.test;

import java.sql.*;

public class TestJDBC2p {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "123456");


        String sql = "select * from user where userid > ?";

        PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);

        pstmt.setInt(1, 2);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getInt(1) + "\t" +rs.getString(2) + "\t" + rs.getString(3));
        }

        rs.close();
        pstmt.close();
        conn.close();

    }
}
