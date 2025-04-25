<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.ibm.util.JDBCUtil2" %>
<%@ page import="com.ibm.entity.User" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: HONOR
  Date: 2025/3/26
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 align="center">用户列表查询</h3>
<center>
    <form action="/query" >
        用户名：<input type="text" name="username" value="${requestScope.username}">
       从<input type="text" name="minScore" value="${requestScope.minScore}">分
        从<input type="text" name="maxScore" value="${requestScope.maxScore}">分
        <input type="submit" value="查询">
    </form>
</center>


<table align="center" border = "1" cellspacing="0">

    <tr>
        <th>头像</th>
        <th>用户名</th>
        <th>积分</th>
        <th>注册时间</th>
        <th>操作</th>
    </tr>

<%--    从request属性范围中取出用户列表--%>
    <c:forEach items="${requestScope.userList}" var="user">
    <tr>
        <td><img src="image/photo/${user.photo}"></td>
        <td>${user.username}</td>
        <td>${user.score}</td>
        <td><fmt:formatDate value="${user.regtime}" pattern="yyyy年MM月dd日  HH时mm分ss秒"/></td>
        <td>
            <a href="/delete?userid=${user.userid}" onclick="return confirm('是否确定删除【${user.username}】')">删除</a>
            <a href="/modify?userid=${user.userid}&username=${user.username}&password=${user.password}&photo=${user.photo}">修改</a>
        </td>
    </tr>
    </c:forEach>
</table>

</body>
</html>
