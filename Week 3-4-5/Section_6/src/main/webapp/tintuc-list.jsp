<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/20/2025
  Time: 10:05 PM
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

<a href="tintuc?action=CREATE" style="display: block">Thêm tin tức mới</a>
<a href="danhmuc" style="display: block">Xem trang quản lý danh mục</a>

<form method="get" name="danhmuc" style="margin-top: 10px; margin-bottom: 10px">
    <label>Danh mục:</label>
    <select name="danhMucName">
        <option value="ALL">Tất cả</option>
        <c:forEach items="${danhMucList}" var="dm">
            <option value="${dm.tenDanhMuc}"
                    <c:if test="${dm.tenDanhMuc == danhMucName}">selected</c:if>>${dm.tenDanhMuc}</option>
        </c:forEach>
    </select>
    <button>Tìm kiếm</button>
</form>

<table border="1" width="60%">
    <%--    Tiêu đề table--%>
    <tr>
        <th>ID</th>
        <th>Tiêu đề</th>
        <th>Nội dung TT</th>
        <th>Liên kết</th>
        <th>Danh mục</th>
        <th>Hành động</th>
    </tr>

    <c:forEach items="${TinTucList}" var="tt">
        <tr>
            <td>${tt.maTT}</td>
            <td>${tt.tieuDe}</td>
            <td>${tt.noiDungTT}</td>
            <td>${tt.lienKet}</td>
            <td>${tt.danhMuc.tenDanhMuc}</td>
            <td>
                <div>
                    <a href="tintuc?action=UPDATE&id=${tt.maTT}" style="display: block; margin-bottom: 4px">Chỉnh
                        sửa</a>
                    <form action="tintuc" method="post">
                        <input name="action" value="DELETE" type="hidden">
                        <input name="maTT" value="${tt.maTT}" type="hidden">
                        <button type="submit">Delete</button>
                    </form>
                </div>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
