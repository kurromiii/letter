<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <jsp:include page="css-import.jsp"></jsp:include>
    <link rel="stylesheet" href="../assets/css/user.css">

</head>
<body>
<div class="container-fluid">
    <div id="org-form">
<form id="login_form" action="login.do" method="post">
    <br><br><br>
    <div class="row  mb-4">
        <label class="col form-label" for="username">Username: </label>
        <input id="username" class="col form-label" type="text" name="username">
    </div>

    <div class="row  mb-4">
        <label class="col form-label" for="password">Password: </label>
        <input id="password" class="col form-label" type="password" name="password">
    </div>

    <div class="row mb-4">
        <input type="submit" class="btn btn-primary" value="Login">
    </div>
    <p style="color: red">${sessionScope.wrongUser}</p>
    <a href="user.do">Register User</a>
</form>
</div>

<jsp:include page="js-import.jsp"></jsp:include>
    <script src="../assets/js/user.js"></script>
</body>
</html>
