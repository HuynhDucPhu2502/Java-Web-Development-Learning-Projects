<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi tiết sản phẩm</title>
    <link href="/resource/bootstrap.min.css" rel="stylesheet">
    <script src="/resource/bootstrap.bundle.min.js"></script>
</head>
<body class="container mt-4">
<h2>Chi tiết sản phẩm</h2>

<c:if test="${not empty product}">
    <div class="card" style="max-width: 600px;">
        <c:if test="${not empty product.imgUrl}">
            <img src="${product.imgUrl}" class="card-img-top" alt="image">
        </c:if>
        <div class="card-body">
            <h5 class="card-title">${product.model}</h5>
            <p class="card-text">${product.description}</p>
            <ul class="list-group list-group-flush">
                <li class="list-group-item"><b>Giá:</b> ${product.price}</li>
                <li class="list-group-item"><b>Số lượng:</b> ${product.quantity}</li>
            </ul>
            <a href="products" class="btn btn-secondary mt-3">Quay lại danh sách</a>
        </div>
    </div>
</c:if>

<c:if test="${empty product}">
    <div class="alert alert-danger">Không tìm thấy sản phẩm!</div>
    <a href="products" class="btn btn-secondary mt-3">Quay lại danh sách</a>
</c:if>
</body>
</html>
