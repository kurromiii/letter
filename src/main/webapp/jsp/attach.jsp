<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Attach</title>
</head>
<body>
<form id="attach_form" method="post" action="attach.do" enctype="multipart/form-data">
    <div>
        <label class="form-label" for="file">File</label>
        <input class="form-control" id="file" type="file" name="file">
        <div id="file-msg error">${sessionScope.error}</div>

        <div class="row mb-4">
            <input type="submit" class="btn btn-primary" value="Save">
        </div>
    </div>
</form>
</body>
</html>
