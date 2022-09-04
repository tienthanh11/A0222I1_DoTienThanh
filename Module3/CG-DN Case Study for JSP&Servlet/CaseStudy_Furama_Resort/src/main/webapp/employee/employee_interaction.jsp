<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/09/2022
  Time: 5:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        .bg-image {
            background-image: url("https://saigonrealestate.vn/wp-content/uploads/2022/03/phoi-canh-biet-thu-Furama-Resort-Spa-Phu-Quoc.jpg");
            height: 300px;
        }

        img {
            width: 100px;
            padding: 10px;
            margin: 15px;
        }
        .btn-outline-primary {
            padding: 10px;
            size: 10px;
        }
    </style>
</head>
<body class="bg-image">
<div class="row">
    <div class="col-lg-1">
        <img src="https://furamavietnam.com/wp-content/uploads/2018/10/logo.png">
    </div>
    <nav class="navbar navbar-expand-lg navbar-light bg-warning">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <button type="button" class="btn btn-outline-primary">
                            <a class="nav-link active" aria-current="page" href="/index.jsp">Home</a>
                        </button>
                    </li>
                    <li class="nav-item">
                        <button type="button" class="btn btn-outline-primary">
                            <a class="nav-link" href="/index_employee?action=create">Create</a>
                        </button>
                    </li>
                    <li class="nav-item">
                        <button type="button" class="btn btn-outline-primary">
                            <a class="nav-link" href="/index_employee?action=edit">Edit</a>
                        </button>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/index_employee?action=delete">Delete</a>
                    </li>
                </ul>
                <form class="d-flex" method="post">
                    <input type="hidden" name="action" value="search">
                    <input class="form-control me-2" type="search" aria-label="Search" name="name"
                           placeholder="Name need to find">
                    <button class="btn btn-outline-primary" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
</div>
<form class="bg-info">
    <c:out value="${msg}"></c:out>
    <p class="mx-5" style="color: yellow"><c:out value="${msgdelete}"></c:out></p>
    <div class="row">
        <div class="col-lg-12">
            <table class="table">
                <thead>
                <tr style="text-align: center; color: red">
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Date of birth</th>
                    <th scope="col">Id Card</th>
                    <th scope="col">Salary</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Email</th>
                    <th scope="col">Address</th>
                    <th scope="col">Education Degree</th>
                    <th scope="col">Position</th>
                    <th scope="col">Division</th>
                </tr>
                </thead>
                <tbody class="content">
                <c:forEach var="employee" items="${employee}">
                    <tr>
                        <th scope="col"><c:out value="${employee.employee_id}"/></th>
                        <td><c:out value="${employee.employee_name}"/></td>
                        <td><c:out value="${employee.employee_birthday}"/></td>
                        <td><c:out value="${employee.employee_id_card}"/></td>
                        <td><c:out value="${employee.employee_salary}"/></td>
                        <td><c:out value="${employee.employee_phone}"/></td>
                        <td><c:out value="${employee.employee_email}"/></td>
                        <td><c:out value="${employee.employee_address}"/></td>
                        <td>
                            <c:if test="${employee.education_degree_id == 1}">
                                Trung cấp
                            </c:if>
                            <c:if test="${employee.education_degree_id == 2}">
                                Cao đẳng
                            </c:if>
                            <c:if test="${employee.education_degree_id == 3}">
                                Đại học
                            </c:if>
                            <c:if test="${employee.education_degree_id == 4}">
                                Sau Đại học
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${employee.position_id == 1}">
                                Lễ tân
                            </c:if>
                            <c:if test="${employee.position_id == 2}">
                                Phục vụ
                            </c:if>
                            <c:if test="${employee.position_id == 3}">
                                Chuyên viên
                            </c:if>
                            <c:if test="${employee.position_id == 4}">
                                Giám sát
                            </c:if>
                            <c:if test="${employee.position_id == 5}">
                                Quản lý
                            </c:if>
                            <c:if test="${employee.position_id == 6}">
                                Giám <đốc></đốc>
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${employee.division_id == 1}">
                                Sale – Marketing
                            </c:if>
                            <c:if test="${employee.division_id == 2}">
                                Hành Chính
                            </c:if>
                            <c:if test="${employee.division_id == 3}">
                                Phục vụ
                            </c:if>
                            <c:if test="${employee.division_id == 4}">
                                Quản lý
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
