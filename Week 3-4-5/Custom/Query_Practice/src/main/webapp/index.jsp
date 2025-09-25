<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<a href="employees">Quay lại</a>
<a href="employees?action=findMaxSalaryPerDepartment">Câu 1</a>
<form action="employees?action=findActiveEmployeesAtDate" method="post">
    <label>Câu 2</label>
    <input type="date" name="date">
    <button>Tìm</button>
</form>
<a href="employees?action=findEmployeesAboveAverageSalary">Câu 3</a>
<form action="employees?action=findEmployeesHiredBetween" method="post">
    <label>Câu 4 From:</label>
    <input type="date" name="dateFrom">
    <label>Câu 4 To:</label>
    <input type="date" name="dateTo">
    <button>Tìm</button>
</form>
<form action="employees?action=findEmployeesWithTenureGreaterThanXYears" method="post">
    <label>Câu 5</label>
    <input name="numberOfYears">
    <button>Tìm</button>
</form>

<table border="1" width="90%">
    <tr>
        <th>id</th>
        <th>fullName</th>
        <th>email</th>
        <th>salary</th>
        <th>title</th>
        <th>hireDate</th>
        <th>terminationDate</th>
        <th>dob</th>
        <th>department</th>
    </tr>

    <c:forEach items="${employees}" var="e">
        <tr>
            <td>${e.id}</td>
            <td>${e.fullName}</td>
            <td>${e.email}</td>
            <td>${e.salary}</td>
            <td>${e.title}</td>
            <td>${e.hireDate}</td>
            <td>${e.terminationDate}</td>
            <td>${e.dob}</td>
            <td>${e.department.name}</td>
        </tr>
    </c:forEach>


</table>

</body>
</html>