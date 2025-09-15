<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hóa đơn thanh toán</title>
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
            max-width: 1000px;
            margin: 0 auto;
            background: white;
            border-radius: 15px;
            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.1);
            overflow: hidden;
        }

        .invoice-header {
            background: linear-gradient(135deg, #10b981 0%, #059669 100%);
            color: white;
            padding: 2rem;
            text-align: center;
        }

        .invoice-header h2 {
            font-size: 2rem;
            margin: 0 0 0.5rem 0;
        }

        .invoice-header p {
            font-size: 1.1rem;
            opacity: 0.9;
        }

        .content {
            padding: 2rem;
        }

        .customer-info {
            background: #f8fafc;
            padding: 1.5rem;
            border-radius: 12px;
            border-left: 4px solid #4f46e5;
            margin-bottom: 2rem;
        }

        .customer-info h3 {
            color: #4f46e5;
            margin-bottom: 1rem;
            font-size: 1.25rem;
        }

        .customer-info p {
            margin-bottom: 0.75rem;
            font-size: 1rem;
        }

        .customer-info p:last-child {
            margin-bottom: 0;
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
        }

        tr:hover {
            background: #f8fafc;
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

        .nav-links {
            display: flex;
            justify-content: center;
            gap: 1rem;
            flex-wrap: wrap;
            margin: 1rem 0;
        }

        .nav-links a {
            display: inline-block;
            background: linear-gradient(135deg, #4f46e5 0%, #7c3aed 100%);
            color: white;
            text-decoration: none;
            padding: 0.75rem 1.5rem;
            border-radius: 8px;
            transition: transform 0.2s, box-shadow 0.2s;
            font-weight: 500;
        }

        .nav-links a:hover {
            transform: translateY(-2px);
            box-shadow: 0 8px 25px rgba(79, 70, 229, 0.3);
        }

        .empty-state {
            text-align: center;
            padding: 2rem;
            background: #f8fafc;
            border-radius: 12px;
            border: 2px dashed #cbd5e1;
        }

        hr {
            border: none;
            height: 2px;
            margin: 2rem 0;
        }

        @media (max-width: 768px) {
            .container {
                margin: 10px;
                border-radius: 10px;
            }

            .invoice-header {
                padding: 1.5rem;
            }

            .invoice-header h2 {
                font-size: 1.5rem;
            }

            .content {
                padding: 1rem;
            }

            .customer-info {
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
    <div class="invoice-header">
        <h2>🧾 Hóa đơn thanh toán</h2>
        <p>Cảm ơn bạn đã mua hàng! 🙏</p>
    </div>

    <div class="content">
        <div class="customer-info">
            <h3>👤 Thông tin khách hàng</h3>
            <p><strong>Họ tên:</strong> ${fullname}</p>
            <p><strong>Địa chỉ:</strong> ${address}</p>
            <p><strong>Phương thức thanh toán:</strong> ${paymentMethod}</p>
        </div>

        <hr style="border: none; height: 2px; background: linear-gradient(135deg, #4f46e5 0%, #7c3aed 100%); margin: 2rem 0;"/>

        <h3 style="color: #4f46e5; margin-bottom: 1rem;">📋 Chi tiết đơn hàng</h3>
        <c:choose>
            <c:when test="${empty sessionScope.cart or empty sessionScope.cart.cartItems}">
                <div class="empty-state">
                    <p>Giỏ hàng trống.</p>
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
                        </tr>
                        <c:forEach var="item" items="${sessionScope.cart.cartItems}">
                            <tr>
                                <td><strong>${item.book.title}</strong></td>
                                <td>${item.book.author}</td>
                                <td>
                                    <fmt:formatNumber value="${item.book.price}" type="currency" currencySymbol="₫"/>
                                </td>
                                <td>${item.quantity}</td>
                                <td>
                                    <strong style="color: #059669;">
                                        <fmt:formatNumber value="${item.subtotal}" type="currency" currencySymbol="₫"/>
                                    </strong>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

                <div class="total-price">
                    💰 Tổng cộng:
                    <fmt:formatNumber value="${sessionScope.cart.totalPrice}" type="currency" currencySymbol="₫"/>
                </div>
            </c:otherwise>
        </c:choose>

        <hr style="border: none; height: 2px; background: linear-gradient(135deg, #10b981 0%, #059669 100%); margin: 2rem 0;"/>

        <div style="text-align: center; background: #f0fdf4; padding: 2rem; border-radius: 12px; border-left: 4px solid #10b981;">
            <h3 style="color: #047857; margin-bottom: 1rem;">✅ Đặt hàng thành công!</h3>
            <p style="color: #065f46;">Đơn hàng của bạn đã được xử lý thành công. Chúng tôi sẽ liên hệ với bạn sớm nhất
                có thể.</p>
        </div>

        <div class="nav-links" style="margin-top: 2rem; justify-content: center;">
            <a href="books">🛍️ Tiếp tục mua sắm</a>
        </div>
    </div>
</div>
</body>
</html>
