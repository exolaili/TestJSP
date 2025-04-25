package com.ibm.servlet;

import com.ibm.entity.User;
import com.ibm.service.UserService;
import com.ibm.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/query")

public class UserQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收用户名
        String username = request.getParameter("username");

        //处理默认值
        if(username == null){
            username = "";
        }

        //接收最小积分
        String sminScore = request.getParameter("minScore");
        //处理默认值
        int minScore = 0;
        if(sminScore == null){
            sminScore = "0";
        }
        if(!"".equals(sminScore)){
            //数据转型
            minScore = Integer.parseInt(sminScore);
        }


        //接收最大积分
        String smaxScore = request.getParameter("maxScore");
        //处理默认值
        int maxScore = 0;
        if(smaxScore == null){
            smaxScore = "0";
        }
        if(!"".equals(smaxScore)){
            //数据转型
            maxScore = Integer.parseInt(smaxScore);
        }

        //调用业务层方法
        UserService userService = new UserServiceImpl();
        List<User> userList = userService.getUserList(username,minScore,maxScore);

        //在request属性范围中保存用户对象
        request.setAttribute("userList",userList);

        //在request属性范围中保存用户名关键字
        request.setAttribute("username",username);

        //在request属性范围中保存最小积分
        request.setAttribute("minScore",sminScore);

        //在request属性范围中保存最大积分
        request.setAttribute("maxScore",smaxScore);

        //转发到用户查看列表
        request.getRequestDispatcher("user_query.jsp").forward(request,response);
    }
}
