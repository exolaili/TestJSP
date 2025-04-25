package com.ibm.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebFilter("/*")
public class TestFilter2 implements Filter {

    public TestFilter2() {
//        System.out.println("TestFilter2 实例化……");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("TestFilter2 init……");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //转型
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //预处理
//        System.out.println("TestFilter2 doFilter…… 预处理");

        //请求路径
        String requestURI = request.getRequestURI();
//        System.out.println("TestFilter2 doFilter…… 请求路径：" + requestURI);

        //保证流程继续执行
        filterChain.doFilter(servletRequest, servletResponse);
        //后处理
//        System.out.println("TestFilter2 doFilter…… 后处理");
    }

    @Override
    public void destroy() {
//        System.out.println("TestFilter2 destroy……");
    }
}
