<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/19/2025
  Time: 11:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="POST" action="<%= request.getContextPath() %>/upload" enctype="multipart/form-data">
    <div>
        <label id="file1">File #1:</label>
        <input type="file" name="file1" id="file1">
    </div>
    <div>
        <label id="file2">File #2:</label>
        <input type="file" name="file2" id="file2">
    </div>
    <div>
        <label id="file3">File #3:</label>
        <input type="file" name="file3" id="file3">
    </div>
    <button>Submit</button>
</form>
</body>
</html>
