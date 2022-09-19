<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/09/2022
  Time: 6:16 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Customer</title>
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
                        <a class="nav-link active" aria-current="page" href="/index.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/index_customer?action=create">Create</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/index_customer?action=edit">Edit</a>
                    </li>
                    <li class="nav-item">
                        <%--<a class="nav-link" href="/index_customer?action=delete">Delete</a>--%>
                        <button type="button" class="nav-item btn btn-primary" data-bs-toggle="modal"
                                data-bs-target="#exampleModal">
                            Delete
                        </button>
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
</body>
</html>
