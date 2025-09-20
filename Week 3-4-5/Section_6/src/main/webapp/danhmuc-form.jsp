<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/20/2025
  Time: 12:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="danhmuc" style="display: block">Danh sách danh mục</a>
<form action="danhmuc" method="post">
    <input name="action" value="SAVE" type="hidden">
    <c:if test="${not empty danhMuc}">
        <input type="hidden" name="danhMucId" value="${danhMuc.maDm}">
    </c:if>

    <div>
        <label>Tên danh mục</label>
        <input name="tenDanhMuc" type="text" value="${danhMuc.tenDanhMuc}">
    </div>
    <div>
        <label>Người quản lý</label>
        <input name="nguoiQuanLy" type="text" value="${danhMuc.nguoiQuanLy}">
    </div>
    <div>
        <label>Ghi chú</label>
        <input name="ghiChu" type="text" value="${danhMuc.ghiChu}">
    </div>
    <button type="submit">Tạo</button>
</form>

</body>
</html>
