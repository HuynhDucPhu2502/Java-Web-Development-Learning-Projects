<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/21/2025
  Time: 4:59 PM
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
<a href="danhmuc" style="display: block">Quay lại</a>

<form action="danhmuc" method="post">
    <input type="hidden" name="action" value="SAVE">
    <c:if test="${not empty danhMuc}">
        <input type="hidden" name="id" value="${danhMuc.maDm}">
    </c:if>

    <div>
        <label>Tên danh mục</label>
        <input name="tenDanhMuc" value="${danhMuc.tenDanhMuc}">
    </div>

    <div>
        <label>Người quản ly' </label>
        <input name="nguoiQuanLy" value="${danhMuc.nguoiQuanLy}">
    </div>

    <div>
        <label>Ghi chú</label>
        <input name="ghiChu" value="${danhMuc.ghiChu}">
    </div>


    <button type="submit">Save</button>
</form>

</body>
</html>
