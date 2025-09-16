<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/16/2025
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="departments">Quay lại</a>
<form action="departments" method="post">
    <input type="hidden" name="action" value="SAVE">

    <c:if test="${not empty department}">
        <input type="hidden" name="id" value="${department.id}">
    </c:if>

    <label>Name:</label>
    <input type="input" name="name" value="${department.name}">
    <input type="submit" value="Save">
</form>
</body>
</html>
