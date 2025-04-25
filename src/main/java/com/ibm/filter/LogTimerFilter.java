package com.ibm.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebFilter("/*")
public class LogTimerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //转型
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        long begin = System.currentTimeMillis();

        filterChain.doFilter(request, response);

        long end = System.currentTimeMillis();


        String logInfo = "IP地址 = " + request.getRemoteAddr() +
                " 请求路径 = " + request.getRequestURI() +
                " 请求方式 = " + request.getMethod() +
                " 响应状态码 = " + response.getStatus() +
                " 执行时间 = " + (end-begin) + "ms" ;

        System.out.println(logInfo);

        //String filename = "D:\\logtime.log"; // logtime.2025-04-01.log

        //格式化当前日期
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(new Date());

        //生成文件名
        String filename = "D:\\logtime." + today + ".log";

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, true));  //打开文件流，true表示追加内容
        bufferedWriter.write(logInfo);  //写入日志信息
        bufferedWriter.newLine();  //换行
        bufferedWriter.close();  //关闭文件流
    }
}
