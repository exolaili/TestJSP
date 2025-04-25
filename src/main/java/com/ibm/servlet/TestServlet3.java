package com.ibm.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


//@WebServlet(urlPatterns = {"/test3","/test4"})
//@WebServlet(urlPatterns = "/test3")
//@WebServlet(value = "/test30")
@WebServlet(value = "/test3",loadOnStartup = 3,
        initParams = {
        @WebInitParam(name = "username",value = "张三"),
        @WebInitParam(name = "password",value = "123")

        })
public class TestServlet3 extends HttpServlet {

    public TestServlet3() {
//        System.out.println("TestServlet3 实例化……");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TestServlet3 doGET……");

        String username = this.getInitParameter("username");
        System.out.println("username = " + username);

        String password = this.getInitParameter("password");
        System.out.println("password = " + password);


    }
}
