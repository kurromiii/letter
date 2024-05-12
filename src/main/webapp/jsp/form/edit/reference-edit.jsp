<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ویرایش ارجاع</title>
    <link rel="stylesheet" href="../../../assets/css/form.css">
    <link rel="stylesheet" href="../../../assets/css/persian-datepicker.min.css">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>
<body>
<!--nav bar-->
<jsp:include page="../../../jsp/dashboard.jsp"></jsp:include>

<div class="formbold-main-wrapper">
    <div class="formbold-form-wrapper">

        <div class="formbold-form-title">
            <h2>ویرایش ارجاع</h2>
        </div>

        <!--start form-->
        <form id="referenceEditForm">

            <input class="form-control" type="text" name="id" value="${sessionScope.reference.id}" hidden="hidden">

            <div class="formbold-input-group">
                <label for="username" class="formbold-form-label"> ارجاع دهنده </label>
                <input type="text" name="username" id="username" placeholder="کاربر سیستم" value="${sessionScope.reference.referenceSenderId.username}" class="formbold-form-input" readonly required/>
            </div>

            <div class="formbold-input-group">
                <label for="referenceReceiver" class="formbold-form-label"> ارجاع گیرنده </label>
                <input type="text" name="referenceReceiver" id="referenceReceiver" value="${sessionScope.reference.referenceReceiverId.username}" class="formbold-form-input" required readonly/>
            </div>

            <div class="formbold-input-group">
                <label for="priorityPre" class="formbold-form-label"> الویت ثبت شده ارجاع </label>
                <input type="text" name="priorityPre" id="priorityPre" value="${sessionScope.reference.priority.title}" class="formbold-form-input" readonly/>
            </div>

            <div class="formbold-input-group">
                <label for="priority" class="formbold-form-label">
                    اولویت ارجاع را انتخاب کنید
                </label>

                <select class="formbold-form-select" name="priority" id="priority">
                    <c:forEach var="priority" items="${sessionScope.priorities}">
                        <option value="${priority}">${priority.title}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="formbold-input-group">
                <label for="refTypePre" class="formbold-form-label"> نوع ثبت شده ارجاع </label>
                <input type="text" name="refTypePre" id="refTypePre" value="${sessionScope.reference.refType.title}" class="formbold-form-input" readonly/>
            </div>

            <div class="formbold-input-group">
                <label for="refType" class="formbold-form-label">
                    نوع ارجاع را انتخاب کنید
                </label>

                <select class="formbold-form-select" name="refType" id="refType">
                    <c:forEach var="refType" items="${sessionScope.refTypes}">
                        <option value="${refType}">${refType.title}</option>
                    </c:forEach>
                </select>
            </div>

            <div>
                <label for="paraph" class="formbold-form-label">
                    پاراف را وارد کنید
                </label>
                <textarea
                        rows="3"
                        name="paraph"
                        id="paraph"
                        class="formbold-form-input"
                >${sessionScope.reference.paraph}</textarea>
            </div>

            <div>
                <label for="explanation" class="formbold-form-label">
                    توضیحات ارجاع را وارد کنید
                </label>
                <textarea
                        rows="4"
                        name="explanation"
                        id="explanation"
                        class="formbold-form-input"
                >${sessionScope.reference.explanation}</textarea>
            </div>

<%--            <div class="formbold-input-group">--%>
<%--                <label for="r_expiration" class="formbold-form-label"> تاریخ انقضا </label>--%>
<%--                <input type="text" name="r_expiration" id="r_expiration" value="${sessionScope.reference.expiration}" class="formbold-form-input"/>--%>
<%--            </div>--%>

            <button id="submit" class="a-btn" onclick="editReference(event)">ویرایش</button>
        </form>
        <!--end form-->
    </div>
</div>

<script src="../../../assets/js/jquery-3.2.1.min.js"></script>
<script src="../../../assets/js/persian-date.min.js"></script>
<script src="../../../assets/js/persian-datepicker.min.js"></script>
<script src="../../../assets/js/app.js"></script>
<script src="../../../assets/js/reference.js"></script>
</body>
</html>
