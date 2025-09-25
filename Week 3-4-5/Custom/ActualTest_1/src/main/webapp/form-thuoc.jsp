<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/25/2025
  Time: 2:20 PM
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
<h1>Thêm mới thuốc</h1>

<form action="thuoc" method="post">

    <div>
        <label>Tên thuốc: </label>
        <input name="tenThuoc" required>
    </div>

    <div>
        <label>Gia': </label>
        <input name="gia" type="number" required>
    </div>

    <div>
        <label>Nam sx: </label>
        <input name="namSX" type="number" required>
    </div>


    <select name="loaiThuocId">
        <c:forEach items="${listLoaiThuoc}" var="loaiThuoc">
            <option value="${loaiThuoc.maLoai}">
                    ${loaiThuoc.tenLoai}
            </option>
        </c:forEach>
    </select>

    <button type="submit">Tạo</button>
</form>


</body>
</html>
