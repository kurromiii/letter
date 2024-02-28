<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="../assets/css/kamadatepicker.min.css">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <jsp:include page="css-import.jsp"></jsp:include>
    <link rel="stylesheet" href="../assets/css/person.css">
</head>
<body>
<div class="container-fluid">
    <div id="org-form">
        <form id="letter_form" method="post" action="profile.do">
            <br><br>
            <div class="row  mb-4">
                <label class="col form-label" for="l_title">Name</label>
                <input id="l_title" class="col form-control" type="text" name="name">
            </div>

            <div class="row  mb-4">
                <label class="col form-label" for="l_letter_number">Family</label>
                <input id="l_letter_number" class="col form-control" type="text" name="family">
            </div>

            <div class="row  mb-4">
                <label class="col form-label" for="l_receiver_name">National Code</label>
                <input id="l_receiver_name" class="col form-control" type="text" name="nationalCode">
            </div>

            <div class="row  mb-4">
                <label class="col form-label" for="l_receiver_title">Username</label>
                <input id="l_receiver_title" class="col form-control" type="text" name="username" required>
            </div>

            <div class="row  mb-4">
                <label class="col form-label" for="l_sender_name">Password</label>
                <input id="l_sender_name" class="col form-control" type="text" name="password" required>
            </div>

            <br><br><br>
            <div class="row  mb-4">
                <label for="gender">Select Gender: </label>
                <select name="gender" id="gender">
                    <c:forEach var="gender" items="${sessionScope.genders}">
                        <option value="${gender}">${gender}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="row  mb-4">
                <label for="role">Select Role: </label>
                <select name="role" id="role">
                    <c:forEach var="role" items="${sessionScope.roles}">
                        <option value="${role}">${role}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="row mb-4">
                <input type="submit" class="btn btn-primary" value="Save">
            </div>

        </form>
    </div>

    <div id="org-table">
        <table class="table table-hover table-primary">
            <thead>
            <tr>
                <th>name</th>
                <th>family</th>
                <th>username</th>
                <th>nationalCode</th>
                <th>gender</th>
                <th>role</th>
                <th>operation</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="profile" items="${sessionScope.profileList}">
                <tr>
                    <td>${profile.name}</td>
                    <td>${profile.family}</td>
                    <td>${profile.username}</td>
                    <td>${profile.nationalCode}</td>
                    <td>${profile.gender}</td>
                    <td>${profile.role}</td>
<%--                    <td>--%>
<%--                        <button class="btn btn-warning" onclick="edit(${letter.id})"><i class="fa fa-edit"></i>--%>
<%--                            Edit--%>
<%--                        </button>--%>
<%--                        <button class="btn btn-danger" onclick="remove(${letter.id})"><i class="fa fa-remove"></i>--%>
<%--                            Remove--%>
<%--                        </button>--%>

<%--                    </td>--%>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<jsp:include page="js-import.jsp"></jsp:include>
<script src="../assets/js/organisation.js"></script>

</body>
</html>
