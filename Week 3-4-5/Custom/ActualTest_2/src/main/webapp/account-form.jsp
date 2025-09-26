<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/26/2025
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="accounts">Danh sách tài khoản</a> |
<a href="accounts?action=CREATE">Tạo mới tài khoản</a>
<h1>Danh sách tài khoản</h1>

<table width="80%" border="1">
    <tr>
        <th>accountNumber</th>
        <th>ownerName</th>
        <th>cardNumber</th>
        <th>ownerAddress</th>
        <th>amount</th>
    </tr>

    <c:forEach items="${listAccount}" var="a">
        <tr>
            <td>${a.accountNumber}</td>
            <td>${a.ownerName}</td>
            <td>${a.cardNumber}</td>
            <td>${a.ownerAddress}</td>
            <td>${a.amount}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
