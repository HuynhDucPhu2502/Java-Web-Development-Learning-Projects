<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/23/2025
  Time: 11:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="carts">Xem giỏ hàng</a>
<h1>Danh sách mặt hàng</h1>

<table border="1" width="80%">
    <tr>
        <th>id</th>
        <th>model</th>
        <th>price</th>
        <th>description</th>
        <th>actions</th>
    </tr>

    <c:forEach items="${productList}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.model}</td>
            <td>${p.price}</td>
            <td>${p.description}</td>
            <td>
                <a href="products?id=${p.id}">Xem chi tiết</a>
                <form action="carts?action=ADD&id=${p.id}" method="post">
                    <button>Thêm vào giỏ hàng</button>
                </form>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
