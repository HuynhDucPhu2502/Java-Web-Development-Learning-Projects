<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/24/2025
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../resource/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="d-flex justify-content-center my-5">
    <div class="card shadow p-4" style="max-width: 700px; width: 100%;">
        <h2 class="text-center mb-4">Registration Details</h2>

        <table class="table table-bordered">
            <tbody>
            <tr>
                <th>First Name</th>
                <td>${firstName}</td>
            </tr>
            <tr>
                <th>Last Name</th>
                <td>${lastName}</td>
            </tr>
            <tr>
                <th>Date of Birth</th>
                <td>${dateOfBirth}</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${email}</td>
            </tr>
            <tr>
                <th>Mobile Number</th>
                <td>${mobileNumber}</td>
            </tr>
            <tr>
                <th>Gender</th>
                <td>${gender}</td>
            </tr>
            <tr>
                <th>Address</th>
                <td>${address}</td>
            </tr>
            <tr>
                <th>City</th>
                <td>${city}</td>
            </tr>
            <tr>
                <th>Pin Code</th>
                <td>${pinCode}</td>
            </tr>
            <tr>
                <th>State</th>
                <td>${state}</td>
            </tr>
            <tr>
                <th>Country</th>
                <td>${country}</td>
            </tr>
            <tr>
                <th>Hobbies</th>
                <td>
                    <c:forEach var="h" items="${hobbies}">
                        <span class="badge bg-primary me-1">${h}</span>
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <th>Course Applied For</th>
                <td>${course}</td>
            </tr>
            </tbody>
        </table>

        <div class="text-center mt-3">
            <a href="form.jsp" class="btn btn-secondary">Back</a>
        </div>
    </div>
</div>

<script src="../resource/bootstrap.bundle.min.js"></script>
</body>
</html>
