<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Giỏ hàng</title>
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

        .empty-state {
            text-align: center;
            padding: 3rem;
            background: #f8fafc;
            border-radius: 12px;
            border: 2px dashed #cbd5e1;
        }

        .empty-state h3 {
            color: #64748b;
            margin-bottom: 1rem;
            font-size: 1.5rem;
        }

        .empty-state p {
            color: #64748b;
            margin-bottom: 2rem;
        }

        .nav-links {
            display: flex;
            justify-content: center;
            gap: 1rem;
            flex-wrap: wrap;
            margin: 1rem 0;
        }

        .nav-links a {
            display: inline-block;
            background: linear-gradient(135deg, #10b981 0%, #059669 100%);
            color: white;
            text-decoration: none;
            padding: 0.75rem 1.5rem;
            border-radius: 8px;
            transition: transform 0.2s, box-shadow 0.2s;
            font-weight: 500;
        }

        .nav-links a:hover {
            transform: translateY(-2px);
            box-shadow: 0 8px 25px rgba(16, 185, 129, 0.3);
        }

        .table-container {
            overflow-x: auto;
            border-radius: 12px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.05);
            margin-bottom: 2rem;
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
            width: 70px;
            padding: 0.5rem;
            border: 1px solid #d1d5db;
            border-radius: 4px;
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

        .btn-success {
            background: linear-gradient(135deg, #10b981 0%, #059669 100%);
            color: white;
        }

        .btn-success:hover {
            transform: translateY(-2px);
            box-shadow: 0 8px 25px rgba(16, 185, 129, 0.3);
        }

        .btn-danger {
            background: linear-gradient(135deg, #ef4444 0%, #dc2626 100%);
            color: white;
        }

        .btn-danger:hover {
            transform: translateY(-2px);
            box-shadow: 0 8px 25px rgba(239, 68, 68, 0.3);
        }

        .total-price {
            background: linear-gradient(135deg, #10b981 0%, #059669 100%);
            color: white;
            padding: 1.5rem;
            border-radius: 12px;
            text-align: center;
            font-size: 1.5rem;
            font-weight: bold;
            margin: 2rem 0;
            box-shadow: 0 8px 25px rgba(16, 185, 129, 0.2);
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

            table {
                font-size: 0.875rem;
            }

            th, td {
                padding: 0.5rem;
            }

            .total-price {
                font-size: 1.25rem;
                padding: 1rem;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h2>🛒 Giỏ hàng</h2>
    </div>

    <div class="content">
        <c:choose>
            <c:when test="${empty sessionScope.cart or empty sessionScope.cart.cartItems}">
                <div class="empty-state">
                    <h3>🛒 Giỏ hàng của bạn đang trống</h3>
                    <p>Hãy thêm một số sách vào giỏ hàng để tiếp tục mua sắm!</p>
                    <div class="nav-links">
                        <a href="books">📚 Tiếp tục mua sách</a>
                    </div>
                </div>
            </c:when>

            <c:otherwise>
                <div class="table-container">
                    <table>
                        <tr>
                            <th>Tiêu đề</th>
                            <th>Tác giả</th>
                            <th>Giá</th>
                            <th>Số lượng</th>
                            <th>Tạm tính</th>
                            <th>Hành động</th>
                        </tr>

                        <c:forEach var="item" items="${sessionScope.cart.cartItems}">
                            <tr>
                                <td><strong>${item.book.title}</strong></td>
                                <td>${item.book.author}</td>
                                <td>
                                    <fmt:formatNumber value="${item.book.price}" type="currency" currencySymbol="₫"/>
                                </td>
                                <td>
                                    <!-- Form cập nhật số lượng -->
                                    <form method="post" action="cart" class="quantity-form">
                                        <input type="hidden" name="action" value="update"/>
                                        <input type="hidden" name="productId" value="${item.book.id}"/>
                                        <input type="number" name="quantity" value="${item.quantity}" min="1"/>
                                        <input type="submit" value="Cập nhật" class="btn btn-primary"/>
                                    </form>
                                </td>
                                <td>
                                    <strong style="color: #059669;">
                                        <fmt:formatNumber value="${item.subtotal}" type="currency" currencySymbol="₫"/>
                                    </strong>
                                </td>
                                <td>
                                    <!-- Form xóa -->
                                    <form method="post" action="cart">
                                        <input type="hidden" name="action" value="remove"/>
                                        <input type="hidden" name="productId" value="${item.book.id}"/>
                                        <input type="submit" value="🗑️ Xóa" class="btn btn-danger"/>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

                <div class="total-price">
                    💰 Tổng cộng:
                    <fmt:formatNumber value="${sessionScope.cart.totalPrice}" type="currency" currencySymbol="₫"/>
                </div>

                <!-- Actions -->
                <div style="display: flex; justify-content: space-between; align-items: center; flex-wrap: wrap; gap: 1rem;">
                    <form method="post" action="cart">
                        <input type="hidden" name="action" value="clear"/>
                        <input type="submit" value="🗑️ Xóa toàn bộ giỏ hàng" class="btn btn-danger"/>
                    </form>

                    <div class="nav-links">
                        <a href="books">← Tiếp tục mua sách</a>
                        <a href="payment" class="btn btn-success">💳 Thanh toán</a>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
