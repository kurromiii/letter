<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>حساب کاربری</title>
    <link rel="stylesheet" href="../../../assets/css/form.css">
    <link rel="stylesheet" href="../../../assets/css/myTable.css">
    <link rel="stylesheet" href="../../../assets/css/user.css">
    <link rel="stylesheet" href="../../../assets/css/all.css">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>
<body>
<!--nav bar-->
<jsp:include page="../../../jsp/dashboard.jsp"></jsp:include>

<div class="formbold-main-wrapper">
    <div class="formbold-form-wrapper">

        <div class="formbold-form-title">
            <h2>ایجاد کاربر جدید</h2>
        </div>

        <!--start form-->
        <form action="user.do" method="POST">

            <div class="formbold-input-group">
                <label for="username" class="formbold-form-label"> نام کاربری </label>
                <input type="text" name="username" id="username" placeholder="نام کاربری خود را وارد کنید" class="formbold-form-input"/>
                <p style="color: red">${sessionScope.duplicateUsername}</p>
            </div>

            <div class="formbold-input-group">
                <label for="password" class="formbold-form-label"> رمز عبور </label>
                <input type="password" name="password" id="password" placeholder="رمز عبور خود را وارد کنید" class="formbold-form-input"/>
            </div>

            <button class="a-btn">ثبت</button>
        </form>
        <!--end form-->
    </div>
</div>
<!--table-->
<table>
    <thead>
    <tr>
        <th>کاربر</th>
        <th>نقش</th>
        <th class="btn"><i class="fa fa-gear"></i></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${sessionScope.userList}">
    <tr>
        <td>${user.user.username}</td>
        <td>${user.role}</td>
        <td>
            <a href=""><i class="fas fa-eye show"></i></a>
            <a href=""><i class="fa fa-edit edit"></i></a>
            <a href=""><i class="fa fa-remove remove"></i></a>
        </td>
    </tr>
    </tbody>
    </c:forEach>
</table>
</body>
</html>
