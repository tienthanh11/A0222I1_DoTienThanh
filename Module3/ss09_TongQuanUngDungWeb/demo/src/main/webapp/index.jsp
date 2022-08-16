<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/08/2022
  Time: 10:34 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Trang index</h1>
<a href="/hello?num1=12&num2=23">Vào trang hello</a>
<form action="/xin-chao" method="get">
    <input type="text" name="num1">
    <input type="text" name="num2">
    <button type="submit">Vào trang xin chào</button>
</form>
</body>
</html>