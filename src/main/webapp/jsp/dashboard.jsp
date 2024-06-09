<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../assets/css/dashboard.css">
    <link rel="stylesheet" href="../assets/css/all.css">
</head>
<body>
<!-- navbar -->
<nav class="navbar">
    <div class="logo_item">
        <i class="bx bx-menu" id="sidebarOpen"></i>
        <img src="../assets/image/logo.png" alt=""></i>لوگو سازمان
    </div>

<%--    <div class="search_bar">--%>
<%--        <input type="text" placeholder="جستجو" />--%>
<%--    </div>--%>

    <div class="navbar_content">
        <i class="bi bi-grid"></i>
        <i class='bx bx-sun' id="darkLight"></i>
        <i class='bx bx-bell' ></i>
        <a href="person.do"><span class="fas fa-user-circle profile"></span></a>

    </div>
</nav>

<!-- sidebar -->
<nav class="sidebar">
    <div class="menu_content">
        <ul class="menu_items">
            <li class="item">
                <a href="dashboard.do" class="nav_link">
              <span class="navlink_icon">
                <i class="fa-solid fa-dashboard"></i>
              </span>
                    <span class="navlink">داشبورد</span>
                </a>
            </li>
            <!-- duplicate or remove this li tag if you want to add or remove navlink with submenu -->
            <!-- start -->
            <li class="item">
                <a href="home.do" class="nav_link">
              <span class="navlink_icon">
                <i class="fa-solid fa-house"></i>
              </span>
                    <span class="navlink">خانه</span>
                </a>
            </li>
            <!-- end -->

            <!-- duplicate this li tag if you want to add or remove  navlink with submenu -->
            <!-- start -->
            <li class="item">
                <div href="#" class="nav_link submenu_item">
              <span class="navlink_icon">
                <i class="bx bx-grid-alt"></i>
              </span>
                    <span class="navlink">بخش ها</span>
                    <i class="bx bx-chevron-right arrow-left"></i>
                </div>

                <ul class="menu_items submenu">
                    <a href="#section1" class="nav_link sublink">اداری</a>
                    <a href="#section2" class="nav_link sublink">نامه نگاری</a>
                    <a href="#" class="nav_link sublink">مدیریت کارمندان</a>
                </ul>
            </li>
            <!-- end -->
        </ul>

        <ul id="section1" class="menu_items">
            <div class="menu_title">
            <span>
            <i class=""></i>
            </span>
                <span class="navlink">اداری</span>
                <i class="bx bx-chevron-right arrow-left"></i>
            </div>
            <!-- duplicate these li tag if you want to add or remove navlink only -->
            <!-- Start -->
            <li class="item">
                <a href="#" class="nav_link">
              <span class="navlink_icon">
                <i class="bx bxs-magic-wand"></i>
              </span>
                    <span class="navlink">سازمان</span>
                </a>
            </li>
            <!-- End -->

            <li class="item">
                <a href="#" class="nav_link">
              <span class="navlink_icon">
                <i class="bx bx-loader-circle"></i>
              </span>
                    <span class="navlink">چارت های سازمانی</span>
                </a>
            </li>
            <li class="item">
                <a href="#" class="nav_link">
              <span class="navlink_icon">
                <i class="bx bx-filter"></i>
              </span>
                    <span class="navlink">چارت جدید</span>
                </a>
            </li>
        </ul>

        <ul id="section2" class="menu_items">
            <div class="menu_title">
            <span>
            <i class="fa-solid fa-envelopes"></i>
            </span>
                <span class="navlink">نامه نگاری</span>
                <i class="bx bx-chevron-right arrow-left"></i>
            </div>
            <!-- duplicate these li tag if you want to add or remove navlink only -->
            <!-- Start -->

            <li class="item">
                <a href="letterBox.do" class="nav_link">
              <span class="navlink_icon">
                <i class="fa-regular fa-inbox"></i>
              </span>
                    <span class="navlink">صندوق نامه و ارجاع</span>
                </a>
            </li>
            <li class="item">
                <a href="letter.do" class="nav_link">
              <span class="navlink_icon">
                <i class="fa-solid fa-pen-to-square"></i></i>
              </span>
                    <span class="navlink">نامه جدید</span>
                </a>
            </li>
            <li class="item">
                <a href="reference.do" class="nav_link">
              <span class="navlink_icon">
                <i class="fa-regular fa-message"></i>
              </span>
                    <span class="navlink">ارجاع جدید</span>
                </a>
            </li>
            <li class="item">
                <a href="letterTable.do" class="nav_link">
              <span class="navlink_icon">
                <i class="fa-regular fa-envelope"></i>
              </span>
                    <span class="navlink">نامه ها</span>
                </a>
            </li>
            <li class="item">
                <a href="referenceTable.do" class="nav_link">
              <span class="navlink_icon">
                <i class="fa-regular fa-messages"></i>
              </span>
                    <span class="navlink">ارجاع ها</span>
                </a>
            </li>
        </ul>

        <ul class="menu_items">
            <div class="menu_title">
            <span>
            <i class="fas fa-users"></i>
            </span>
                <span class="navlink">مدیریت کارمندان</span>
                <i class="bx bx-chevron-right arrow-left"></i>
            </div>
            <!-- duplicate these li tag if you want to add or remove navlink only -->
            <!-- Start -->
            <li class="item">
                <a href="personTable.do" class="nav_link">
              <span class="navlink_icon">
                <i class="fas fa-id-card"></i>
              </span>
                    <span class="navlink">پروفایل ها</span>
                </a>
            </li>
            <!-- End -->

            <li class="item">
                <a href="user.do" class="nav_link">
              <span class="navlink_icon">
                <i class="fas fa-user-circle"></i>
              </span>
                    <span class="navlink">کاربران</span>
                </a>
            </li>
            <li class="item">
                <a href="person.do" class="nav_link">
              <span class="navlink_icon">
                <i class="fas fa-user-edit"></i>
              </span>
                    <span class="navlink">ایجاد پروفایل</span>
                </a>
            </li>
            <li class="item">
                <a href="user.do" class="nav_link">
              <span class="navlink_icon">
                <i class="fas fa-user-plus"></i>
              </span>
                    <span class="navlink">ایجاد کاربر جدید</span>
                </a>
            </li>
        </ul>

        <!-- Sidebar Open / Close -->
        <div class="bottom_content">
            <div class="bottom expand_sidebar">
                <span> باز کردن</span>
                <i class='bx bx-log-in' ></i>
            </div>
            <div class="bottom collapse_sidebar">
                <span> بستن</span>
                <i class='bx bx-log-out'></i>
            </div>
        </div>
    </div>
</nav>
<!-- JavaScript -->
<script src="../assets/js/dashboard.js"></script>
</body>
</html>
