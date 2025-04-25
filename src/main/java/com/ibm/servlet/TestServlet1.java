package com.ibm.servlet;

import jakarta.servlet.*;

import java.io.IOException;

public class TestServlet1 implements Servlet {

    public TestServlet1() {
//        System.out.println("TestServlet1  实例化……");
    }
    @Override//初始化方法
    public void init(ServletConfig servletConfig) throws ServletException {
//        System.out.println("TestServlet1  初始化……");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override//服务方法
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("TestServlet1  服务……");
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override//销毁方法
    public void destroy() {
        System.out.println("TestServlet1  销毁……");
    }
}
