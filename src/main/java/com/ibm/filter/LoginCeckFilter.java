package com.ibm.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


/*@WebFilter(value = "/*", initParams = {
     @WebInitParam(name = "servletPassList", value="/login, /register"),
     @WebInitParam(name = "jspPassList", value="/user_login.jsp, /user_register.jsp, /test_servlet.jsp")
})*/

public class LoginCeckFilter implements Filter {

    private String servletPassList;
    private String jspPassList;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.servletPassList = filterConfig.getInitParameter("servletPassList");
        this.jspPassList = filterConfig.getInitParameter("jspPassList");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //转型
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //设置输出内容
        response.setContentType("text/html;charset=utf-8 ");

        //获取out输出对象
        PrintWriter out = response.getWriter();

        //获取session对象
        HttpSession session = request.getSession();

        //获取请求路线
        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        //是否拦截标志变量
        boolean interceptFlag = false;

        if (!requestURI.contains(".")) {//servlet的路径 /login /register
            //if("/login".equals(requestURI) || "/register".equals(requestURI)){
            if (this.servletPassList.contains(requestURI)) {
                if (this.servletPassList.contains(requestURI)) {
                    interceptFlag = false;//无需拦截
                } else {
                    interceptFlag = true;//需要拦截
                }
            } else {//文件名
                if (requestURI.endsWith(".jsp")) {
                    //if("/user_login.jsp".equals(requestURI) || "/user_register.jsp".equals(requestURI)){
                    if (this.jspPassList.contains(requestURI)) {
                        interceptFlag = false;//无需拦截
                    } else {
                        interceptFlag = true;//需要拦截
                    }
                } else {//其他类型
                    interceptFlag = false;//无需拦截
                }
            }

            if (interceptFlag && session.getAttribute("user") == null) {//未登录
                out.print("<script>alert('您尚未登录，请先登录');location='/user_login.jsp'</script>");
            } else {
                filterChain.doFilter(request, response);
            }


        }
    }
}

