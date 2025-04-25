package com.ibm.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebFilter(value = "/*",initParams =
//@WebInitParam(name = "username", value = "张三"))
public class TestFilter1 implements Filter {

    private String username = null;
    public TestFilter1() {
//        System.out.println("TestFilter1 实例化……");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("TestFilter1 init……");

        this.username = filterConfig.getInitParameter("username");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

//        System.out.println("username = " + this.username);

        //转型
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //预处理
//        System.out.println("TestFilter1 doFilter…… 预处理");

        //请求路径
        String requestURI = request.getRequestURI();
//        System.out.println("TestFilter1 doFilter…… 请求路径：" + requestURI);

        //保证流程继续执行
        filterChain.doFilter(servletRequest, servletResponse);
        //后处理
//        System.out.println("TestFilter1 doFilter…… 后处理");
    }

    @Override
    public void destroy() {
//        System.out.println("TestFilter1 destroy……");
    }
}
