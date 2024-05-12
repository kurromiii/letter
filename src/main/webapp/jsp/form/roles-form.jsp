<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>سطح دسترسی</title>
    <jsp:include page="../css-import.jsp"></jsp:include>
    <link rel="stylesheet" href="../../assets/css/kamadatepicker.min.css">
    <link rel="stylesheet" href="../../assets/css/form.css">
    <meta charset="UTF-8" lang="fa">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>
<body>
<!--nav bar-->
<jsp:include page="../../jsp/dashboard.jsp"></jsp:include>

<div class="formbold-main-wrapper">
    <div class="formbold-form-wrapper">

        <div class="formbold-form-title">
            <h2>فرم تعلق سطح دسترسی به کاربر</h2>
        </div>

        <!--start form-->
        <form action="roles.do">

            <div class="formbold-input-group">
                <label for="user" class="formbold-form-label"> نام کاربری </label>
                <input type="text" name="user" id="user" placeholder="نام کاربری را وارد کنید" class="formbold-form-input"/>
            </div>

            <div class="formbold-input-group">
                <label for="role" class="formbold-form-label"> نقش </label>
                <input type="text" name="role" id="role" placeholder="نقش را وارد کنید" class="formbold-form-input"/>
            </div>

<%--            <div class="formbold-input-group">--%>
<%--                <label for="role" class="formbold-form-label">--%>
<%--                    نقش  را انتخاب کنید--%>
<%--                </label>--%>

<%--                <select class="formbold-form-select" name="role" id="role">--%>
<%--                    <option value="admin">admin</option>--%>
<%--                    <option value="user">user</option>--%>
<%--                    <option value="manager">manager</option>--%>
<%--                </select>--%>
<%--            </div>--%>

            <button class="a-btn">ثبت</button>

        </form>
        <!--end form-->
    </div>
</div>
</body>
</html>
