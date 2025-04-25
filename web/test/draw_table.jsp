<%--
  Created by IntelliJ IDEA.
  User: HONOR
  Date: 2025/3/24
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1" cellspacing="0">
       <%
           int data = 1;
           String color = "red";
           for(int i =1;i<=10;i++){

                  if (i%2==0){
                       color = "red";
                   }else if (i%2==1){
                       color = "yellow";
                   }

                  out.print("<tr bgcolor=" + color + ">");

               for(int j =1;j<=10;j++){
                   out.print("<td>" + (data++) + "</td>");
               }

              out.print("</tr>");
           }
       %>
    </table>
</body>
</html>
