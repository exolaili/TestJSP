package com.ibm.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

import java.io.IOException;

@WebFilter(value = "/*",initParams = {
        @WebInitParam(name = "charSet",value = "UTF-8")})
public class CharacterEncodingFilter implements Filter {

    private String charSet;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.charSet = filterConfig.getInitParameter("charSet");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(this.charSet);
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
