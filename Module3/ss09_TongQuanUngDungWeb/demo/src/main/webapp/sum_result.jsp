<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/08/2022
  Time: 3:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int n1 = Integer.parseInt(request.getParameter("num1"));
    int n2 = Integer.parseInt(request.getParameter("num2"));
    int sum = n1 + n2;
%>
<h1>result <%=sum%></h1>
</body>
</html>
