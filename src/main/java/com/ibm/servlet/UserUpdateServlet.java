package com.ibm.servlet;

import com.ibm.entity.User;
import com.ibm.service.UserService;
import com.ibm.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/update")
public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session对象
        HttpSession session = request.getSession();

        //接收数据
        int userid = Integer.parseInt(request.getParameter("userid").trim());
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String photo = request.getParameter("photo").trim();

        //将数据封装到User对象中
        User saveUser = (User) session.getAttribute("user");
        saveUser.setUserid(userid);
        saveUser.setUsername(username);
        saveUser.setPassword(password);
        saveUser.setPhoto(photo);

        //调用业务层方法
        UserService userService = new UserServiceImpl();
        boolean res = userService.updateUser(saveUser);

        if (res) {
            //重定向到用户列表页面
            response.sendRedirect("user_query.jsp");
        } else {
            //重定向到用户修改页面
            response.sendRedirect("user_modify.jsp");
        }

//        // 转发到JSP页面
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user_modify.jsp");
//        dispatcher.forward(request, response);



    }
}
