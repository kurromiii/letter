<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ورود</title>
    <link rel="stylesheet" href="assets/css/form.css">
    <link rel="stylesheet" href="assets/css/login.css">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>
<body>
<div class="formbold-main-wrapper">
    <div class="formbold-form-wrapper">
        <div class="formbold-form-title">
            <h2>
                اتوماسیون اداری
            </h2>
        </div>

        <!--start form-->
        <form action=" " method="post">

            <div class="formbold-input-group">
                <label for="username" class="formbold-form-label"> نام کاربری </label>
                <input type="text" name="username" id="username" placeholder="نام کاربری خود را وارد کنید" class="formbold-form-input"/>
            </div>

            <div class="formbold-input-group">
                <label for="password" class="formbold-form-label"> رمز عبور </label>
                <input type="password" name="password" id="password" placeholder="رمز عبور خود را وارد کنید" class="formbold-form-input"/>
            </div>

            <button class="a-btn">ورود</button>
        </form>
        <!--end form-->
    </div>
</div>
</body>
</html>
