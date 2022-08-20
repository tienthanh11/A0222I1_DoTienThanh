<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách khách hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <style>
        .table-primary {
            text-align: center;
        }

        h1 {
            text-align: center;
            color: red;
        }

        th {
            color: blue;
        }

        img {
            width: 100px;
            height: 100px;
        }

        td {
            vertical-align: middle;
        }
    </style>
</head>
<body>
<h1>Danh sách khách hàng</h1>
<table class="table table-primary">
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>

    <c:forEach var="c" items="${customerListServlet}">
    <tr>
        <td><p>${c.name}</p></td>
        <td><p>${c.birthday}</p></td>
        <td><p>${c.address}</p></td>
        <td><img src="${c.image}"></td>
    </tr>
    </c:forEach>
</body>
</html>