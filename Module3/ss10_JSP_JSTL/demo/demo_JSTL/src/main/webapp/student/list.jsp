<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/08/2022
  Time: 6:47 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <style>
        h1 {
            color: red;
            padding: 10px;
            text-align: center;
        }

        .table-primary {
            text-align: center;
        }

        th {
            color: blue;
        }
    </style>
</head>
<body>
<h1>Trang list student</h1>

<table class="table table-primary">
    <tr class="table-warning">
        <th>STT</th>
        <th>ID</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Birthday</th>
        <th>Point</th>
        <th>Ranking</th>
        <th>Account</th>
        <th>Email</th>
        <th>Class ID</th>
    </tr>
    <c:forEach var="student" items="${studentList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <c:if test="${student.gender}">
                <td>Nam</td>
            </c:if>
            <c:if test="${!student.gender}">
                <td>Nữ</td>
            </c:if>
            <td>${student.birthday}</td>
            <td>${student.point}</td>
            <c:choose>
                <c:when test="${student.point >= 8}">
                    <td>Giỏi</td>
                </c:when>
                <c:when test="${student.point >= 7}">
                    <td>Khá</td>
                </c:when>
                <c:when test="${student.point >= 6}">
                    <td>Trung Bình</td>
                </c:when>
                <c:otherwise>
                    <td>Yếu</td>
                </c:otherwise>
            </c:choose>
            <td>${student.account}</td>
            <td>${student.email}</td>
            <td>${student.classId}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

