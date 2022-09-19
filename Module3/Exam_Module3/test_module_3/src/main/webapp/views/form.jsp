<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <script src="bootstrap-5.1.3/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="row">
    <div class="col-md-1 col-lg-1">

    </div>
    <div class="col-md-10 col-lg-10">
        <section class="vh-100 bg-image"
                 style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
            <div class="mask d-flex align-items-center h-100 gradient-custom-3">
                <div class="container h-100">
                    <div class="row d-flex justify-content-center align-items-center h-100">
                        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                            <div class="card" style="border-radius: 15px;">
                                <div class="card-body p-5">
                                    <h2 class="text-uppercase text-center mb-5">Form Control</h2>
                                    <c:if test="${message != null}">
                                        <h3 style="color:red;">${message}</h3>
                                    </c:if>
                                    <form method="post">
                                        <div class="form-outline mb-4">
                                            <input type="text" id="form2Example1cg" value="${target.id}" name="id"
                                                   class="form-control form-control-lg" required/>

                                            <label class="form-label" for="form2Example1cg">Id(*)</label>
                                            <c:if test="${error != null}">
                                                <h5 style="color:red;">${error.get('id')}</h5>
                                            </c:if>
                                        </div>
                                        <div class="form-outline mb-4">
                                            <input type="number" id="form3Example1cg" value="${target.area}" name="area"
                                                   required   class="form-control form-control-lg"/>
                                            <label class="form-label" for="form3Example1cg">Area(*)</label>
                                            <c:if test="${error != null}">
                                                <h5 style="color:red;">${error.get('area')}</h5>
                                            </c:if>
                                        </div>
                                        <div class="form-outline mb-4">
                                            <label class="form-label" for="form2Example1cg">Status(*)</label>
                                            <label>
                                                <select class="select" name="status" required>
                                                    <c:forEach items="${listStatus}" var="item">
                                                        <option value="${item.id}">
                                                                ${item.name}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </label>
                                        </div>
                                        <div class="form-outline mb-4">
                                            <label>
                                                <label class="form-label" for="form2Example1cg">Stage(*)</label>
                                                <label>
                                                    <select class="select" name="stage" required>
                                                        <c:forEach begin="1" end="15" varStatus="item">
                                                            <option value="${item.count}">
                                                                    ${item.count}
                                                            </option>
                                                        </c:forEach>
                                                    </select>
                                                </label>
                                            </label>
                                        </div>
                                        <div class="form-outline mb-4">
                                            <label class="form-label" for="form2Example1cg">Type Stage(*)</label>
                                            <label>
                                                <select class="select" name="typeStage" required>
                                                    <c:forEach items="${listType}" var="item">
                                                        <option value="${item.id}">
                                                                ${item.name}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </label>
                                        </div>
                                        <div class="form-outline mb-4">
                                            <input type="date" id="form3Example6cg" value="${target.dateIn}"
                                                   name="dateIn" required
                                                   class="form-control form-control-lg"/>
                                            <label class="form-label" for="form3Example6cg">date In(*)</label>
                                        </div>
                                        <div class="form-outline mb-4">
                                            <input type="date" id="form3Example4cg" value="${target.dateOut}"
                                                   name="dateOut" required
                                                   class="form-control form-control-lg"/>
                                            <label class="form-label" for="form3Example4cg">date Out(*)</label>
                                            <c:if test="${error != null}">
                                                <h5 style="color:#ff0000;">${error.get('dateOut')}</h5>
                                            </c:if>
                                        </div>
                                        <div class="form-outline mb-4">
                                            <input type="number" id="form3Example4cg" value="${target.price}"
                                                   name="price" required
                                                   class="form-control form-control-lg"/>
                                            <label class="form-label" for="form3Example4cg">Price(*)</label>
                                            <c:if test="${error != null}">
                                                <h5 style="color:red;">${error.get('price')}</h5>
                                            </c:if>
                                        </div>
                                        <div class="form-outline mb-4">
                                            <input type="text"   value="${target.textStage}"
                                                   name="textStage"
                                                   class="form-control form-control-lg"/>
                                            <label class="form-label" for="form3Example4cg">text Stage</label>
                                        </div>
                                        <div class="d-flex justify-content-center">
                                            <button type="submit"
                                                    class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">
                                                Submit
                                            </button>
                                            <button type="reset"
                                                    class="btn btn-warning btn-block btn-lg gradient-custom-4 text-body">
                                                Reset
                                            </button>
                                            <a href="/main">
                                                <button type="button"
                                                        class="btn btn-info btn-block btn-lg gradient-custom-4 text-body">
                                                    Back List
                                                </button>
                                            </a>
                                        </div>

                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <div class="col-md-1 col-lg-1">

    </div>
</div>
</body>
</html>
