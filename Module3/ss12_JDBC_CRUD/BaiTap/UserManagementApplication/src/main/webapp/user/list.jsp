<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/08/2022
  Time: 3:52 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/users?action=create">Add New User</a>
    </h2>
    <h2>
        <p>Find by Country</p>
        <input type="text" id="find-country">
        <a class="btn btn-primary btn-find" href="" type="button">Find by Country</a>
        <a class="btn btn-primary" href="/users" type="button">Trở về</a>

        <script>
            // $('.btn-find').click(function () {
            //   let country=$('#find-country').val();
            //   $('.btn-find').attr("href","/users?action=find&id="+country);
            // })
        </script>
    </h2>
    <h2>
        <a href="/users?action=sort">Sort by name</a>
    </h2>
</center>
<c:if test="${empty listUser}">
    <h1 style="color: red; text-align: center">User List Empty</h1>
</c:if>
<c:if test="${not empty listUser}">
    <div align="center">
        <table border="1" cellpadding="5">
            <h3>List of Users</h3>
            <tr>
                <th>STT</th>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="user" items='${requestScope["listUser"]}' varStatus="c">
                <tr>
                    <td><c:out value="${c.count}"/></td>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.country}"/></td>
                    <td>
                        <a href="/users?action=edit&id=${user.id}" class="btn btn-primary">Edit</a>
                        <a href="/users?action=delete&id=${user.id}" class="btn btn-danger">Delete</a>
<%--                        <a class="btn btn-primary btn-edit" data-toggle="modal" data-id="${user.id}"--%>
<%--                           data-name="${user.name}" data-email="${user.email}" data-country="${user.country}"--%>
<%--                           data-target="#editUserModal" href="" type="button">Edit</a>--%>
<%--                        <a class="btn btn-danger btn-delete" data-toggle="modal" data-id="${user.id}"--%>
<%--                           data-target="#deleteUserModal" href="" type="button">Delete</a>--%>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>
<!-- Create Modal -->
<div id="createProductModal" class="modal fade">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form action="/users?action=create" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Thêm mới người dùng</h4>
                    <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close">X</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Tên người dùng</label>
                        <input type="text" class="form-control" name="name" required>
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="text" class="form-control" name="email" required>
                    </div>
                    <div class="form-group">
                        <label>Quốc tịch</label>
                        <input type="text" class="form-control" name="country"
                               required>
                    </div>
                    <%--                        <div class="form-group">--%>
                    <%--                            <label>Hình ảnh</label>--%>
                    <%--                            <input type="file" class="form-control imgProduct" name="imgProduct" value="a">--%>
                    <%--                        </div>--%>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-bs-dismiss="modal" value="Hủy">
                    <input type="submit" class="btn btn-primary" value="Xác nhận">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Edit Modal -->
<div id="editUserModal" class="modal fade">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form action="/users?action=edit" method="post" id="form_edit">
                <div class="modal-header">
                    <h4 class="modal-title">Update người dùng</h4>
                    <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close">X</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>ID</label>
                        <input type="text" class="form-control" id="user_id" name="id" value="0">
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Tên người dùng</label>
                            <input type="text" class="form-control" name="name" id="user_name" required>
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input type="text" class="form-control" name="email" id="user_email" required>
                        </div>
                        <div class="form-group">
                            <label>Quốc tịch</label>
                            <input type="text" class="form-control" name="country" id="user_country"
                                   required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-bs-dismiss="modal" value="Hủy">
                        <input type="submit" class="btn btn-primary confirm-edit" value="Xác nhận">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    // $('.btn-edit').click(function () {
    //   let id=$(this).data("id");
    //   let name=$(this).data("name");
    //   let email=$(this).data("email");
    //   let country=$(this).data("country");
    //   $("#user_id").val(id);
    //   $("#user_name").val(name);
    //   $("#user_email").val(email);
    //   $("#user_country").val(country);
    // })
    // $('.confirm-edit').click(function () {
    //   $('#form_edit').attr("action","/users?action=edit&id="+id);
    // })
</script>

<!-- Delete Modal -->
<div class="modal fade" id="deleteUserModal">
    <div class="modal-dialog">
        <div class="modal-content" id="form-confirm-delete">
            <div class="modal-header">
                <h5 class="modal-title">Delete Product</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                </button>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    Are you sure to delete?
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <a type="button" class="btn btn-danger btn-confirm-delete" href="">Delete</a>
            </div>
        </div>
    </div>
</div>
<script>
    // $(function () {
    //   $('.btn-delete').click(function () {
    //     let id=$(this).data("id");
    //     $('.btn-confirm-delete').attr("href","/users?action=delete&id="+id);
    //   })
    // });
</script>
<!-- Optional JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="list.js"></script>
</body>
</html>
