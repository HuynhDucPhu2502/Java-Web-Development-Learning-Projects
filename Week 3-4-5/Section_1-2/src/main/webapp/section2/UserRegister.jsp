<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>User Registration Form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../resource/bootstrap.min.css" rel="stylesheet">
    <style>
        .card-wrap{max-width:560px}
        .btn-primary{background:#0d6efd;border-color:#0d6efd}
    </style>
</head>
<body class="bg-light">

<div class="container py-5">
    <div class="d-flex justify-content-center">
        <div class="card card-wrap shadow-sm border rounded-3">
            <div class="card-body p-4">
                <h3 class="text-center mb-4">User Registration Form</h3>

                <form action="${pageContext.request.contextPath}/accounts/add" method="post">
                    <div class="row g-3">
                        <div class="col-md-6">
                            <input type="text" class="form-control" name="firstName" placeholder="First Name" required>
                        </div>
                        <div class="col-md-6">
                            <input type="text" class="form-control" name="lastName" placeholder="Last Name" required>
                        </div>

                        <div class="col-12">
                            <input type="email" class="form-control" name="email" placeholder="Your Email" required>
                        </div>

                        <div class="col-12">
                            <input type="password" class="form-control" name="password" placeholder="Password" required>
                        </div>

                        <div class="col-12">
                            <label class="form-label mb-1">Birthday</label>
                            <input type="date" class="form-control" name="dateOfBirth" required>
                        </div>

                        <div class="col-12">
                            <label class="form-label mb-1">Gender</label>
                            <div class="d-flex gap-3">
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="gender" id="female" value="Female">
                                    <label class="form-check-label" for="female">Female</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="gender" id="male" value="Male">
                                    <label class="form-check-label" for="male">Male</label>
                                </div>
                            </div>
                        </div>

                        <div class="col-12 pt-2">
                            <button class="btn btn-primary w-100 py-2" type="submit">Sign Up</button>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>

<script src="../resource/bootstrap.bundle.min.js"></script>
</body>
</html>
