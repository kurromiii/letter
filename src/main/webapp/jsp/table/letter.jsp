<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>جدول نامه ها</title>
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
        <th>عنوان</th>
        <th>شماره نامه</th>
        <th> کاربر</th>
        <th>فرستنده</th>
        <th>عنوان فرستنده</th>
        <th>گیرنده</th>
        <th>عنوان گیرنده</th>
        <th>سطح دسترسی</th>
        <th>روش فرستادن</th>
        <th>تاریخ</th>
        <th>نوع</th>
        <th class="btn"><i class="fa fa-gear"></i></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="letter" items="${sessionScope.letterList}">
    <tr>
        <td>${letter.id}</td>
        <td>${letter.title}</td>
        <td>${letter.letterNumber}</td>
        <td>${letter.user.username}</td>
        <td>${letter.senderName}</td>
        <td>${letter.senderTitle}</td>
        <td>${letter.receiverName}</td>
        <td>${letter.receiverTitle}</td>
        <td>${letter.accessLevel}</td>
        <td>${letter.transferMethod}</td>
        <td>${letter.getFaDate()}</td>
        <td>${letter.letterType}</td>
        <td>
            <a href="#" onclick="selectLetter(${letter.id})"><i class="fas fa-eye show"></i></a>
            <a href="#" onclick="showEditLetter(${letter.id})"><i class="fa fa-edit edit"></i></a>
            <a href="#" onclick="removeLetter(${letter.id})"><i class="fa fa-remove remove"></i></a>
        </td>
    </tr>
    </tbody>
    </c:forEach>
</table>
<script src="../../assets/js/letter.js"></script>
</body>
</html>
