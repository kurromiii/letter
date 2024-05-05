<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ویرایش نامه</title>
    <link rel="stylesheet" href="../../../assets/css/form.css">
    <link rel="stylesheet" href="../../../assets/css/kamadatepicker.min.css">
    <link rel="stylesheet" href="../../../assets/fontawesome-free-6.5.2-web/css/all.min.css">
    <jsp:include page="../../../jsp/css-import.jsp"></jsp:include>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>
<body>
<!--nav bar-->
<jsp:include page="../../../jsp/all.jsp"></jsp:include>

<div class="formbold-main-wrapper">
    <div class="formbold-form-wrapper">
        <!--img-->
        <img src="../../../assets/image/lettering.jpg" alt="">

        <!--start form-->
        <form id="myForm" enctype="multipart/form-data">

            <input class="form-control" type="text" name="id" value="${sessionScope.letter.id}" hidden="hidden">
<%--            <input class="form-control" type="text" placeholder="ID" value="${sessionScope.letter.id}" disabled>--%>

            <div class="formbold-input-group">
                <label for="title" class="formbold-form-label"> عنوان </label>
                <input type="text" name="title" id="title" value="${sessionScope.letter.title}" class="formbold-form-input"/>
            </div>

            <div class="formbold-input-group">
                <label for="letter_number" class="formbold-form-label"> شماره نامه </label>
                <input type="text" name="letter_number" id="letter_number" value="${sessionScope.letter.letterNumber}" class="formbold-form-input"/>
            </div>

            <div class="formbold-input-group">
                <label for="sender_name" class="formbold-form-label"> نام فرستنده نامه </label>
                <input type="text" name="sender_name" id="sender_name" value="${sessionScope.letter.senderName}" class="formbold-form-input"/>
            </div>

            <div class="formbold-input-group">
                <label for="sender_title" class="formbold-form-label"> عنوان فرستنده نامه </label>
                <input type="text" name="sender_title" id="sender_title" value="${sessionScope.letter.senderTitle}" class="formbold-form-input"/>
            </div>

            <div class="formbold-input-group">
                <label for="receiver_name" class="formbold-form-label"> نام گیرنده نامه </label>
                <input type="text" name="receiver_name" id="receiver_name" value="${sessionScope.letter.receiverName}" class="formbold-form-input"/>
            </div>

            <div class="formbold-input-group">
                <label for="receiver_title" class="formbold-form-label"> عنوان گیرنده نامه </label>
                <input type="text" name="receiver_title" id="receiver_title" value="${sessionScope.letter.receiverTitle}" class="formbold-form-input"/>
            </div>

<%--            <div class=" row formbold-input-group">--%>
<%--                <label class="formbold-form-label"> ارجاع گیرندکان نامه </label>--%>
<%--                <div class="position-relative">--%>
<%--                    <div class="col-12 position-relative">--%>
<%--                        <input class="col-12 formbold-form-input" oninput="getReferences(event)" type="text" value="${sessionScope.letter.userList}"/>--%>
<%--                        <div   id="person-ref-list" class="border col-12" style="position: absolute;">--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div id="selected-list" class="col-12 row ">--%>
<%--                </div>--%>
<%--            </div>--%>

            <div class="formbold-input-group">
                <label for="accessLevelPre" class="formbold-form-label"> سطح دسترسی ثبت شده نامه </label>
                <input type="text" name="accessLevelPre" id="accessLevelPre" value="${sessionScope.letter.accessLevel}" class="formbold-form-input"/>
            </div>

            <div class="formbold-input-group">
                <label for="accessLevel" class="formbold-form-label">
                    سطح دسترسی نامه را انتخاب کنید
                </label>

                <select class="formbold-form-select" name="accessLevel" id="accessLevel">
                    <c:forEach var="accessLevel" items="${sessionScope.accessLevels}">
                        <option value="${accessLevel}">${accessLevel.title}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="formbold-input-group">
                <label for="transferMethod" class="formbold-form-label">
                    روش فرستادن نامه را انتخاب کنید
                </label>

                <select class="formbold-form-select" name="transferMethod" id="transferMethod">
                    <c:forEach var="transferMethod" items="${sessionScope.transferMethods}">
                        <option value="${transferMethod}">${transferMethod.title}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="formbold-input-group">
                <label for="letterType" class="formbold-form-label">
                    نوع نامه را انتخاب کنید
                </label>

                <select class="formbold-form-select" name="letterType" id="letterType">
                    <c:forEach var="letterType" items="${sessionScope.letterTypes}">
                        <option value="${letterType}">${letterType.title}</option>
                    </c:forEach>
                </select>
            </div>

            <div>
                <label for="context" class="formbold-form-label">
                    متن نامه را وارد کنید
                </label>
                <textarea
                        rows="10"
                        name="context"
                        id="context"
                        class="formbold-form-input"
                >${sessionScope.letter.context}</textarea>
            </div>

            <div class="formbold-input-group">
                <label for="date" class="formbold-form-label"> تاریخ </label>
                <input type="text" name="date" id="date" value="${sessionScope.letter.getFaDate()}" class="formbold-form-input" required/>
            </div>

<%--            <div class="formbold-form-file-flex">--%>
<%--                <label for="file" class="formbold-form-label">--%>
<%--                    تصویر نامه--%>
<%--                </label>--%>
<%--                <input--%>
<%--                        type="file"--%>
<%--                        name="file"--%>
<%--                        id="file"--%>
<%--                        class="formbold-form-file"--%>
<%--                />--%>
<%--            </div>--%>

            <button id="submit"  class="formbold-btn" onclick="edit()">ویرایش</button>
        </form>
        <!--end form-->
    </div>
</div>
<script src="../../../assets/js/jquery-3.7.1.min.js"></script>
<script src="../../../assets/js/kamadatepicker.holidays.js"></script>
<script src="../../../assets/js/kamadatepicker.min.js"></script>
<script src="../../../assets/js/referenceInput.js"></script>
<script>
    let myElement = document.querySelector('#date');
    kamaDatepicker(myElement);

    kamaDatepicker('date', { buttonsColor: "red", forceFarsiDigits: true });
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
