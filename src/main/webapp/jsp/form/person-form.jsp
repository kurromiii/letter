<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>پروفایل</title>
    <link rel="stylesheet" href="../../assets/css/form.css">
    <link rel="stylesheet" href="../../assets/css/kamadatepicker.min.css">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>
<body>
<!--nav bar-->
<jsp:include page="../../jsp/dashboard.jsp"></jsp:include>

<div class="formbold-main-wrapper">
    <div class="formbold-form-wrapper">
        <!--img-->
<%--        <img src="../../assets/image/organization.jpg" alt="">--%>

        <div class="formbold-form-title">
            <h2>ایجاد پروفایل</h2>
        </div>

        <!--start form-->
        <form action="person.do" method="POST">

            <div class="formbold-input-group">
                <label for="name" class="formbold-form-label"> نام </label>
                <input type="text" name="name" id="name" placeholder="نام خود را وارد کنید" class="formbold-form-input"/>
            </div>

            <div class="formbold-input-group">
                <label for="family" class="formbold-form-label"> نام خانوادگی </label>
                <input type="text" name="family" id="family" placeholder="نام خانوادگی خود را وارد کنید" class="formbold-form-input"/>
            </div>

            <div class="formbold-input-group">
                <label for="nationalCode" class="formbold-form-label"> کد ملی </label>
                <input type="text" name="nationalCode" id="nationalCode" placeholder="کد ملی خود را وارد کنید" class="formbold-form-input"/>
            </div>

            <div class="formbold-input-group">
                <label for="gender" class="formbold-form-label">
                    جنسیت خود را انتخاب کنید
                </label>

                <select class="formbold-form-select" name="gender" id="gender">
                    <c:forEach var="gender" items="${sessionScope.genders}">
                        <option value="${gender}">${gender.title}</option>
                    </c:forEach>
                </select>
            </div>

<%--            <div class="formbold-input-group">--%>
<%--                <label for="l_date" class="formbold-form-label"> تاریخ تولد </label>--%>
<%--                <input type="text" name="l_date" id="l_date" placeholder="تاریخ تولد خود را وارد کنید" class="formbold-form-input"/>--%>
<%--            </div>--%>

<%--            <div class="formbold-form-file-flex">--%>
<%--                <label for="file" class="formbold-form-label">--%>
<%--                    عکس پرسنلی--%>
<%--                </label>--%>
<%--                <input--%>
<%--                        type="file"--%>
<%--                        name="file"--%>
<%--                        id="file"--%>
<%--                        class="formbold-form-file"--%>
<%--                />--%>
<%--            </div>--%>

            <button class="a-btn">ثبت</button>
        </form>
        <!--end form-->
    </div>
</div>
<script src="../../assets/js/jquery-3.7.1.min.js"></script>
<script src="../../assets/js/kamadatepicker.holidays.js"></script>
<script src="../../assets/js/kamadatepicker.min.js"></script>
<script src="../../assets/js/referenceInput.js"></script>
<script>
    let myElement = document.querySelector('#l_date');
    kamaDatepicker(myElement);

    kamaDatepicker('l_date', { buttonsColor: "red", forceFarsiDigits: true });
</script>
</body>
</html>
