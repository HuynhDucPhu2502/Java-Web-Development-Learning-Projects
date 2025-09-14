<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Account List</title>
    <link href="../resource/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container py-5">
    <div class="card shadow-lg rounded-3">
        <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
            <h4 class="mb-0">Danh sách Account</h4>
            <a href="${pageContext.request.contextPath}/accounts/add" class="btn btn-light btn-sm">+ Thêm mới</a>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-hover align-middle">
                    <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Họ và Tên</th>
                        <th>Email</th>
                        <th>Ngày sinh</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="a" items="${accounts}">
                        <tr>
                            <td>${a.id}</td>
                            <td>${a.firstName} ${a.lastName}</td>
                            <td><span class="badge bg-info text-dark">${a.email}</span></td>
                            <td>${a.dateOfBirth}</td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty accounts}">
                        <tr>
                            <td colspan="4" class="text-center text-muted">Chưa có dữ liệu</td>
                        </tr>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="../resource/bootstrap.bundle.min.js"></script>
</body>
</html>
