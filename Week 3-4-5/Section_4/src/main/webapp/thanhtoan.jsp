<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thanh toán</title>
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

        .form-container {
            background: #f8fafc;
            padding: 2rem;
            border-radius: 12px;
            margin-bottom: 2rem;
            border: 2px solid #e2e8f0;
        }

        .form-group {
            margin-bottom: 1.5rem;
        }

        .form-group label {
            display: block;
            margin-bottom: 0.5rem;
            font-weight: 600;
            color: #374151;
        }

        .form-group input[type="text"],
        .form-group textarea {
            width: 100%;
            padding: 0.75rem;
            border: 2px solid #e2e8f0;
            border-radius: 8px;
            font-size: 1rem;
            transition: border-color 0.2s;
        }

        .form-group input[type="text"]:focus,
        .form-group textarea:focus {
            outline: none;
            border-color: #4f46e5;
            box-shadow: 0 0 0 3px rgba(79, 70, 229, 0.1);
        }

        .radio-group {
            display: flex;
            flex-direction: column;
            gap: 0.75rem;
        }

        .radio-item {
            display: flex;
            align-items: center;
            gap: 0.5rem;
            padding: 0.75rem;
            background: white;
            border: 2px solid #e2e8f0;
            border-radius: 8px;
            transition: all 0.2s;
        }

        .radio-item:hover {
            border-color: #4f46e5;
            background: #f8fafc;
        }

        .radio-item input[type="radio"] {
            margin: 0;
        }

        .radio-item label {
            margin: 0;
            cursor: pointer;
            font-weight: 500;
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

        .btn-success {
            background: linear-gradient(135deg, #10b981 0%, #059669 100%);
            color: white;
        }

        .btn-success:hover {
            transform: translateY(-2px);
            box-shadow: 0 8px 25px rgba(16, 185, 129, 0.3);
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
            background: linear-gradient(135deg, #6b7280 0%, #4b5563 100%);
            color: white;
            text-decoration: none;
            padding: 0.75rem 1.5rem;
            border-radius: 8px;
            transition: transform 0.2s, box-shadow 0.2s;
            font-weight: 500;
        }

        .nav-links a:hover {
            transform: translateY(-2px);
            box-shadow: 0 8px 25px rgba(107, 114, 128, 0.3);
        }

        .empty-state {
            text-align: center;
            padding: 2rem;
            background: #f8fafc;
            border-radius: 12px;
            border: 2px dashed #cbd5e1;
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

            .form-container {
                padding: 1rem;
            }

            .radio-group {
                gap: 0.5rem;
            }

            .radio-item {
                padding: 0.5rem;
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
        <h2>🛍️ Thanh toán</h2>
    </div>

    <div class="content">
        <!-- Form nhập thông tin khách hàng -->
        <div class="form-container">
            <form method="post" action="#">
                <div class="form-group">
                    <label for="fullname">👤 Họ tên:</label>
                    <input type="text" id="fullname" name="fullname" required/>
                </div>

                <div class="form-group">
                    <label for="address">📍 Địa chỉ:</label>
                    <textarea id="address" name="address" rows="3" required></textarea>
                </div>

                <div class="form-group">
                    <label>💳 Phương thức thanh toán:</label>
                    <div class="radio-group">
                        <div class="radio-item">
                            <input type="radio" id="paypal" name="paymentMethod" value="PayPal" required/>
                            <label for="paypal">💙 PayPal</label>
                        </div>
                        <div class="radio-item">
                            <input type="radio" id="atm" name="paymentMethod" value="ATM"/>
                            <label for="atm">🏧 ATM</label>
                        </div>
                        <div class="radio-item">
                            <input type="radio" id="mastercard" name="paymentMethod" value="MasterCard"/>
                            <label for="mastercard">💳 MasterCard</label>
                        </div>
                    </div>
                </div>

                <h3 style="color: #4f46e5; margin: 2rem 0 1rem 0;">🛒 Giỏ hàng của bạn</h3>
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
                                            <fmt:formatNumber value="${item.book.price}" type="currency"
                                                              currencySymbol="₫"/>
                                        </td>
                                        <td>${item.quantity}</td>
                                        <td>
                                            <strong style="color: #059669;">
                                                <fmt:formatNumber value="${item.subtotal}" type="currency"
                                                                  currencySymbol="₫"/>
                                            </strong>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>

                        <div class="total-price">
                            💰 Tổng cộng:
                            <fmt:formatNumber value="${sessionScope.cart.totalPrice}" type="currency"
                                              currencySymbol="₫"/>
                        </div>
                    </c:otherwise>
                </c:choose>

                <div style="text-align: center; margin-top: 2rem;">
                    <input type="submit" value="✅ Xác nhận thanh toán" class="btn btn-success"
                           style="font-size: 1.1rem; padding: 1rem 2rem;"/>
                </div>
            </form>
        </div>

        <div class="nav-links">
            <a href="books">← Quay lại danh sách sách</a>
        </div>
    </div>
</div>
</body>
</html>
