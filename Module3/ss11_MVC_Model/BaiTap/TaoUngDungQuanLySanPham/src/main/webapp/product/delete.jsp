<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/08/2022
  Time: 3:38 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting product</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${requestScope["product"].getName()}</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${requestScope["product"].getPrice()}</td>
            </tr>
            <tr>
                <td>Description: </td>
                <td>${requestScope["product"].getDescription()}</td>
            </tr>
            <tr>
                <td>Producer: </td>
                <td>${requestScope["product"].getProducer()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete product"/></td>
                <td><a href="/products">Back to product list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
