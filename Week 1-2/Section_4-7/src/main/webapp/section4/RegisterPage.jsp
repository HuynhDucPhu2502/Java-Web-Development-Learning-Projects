<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>

    <link href="<%= request.getContextPath() %>/resources/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container py-5">
    <a href="../index.jsp">Quay lại</a>

    <h2 class="text-center mb-4 text-primary">Biểu mẫu đăng ký</h2>

    <div class="card p-4 shadow-sm">
        <form method="POST" action="<%= request.getContextPath() %>/register">
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <div class="row">
                    <div class="col">
                        <input type="text" class="form-control" id="name" name="name" placeholder="Tên" required>
                    </div>
                    <div class="col">
                        <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Họ"
                               required>
                    </div>
                </div>
            </div>

            <div class="mb-3">
                <label for="username" class="form-label">Tên người dùng</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>

            <div class="mb-3">
                <label for="email" class="form-label">E-mail</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>

            <div class="mb-3">
                <label for="password" class="form-label">Mật khẩu</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>

            <div class="mb-3">
                <label for="bio" class="form-label">Mô tả ngắn</label>
                <textarea class="form-control" id="bio" name="bio" rows="4"
                ></textarea>
            </div>

            <button type="submit" class="btn btn-primary w-100">Submit</button>
        </form>
    </div>
</div>

<script src="<%= request.getContextPath() %>/resources/bootstrap.bundle.min.js"></script>
</body>
</html>
