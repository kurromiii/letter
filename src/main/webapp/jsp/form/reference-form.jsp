<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ارجاع</title>
    <link rel="stylesheet" href="../../assets/css/form.css">
    <link rel="stylesheet" href="../../assets/css/persian-datepicker.min.css">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>
<body>
<div class="formbold-main-wrapper">
    <div class="formbold-form-wrapper">
        <!--img-->
        <img src="../../assets/image/reference.jpg" alt="">

        <!--start form-->
        <form action="reference.do" method="POST">

            <div class="formbold-input-group">
                <label for="letterIdRef" class="formbold-form-label"> کد نامه </label>
                <input type="text" name="letterIdRef" id="letterIdRef" placeholder="نامه" value="${sessionScope.letterIdRef}" class="formbold-form-input" required/>
            </div>

            <div class="formbold-input-group">
                <label for="username" class="formbold-form-label"> ارجاع دهنده </label>
                <input type="text" name="username" id="username" placeholder="کاربر سیستم" value="${sessionScope.user}" class="formbold-form-input" readonly required/>
            </div>

            <div class="formbold-input-group">
                <label for="referenceReceiver" class="formbold-form-label"> ارجاع گیرنده </label>
                <input type="text" name="referenceReceiver" id="referenceReceiver" placeholder="نام کاربری ارجاع گیرنده را وارد کنید" class="formbold-form-input" required/>
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
                <label for="r_refType" class="formbold-form-label">
                    نوع ارجاع را انتخاب کنید
                </label>

                <select class="formbold-form-select" name="r_refType" id="r_refType">
                    <c:forEach var="r_refType" items="${sessionScope.refTypes}">
                        <option value="${r_refType}">${r_refType.title}</option>
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
                        placeholder="پاراف..."
                        class="formbold-form-input"
                ></textarea>
            </div>

            <div>
                <label for="explanation" class="formbold-form-label">
                    توضیحات ارجاع را وارد کنید
                </label>
                <textarea
                        rows="4"
                        name="explanation"
                        id="explanation"
                        placeholder="توضیحات..."
                        class="formbold-form-input"
                ></textarea>
            </div>

            <div class="formbold-input-group">
                <label for="r_expiration" class="formbold-form-label"> تاریخ انقضا </label>
                <input type="text" name="r_expiration" id="r_expiration" placeholder="تاریخ انقضای ارجاع را وارد کنید" class="formbold-form-input"/>
            </div>

            <button class="a-btn">ثبت</button>
        </form>
        <!--end form-->
    </div>
</div>

<script src="../../assets/js/jquery-3.2.1.min.js"></script>
<script src="../../assets/js/persian-date.min.js"></script>
<script src="../../assets/js/persian-datepicker.min.js"></script>
<script src="../../assets/js/app.js"></script>
</body>
</html>
