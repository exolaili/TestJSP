package com.ibm.util;

import java.sql.*;

//JDBC的工具类
public class JDBCUtil {

    private Connection conn;
    private PreparedStatement pstmt;

    //构造方法
    public JDBCUtil(){

        //加载JDBC驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //打开数据库连接，只在类内部使用
    private void openConnection(){
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //关闭数据库连接
    public void closeConnection(){

        try {
            if(this.pstmt!=null) {
                this.pstmt.close();
                this.pstmt = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(this.conn!=null) {
                this.conn.close();
                this.conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //数据更新
    public boolean execUpdate(String sql, Object... params){

        try {
            //获取连接
            openConnection();

            //通过conn创建语句对象
            this.pstmt = conn.prepareStatement(sql);

            //参数赋值
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i+1, params[i]);
            }

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            //关闭连接
            this.closeConnection();
        }

    }

    //数据查询
    public ResultSet execQuery(String sql, Object... params){

        try {
            //获取连接
            openConnection();

            //通过conn创建语句对象
            this.pstmt = conn.prepareStatement(sql);

            //参数赋值
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i+1, params[i]);
            }

            return pstmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws SQLException {

        JDBCUtil jdbcUtil = new JDBCUtil();

//        String sql = "insert into user values (null,?,?)";
//        boolean flag = jdbcUtil.execUpdate(sql, "user12", "exo12");
//
//        System.out.println(flag);

        String sql = "select * from user where userid > ?";
        ResultSet rs = jdbcUtil.execQuery(sql,4);

        while(rs.next()){
            System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" +  rs.getString(3));
        }

        jdbcUtil.closeConnection();

    }

}
