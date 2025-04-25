package com.ibm.servlet;

import com.ibm.service.UserService;
import com.ibm.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置输出内容类型
        response.setContentType("text/html;charset=utf-8");
        //获取out输出对象
        PrintWriter out = response.getWriter();
        
        //接收用户编号
        int userid = Integer.parseInt( request.getParameter("userid"));

        //调用业务层编号
        UserService userService = new UserServiceImpl();

       if(userService.deleteUser(userid)){
            //提示删除成功
            out.print("<script>alert('删除成功');location='/query'</script>");

       }else {
           out.print("<script>alert('删除失败');history.back()</script>");
       }

    }
}
