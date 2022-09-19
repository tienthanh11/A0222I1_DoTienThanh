<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/09/2022
  Time: 2:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Product Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"/>
    <script src="webjars/jquery/3.6.0/dist/jquery.slim.min.js"></script>
    <link rel="stylesheet" href="webjars/izitoast/1.4.0/dist/css/iziToast.min.css"/>
    <script src="webjars/izitoast/1.4.0/dist/js/iziToast.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <script src="/product/script.js"></script>
</head>
<body>

<div class="container">
    <div class="row">
        <h2 style="text-align: center; color: blue">List Product</h2>
    </div>
    <div class="row mb-2">
        <div class="col-md-6 mb-2">
            <a type="button" class="btn btn-info border-end-0 border rounded-pill btn-create" data-bs-toggle="modal"
               data-bs-target="#createProductModal" data-id="${product.id}" style="color: white" href="">
                <span class="bi bi-plus"></span> Add new product
            </a>
        </div>
        <div class="col-md-6">
            <form action="" method="post" id="form-search" class="d-flex" style="margin-bottom: 0">
                <div class="col-4">
                    <select class="form-select border-end-0 border rounded-pill" id="select-sort"
                            aria-label="Default select example">
                        <c:forEach var="col" items='${requestScope["listColumn"]}' begin="1" end="5" varStatus="status">
                            <c:if test="${status.count == key}">
                                <option value="${status.count}" selected><c:out value="${col}"/></option>
                            </c:if>
                            <c:if test="${status.count != key}">
                                <option value="${status.count}"><c:out value="${col}"/></option>
                            </c:if>
                        </c:forEach>
                        <%--                    <option value="All" selected>All</option>--%>
                        <%--                    <option value="name">Product name</option>--%>
                        <%--                    <option value="price">Price</option>--%>
                        <%--                    <option value="quantity">Quantity</option>--%>
                        <%--                    <option value="color">Color</option>--%>
                        <%--                    <option value="category">Category</option>--%>
                    </select>
                </div>
                <div class="col-8">
                    <div class="input-group">
                        <c:choose>
                            <c:when test="${not empty value}">
                                <input type="search" class="form-control border-end-0 border rounded-pill"
                                       id="input-search" placeholder="&#xF002; Search" aria-label="Username"
                                       aria-describedby="basic-addon1"
                                       style="font-family:Arial, FontAwesome; margin-left:1%" value="${value}">
                            </c:when>
                            <c:otherwise>
                                <input type="search" class="form-control border-end-0 border rounded-pill"
                                       id="input-search" placeholder="&#xF002; Search" aria-label="Username"
                                       aria-describedby="basic-addon1"
                                       style="font-family:Arial, FontAwesome; margin-left:1%">
                            </c:otherwise>
                        </c:choose>
                        <%--                        <input type="search" class="form-control border-end-0 border rounded-pill" id="input-search"--%>
                        <%--                               placeholder="&#xF002; Search" aria-label="Username" aria-describedby="basic-addon1"--%>
                        <%--                               style="font-family:Arial, FontAwesome; margin-left: 1%"/>--%>
                        <button type="submit" class="btn btn-primary border-end-0 border rounded-pill btn-search"
                                style="font-family:Arial, FontAwesome; margin-left:1%">&#xF002; Search
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <c:if test="${not empty list}">
            <script>
                const t = ${list};
                iziToast.success({
                    position: "topCenter",
                    message: t == 1 ? "Deleted successfully" : t == 2 ? "Update successfully" : "Created successfully",
                    timeout: 2000
                });
            </script>
        </c:if>
        <c:if test="${empty products}">
            <p>Empty List Products/Not Found</p>
        </c:if>
        <c:if test="${not empty products}">
            <table class="table table-dark table-striped table-hover" id="myTable">
                <thead class="table table-primary">
                <tr>
                    <th>STT</th>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Color</th>
                    <th>Category</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody class="table-group-divider table-warning" style="border-top-color: red">
                <c:forEach var="product" items='${requestScope["products"]}' varStatus="status">
                    <tr>
                        <td><c:out value="${status.count}"/></td>
                        <td id="name"><c:out value="${product.name}"/></td>
                        <td id="price"><c:out value="${product.price}"/></td>
                        <td id="quantity"><c:out value="${product.quantity}"/></td>
                        <td id="color"><c:out value="${product.color}"/></td>
                        <td id="category"><c:out value="${product.category}"/></td>
                        <td>
                            <a type="button" class="btn btn-info btn-edit" data-bs-toggle="modal" data-id="${product.id}"
                               data-price="${product.price}" data-quantity="${product.quantity}"
                               data-color="${product.color}" data-description="${product.description}"
                               data-category="${product.category}" data-code_category="${product.code_category}"
                               data-bs-target="#editUserModal" >
                                <span class="bi bi-pencil" style="color: white"></span>
                            </a>
                            |
                            <a type="button" class="btn btn-danger btn-delete" data-bs-toggle="modal"
                               data-id="${product.id}" data-bs-target="#deleteUserModal" href="">
                                <span class="bi bi-trash" style="color: white"></span>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
    <div class="row" id="nav-page" data-id="${currentPage}">
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                <li class="page-item">
                    <c:if test="${currentPage != 1 and not empty currentPage}">
                        <a class="page-link pagination-link" href="/product?page=${currentPage - 1}">Previous</a>
                    </c:if>
                </li>
                <c:forEach begin="1" end="${noOfPages}" var="i">
                    <c:choose>
                        <c:when test="${currentPage eq i}">
                            <li class="page-item">
                                <a class="page-link pagination-link">${i}</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a class="page-link pagination-link" href="/product?page=${i}">${i}</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <li class="page-item">
                    <c:if test="${currentPage lt noOfPages}">
                        <a class="page-link pagination-link" href="/product?page=${currentPage + 1}">Next</a>
                    </c:if>
                </li>
            </ul>
        </nav>
    </div>
