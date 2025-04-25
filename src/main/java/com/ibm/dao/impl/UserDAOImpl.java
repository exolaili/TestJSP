package com.ibm.dao.impl;

import com.ibm.dao.UserDAO;
import com.ibm.entity.User;
import com.ibm.util.JDBCUtil2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private JDBCUtil2 jdbcUtil2 = new JDBCUtil2();

    @Override
    public User findUser(String username, String password) {

        String sql = "select * from user where username = ? and password = ?";

        ResultSet rs = jdbcUtil2.execQuery(sql, username, password);

        try {
            if (rs.next()) {//查找成功

                //    if("ibm".equals(username) && "123".equals(password)){//登录成功
                //        //在session属性范围中保存用户名
                //        session.setAttribute("username",username);
                //
                //        //在session属性范围中保存用户积分
                //        session.setAttribute("score",rs.getInt(4));
                //
                //        //在session属性范围中保存用户头像文件名
                //        session.setAttribute("photo",rs.getString(5));

                //创建并填充实体类对象
                User user = new User();

                user.setUserid(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setScore(rs.getInt(4));
                user.setPhoto(rs.getString(5));
                user.setRegtime(rs.getTimestamp(6));

                return user;

            } else {//查找失败
                return null;
            }
        } catch (SQLException e) {
            return null;
        } finally {
            //关闭数据库连接
            jdbcUtil2.closeConnection();
        }

    }

    @Override
    public List<User> findUserList(String username, int minScore, int maxScore) {

        String sql = null;
        ResultSet rs = null;

        if (minScore == 0 && maxScore == 0) {
            sql = "select * from user where username like ?";
            rs = jdbcUtil2.execQuery(sql, "%" + username + "%");
        } else if (minScore != 0 && maxScore == 0) {
            sql = "select * from user where username like ? and score >= ?";
            rs = jdbcUtil2.execQuery(sql, "%" + username + "%", minScore);
        } else if (minScore == 0 && maxScore != 0) {
            sql = "select * from user where username like ? and score <= ?";
            rs = jdbcUtil2.execQuery(sql, "%" + username + "%", maxScore);
        } else if (minScore != 0 && maxScore != 0) {
            sql = "select * from user where username like ? and score >= ? and score <= ?";
            rs = jdbcUtil2.execQuery(sql, "%" + username + "%", minScore, maxScore);
        }

        //用户列表
        List<User> userList = new ArrayList<>();
        try {
            while (rs.next()) {
                //创建并填充实体类对象
                User user = new User();

                user.setUserid(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setScore(rs.getInt(4));
                user.setPhoto(rs.getString(5));
                user.setRegtime(rs.getTimestamp(6));

                //添加到用户列表中
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            return null;
        } finally {
            jdbcUtil2.closeConnection();
        }
    }

    @Override
    public boolean deleteUser(int userid) {
        String sql = "delete from user where userid = ?";
        return jdbcUtil2.execUpdate(sql, userid);
    }

    @Override
    public boolean insertUser(User user) {
        String sql = "insert into user(username,password,score,photo,regTime) values(?,?,?,?,?)";
        boolean res = jdbcUtil2.execUpdate(sql, user.getUsername(), user.getPassword(), user.getScore(), user.getPhoto(), user.getRegtime());
        return res;

    }

    @Override
    public boolean findUserCount(String username) {
        String sql = "select * from user where username = ?";
        ResultSet rs = jdbcUtil2.execQuery(sql, username);
        //判断查询结果中是否有数据
        try {
            if (rs.next()) {//用户名重复
                return false;
            }
        } catch (SQLException e) {
            return false;
        }finally {
            jdbcUtil2.closeConnection();
        }
           return true;
    }

    @Override
    public User findUser(int userid) {
        String sql = "select username,password,photo from user where userid = ?";
        ResultSet rs = jdbcUtil2.execQuery(sql, userid);
        try {
            if (rs.next()) {
                User upUser = new User();
                upUser.setUserid(userid);
                upUser.setUsername(rs.getString(1));
                upUser.setPassword(rs.getString(2));
                upUser.setPhoto(rs.getString(3));

                return upUser;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            jdbcUtil2.closeConnection();
        }
        return null;
    }

    @Override
    public boolean updateUser(User user) {
        String sql = "update user set username = ?,password = ?,photo = ? where userid = ?";
        boolean res = jdbcUtil2.execUpdate(sql, user.getUsername(), user.getPassword(), user.getPhoto(), user.getUserid());
        if (res) {
            return true;
        }
        return false;
    }


}
