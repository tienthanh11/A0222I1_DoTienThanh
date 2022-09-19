<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>List</title>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<div class="row">
    <div class="col-md-5 col-lg-5" style="text-align: center">
        <a href="/main?action=insert" style="text-decoration: none">
            <button class="btn btn-success">Create</button>
        </a>
    </div>
    <div class="col-md-7 col-lg-7">
        <form method="get" action="/main" class="row">
            <input type="hidden" name="action" value="search">
            <div class="col-md-3 col-lg-3">
                <p>ID</p>
                <label>
                    <input name="nameSearch" placeholder="Name search" type="text">
                </label>
            </div>
            <div class="col-md-3 col-lg-3">
                <p>Stage</p>
                <label>
                    <select class="select" name="stageSearch">
                        <option value="0">Choice stage</option>
                        <c:forEach begin="1" end="15" varStatus="item">
                            <option value="${item.count}">
                                    ${item.count}
                            </option>
                        </c:forEach>
                    </select>
                </label>
            </div>
            <div class="col-md-3 col-lg-3">
                <p>Date In</p>
                <label>
                    <input name="dateInSearch" placeholder="Date In Search" type="date">
                </label>
            </div>
            <div class="col-md-3 col-lg-3">
                <p>Date out</p>
                <label>
                    <input name="dateOutSearch" placeholder="Date Out Search" type="date">
                </label>
            </div>
            <div class="row">
                <div class="col-md-4 col-lg-4">
                    <button type="submit" class="btn btn-primary">Search</button>
                </div>
                <div class="col-md-4 col-lg-4">
                    <button type="reset" class="btn btn-danger">Reset</button>
                </div>
                <div class="col-md-4 col-lg-4">
                   <a href="/main"> <button type="button" class="btn btn-second">Refresh List</button></a>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="row">
    <div class="col-md-1 col-lg-1">

    </div>
    <div class="col-md-10 col-lg-10">
        <table class="table table-striped table-dark">
            <tr>
                <th>ID</th>
                <th>Area</th>
                <th>Status</th>
                <th>Stage</th>
                <th>Type</th>
                <th>Price</th>
                <th>Date In</th>
                <th>Date Out</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${list}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.area}</td>
                    <c:forEach items="${listStatus}" var="check">
                        <c:if test="${item.status == check.id}">
                            <td>${check.name}</td>
                        </c:if>
                    </c:forEach>
                    <td>${item.stage}</td>
                    <c:forEach items="${listType}" var="check">
                        <c:if test="${item.typeStage == check.id}">
                            <td>${check.name}</td>
                        </c:if>
                    </c:forEach>
                    <td>${item.price}</td>
                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${item.dateIn}"/></td>
                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${item.dateOut}"/></td>
                    <td>
                        <a onclick="showInfoDelete('${item.id}')"
                           data-bs-toggle="modal" data-bs-target="#delete">
                            <i class="fa-solid fa-eraser"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-1 col-lg-1">
    </div>
</div>
<%-- page jump not change --%>
<c:if test="${max_page != null}">
    <div>
        <ul class="pagination justify-content-center">
            <c:forEach begin="1" end="${max_page}" var="item">
                <li class="page-item"><a class="page-link"
                                         href="/main?action=display&&offset=${item-1}">${item}</a></li>
            </c:forEach>
        </ul>
    </div>
</c:if>

<div class="modal fade" id="delete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/main?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="deleteId" name="id">
                    <span>Are you delete </span><span id="deleteName"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script>
    function showInfoDelete(id) {
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerText = id;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
        integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"
        integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK"
        crossorigin="anonymous"></script>
</body>
</html>
