<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/23/2025
  Time: 5:55 PM
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
<a href="products">Quay lai</a>
<h1>Product details</h1>
<p>Id: ${p.id}</p>
<p>model: ${p.model}</p>
<p>price: ${p.price}</p>
<p>description: ${p.description}</p>
</body>
</html>
