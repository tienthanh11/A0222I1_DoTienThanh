<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22/08/2022
  Time: 7:44 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <style>
        h1 {
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
<h1>Products</h1>
<p>
    <a href="/products?action=create">Create new product</a>
</p>
<form >
    <input type="text" name="search" placeholder="Search By Name">
    <input type="text" name="action" hidden value="search">
    <button>Search</button>
</form>
<table class="table table-primary">
    <tr class="table-success">
        <td><strong>Id</strong></td>
        <td><strong>Name</strong></td>
        <td><strong>Price</strong></td>
        <td><strong>Description</strong></td>
        <td><strong>Producer</strong></td>
        <td><strong>Edit</strong></td>
        <td><strong>Delete</strong></td>
    </tr>
    <c:forEach var="product" items='${requestScope["products"]}'>
        <tr>
            <td>${product.getId()}</td>
            <td><a href="/products?action=view&id=${product.getId()}">${product.getName()}</a></td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getProducer()}</td>
            <td>
                <a href="/products?action=edit&id=${product.getId()}">
                    <button type="button" class="btn btn-outline-primary">Edit</button>
                </a>
            </td>
            <td>
                <a href="/products?action=delete&id=${product.getId()}">
                    <button type="button" class="btn btn-outline-primary">Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
