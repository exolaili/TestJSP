<%--
  Created by IntelliJ IDEA.
  User: HONOR
  Date: 2025/3/26
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style type="text/css">
        .red{
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>
<%
    //从requests属性范围中取出登录失败的提示信息
    String loginErrorMessage = "";

    if(request.getAttribute("loginErrorMessage")!=null){
        loginErrorMessage = (String)request.getAttribute("loginErrorMessage");
    }
%>

<h3 align="center">用户登录</h3>

<center>
    <form action ="/login" method ="post">
        <table>
            <tr>
                <td>用户名：</td>
                <td>
                    <input type="text" name="username">
                </td>
            </tr>

            <tr>
                <td>密码：</td>
                <td>
                    <input type="password" name="password">
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="登录">
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <a><a href="user_register.jsp">注册新用户</a>
                </td>
            </tr>
        </table>
    </form>

    <div class="red"><%=loginErrorMessage%></div>
</center>
</body>
</html>
