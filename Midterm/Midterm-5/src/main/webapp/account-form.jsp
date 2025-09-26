<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/26/2025
  Time: 1:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="accounts">Xem danh sách tài khoản</a> |
<a href="accounts?action=CREATE">Tạo mới tài khoản</a>
<h1>Tạo mới tài khoản</h1>

<form action="accounts" method="post">

    <div>
        <label>ownerName</label>
        <input required name="ownerName">
    </div>

    <div>
        <label>cardNumber</label>
        <input required name="cardNumber">
    </div>

    <div>
        <label>ownerAddress</label>
        <input required name="ownerAddress">
    </div>

    <div>
        <label>amount</label>
        <input required name="amount">
    </div>

    <button type="submit">Lưu</button>

</form>


</body>
</html>
