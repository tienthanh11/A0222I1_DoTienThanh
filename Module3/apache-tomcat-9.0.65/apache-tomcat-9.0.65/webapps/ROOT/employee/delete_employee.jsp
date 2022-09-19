<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/09/2022
  Time: 5:33 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
    <h1>Delete Employee</h1>
    <input type="hidden" name="action" value="delete">
    <div class="mb-3">
        <label for="exampleInputId" class="form-label"><strong>ID</strong></label>
        <input type="text" name="id" class="form-control" id="exampleInputId">
    </div>
    <button type="submit" class="btn btn-primary">Delete</button>
</form>
</body>
</html>
