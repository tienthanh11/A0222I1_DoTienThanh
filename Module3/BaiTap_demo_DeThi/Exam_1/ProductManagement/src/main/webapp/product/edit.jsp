<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/09/2022
  Time: 7:21 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <style>
        .font-text-footer {
            color: blue;
        }

        .show-search {
            width: 130px;
        }

        .create-new {
            border: 1px solid white;
            background-color: darkturquoise;
            color: white;
        }
    </style>
</head>
<body>
<%--++++++++++++++hiển thị+++++++++++--%>
<div>
    <center>
        <h1 class="font-text-footer">Product List</h1>
        <c:if test="${mess != null}">
            <h2 class="text-danger">${mess}</h2>
        </c:if>
        <br>
        <br>
        <%--++++++++++++++++++form search++++++++++++++--%>
        <nav class="navbar navbar-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="/product?action=create">
                    <button type="button" class="create-new"><span class="bi bi-plus"></span>Add new product</button>
                </a>
                <form class="d-flex" action="/product" method="get">
                    <input class="form-control me-2" type="search" name="nameProductSearch" placeholder="Search"
                           aria-label="Search" value="${nameProductSearch}">
                    <button type="submit" class="btn btn-primary show-search" name="action" value="search">
                        <span class="bi bi-search"></span> Search
                    </button>
                </form>
            </div>
        </nav>
    </center>
    <br>
    <div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Color</th>
                <th>Describe</th>
                <th>Category</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${productList}">
                <tr>
                    <td><c:out value="${product.id}"/></td>
                    <td><c:out value="${product.name}"/></td>
                    <td><c:out value="${product.price}"/></td>
                    <td><c:out value="${product.quantity}"/></td>
                    <td><c:out value="${product.color}"/></td>
                    <td><c:out value="${product.describe}"/></td>
                    <c:forEach var="category" items="${categoryList}">
                        <c:if test="${product.categoryId == category.id}">
                            <td><c:out value="${category.name}"/></td>
                        </c:if>
                    </c:forEach>
                    <td>
                        <button type="submit" class="btn btn-primary">Edit</button>
                    </td>
                    <td>
                        <!-- Button trigger modal -->
                        <button type="button" onclick="showInfo('${product.id}', '${product.name}')"
                                class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal">
                            Delete
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<!-- Modal Delete -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <%-----------thêm thẻ form---------%>
        <form action="/product?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-danger" id="deleteModalLabel">Xác nhận xoá !</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input hidden type="text" name="idDelete" id="idDelete">
                    <span>Bạn có muốn xoá product</span>
                    <span class="text-danger" id="idValueProduct"></span><span> không ?</span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>

<%--
<form action="/product?action=edit" method="post">
    <td><input name="id" disabled type="text" value="${product.id}"></td>
    <td><input name="name" type="text" value="${product.name}"></td>
    <td><input name="price" type="number" value="${product.price}"></td>
    <td><input name="quantity" type="number" value="${product.quantity}"></td>
    <td><input name="color" type="text" value="${product.color}"></td>

    <td>
        <select name="typeId" class="me-2">
            <c:forEach items="${categoryList}" var="category">
                <c:if test="${product.categoryId == category.id}">
                    <option value="${category.id}" selected>${category.name}</option>
                </c:if>
            </c:forEach>

            <c:forEach items="${categoryList}" var="category">
                <c:if test="${product.categoryId != category.id}">
                    <option value="${category.id}" selected>${category.name}</option>
                </c:if>
            </c:forEach>
        </select>
    </td>

    <td>
        <a href="/product?action=edit&id=${product.id}">
            <button type="submit" class="btn btn-primary">Edit</button>
        </a>
    </td>
    <td>
        <!-- Button trigger modal -->
        <button type="button" onclick="showInfo('${product.id}','${product.name}')"
                class="btn btn-danger"
                data-bs-toggle="modal"
                data-bs-target="#deleteModal">
            Delete
        </button>
    </td>
</form>
--%>

