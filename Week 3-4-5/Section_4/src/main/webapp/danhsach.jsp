<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Danh sách sách</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            background: white;
            border-radius: 15px;
            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.1);
            overflow: hidden;
        }

        .header {
            background: linear-gradient(135deg, #4f46e5 0%, #7c3aed 100%);
            color: white;
            padding: 2rem;
            text-align: center;
        }

        .header h2 {
            font-size: 2rem;
            margin: 0;
        }

        .content {
            padding: 2rem;
        }

        .nav-links {
            margin-bottom: 2rem;
            text-align: center;
        }

        .nav-links a {
            display: inline-block;
            background: linear-gradient(135deg, #10b981 0%, #059669 100%);
            color: white;
            text-decoration: none;
            padding: 0.75rem 1.5rem;
            border-radius: 8px;
            margin: 0 0.5rem;
            transition: transform 0.2s, box-shadow 0.2s;
        }

        .nav-links a:hover {
            transform: translateY(-2px);
            box-shadow: 0 8px 25px rgba(16, 185, 129, 0.3);
        }

        .search-form {
            background: #f8fafc;
            padding: 1.5rem;
            border-radius: 12px;
            margin-bottom: 2rem;
            border: 2px solid #e2e8f0;
        }

        .search-form form {
            display: flex;
            gap: 1rem;
            align-items: center;
            flex-wrap: wrap;
        }

        .search-form input[type="text"] {
            flex: 1;
            min-width: 200px;
            padding: 0.75rem;
            border: 2px solid #e2e8f0;
            border-radius: 8px;
            font-size: 1rem;
        }

        .search-form input[type="text"]:focus {
            outline: none;
            border-color: #4f46e5;
            box-shadow: 0 0 0 3px rgba(79, 70, 229, 0.1);
        }

        .btn {
            padding: 0.75rem 1.5rem;
            border: none;
            border-radius: 8px;
            font-size: 1rem;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            transition: all 0.2s;
            font-weight: 500;
        }

        .btn-primary {
            background: linear-gradient(135deg, #4f46e5 0%, #7c3aed 100%);
            color: white;
        }

        .btn-primary:hover {
            transform: translateY(-2px);
            box-shadow: 0 8px 25px rgba(79, 70, 229, 0.3);
        }

        .btn-secondary {
            background: #6b7280;
            color: white;
        }

        .btn-secondary:hover {
            background: #4b5563;
            transform: translateY(-2px);
        }

        .btn-success {
            background: linear-gradient(135deg, #10b981 0%, #059669 100%);
            color: white;
        }

        .btn-success:hover {
            transform: translateY(-2px);
            box-shadow: 0 8px 25px rgba(16, 185, 129, 0.3);
        }

        .table-container {
            overflow-x: auto;
            border-radius: 12px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.05);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background: white;
        }

        th, td {
            padding: 1rem;
            text-align: left;
            border-bottom: 1px solid #e2e8f0;
        }

        th {
            background: linear-gradient(135deg, #f8fafc 0%, #e2e8f0 100%);
            font-weight: 600;
            color: #374151;
            position: sticky;
            top: 0;
        }

        tr:hover {
            background: #f8fafc;
        }

        .quantity-form {
            display: flex;
            gap: 0.5rem;
            align-items: center;
        }

        .quantity-form input[type="number"] {
            width: 60px;
            padding: 0.5rem;
            border: 1px solid #d1d5db;
            border-radius: 4px;
        }

        .quantity-form button {
            padding: 0.5rem 1rem;
            font-size: 0.875rem;
        }

        img {
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
        }

        @media (max-width: 768px) {
            .container {
                margin: 10px;
                border-radius: 10px;
            }

            .header {
                padding: 1.5rem;
            }

            .header h2 {
                font-size: 1.5rem;
            }

            .content {
                padding: 1rem;
            }

            .search-form form {
                flex-direction: column;
            }

            .search-form input[type="text"] {
                min-width: 100%;
            }

            table {
                font-size: 0.875rem;
            }

            th, td {
                padding: 0.5rem;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h2>📚 Danh sách sách</h2>
    </div>

    <div class="content">
        <!-- Navigation -->
        <div class="nav-links">
            <a href="cart">🛒 Xem giỏ hàng</a>
        </div>

        <!-- Search form -->
        <div class="search-form">
            <form method="get" action="books">
                <input type="text" name="search" placeholder="Nhập tiêu đề sách..."
                       value="${param.search != null ? param.search : ''}"/>
                <button type="submit" class="btn btn-primary">🔍 Tìm kiếm</button>
                <a href="books" class="btn btn-secondary">Xem tất cả</a>
            </form>
        </div>

        <!-- Books table -->
        <div class="table-container">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Tiêu đề</th>
                    <th>Tác giả</th>
                    <th>Giá</th>
                    <th>Ảnh</th>
                    <th>Chi tiết</th>
                    <th>Thêm vào giỏ</th>
                </tr>
                <c:forEach var="b" items="${books}">
                    <tr>
                        <td>${b.id}</td>
                        <td><strong>${b.title}</strong></td>
                        <td>${b.author}</td>
                        <td><strong>${b.price} USD</strong></td>
                        <td><img src="${b.imgUrl}" alt="cover" width="60"/></td>
                        <td><a href="books?id=${b.id}" class="btn btn-primary">👁️ Xem chi tiết</a></td>
                        <td>
                            <form method="post" action="cart" class="quantity-form">
                                <input type="hidden" name="action" value="add"/>
                                <input type="hidden" name="productId" value="${b.id}"/>
                                <input type="number" name="qty" value="1" min="1"/>
                                <button type="submit" class="btn btn-success">🛒 Thêm</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
