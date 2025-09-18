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
<a href="employees">Quay lại</a>
<form action="employees" method="post">
    <input type="hidden" name="action" value="SAVE">

    <c:if test="${not empty employee}">
        <input type="hidden" name="id" value="${employee.id}">
    </c:if>

    <div>
        <label>Name:</label>
        <input type="input" name="name" value="${employee.name}">
    </div>

    <div>
        <label>Salary:</label>
        <input type="input" name="salary" value="${employee.salary}">
    </div>

    <div>
        <label>Department Name:</label>
        <select name="departmentId">
            <c:forEach items="${departments}" var="d">
                <option value="${d.id}"
                <c:if test="${d.id == employee.department.id}">selected</c:if>">
                ${d.name}
                </option>
            </c:forEach>
        </select>
    </div>

    <input type="submit" value="Save">
</form>
</body>
</html>
