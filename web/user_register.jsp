<%--
  Created by IntelliJ IDEA.
  User: HONOR
  Date: 2025/3/25
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 align="center">新用户注册</h3>

<form action="/register" method="post">
    <table align="center" border = "0" cellspacing="0">
        <tr>
            <td>用户名：</td>
            <td>
                <input type="text" name="username" width="200px">
            </td>
        </tr>

        <tr>
            <td>密码：</td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>

        <tr>
            <td>头像</td>
            <td>
                <input type="radio" name="photo" value="1.gif" checked><img src="image/photo/1.gif">
                <input type="radio" name="photo" value="2.gif"><img src="image/photo/2.gif">
                <input type="radio" name="photo" value="3.gif"><img src="image/photo/3.gif">
                <input type="radio" name="photo" value="4.gif"><img src="image/photo/4.gif">
                <input type="radio" name="photo" value="5.gif"><img src="image/photo/5.gif">
            </td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="注册">
            </td>
        </tr>
    </table>
</form>


</body>
</html>
