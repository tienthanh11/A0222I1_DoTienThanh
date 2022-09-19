<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/09/2022
  Time: 5:33 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <style>
        .bg-image {
            background: url("https://saigonrealestate.vn/wp-content/uploads/2022/03/phoi-canh-biet-thu-Furama-Resort-Spa-Phu-Quoc.jpg") no-repeat center center fixed;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
            width: 100%;
            height: 100%;
        }

        img {
            width: 100px;
            padding: 10px;
            margin: 15px;
        }

        .home {
            position: absolute;
            top: 5%;
            margin-left: 17px;
            margin-top: 17px;
        }

        h1 {
            text-align: center;
            color: blue;
            background-color: yellow;
            padding: 10px;
        }

        .form-label {
            color: red;
            padding: 10px;
            margin: 5px;
        }

        .form-control {
            width: 30%;
            padding: 10px;
            margin: 5px;
        }

        .form-select {
            width: 30%;
            height: 100px;
            padding: 10px;
            margin: 5px;
        }

        .btn-primary {
            padding: 10px;
            margin: 5px;
        }
    </style>
</head>
<body class="bg-image">
<div class="row">
    <div class="col-lg-10">
        <img src="https://furamavietnam.com/wp-content/uploads/2018/10/logo.png">
    </div>
    <div class="col-lg-2">
        <a href="/index_employee" class="home">
            <button type="button" class="btn btn-outline-primary">
                <span class="bi bi-house-fill"> Home </span>
            </button>
        </a>
    </div>
</div>
<form method="post">
    <h1>Create Employee</h1>
    <input type="hidden" name="action" value="create">
    <div class="mb-3">
        <label for="exampleInputId" class="form-label"><strong>ID</strong></label>
        <input type="text" name="id" class="form-control" id="exampleInputId">
    </div>
    <div class="mb-3">
        <label for="exampleInputName" class="form-label"><strong>Name</strong></label>
        <input type="text" name="name" class="form-control" id="exampleInputName">
        <span style="color: red"><c:out value="${msgName}"></c:out></span>
    </div>
    <div class="mb-3">
        <label for="exampleInputBirthday" class="form-label"><strong>Birthday</strong></label>
        <input type="text" name="birthday" class="form-control" id="exampleInputBirthday">
        <span style="color: red"><c:out value="${msgbirth}"></c:out></span>
    </div>
    <div class="mb-3">
        <label for="exampleInputIdCard" class="form-label"><strong>ID Card</strong></label>
        <input type="text" name="idCard" class="form-control" id="exampleInputIdCard">
    </div>
    <div class="mb-3">
        <label for="exampleInputSalary" class="form-label"><strong>Salary</strong></label>
        <input type="text" name="salary" class="form-control" id="exampleInputSalary">
        <span style="color: red"><c:out value="${msgsalary}"></c:out></span>
    </div>
    <div class="mb-3">
        <label for="exampleInputPhone" class="form-label"><strong>Phone</strong></label>
        <input type="text" name="phone" class="form-control" id="exampleInputPhone">
        <span style="color: red"><c:out value="${msgphone}"></c:out></span>
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail" class="form-label"><strong>Email</strong></label>
        <input type="text" name="email" class="form-control" id="exampleInputEmail">
    </div>
    <div class="mb-3">
        <label for="exampleInputAddress" class="form-label"><strong>Address</strong></label>
        <input type="text" name="address" class="form-control" id="exampleInputAddress">
    </div>
    <div class="mb-3">
        <label for="exampleInputDegree" class="form-label"><strong>Degree</strong></label>
        <div class="form-floating">
            <select class="form-select" name="degree" id="exampleInputDegree">
                <option selected>Open the degree select menu</option>
                <option value="1">Trung cấp</option>
                <option value="2">Cao đẳng</option>
                <option value="3">Đại học</option>
                <option value="4">Sau Đại học</option>
            </select>
        </div>
    </div>
    <div class="mb-3">
        <label for="exampleInputPosition" class="form-label"><strong>Position</strong></label>
        <div class="form-floating">
            <select class="form-select" name="position" id="exampleInputPosition">
                <option selected>Open the position select menu</option>
                <option value="1">Lễ tân</option>
                <option value="2">Phục vụ</option>
                <option value="3">Chuyên viên</option>
                <option value="4">Giám sát</option>
                <option value="5">Quản lý</option>
                <option value="6">Giám đốc</option>
            </select>
        </div>
    </div>
    <div class="mb-3">
        <label for="exampleInputDivision" class="form-label"><strong>Division</strong></label>
        <div class="form-floating">
            <select class="form-select" name="division" id="exampleInputDivision">
                <option selected>Open the division select menu</option>
                <option value="1">Sale – Marketing</option>
                <option value="2">Hành Chính</option>
                <option value="3">Phục vụ</option>
                <option value="4">Quản lý</option>
            </select>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Add New</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
