<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/09/2022
  Time: 6:37 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<center>
    <h2 class="m-4">Danh sách sách</h2>
    <c:if test="${message!=null}">
        <h3 class="text-primary">${message}</h3>
    </c:if>
    <button type="submit" name="action" value="search" class="btn btn-outline-info "><a href="/book">Quay lại</a></button>
    <form action="/book?action=search">
        <input name="nameSearch" type="text">
        <button type="submit" name="action" value="search" class="btn btn-outline-info ">Search</button>
    </form>
    <table class="table table-sm text-center">
        <%--        id="tableList--%>
        <thead>
        <tr>
            <th scope="col">Mã sách</th>
            <th scope="col">Tên sách</th>
            <th scope="col">Tác giả</th>
            <th scope="col">Số lượng</th>
            <th scope="col">Mô tả</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${bookList}" var="book" varStatus="status">
            <tr>
                <td>${book.bookId}</td>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.quantity}</td>
                <td>${book.description}</td>
                <td>
                    <a href="/borrow?id=${book.bookId}">
                        <button type="button" class="btn text-light btn-success btn-outline-secondary">Mượn
                        </button>
                    </a>
                </td>
                    <%--                <td>--%>
                    <%--                    <button type="button"--%>
                    <%--                            onclick="showInfo('${book.id}','${book.id}')"--%>
                    <%--                            class="btn btn-success text-light btn-outline-dark"--%>
                    <%--                            data-toggle="modal"--%>
                    <%--                            data-target="#exampleModal">--%>
                    <%--                        delete--%>
                    <%--                    </button>--%>
                    <%--                </td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</center>
<%--<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--    <div class="modal-dialog">--%>
<%--        &lt;%&ndash;            **********Thêm thẻ form **************&ndash;%&gt;--%>
<%--        <form action="ground">--%>
<%--            <div class="modal-content">--%>
<%--                <div class="modal-header">--%>
<%--                    <h5 class="modal-title text-danger" id="exampleModalLabel">Xác nhận xóa</h5>--%>
<%--                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                        <span aria-hidden="true">&times;</span>--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--                <div class="modal-body">--%>
<%--                    &lt;%&ndash;****************************** thêm *************************&ndash;%&gt;--%>
<%--                    <input hidden type="text" id="idGround" name="id">--%>
<%--                    <span>Bạn có muốn xóa mặt bằng với mã  </span>--%>
<%--                    <span class="text-danger" id="nameGround"></span> không?<span/>--%>
<%--                    &lt;%&ndash;*************************************************************&ndash;%&gt;--%>
<%--                </div>--%>
<%--                <div class="modal-footer">--%>
<%--                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Không</button>--%>
<%--                    &lt;%&ndash;*********************** Chuyển type button sang submit **********************&ndash;%&gt;--%>
<%--                    <button type="submit" name="action" value="delete" class="btn btn-primary">Có</button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </form>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<script src="datatables/js/jquery.dataTables.min.js"></script>--%>
<%--<script src="datatables/js/dataTables.bootstrap4.min.js"></script>--%>
<%--<script>--%>
<%--    $(document).ready(function () {--%>
<%--        $('#tableList').dataTable({--%>
<%--            "dom": 'lrtip',--%>
<%--            "lengthChange": false,--%>
<%--            "pageLength": 6--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>
<%--<script>--%>
<%--    function showInfo(id, name) {--%>
<%--        document.getElementById("idGround").value = id;--%>
<%--        document.getElementById("nameGround").innerText = name;--%>
<%--    }--%>
<%--</script>--%>
</body>
</html>
