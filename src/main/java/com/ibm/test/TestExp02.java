package com.ibm.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestExp02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "123456");


    }
}
