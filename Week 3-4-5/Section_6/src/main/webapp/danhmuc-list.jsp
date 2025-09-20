<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/19/2025
  Time: 7:18 PM
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
<a href="danhmuc-form.jsp" style="display: block">Thêm danh mục mới</a>
<a href="tintuc" style="display: block">Xem trang quản lý tin tức</a>

<table border="1" width="60%">
    <%--    Tiêu đề table--%>
    <tr>
        <th>ID</th>
        <th>Tên danh mục</th>
        <th>Người quản lý</th>
        <th>Ghi chú</th>
        <th>Hành động</th>
    </tr>

    <c:forEach items="${DanhMucList}" var="dm">
        <tr>
            <td>${dm.maDm}</td>
            <td>${dm.tenDanhMuc}</td>
            <td>${dm.nguoiQuanLy}</td>
            <td>${dm.ghiChu}</td>
            <td>
                <div>
                    <a href="danhmuc?action=UPDATE&id=${dm.maDm}" style="display: block; margin-bottom: 4px">Chỉnh
                        sửa</a>
                    <form action="danhmuc" method="post">
                        <input name="action" value="DELETE" type="hidden">
                        <input name="maDm" value="${dm.maDm}" type="hidden">
                        <button type="submit">Delete</button>
                    </form>
                </div>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
