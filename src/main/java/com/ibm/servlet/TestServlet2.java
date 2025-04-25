package com.ibm.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class TestServlet2 extends HttpServlet {
    public TestServlet2() {
//        System.out.println("TestServlet2  实例化……");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TestServlet2  doGET……");

        String localParameter1 = this.getInitParameter("localParameter1");
        System.out.println("localParameter1 = " + localParameter1);

        String localParameter2 = this.getInitParameter("localParameter2");
        System.out.println("localParameter2 = " + localParameter2);

        String globalParameter = this.getServletContext().getInitParameter("globalParameter");
        System.out.println("globalParameter = " + globalParameter);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TestServlet2  doPOST……");
    }


}
