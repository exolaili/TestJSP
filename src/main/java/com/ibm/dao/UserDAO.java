package com.ibm.dao;

import com.ibm.entity.User;

import java.util.List;

public interface UserDAO {
    //根据用户名和密码查找用户
    User findUser(String username, String password);

    //根据用户名、积分段查找用户
    List<User> findUserList(String username, int minScore, int maxScore);

     //根据主键删除用户
     boolean deleteUser(int userid);

     //注册成功，插入用户
     boolean insertUser(User user);

     //查找用户名是否已经存在
     boolean findUserCount(String username);

     //根据主键修改当前用户信息
    User findUser(int userid);

    //根据主键更新当前用户信息
    boolean updateUser(User user);
}
