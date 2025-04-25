package com.ibm.service.impl;

import com.ibm.dao.UserDAO;
import com.ibm.dao.impl.UserDAOImpl;
import com.ibm.entity.User;
import com.ibm.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();
    @Override
    public User login(String username, String password) {
        return userDAO.findUser(username, password);
    }

    @Override
    public List<User> getUserList(String username, int minScore, int maxScore) {

        return userDAO.findUserList(username, minScore, maxScore);
    }

    @Override
    public boolean deleteUser(int userid) {
        return userDAO.deleteUser(userid);
    }

    @Override
    public boolean register(User user) {
        return userDAO.insertUser(user);
    }

    @Override
    public boolean checkUsername(String username) {
        return userDAO.findUserCount(username);
    }

    @Override
    public User getUser(int userid) {
        return userDAO.findUser(userid);
    }

    @Override
    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }


}
