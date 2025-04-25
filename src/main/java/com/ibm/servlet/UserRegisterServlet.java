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
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //设置输出内容类型
        response.setContentType("text/html;charset=utf-8");
        //获取out输出对象
        PrintWriter out = response.getWriter();

        //接收用户注册信息
        String regUsername = request.getParameter("username");
        String regPassword = request.getParameter("password");
        String regPhoto = request.getParameter("photo");
        int regScore = 10;
        Date regTime = new Date();

        UserService userService = new UserServiceImpl();
        //接收用户名,用于判断是否存在

        if(userService.checkUsername(regUsername)){
            User regUser = new User();
            //将用户数据封装到User对象中
            regUser.setUsername(regUsername);
            regUser.setPassword(regPassword);
            regUser.setPhoto(regPhoto);
            regUser.setScore(regScore);
            regUser.setRegtime(regTime);

            //调用业务层方法
            userService.register(regUser);
            //注册成功，并返回登录界面
            out.print("<script>alert('注册成功');location='user_login.jsp'</script>");

        }else {
            out.print("<script>alert('用户名已存在，请重新输入用户名');history.back()</script>");
        }


    }
}
