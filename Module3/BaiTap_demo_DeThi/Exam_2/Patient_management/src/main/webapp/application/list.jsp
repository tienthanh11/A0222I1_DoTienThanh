<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/09/2022
  Time: 8:18 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Patient Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"/>
    <script src="webjars/jquery/3.6.0/dist/jquery.slim.min.js"></script>
    <link rel="stylesheet" href="webjars/izitoast/1.4.0/dist/css/iziToast.min.css"/>
    <script src="webjars/izitoast/1.4.0/dist/js/iziToast.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <script src="/application/list.js"></script>
</head>
<body>

<div class="container">
    <div class="row">
        <h2 style="text-align: center; color: blue">Application</h2>
    </div>
    <div class="row mb-2">
        <div class="col-md-6 mb-2">
            <a type="button" class="btn btn-info border-end-0 border rounded-pill btn-create" data-bs-toggle="modal"
               data-bs-target="#createObjectModal" style="color: white" href="">
                <span class="bi bi-plus"></span> Create new
            </a>
        </div>
        <div class="col-md-6">
            <form action="" method="post" id="form-search" class="d-flex" style="margin-bottom: 0">
                <div class="col-4 search-class" data-value="${value}">
                    <select class="form-select border-end-0 border rounded-pill" id="select-sort"
                            aria-label="Default select example">
                        <c:forEach var="col" items='${requestScope["listColumn"]}' begin="1" end="6" varStatus="status">
                            <c:if test="${status.count == key}">
                                <option value="${status.count}" selected><c:out value="${col}"/></option>
                            </c:if>
                            <c:if test="${status.count != key}">
                                <option value="${status.count}"><c:out value="${col}"/></option>
                            </c:if>
                        </c:forEach>
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
                        <button type="submit" class="btn btn-primary border-end-0 border rounded-pill btn-search"
                                style="font-family:Arial, FontAwesome; margin-left:1%">&#xF002; Search
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <c:if test="${not empty m}">
            <script>
                const t = ${m};
                iziToast.success({
                    position: "topCenter",
                    message: t == 1 ? "Deleted successfully" : t == 2 ? "Update successfully" :
                        t == 3 ? "Created successfully" : t == 4 ? "Insert not success" : "Not success",
                    timeout: 2000
                });
            </script>
        </c:if>
        <c:if test="${empty objectList}">
            <p>Empty List Object/Not Found</p>
        </c:if>
        <c:if test="${not empty objectList}">
            <table class="table table-dark table-striped table-hover" id="myTable">
                <thead class="table table-primary">
                <tr>
                        <%--nhập bên tag servlet--%>
                    <c:forEach var="th" items="${listColumn}">
                        <th><c:out value="${th}"/></th>
                    </c:forEach>
                </tr>
                </thead>
                    <%--Sửa ở đây--%>
                <tbody class="table-group-divider table-warning" style="border-top-color: red">
                <c:forEach var="object" items='${requestScope["objectList"]}' varStatus="status">
                    <tr>
                        <td><c:out value="${status.count}"/></td>
                        <td id="id_object"><c:out value="${object.id_object}"/></td>
                        <td id="id_patience"><c:out value="${object.id_patience}"/></td>
                        <td id="name_patience"><c:out value="${object.name_patience}"/></td>
                        <td id="date_in"><c:out value="${object.date_in}"/></td>
                        <td id="date_out"><c:out value="${object.date_out}"/></td>
                        <td id="reason"><c:out value="${object.reason}"/></td>
                        <td>
                            <a type="button" class="btn btn-info btn-edit" data-bs-toggle="modal"
                               data-object="${object.id_object}" data-people="${object.id_patience}"
                               data-name="${object.name_patience}" data-datein="${object.date_in}"
                               data-dateout="${object.date_out}" data-reason="${object.reason}"
                               data-bs-target="#editObjectModal">
                                <span class="bi bi-pencil" style="color: white"></span>
                            </a>
                            |
                            <a type="button" class="btn btn-danger btn-delete" data-bs-toggle="modal"
                               data-id="${object.id_object}" data-bs-target="#deleteObjectModal" href="">
                                <span class="bi bi-trash" style="color: white"></span>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
    <%--https://ibytecode.com/blog/pagination-in-servlet-and-jsp/--%>
    <div class="row" id="nav-page" data-id="${currentPage}">
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                <li class="page-item">
                    <c:if test="${currentPage != 1 and not empty currentPage}">
                        <a class="page-link pagination-link" href="/application?page=${currentPage - 1}">Previous</a>
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
                                <a class="page-link pagination-link" href="/application?page=${i}">${i}</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <li class="page-item">
                    <c:if test="${currentPage lt noOfPages}">
                        <a class="page-link pagination-link" href="/application?page=${currentPage + 1}">Next</a>
                    </c:if>
                </li>
            </ul>
        </nav>
    </div>
