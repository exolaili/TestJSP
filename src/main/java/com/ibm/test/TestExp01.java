package com.ibm.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestExp01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "123456");

        Statement stmt = conn.createStatement();

        for(int i = 1;i<=100;i++){
            String sql = "insert into user values (null,'user','exo5')";
            stmt.executeUpdate(sql);
        }




        stmt.close();
        conn.close();

    }
}
