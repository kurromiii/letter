<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../../../jsp/css-import.jsp"></jsp:include>
    <link rel="stylesheet" href="../../../assets/css/profile.css">
    <link rel="stylesheet" href="../../../assets/css/all.css">
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

        <div class="row gutters-sm">
            <div class="col-md-4 mb-3">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex flex-column align-items-center text-center">
<%--                            <img src="../../../assets/image/profile.jpg" alt="" class="rounded-circle" width="150" height="110">--%>
                            <span class="fas fa-user-circle"></span>
                            <div class="mt-3">
                                <h4>${sessionScope.principalUser}</h4>
                                <p class="text-muted font-size-sm">نقش</p>
                                <button class="btn btn-outline-primary">Message</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <div class="card mb-3">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">نام</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${sessionScope.person.name}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">نام خانوادگی</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${sessionScope.person.family}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">کد ملی</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${sessionScope.person.nationalCode}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">جنسیت</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${sessionScope.person.gender.title}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">نام کاربری</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                ${sessionScope.person.user.username}
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-12">
                                <a class="btn btn-info " target="__blank" href="#" onclick="showEditPerson(${sessionScope.person.id})">ویرایش</a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>

    </div>
</div>

<script src="../../../assets/js/person.js"></script>
</body>
</html>
