<%--
  Created by IntelliJ IDEA.
  User: HONOR
  Date: 2025/3/26
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主页</title>
</head>
<body>

<c:if test="${sessionScope.user == null}">
    <script>
        // 弹出对话框
        alert("您尚未登录，请先登录,再查看主页用户信息");
        // 跳转登录页面
        location = "user_login.jsp";
    </script>

</c:if>

<c:if test="${sessionScope.user != null}">

    <img src="image/photo/${sessionScope.user.photo}">
    欢迎【${sessionScope.user.username}】光临主页，当前积分为：${sessionScope.user.score}
    <br>
    <a href="/query">点击查看用户信息</a>
    <br>
    <a href="/logout">用户注销</a>
    
</c:if>


</body>
</html>
