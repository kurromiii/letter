<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>جدول افراد</title>
    <link rel="stylesheet" href="../../assets/css/table.css">
    <link rel="stylesheet" href="../../assets/fontawesome-free-6.5.2-web/css/all.min.css">
</head>
<body>
<!--nav bar-->
<%--<jsp:include page="../../jsp/all.jsp"></jsp:include>--%>

<!--table-->
<div class="t-w">
<table>
    <thead>
    <tr>
        <th><i class="fa fa-window-minimize"></i></th>
        <th>نام</th>
        <th>فامیلی</th>
        <th>کد ملی</th>
        <th>جنسیت</th>
        <th class="btn"><i class="fa fa-gear"></i></th>
    </tr>
    </thead>
    <tbody>
   <c:forEach var="person" items="${sessionScope.personList}">
    <tr>
        <td>${person.id}</td>
        <td>${person.name}</td>
        <td>${person.family}</td>
        <td>${person.nationalCode}</td>
        <td>${person.gender}</td>
        <td>
            <a href=""><i class="fas fa-eye show"></i></a>
            <a href=""><i class="fa fa-edit edit"></i></a>
            <a href=""><i class="fa fa-remove remove"></i></a>
        </td>
    </tr>
    </tbody>
    </c:forEach>
</table>
</div>
</body>
</html>
