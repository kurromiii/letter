<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../../../jsp/css-import.jsp"></jsp:include>
    <link rel="stylesheet" href="../../../assets/css/profile.css">
    <link rel="stylesheet" href="../../../assets/css/profile-form.css">
    <meta charset="UTF-8" lang="fa">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="container">
    <div class="main-body">

        <!-- Breadcrumb -->
        <nav aria-label="breadcrumb" class="main-breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="home.do">خانه</a></li>
                <li class="breadcrumb-item"><a href="javascript:void(0)">حساب کاربری</a></li>
                <li class="breadcrumb-item active" aria-current="page">پروفایل</li>
            </ol>
        </nav>
        <!-- /Breadcrumb -->

        <div class="row">
            <div class="col-lg-4">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex flex-column align-items-center text-center">
                            <span class="fas fa-user-circle"></span>
                            <div class="mt-3">
                                <h4>${sessionScope.principalUser}</h4>
                                <p class="text-muted font-size-sm">role</p>
                                <button class="btn btn-outline-primary">Message</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-8">
                <div class="card">
                    <div class="card-body">
                        <form id="personEditForm">
                            <input class="form-control" type="text" name="id" value="${sessionScope.person.id}" hidden="hidden">
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">نام</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <input type="text" name="name" id="name" value="${sessionScope.person.name}" class="form-control">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">نام خانوادگی</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <input type="text" name="family" id="family" value="${sessionScope.person.family}" class="form-control">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">کد ملی</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <input type="text" name="nationalCode" id="nationalCode" value="${sessionScope.person.nationalCode}" class="form-control">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">جنسیت</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <select class="form-select" name="gender" id="gender">
                                        <c:forEach var="gender" items="${sessionScope.genders}">
                                            <option value="${gender}">${gender.title}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-3"></div>
                                <div class="col-sm-9 text-secondary">
                                    <button id="submit" class="btn btn-primary px-4" onclick="editPerson()">ویرایش</button>
                                </div>
                            </div>
                        </form>
                    </div>

                </div>

            </div>
        </div>
    </div>
</div>

<script src="../../../assets/js/person.js"></script>
</body>
</html>
