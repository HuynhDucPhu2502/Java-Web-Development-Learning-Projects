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

<form action="tintuc" method="post" id="form">
    <input type="hidden" name="action" value="SAVE">

    <c:if test="${not empty tinTuc}">
        <input type="hidden" name="id" value="${tinTuc.maTT}">
    </c:if>

    <div>
        <label>Tieu de</label>
        <input name="tieuDe" value="${tinTuc.tieuDe}" required>
    </div>

    <div>
        <label>noiDungTT</label>
        <input name="noiDungTT" value="${tinTuc.noiDungTT}" required id="noiDungTT">
    </div>

    <div>
        <label>lienKet</label>
        <input name="lienKet" value="${tinTuc.lienKet}" required id="lienKet">
    </div>

    <select name="danhMucId">
        <c:forEach items="${listDanhMuc}" var="dm">
            <option value="${dm.maDm}">${dm.tenDanhMuc}</option>
        </c:forEach>
    </select>


    <button type="submit">Save</button>
</form>

<script>
    document.getElementById("form").addEventListener("submit", (e) => {
        const noiDungTT = document.getElementById("noiDungTT").value.trim();
        const lienKet = document.getElementById("lienKet").value.trim();

        const lienKetRegex = /^http:\/\/\w+$/
        const noiDungRegex = /^\w{1,255}$/

        if (!noiDungRegex.test(noiDungTT)) {
            alert("Nội dung không quá 255 ký tự")
            e.preventDefault()
        }

        if (!lienKetRegex.test(lienKet)) {
            alert("Liên kết bắt đầu bởi “http://” ")
            e.preventDefault()
        }
    })
</script>

</body>
</html>
