<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Result</title>
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
                <td>${student.firstName}</td>
            </tr>
            <tr>
                <th>Last Name</th>
                <td>${student.lastName}</td>
            </tr>
            <tr>
                <th>Date of Birth</th>
                <td>${student.dateOfBirth}</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${student.email}</td>
            </tr>
            <tr>
                <th>Mobile Number</th>
                <td>${student.mobileNumber}</td>
            </tr>
            <tr>
                <th>Gender</th>
                <td>${student.gender}</td>
            </tr>
            <tr>
                <th>Address</th>
                <td>${student.address}</td>
            </tr>
            <tr>
                <th>City</th>
                <td>${student.city}</td>
            </tr>
            <tr>
                <th>Pin Code</th>
                <td>${student.pinCode}</td>
            </tr>
            <tr>
                <th>State</th>
                <td>${student.state}</td>
            </tr>
            <tr>
                <th>Country</th>
                <td>${student.country}</td>
            </tr>
            <tr>
                <th>Hobbies</th>
                <td>
                    <c:forEach var="h" items="${student.hobbies}">
                        <span class="badge bg-primary me-1">${h}</span>
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <th>Course Applied For</th>
                <td>${student.course}</td>
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
