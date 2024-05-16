<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../assets/css/all.css">
    <link rel="stylesheet" href="../assets/css/card.css">
</head>
<body>
<!--nav bar-->
<jsp:include page="../jsp/dashboard.jsp"></jsp:include>

<div class="row">
    <div class="card">
        <p>تعداد بازدید</p>
        <div>
            <span class="fa-solid fa-eye"></span>
        </div>
        <p>${sessionScope.visited}</p>
    </div>
</div>

<div class="row">
    <div class="card">
        <p>تعداد آنلاین</p>
        <div>
            <span class="fas fa-user-friends"></span>
        </div>
        <p>${sessionScope.online}</p>
    </div>
</div>
</body>
</html>
