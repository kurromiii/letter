<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Reference</title>
    <link rel="stylesheet" href="../assets/css/persian-datepicker.min.css">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <jsp:include page="css-import.jsp"></jsp:include>
    <link rel="stylesheet" href="../assets/css/reference.css">
</head>
<body>
<jsp:include page="../jsp/navbar.jsp"></jsp:include>

<div class="content">
    <div id="org-form">
        <form id="refEditForm">
            <h1>Edit Reference</h1>
            <br>
            <input class="form-control" type="text" name="id" value="${sessionScope.reference.id}" hidden="hidden">
            <input class="form-control" type="text" placeholder="ID" value="${sessionScope.reference.id}" disabled>
            <br><br>
            <div class="row  mb-4 w-100">
                <label class="col form-label" for="username">username</label>
                <input id="username" class="col form-control" type="text" name="username" value="${sessionScope.reference.referenceSenderId.username}" required readonly>
            </div>
            <div class="row  mb-4">
                <label for="letterIdRef">Letter Id</label>
                <input type="text" id="letterIdRef" name="letterIdRef" value="${sessionScope.reference.letterId.id}" required readonly>
            </div>

            <div class="row  mb-4">
                <label for="r_refType">Select Reference Type : </label>
                <select name="r_refType" id="r_refType">
                    <c:forEach var="r_refType" items="${sessionScope.refTypes}">
                        <option value="${r_refType}">${r_refType}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="row  mb-4">
                <label for="priority">Select Reference Priority : </label>
                <select name="priority" id="priority">
                    <c:forEach var="priority" items="${sessionScope.priorities}">
                        <option value="${priority}">${priority}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="row  mb-4">
                <p>Paraph</p>
                <label class="col form-label" for="paraph">
                    <textarea id="paraph" class="col form-control" name="paraph"></textarea>
                </label>
            </div>


            <div class="row  mb-4">
                <p>Explanation</p>
                <label class="col form-label" for="explanation">
                    <textarea id="explanation" class="col form-control" name="explanation"></textarea>
                </label>
            </div>

            <div>
                <label for="validate">Validation : </label>
                <input type="checkbox" id="validate" name="validate" value="${sessionScope.reference.validate}">
            </div>
            <br><br>

            <div>
                <label for="status">Status : </label>
                <input type="checkbox" id="status" name="status" value="${sessionScope.reference.status}">
            </div>
            <br><br>

            <div class="row  mb-4">
                <label for="r_expiration">Expiration Date : </label>
                <input type="text" id="r_expiration" name="r_expiration" value="${sessionScope.reference.getFaExpiration()}">
            </div>
            <br><br>

            <div class="row  mb-4">
                <label class="col form-label" for="referenceReceiver">Reference Receiver</label>
                <input id="referenceReceiver" class="col form-control" type="text" name="referenceReceiver" value="${sessionScope.reference.referenceReceiverId.username}" required>
            </div>
        </form>
        <button id="submit" class="btn btn-warning" onclick="edit()"><i class="fa fa-edit"></i> Edit</button>
    </div>
</div>


<jsp:include page="js-import.jsp"></jsp:include>

<script src="../assets/js/reference.js"></script>
<script src="../assets/js/referenceInput.js"></script>

<script src="../assets/js/jquery-3.2.1.min.js"></script>
<script src="../assets/js/persian-date.min.js"></script>
<script src="../assets/js/persian-datepicker.min.js"></script>
<script src="../assets/js/app.js"></script>

<script>
    function edit() {
        const refEditForm = document.getElementById("refEditForm");
        const queryString = new URLSearchParams(new FormData(refEditForm)).toString();
        fetch("/referenceEdit.do?" + queryString, {
            method: "PUT"
        }).then(() => {
            document.location.replace("/reference.do");
        });
    }
</script>

</body>
</html>
