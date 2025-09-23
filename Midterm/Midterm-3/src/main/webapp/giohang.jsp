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
<a href="products">Xem danh sách mặt hàng</a>
<h1>Giỏ hàng</h1>

<table border="1" width="80%">
    <tr>
        <th>id</th>
        <th>model</th>
        <th>price</th>
        <th>description</th>
        <th>quantity</th>
        <th>subtotal</th>
        <th>actions</th>
    </tr>

    <c:forEach items="${cart.items}" var="item">
        <tr>
            <td>${item.product.id}</td>
            <td>${item.product.model}</td>
            <td>${item.product.price}</td>
            <td>${item.product.description}</td>
            <td>${item.quantity}</td>
            <td>${item.subTotal}</td>
            <td>
                <form action="carts?action=REMOVE&id=${item.product.id}" method="post">
                    <button>Xóa khỏi giỏ hàng</button>
                </form>
                <form action="carts?action=UPDATE-QUANTITY&id=${item.product.id}" method="post">
                    <input name="quantity" value="${item.quantity}">
                    <button>Cập nhật so luong</button>
                </form>
            </td>
        </tr>
    </c:forEach>

</table>

<p>Tổng tiêền: ${cart.total}</p>

<form action="carts?action=CHECKOUT" method="post">
    <div>
        <label>Tên khách hàng</label>
        <input name="name" required>
    </div>

    <div>
        <label>Địa ch</label>
        <input name="address" required>
    </div>

    <button>Thanh toán</button>
</form>

</body>
</html>
