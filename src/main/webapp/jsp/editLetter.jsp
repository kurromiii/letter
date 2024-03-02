<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Letter</title>
    <link rel="stylesheet" href="../assets/css/kamadatepicker.min.css">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <jsp:include page="css-import.jsp"></jsp:include>
    <link rel="stylesheet" href="../assets/css/letter.css">
    <link rel="stylesheet" href="../assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/css/all.css">
    <link rel="stylesheet" href="../assets/css/sidebar.css">
</head>
<body>
<div class="container-fluid">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Project</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="../index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.do">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About Us</a>
                </li>
            </ul>
        </div>
    </nav>
</div>

<!-- The sidebar -->
<div class="sidebar">
    <a href="organisation.do">Organization</a>
    <a href="person.do">Person</a>
    <a href="user.do">User</a>
    <a href="letter.do">Letter</a>
    <a href="reference.do">Reference</a>
</div>

<div class="container-fluid">
    <div id="org-form">
        <form id="myForm" >
            <h1>Edit Letter</h1>
            <br>
            <input class="form-control" type="text" name="id" value="${sessionScope.letter.id}" hidden="hidden">
            <input class="form-control" type="text" placeholder="ID" value="${sessionScope.letter.id}" disabled>
            <br><br>
            <div class="row  mb-4">
                <label class="col form-label" for="l_title">Title</label>
                <input id="l_title" class="col form-control" type="text" name="l_title" value="${sessionScope.letter.title}">
            </div>

            <div class="row  mb-4">
                <label class="col form-label" for="l_letter_number">Letter Number</label>
                <input id="l_letter_number" class="col form-control" type="text" name="l_letter_number" value="${sessionScope.letter.letterNumber}">
            </div>

            <div class="row  mb-4">
                <p>context</p>
                <label class="col form-label" for="l_context">
                    <textarea id="l_context" class="col form-control" name="l_context"></textarea>
                </label>
            </div>

            <div class="row  mb-4">
                <label class="col form-label" for="l_receiver_name">Receiver Name</label>
                <input id="l_receiver_name" class="col form-control" type="text" name="l_receiver_name" value="${sessionScope.letter.receiverName}">
            </div>

            <div class="row  mb-4">
                <label class="col form-label" for="l_receiver_title">Receiver Title</label>
                <input id="l_receiver_title" class="col form-control" type="text" name="l_receiver_title" value="${sessionScope.letter.receiverTitle}">
            </div>

            <div class="row  mb-4">
                <label class="col form-label" for="l_sender_name">Sender Name</label>
                <input id="l_sender_name" class="col form-control" type="text" name="l_sender_name" value="${sessionScope.letter.senderName}">
            </div>

            <div class="row  mb-4">
                <label class="col form-label" for="l_sender_title">Sender Title</label>
                <input id="l_sender_title" class="col form-control" type="text" name="l_sender_title"  value="${sessionScope.letter.senderTitle}">
            </div>

<%--            <div>--%>
<%--                <label class="form-label" for="file">File</label>--%>
<%--                <input class="form-control" id="file" type="file" name="file" value="${sessionScope.letter.image}">--%>
<%--                <div id="file-msg error">${sessionScope.error}</div>--%>
<%--            </div>--%>
            <br><br><br>
            <div class="row  mb-4">
                <label for="accessLevel">Select AccessLevel: </label>
                <select name="accessLevel" id="accessLevel">
                    <c:forEach var="accessLevel" items="${sessionScope.accessLevels}">
                        <option value="${accessLevel}">${accessLevel}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="row  mb-4">
                <label for="transferMethod">Select Transfer Method: </label>
                <select name="transferMethod" id="transferMethod">
                    <c:forEach var="transferMethod" items="${sessionScope.transferMethods}">
                        <option value="${transferMethod}">${transferMethod}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="row  mb-4">
                <label for="letterType">Select Letter Type: </label>
                <select name="letterType" id="letterType">
                    <c:forEach var="letterType" items="${sessionScope.letterTypes}">
                        <option value="${letterType}">${letterType}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="row  mb-4">
                <label for="l_date">Date : </label>
                <input type="text" id="l_date" name="l_date" required  value="${sessionScope.letter.getFaDate()}">
            </div>

        </form>
        <button id="submit" class="btn btn-warning" onclick="edit()"><i class="fa fa-edit"></i> Edit</button>
    </div>
</div>
<jsp:include page="js-import.jsp"></jsp:include>

<script src="../assets/js/letter.js"></script>

<script src="../assets/js/jquery-3.7.1.min.js"></script>
<script src="../assets/js/kamadatepicker.holidays.js"></script>
<script src="../assets/js/kamadatepicker.min.js"></script>
<script>
    let myElement = document.querySelector('#l_date');
    kamaDatepicker(myElement);

    kamaDatepicker('l_date', { buttonsColor: "red", forceFarsiDigits: true });
</script>
<script>
    function edit() {
        const myForm = document.getElementById("myForm");
        const queryString = new URLSearchParams(new FormData(myForm)).toString();
        fetch("/letterEdit.do?" + queryString, {
            method: "PUT"
        }).then(() => {
            document.location.replace("/letter.do");
        });
    }
</script>

</body>
</html>
