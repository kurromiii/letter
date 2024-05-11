<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>جدول ارجاع</title>
    <link rel="stylesheet" href="../../assets/css/myTable.css">
    <link rel="stylesheet" href="../../assets/css/all.css">
</head>
<body>
<!--nav bar-->
<jsp:include page="../../jsp/dashboard.jsp"></jsp:include>

<!--table-->
<table>
    <thead>
    <tr>
        <th><i class="fa fa-window-minimize"></i></th>
        <th>عنوان نامه</th>
        <th>ارجاع دهنده</th>
        <th>ارجاع گیرنده</th>
        <th>اولویت</th>
        <th>نوع</th>
        <th>پاراف</th>
        <th>توضیحات</th>
        <th>تاریخ ثبت</th>
        <th>تاریخ انقضا</th>
        <th class="btn"><i class="fa fa-gear"></i></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="reference" items="${sessionScope.referenceList}">
    <tr>
        <td>${reference.id}</td>
        <td>${reference.letterId.title}</td>
        <td>${reference.referenceSenderId.username}</td>
        <td>${reference.referenceReceiverId.username}</td>
        <td>${reference.priority}</td>
        <td>${reference.refType}</td>
        <td>${reference.paraph}</td>
        <td>${reference.explanation}</td>
        <td>${reference.refDateAndTime}</td>
        <td>${reference.expiration}</td>
        <td>
            <a href="#" onclick="selectReference(${reference.id})"><i class="fas fa-eye show"></i></a>
            <a href="#" onclick="edit(${reference.id})"><i class="fa fa-edit edit"></i></a>
            <a href="#" onclick="remove(${reference.id})"><i class="fa fa-remove remove"></i></a>
            <a href="#" onclick="showLetter(${reference.letterId.id})"><i class="fa-regular fa-envelope"></i></a>
        </td>
    </tr>
    </tbody>
    </c:forEach>
</table>

<script>
    function edit(id) {
        document.location.replace("/referenceEdit.do?id=" + id);
    }
    function selectReference(id) {
        document.location.replace("/referenceDisplay.do?id=" + id);
    }
    function showLetter(id) {
        document.location.replace("/letterDisplay.do?id=" + id);
    }
</script>
<script src="../../assets/js/reference.js"></script>
</body>
</html>
