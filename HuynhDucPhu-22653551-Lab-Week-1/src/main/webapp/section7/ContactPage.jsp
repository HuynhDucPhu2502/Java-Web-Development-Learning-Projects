<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/20/2025
  Time: 11:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/contacts" method="post" enctype="multipart/form-data">
    <div>
        <label>Họ: </label>
        <input type="text" name="firstName">
    </div>
    <div>
        <label>Tên: </label>
        <input type="text" name="lastName">
    </div>
    <div>
        <label>Ảnh đại diện: </label>
        <input type="file" name="avatarImg">
    </div>
    <button>Submit</button>
</form>
</body>
</html>