</div>
<!-- Create Modal -->
<div class="modal fade" id="createProductModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form action="/product?action=create" method="post">
                <div class="modal-header">
                    <h4 class="modal-title" style="color: blue">Create Product</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Product Name</label>
                        <input type="text" class="form-control" name="name" required/>
                    </div>
                    <div class="form-group">
                        <label>Product Price</label>
                        <input type="number" step="any" class="form-control" name="price" required>
                    </div>
                    <div class="form-group">
                        <label>Product Quantity</label>
                        <input type="number" class="form-control" name="quantity" required>
                    </div>
                    <div class="form-group">
                        <label>Product Color</label>
                        <input type="text" class="form-control" name="color" required/>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea class="form-control" name="description"></textarea>
                    </div>
                    <div class="form-group">
                        <label>Category</label>
                        <select class="form-select" name="category" id="select-category"
                                aria-label="Default select example" required>
                            <c:forEach var="category" items="${listCategory}" varStatus="status">
                                <option value="${category.id}"><c:out value="${category.name}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-danger" data-bs-dismiss="modal" value="Huỷ"/>
                    <input type="submit" class="btn btn-primary confirm-create" value="Xác nhận"/>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Edit Modal -->
<div class="modal fade" id="editUserModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form action="/product?action=edit" method="post" id="form_edit">
                <div class="modal-header">
                    <h4 class="modal-title" style="color: blue">Update product</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
<%--                        <label>ID Product</label>--%>
                        <input type="text" class="form-control" name="id" id="product_id" hidden/>
                    </div>
                    <div class="form-group">
                        <label>Product Name</label>
                        <input type="text" class="form-control" name="name" id="product_name" required/>
                    </div>
                    <div class="form-group">
                        <label>Product Price</label>
                        <input type="number" step="any" class="form-control" name="price" id="product_price" required>
                    </div>
                    <div class="form-group">
                        <label>Product Quantity</label>
                        <input type="number" class="form-control" name="quantity" id="product_quantity"required>
                    </div>
                    <div class="form-group">
                        <label>Product Color</label>
                        <input type="text" class="form-control" name="color" id="product_color" required/>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea class="form-control" name="description" id="product_description"></textarea>
                    </div>
                    <div class="form-group set_select">
                        <label>Category</label>
                        <select class="form-select" name="category" id="product_category"
                                aria-label="Default select example" required>
                            <c:forEach var="category" items="${listCategory}" varStatus="status">
                                <option value="${category.id}">
                                    <c:out value="${category.name}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-danger" data-bs-dismiss="modal" value="Huỷ"/>
                    <input type="submit" class="btn btn-primary confirm-edit" value="Xác nhận"/>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Delete Modal -->
<div class="modal fade" id="deleteUserModal">
    <div class="modal-dialog">
        <div class="modal-content" id="form-confirm-delete">
            <div class="modal-header">
                <h5 class="modal-title" style="color: blue">Delete Product</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                </button>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    Are you sure to delete?
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                <a type="button" id="ToastDelete" class="btn btn-primary btn-confirm-delete">Delete</a>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
        integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
        integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
        crossorigin="anonymous"></script>
</body>
</html>