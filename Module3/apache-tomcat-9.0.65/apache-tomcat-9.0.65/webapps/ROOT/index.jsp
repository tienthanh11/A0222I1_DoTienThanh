<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/09/2022
  Time: 5:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ứng Dụng Quản Lý Khu Nghỉ Dưỡng Furama</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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

        .col-lg-2 {
            padding: 25px;
        }

        strong {
            color: red;
            margin: 20px;
        }
    </style>
</head>
<body class="bg-image">
<div class="row">
    <div class="col-lg-10">
        <img src="https://furamavietnam.com/wp-content/uploads/2018/10/logo.png">
    </div>
    <div class="col-lg-2">
        <strong>Code Gym Đà Nẵng</strong>
    </div>
    <nav class="navbar navbar-expand-lg navbar-light bg-warning">
        <div class="container-fluid">
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="/index_employee">Employee</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/index_customer">Customer</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/index_service">Service</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/index_contract">Contract</a>
                    </li>
                </ul>
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" href="#">
                    <button class="btn btn-outline-primary" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
