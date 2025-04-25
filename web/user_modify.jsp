<%@ page import="com.ibm.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: HONOR
  Date: 2025/3/31
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        .hidden{
            display: none;
        }
    </style>
</head>
<body>
<h3 align="center">用户资料修改</h3>

<%--<%--%>
<%--    Object userObj = session.getAttribute("user");--%>
<%--    if (userObj != null) {--%>
<%--        User user = (User) userObj;--%>
<%--    } else{--%>
<%--        response.getWriter().println("用户数据为空");--%>
<%--//        response.sendRedirect("user_login.jsp");--%>
<%--    }--%>
<%--%>--%>

<form action="/update">
    <table align="center" border = "1" cellspacing="0" width="700px">

<c:if test="${sessionScope.user == null}">
    <script>
        // 弹出对话框
        alert("用户信息为空，无法进行修改");
        // 跳转查询页面
        location = "user_query.jsp";
    </script>
</c:if>

<c:if test="${sessionScope.user != null}">

        <input type="hidden" name="userid" value="${sessionScope.user.userid}">

        <tr>
            <td>用户名：</td>
            <td>
                <input type="text" name="username" width="400px" value="${sessionScope.user.username}">
            </td>
        </tr>

        <tr>
            <td>密码：</td>
            <td>
                <input type="password" name="password" value="${sessionScope.user.password}">
            </td>
        </tr>

        <tr>
            <td>头像</td>
            <td>
                <img class="hidden" src="image/photo/${sessionScope.user.photo}" alt="当前头像" >
                <input type="radio" name="photo" value="1.gif" <c:if test="${sessionScope.user.photo == '1.gif'}">checked</c:if>><img src="image/photo/1.gif">
                <input type="radio" name="photo" value="2.gif" <c:if test="${sessionScope.user.photo == '2.gif'}">checked</c:if>><img src="image/photo/2.gif">
                <input type="radio" name="photo" value="3.gif" <c:if test="${sessionScope.user.photo == '3.gif'}">checked</c:if>><img src="image/photo/3.gif">
                <input type="radio" name="photo" value="4.gif" <c:if test="${sessionScope.user.photo == '4.gif'}">checked</c:if>><img src="image/photo/4.gif">
                <input type="radio" name="photo" value="5.gif" <c:if test="${sessionScope.user.photo == '5.gif'}">checked</c:if>><img src="image/photo/5.gif">
            </td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="保存" >
            </td>
        </tr>
</c:if>
    </table>
</form>
</body>
</html>
