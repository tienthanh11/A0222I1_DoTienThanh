<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 07/09/2022
  Time: 7:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        .font-text-footer {
            color: blue;
        }

        .text-light {
            text-decoration: none;
        }
    </style>
</head>
<body>
<div>
    <h1 class="font-text-footer">Add new product</h1>
    <c:if test="${mess != null}">
        <h2 class="text-danger">${mess}</h2>
    </c:if>
    <br>
    <div>
        <form action="/product?action=create" method="post">
            <div class="mb-3">
                <label for="exampleInputName" class="form-label">Name</label>
                <input type="text" name="name" class="form-control" id="exampleInputName"
                       value="${product.name}">
            </div>
            <div class="mb-3">
                <label for="exampleInputPrice" class="form-label">Price</label>
                <input type="text" name="price" class="form-control" id="exampleInputPrice"
                       value="${product.price}">
            </div>
            <div class="mb-3">
                <label for="exampleInputQuantity" class="form-label">Quantity</label>
                <input type="number" name="quantity" class="form-control" id="exampleInputQuantity"
                       value="${product.quantity}">
            </div>
            <div class="mb-3">
                <label for="exampleInputColor" class="form-label">Color</label>
                <input type="text" name="color" class="form-control" id="exampleInputColor"
                       value="${product.color}">
            </div>
            <div class="mb-3">
                <label for="exampleInputDescribe" class="form-label">Describe</label>
                <input type="text" name="describe" class="form-control" id="exampleInputDescribe"
                       value="${product.describe}">
            </div>
            <div class="mb-3">
                <label for="exampleInputCategory" class="form-label">Category</label>
                <select class="form-select" id="exampleInputCategory" name="categoryId">
                    <option selected>Open the category menu</option>
                    <c:forEach var="category" items="${categoryList}">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                </select>
            </div>
            <br>
            <div class="mb-5">
                <button type="submit" class="btn btn-success">Create</button> |
                <button type="button" class="btn btn-secondary">
                    <a class="text-light" href="/product">Back</a>
                </button>
            </div>
        </form>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
