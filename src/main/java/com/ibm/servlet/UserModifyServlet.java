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

@WebServlet("/modify")
public class UserModifyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用业务层方法
        UserService userService = new UserServiceImpl();
        //获取session
        HttpSession session = request.getSession();
        //获取用户id
        int userid = Integer.parseInt(request.getParameter("userid"));

        // 获取用户对象
        User upUser = userService.getUser(userid);

        if (upUser != null) {
            // 将用户对象存入 session
            session.setAttribute("user", upUser);
        } else {
            // 处理用户不存在的情况
            response.getWriter().println("用户不存在");
            return;
        }


        //在session属性范围中保存用户id
        session.setAttribute("userid",upUser.getUserid());

        //在session属性范围中保存用户名关键字
        session.setAttribute("username",upUser.getUsername());

        //在session属性范围中保存密码
        session.setAttribute("password",upUser.getPassword());

        //重定向到用户修改页面
        response.sendRedirect("user_modify.jsp");

//        // 转发到update
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/update");
//        dispatcher.forward(request, response);
    }

}
