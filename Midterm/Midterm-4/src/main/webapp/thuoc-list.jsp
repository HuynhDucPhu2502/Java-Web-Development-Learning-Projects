<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/25/2025
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="loaithuoc">Danh sách các loại thuốc</a> |
<a href="thuoc">Danh sách thuốc</a> |
<a href="thuoc?action=CREATE">Thêm mới thuốc</a>
<h1>Danh sách thuốc</h1>

<form action="thuoc" method="get">
    <select name="loaiThuocId">
        <option value="ALL">Tất ca</option>

        <c:forEach items="${listLoaiThuoc}" var="loaiThuoc">
            <option value="${loaiThuoc.maLoai}">${loaiThuoc.tenLoai}</option>
        </c:forEach>

    </select>

    <button type="submit">Tìm kiếm</button>
</form>

<table border="1" width="80%">
    <tr>
        <th>maThuoc</th>
        <th>tenThuoc</th>
        <th>gia</th>
        <th>namSX</th>
        <th>loaiThuoc</th>
    </tr>

    <c:forEach items="${listThuoc}" var="thuoc">
        <tr>
            <td>${thuoc.maThuoc}</td>
            <td>${thuoc.tenThuoc}</td>
            <td>${thuoc.gia}</td>
            <td>${thuoc.namSX}</td>
            <td>${thuoc.loaiThuoc.tenLoai}</td>
        </tr>
    </c:forEach>

</table>


</body>
</html>
