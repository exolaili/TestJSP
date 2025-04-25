package com.ibm.service;

import com.ibm.entity.User;

import java.util.List;

public interface UserService {

    //用户登录
    User login(String username, String password);

    //用户查询
    List<User> getUserList(String username, int minScore, int maxScore);

    //用户删除
    boolean deleteUser(int userid);

    //用户注册
    boolean register(User user);

    //检查用户名是否存在
    boolean checkUsername(String username);

    //查询当前用户信息
    User getUser(int userid);

    //更新当前用户信息
    boolean updateUser(User user);
}
