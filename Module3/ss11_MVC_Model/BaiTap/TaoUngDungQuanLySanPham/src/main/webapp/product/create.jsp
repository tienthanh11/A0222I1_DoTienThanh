<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23/08/2022
  Time: 5:20 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new product</title>
</head>
<body>
<h1>Create new product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>
                    <input type="text" name="name" id="name"/>
                </td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>
                    <input type="text" name="price" id="price"/>
                </td>
            </tr>
            <tr>
                <td>Description: </td>
                <td>
                    <input type="text" name="description" id="description"/>
                </td>
            </tr>
            <tr>
                <td>Producer: </td>
                <td>
                    <input type="text" name="producer" id="producer"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Create product"/>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
