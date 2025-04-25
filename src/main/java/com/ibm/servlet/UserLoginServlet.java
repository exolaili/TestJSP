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

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session对象
        HttpSession session = request.getSession();

        //接收数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //调用业务层方法
        UserService userService = new UserServiceImpl();
        User user = userService.login(username, password);

        if (user != null) {//登录成功
            //在session属性范围中保存用户对象
            session.setAttribute("user", user);

            //重定向转跳到主页
            response.sendRedirect("user_index.jsp");
        } else {//登录失败
            //在request属性范围中保存登录失败的提示信息
            request.setAttribute("loginErrorMessage", "登录失败");

            //转跳到登录页面
            request.getRequestDispatcher("user_login.jsp").forward(request, response);

        }
    }
}
