<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Home</title>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <jsp:include page="css-import.jsp"></jsp:include>
  <link rel="stylesheet" href="../assets/css/all.css">
  <link rel="stylesheet" href="../assets/css/home.css">
</head>
<body>
<!--start website-->
<div class="wrapper">
  <!--parallax-->
  <section class="parallax">
    <!--menu-->
    <section class="menu">
      <div class="right">
        <ul>
          <li><a href="home.do" class="fa-solid fa-house"></a></li>
          <li><a href="#">سازمان</a>
          </li>
          <li><a href="letterBox.do">اداری </a>
            <ul class="submenu">
              <li><a href="letter.do">نامه</a></li>
              <li><a href="reference.do">ارجاع</a></li>
            </ul>
          </li>

          <%--todo : how to get role instead of username , this is not dynamic.--%>
<%--          <c:set var="username" value="admin" />--%>
<%--          <c:if test="${pageContext.request.userPrincipal.name.equals(username)}">--%>
            <li><a href="dashboard.do">داشبورد </a></li>
<%--          </c:if>--%>

<%--          <c:if test="${not pageContext.request.userPrincipal.name.equals(username)}">--%>
<%--            <li><a href="userDashboard.do">داشبورد </a></li>--%>
<%--          </c:if>--%>

        </ul>
      </div>
      <div class="left">
        <ul>

            <li><a href="person.do" class="fas fa-user-circle"></a></li>

          <li class="logOut"><a href="logout.do" class="fas fa-sign-out"></a></li>
        </ul>
      </div>
    </section>
    <!--end menu-->
    <div class="d-flex w-100 ">
      <h1>اتوماسیون اداری</h1>
    </div>
  </section>
  <!--end parallax-->
  <!--news-->
  <section class="news row py-3 justify-content-center">
    <!--div.item*3>img+p+a{read-more}-->
    <div class="col-sm-4 p-3 col-6 item"><img class="w-100" src="../assets/image/organization.jpg" alt="">
      <p>
        سازمان مربوط به شما
      </p>
      <a href="">اطلاعات بیشتر</a>
    </div>
    <div class="col-sm-4 p-3 col-6 item"><img class="w-100" src="../assets/image/lettering.jpg" alt="">
      <p>
        سیستم نامه نگاری
      </p>
      <a href="">اطلاعات بیشتر</a>
    </div>
    <div class="col-sm-4 p-3 col-6 item"><img class="w-100" src="../assets/image/reference.jpg" alt="">
      <p>
        سیستم ارجاع نامه ها
      </p>
      <a href="">اطلاعات بیشتر</a>
    </div>
  </section>
  <!--end news-->
  <!--parallax-->
  <section class="parallax">
  </section>
  <!--end parallax-->
</div>
<!--footer-->
<section class="footer">
  <p>با ما در ارتباط باشید !</p>
  <p>جهت اطلاعات بیشتر</p>
  <span class="fab fa-telegram"></span>
  <span class="fab fa-facebook"></span>
  <span class="fab fa-instagram"></span>
</section>
<!--end footer-->
<!--end start website-->
</body>
</html>