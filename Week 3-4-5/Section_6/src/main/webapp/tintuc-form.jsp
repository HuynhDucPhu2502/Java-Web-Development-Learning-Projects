<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/20/2025
  Time: 10:58 PM
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
<a href="tintuc" style="display: block">Danh sách tin tức</a>
<form action="tintuc" method="post">
    <input name="action" value="SAVE" type="hidden">
    <c:if test="${not empty tinTuc}">
        <input type="hidden" name="tinTucId" value="${tinTuc.maTT}"/>
    </c:if>

    <div>
        <label>Tiêu đề</label>
        <input name="tieuDe" type="text" value="${tinTuc.tieuDe}"/>
    </div>
    <div>
        <label>Nội dung tin tức</label>
        <textarea name="noiDungTT" type="text">${tinTuc.noiDungTT}</textarea>
    </div>
    <div>
        <label>Liên kết</label>
        <input name="lienKet" type="text" value="${tinTuc.lienKet}"/>
    </div>
    <div>
        <label>Danh mục:</label>
        <select name="danhMucId">
            <c:forEach items="${danhMucList}" var="dm">
                <option value="${dm.maDm}"
                        <c:if test="${dm.tenDanhMuc == tinTuc.danhMuc.tenDanhMuc}">selected</c:if>>${dm.tenDanhMuc}</option>
            </c:forEach>
        </select>
    </div>


    <button type="submit">Tạo</button>
</form>
</body>
</html>
