<%--
  Created by IntelliJ IDEA.
  User: HONOR
  Date: 2025/3/24
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .red{
            color: red;
            font-weight: bold;
        }
        td{
            width: 100px;
            height: 50px;
            text-align: center;
        }
    </style>
</head>
<body>

       <%
           //接收开始年份
           String sbegin = request.getParameter("begin_year");
           if(sbegin==null  || "".equals(sbegin)){
               sbegin = "1900";
           }
           int begin = Integer.parseInt(sbegin);
           //接收结束年份
           String send = request.getParameter("end_year");
           if(send==null  || "".equals(send)){
               send = "2025";
           }
           int end = Integer.parseInt(send);
           //接收行数
           String srow = request.getParameter("row");
           if(srow==null || "".equals(srow)){
               srow = "10";
           }
           int row = Integer.parseInt(srow);

           //接受列数
           String scol = request.getParameter("col");
           if(scol==null || "".equals(scol)){
                scol = "10";
           }
           int col = Integer.parseInt(scol);
           %>

          <table border="1" cellspacing="0">
          <%
              int year = begin;
              for(int i =1;i<=row;i++){

               out.print("<tr>");

               for(int j =1;j<=col;j++){
                   if(year<=end){
                       if(isLeapYear(year)){
                           out.print("<td class ='red'>"+ (year++) +"</td>");
                       }else{
                           out.print("<td>"+ (year++) +"</td>");
                       }
                   }else{
                       out.print("<td></td>");
                   }
               }
               out.print("</tr>");
           }
        %>
        <%!
            boolean isLeapYear(int year){
//                if(year%4==0 && year%100!=0 || year%400==0){
//                    return true;
//                }
//                return false;
                return year %4 == 0 && year %100 !=0 || year %400 ==0;
            }
        %>

    </table>

</body>
</html>