</div>

<!-- Create Modal -->
<div class="modal fade" id="createObjectModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form action="/application?action=create" method="post" id="myForm">
                <div class="modal-header">
                    <h4 class="modal-title" style="color: blue">Create Object</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Mã bệnh án</label>
                        <input type="text" class="form-control id-object" name="id_object"/>
                        <div class="object-msg" style="color: red"></div>
                    </div>
                    <div class="form-group">
                        <label>Mã bệnh nhân</label>
                        <input type="text" class="form-control" name="id_patience" required/>
                        <div class="patient-msg" style="color: red"></div>
                    </div>
                    <div class="form-group">
                        <label>Tên bệnh nhân</label>
                        <input type="text" class="form-control" name="name_patience" required/>
                        <div class="name-msg" style="color: red"></div>
                    </div>
                    <div class="form-group">
                        <label>Ngày nhập viện</label>
                        <input type="date" class="form-control date-in" name="date_in" required/>
                        <div class="datein-msg" style="color: red"></div>
                    </div>
                    <div class="form-group">
                        <label>Ngày ra viện</label>
                        <input type="date" class="form-control date-out" name="date_out" required/>
                        <div class="dateout-msg" style="color: red"></div>
                    </div>
                    <div class="form-group">
                        <label>Lý do nhập viện</label>
                        <input type="text" class="form-control" name="reason" required/>
                        <div class="reason-msg" style="color: red"></div>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-danger" data-bs-dismiss="modal" value="Huỷ"/>
                        <input type="submit" class="btn btn-primary confirm-create" id="submit-btn" value="Xác nhận"
                               disabled="disabled"/>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Edit Modal -->
<div class="modal fade" id="editObjectModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form action="/application?action=edit" method="post" id="form_edit">
                <div class="modal-header">
                    <h4 class="modal-title" style="color: blue">Edit Object</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input type="text" class="form-control" name="id_object" id="id-object" hidden>
                        <input type="text" class="form-control" name="id_patience" id="id-patience" hidden>
                    </div>
                    <div class="form-group">
                        <label>Mã bệnh án</label>
                        <input type="text" class="form-control" id="id-object-disable" disabled/>
                    </div>
                    <div class="form-group">
                        <label>Mã bệnh nhân</label>
                        <input type="text" class="form-control" name="id_patience" id="id-patience-disable" disabled>
                    </div>
                    <div class="form-group set-select">
                        <label>Tên bệnh nhân</label>
                        <select class="form-select" name="name_patience" id="name-patience"
                                aria-label="Default select example" required>
                            <c:forEach items="${categoryList}" var="p" varStatus="c">
                                <option value="${p.id}"><c:out value="${p.name}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Ngày nhập viện</label>
                        <input type="date" step="any" class="form-control" name="date_in" id="date-in" required>
                    </div>
                    <div class="form-group">
                        <label>Ngày ra viện</label>
                        <input type="date" class="form-control" name="date_out" id="date-out" required>
                    </div>
                    <div class="form-group">
                        <label>Lý do nhập viện</label>
                        <input type="text" class="form-control" name="reason" id="reason-input" required>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-danger" data-bs-dismiss="modal" value="Huỷ"/>
                        <input type="submit" class="btn btn-primary confirm-edit" value="Xác nhận"/>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Delete Modal -->
<div class="modal fade" id="deleteObjectModal">
    <div class="modal-dialog">
        <div class="modal-content" id="form-confirm-delete">
            <div class="modal-header">
                <h5 class="modal-title" style="color: blue">Delete Object</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
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
