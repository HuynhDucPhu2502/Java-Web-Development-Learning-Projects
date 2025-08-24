<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bài tập thực hành tuần 1 - 2</title>
    <link href="<%= request.getContextPath() %>/resources/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container py-5">

    <h1 class="text-center mb-4 text-primary">Bài tập thực hành tuần 1</h1>

    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-3 g-4">
        <div class="col">
            <div class="card shadow-sm">
                <a href="section4/RegisterPage.jsp" class="text-decoration-none">
                    <div class="card-body text-center">
                        <h3 class="card-title text-primary">Bài 4 - Register Form</h3>
                    </div>
                </a>
            </div>
        </div>
        <div class="col">
            <div class="card shadow-sm">
                <a href="section5/Home.jsp" class="text-decoration-none">
                    <div class="card-body text-center">
                        <h3 class="card-title text-primary">Bài 5 - Auth Filter</h3>
                    </div>
                </a>
            </div>
        </div>
        <div class="col">
            <div class="card shadow-sm">
                <a href="section6/UploadPage.jsp" class="text-decoration-none">
                    <div class="card-body text-center">
                        <h3 class="card-title text-primary">Bài 6 - Upload files</h3>
                    </div>
                </a>
            </div>
        </div>
        <div class="col">
            <div class="card shadow-sm">
                <a href="section7/ContactPage.jsp" class="text-decoration-none">
                    <div class="card-body text-center">
                        <h3 class="card-title text-primary">Bài 7 - File upload to database</h3>
                    </div>
                </a>
            </div>
        </div>


    </div>
</div>

<script src="<%= request.getContextPath() %>/resources/bootstrap.bundle.min.js"></script>
</body>
</html>
