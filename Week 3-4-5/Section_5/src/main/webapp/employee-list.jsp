<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/16/2025
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <style>
        .btn {
            padding: 4px 8px;
            cursor: pointer;
            background: blue;
            border: 1px solid;
            color: white;
            text-decoration: none;
        }
    </style>
</head>
<body>
<a href="employees?action=CREATE" style="display: block">Thêm nhân viên</a>
<a href="departments" style="display: block">Danh sách phòng ban</a>

<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>salary</th>
        <th>dept</th>
        <th>actions</th>
    </tr>

    <c:forEach items="${employees}" var="e">
        <tr>
            <td>${e.id}</td>
            <td>${e.name}</td>
            <td>${e.salary}</td>
            <td>${e.department.id}</td>
            <td>
                <div style="display: flex; gap: 12px; justify-content: center; align-items: center">
                    <a href="employees?action=EDIT&id=${e.id}" class="btn">Edit</a>

                    <form action="employees" method="post" style="margin: 0">
                        <input type="hidden" name="action" value="DELETE">
                        <input type="hidden" name="id" value="${e.id}">
                        <input type="submit" value="Delete" class="btn">
                    </form>
                </div>
            </td>

        </tr>
    </c:forEach>

</table>
</body>
</html>
