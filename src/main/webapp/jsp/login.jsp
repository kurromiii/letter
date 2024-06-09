<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body onload="document.forms.creds.submit()">
<form name="creds" method="post" action="j_security_check">
    <input type="hidden" name="j_username" value="${sessionScope.username}">
    <input type="hidden" name="j_password" value="${sessionScope.password}">
</form>
</body>

</html>

