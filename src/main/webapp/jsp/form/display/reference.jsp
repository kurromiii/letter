<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>مشاهده ارجاع</title>
    <link rel="stylesheet" href="../../../assets/css/displayForm.css">
</head>
<body>
<!--nav bar-->
<jsp:include page="../../../jsp/all.jsp"></jsp:include>

<div class="formbold-main-wrapper">
    <div class="formbold-form-wrapper">

        <div class="formbold-form-title">
            <h2 class="">ارجاع</h2>
            <a class="formbold-btn primary" href="#" onclick="showLetter(${sessionScope.reference.letterId.id})">مشاهده نامه</a>
            <a class="formbold-btn warning" href="#" onclick="edit(${sessionScope.reference.id})">ویرایش</a>
            <a class="formbold-btn danger" href="#" onclick="remove(${sessionScope.reference.id})">حذف</a>
        </div>

        <!--start form-->
        <form inert action="" method="POST">
            <div class="formbold-input-flex">
                <div>
                    <label for="username" class="formbold-form-label"> ارجاع دهنده : </label>
                    <input type="text" name="username" id="username" class="formbold-form-input" value="${sessionScope.reference.referenceSenderId.username}"/>
                </div>

                <div>
                    <label for="referenceReceiver" class="formbold-form-label"> ارجاع گیرنده : </label>
                    <input type="text" name="referenceReceiver" id="referenceReceiver" class="formbold-form-input" value="${sessionScope.reference.referenceReceiverId.username}"/>
                </div>
            </div>

            <div class="formbold-input-flex">
                <div>
                    <label for="priority" class="formbold-form-label"> اولویت ارجاع : </label>
                    <input type="text" name="priority" id="priority" class="formbold-form-input" value="${sessionScope.reference.priority}"/>
                </div>
                <div>
                    <label for="r_refType" class="formbold-form-label"> نوع ارجاع : </label>
                    <input type="text" name="r_refType" id="r_refType" class="formbold-form-input" value="${sessionScope.reference.refType}"/>
                </div>
            </div>

            <div>
                <label for="paraph" class="formbold-form-label">
                    پاراف ارجاع :
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
                    توضیحات ارجاع :
                </label>
                <textarea
                        rows="3"
                        name="explanation"
                        id="explanation"
                        class="formbold-form-input"
                >${sessionScope.reference.explanation}</textarea>
            </div>

            <div class="formbold-input-flex">
                <div>
                    <label for="refDateAndTime" class="formbold-form-label">تاریخ ثبت ارجاع : </label>
                    <input type="text" name="refDateAndTime" id="refDateAndTime" class="formbold-form-input"/>
                </div>
                <div>
                    <label for="r_expiration" class="formbold-form-label">تاریخ انقضا ارجاع : </label>
                    <input type="text" name="r_expiration" id="r_expiration" class="formbold-form-input" value="${sessionScope.reference.expiration}"/>
                </div>
            </div>
        </form>
    </div>
</div>

<script>
    function edit(id) {
        document.location.replace("/referenceEdit.do?id=" + id);
    }
    function showLetter(id) {
        document.location.replace("/letterDisplay.do?id=" + id);
    }
</script>
<script src="../../../assets/js/reference.js"></script>
</body>
</html>
