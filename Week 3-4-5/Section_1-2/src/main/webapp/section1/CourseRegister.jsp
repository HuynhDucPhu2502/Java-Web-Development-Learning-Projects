<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Course Registration</title>
    <!-- Dùng file bootstrap trong resource -->
    <link href="../resource/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="d-flex justify-content-center my-5">
    <div class="card shadow p-4" style="max-width: 900px; width: 100%;">
        <h2 class="text-center mb-4">Course Registration</h2>

        <form method="post" action="${pageContext.request.contextPath}/course-register">
            <div class="row g-3">
                <div class="col-md-6">
                    <label class="form-label">First Name</label>
                    <input name="firstName" maxlength="30" required class="form-control">
                </div>

                <div class="col-md-6">
                    <label class="form-label">Last Name</label>
                    <input name="lastName" maxlength="30" required class="form-control">
                </div>

                <div class="col-md-6">
                    <label class="form-label">Date of Birth</label>
                    <input name="dateOfBirth" type="date" required class="form-control">
                </div>

                <div class="col-md-6">
                    <label class="form-label">Email</label>
                    <input name="email" type="email" required class="form-control">
                </div>

                <div class="col-md-6">
                    <label class="form-label">Mobile Number</label>
                    <input name="mobileNumber" type="tel" class="form-control">
                </div>

                <div class="col-md-6">
                    <label class="form-label">Gender</label><br>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" value="Male" required>
                        <label class="form-check-label">Male</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" value="Female">
                        <label class="form-check-label">Female</label>
                    </div>
                </div>

                <div class="col-12">
                    <label class="form-label">Address</label>
                    <textarea name="address" class="form-control"></textarea>
                </div>

                <div class="col-md-6">
                    <label class="form-label">City</label>
                    <input name="city" class="form-control">
                </div>

                <div class="col-md-6">
                    <label class="form-label">Pin code</label>
                    <input name="pinCode" class="form-control">
                </div>

                <div class="col-md-6">
                    <label class="form-label">State</label>
                    <input name="state" maxlength="30" class="form-control">
                </div>

                <div class="col-md-6">
                    <label class="form-label">Country</label>
                    <input name="country" class="form-control">
                </div>

                <div class="col-12">
                    <label class="form-label">Hobbies</label><br>
                    <div class="form-check form-check-inline">
                        <input type="checkbox" class="form-check-input" name="hobbies" value="Drawing">
                        <label class="form-check-label">Drawing</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input type="checkbox" class="form-check-input" name="hobbies" value="Singing">
                        <label class="form-check-label">Singing</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input type="checkbox" class="form-check-input" name="hobbies" value="Sketching">
                        <label class="form-check-label">Sketching</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input type="checkbox" class="form-check-input" name="hobbies" value="Others">
                        <label class="form-check-label">Others</label>
                    </div>
                </div>

                <div class="col-12">
                    <label class="form-label">Course applies for</label><br>
                    <div class="form-check form-check-inline">
                        <input type="radio" class="form-check-input" name="course" value="BCA" required>
                        <label class="form-check-label">BCA</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input type="radio" class="form-check-input" name="course" value="B.com">
                        <label class="form-check-label">B.com</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input type="radio" class="form-check-input" name="course" value="B.Sc">
                        <label class="form-check-label">B.Sc</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input type="radio" class="form-check-input" name="course" value="B.A">
                        <label class="form-check-label">B.A</label>
                    </div>
                </div>

                <div class="col-12">
                    <button type="submit" class="btn btn-primary w-100">Apply</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script src="../resource/bootstrap.bundle.min.js"></script>
</body>
</html>
