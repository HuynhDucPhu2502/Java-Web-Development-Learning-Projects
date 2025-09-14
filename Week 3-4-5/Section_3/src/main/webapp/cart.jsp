<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Giỏ hàng</title>
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
            box-shadow: 0 20px 40px rgba(0,0,0,0.1);
            overflow: hidden;
        }

        .header {
            background: linear-gradient(135deg, #4facfe 0%, #00f2fe 100%);
            color: white;
            padding: 30px;
            text-align: center;
        }

        .header h2 {
            font-size: 2.5rem;
            font-weight: 300;
            margin: 0;
        }

        .content {
            padding: 30px;
        }

        .empty-cart {
            text-align: center;
            padding: 60px 20px;
            color: #666;
        }

        .empty-cart-icon {
            font-size: 4rem;
            margin-bottom: 20px;
            opacity: 0.5;
        }

        .empty-cart h3 {
            font-size: 1.5rem;
            margin-bottom: 10px;
            color: #333;
        }

        .empty-cart p {
            font-size: 1.1rem;
            margin-bottom: 30px;
        }

        .cart-table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 30px;
            background: white;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 5px 15px rgba(0,0,0,0.08);
        }

        .cart-table th {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 20px 15px;
            text-align: left;
            font-weight: 600;
            font-size: 0.95rem;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }

        .cart-table td {
            padding: 20px 15px;
            border-bottom: 1px solid #f0f0f0;
            vertical-align: middle;
        }

        .cart-table tr:last-child td {
            border-bottom: none;
        }

        .cart-table tr:hover {
            background-color: #f8f9ff;
        }

        .product-info {
            display: flex;
            flex-direction: column;
        }

        .product-name {
            font-weight: 600;
            color: #333;
            font-size: 1.1rem;
            margin-bottom: 5px;
        }

        .product-desc {
            color: #666;
            font-size: 0.9rem;
        }

        .price {
            font-weight: 600;
            color: #2c5aa0;
            font-size: 1.1rem;
        }

        .quantity-form {
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .quantity-input {
            width: 70px;
            padding: 8px 12px;
            border: 2px solid #e1e5e9;
            border-radius: 6px;
            text-align: center;
            font-size: 1rem;
            transition: border-color 0.3s ease;
        }

        .quantity-input:focus {
            outline: none;
            border-color: #4facfe;
        }

        .btn {
            padding: 8px 16px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 0.9rem;
            font-weight: 500;
            text-decoration: none;
            display: inline-block;
            text-align: center;
            transition: all 0.3s ease;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }

        .btn-update {
            background: linear-gradient(135deg, #11998e 0%, #38ef7d 100%);
            color: white;
        }

        .btn-update:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(17, 153, 142, 0.4);
        }

        .btn-remove {
            background: linear-gradient(135deg, #ff6b6b 0%, #ee5a52 100%);
            color: white;
        }

        .btn-remove:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(255, 107, 107, 0.4);
        }

        .btn-clear {
            background: linear-gradient(135deg, #ffa726 0%, #fb8c00 100%);
            color: white;
            padding: 12px 24px;
            font-size: 1rem;
        }

        .btn-clear:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(255, 167, 38, 0.4);
        }

        .btn-primary {
            background: linear-gradient(135deg, #4facfe 0%, #00f2fe 100%);
            color: white;
            padding: 12px 24px;
            font-size: 1rem;
        }

        .btn-primary:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(79, 172, 254, 0.4);
        }

        .btn-secondary {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 12px 24px;
            font-size: 1rem;
        }

        .btn-secondary:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(102, 126, 234, 0.4);
        }

        .cart-actions {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-top: 30px;
            padding-top: 20px;
            border-top: 2px solid #f0f0f0;
        }

        .navigation-buttons {
            display: flex;
            gap: 15px;
        }

        .subtotal {
            font-weight: 600;
            color: #2c5aa0;
            font-size: 1.1rem;
        }

        @media (max-width: 768px) {
            .cart-table {
                font-size: 0.9rem;
            }

            .cart-table th,
            .cart-table td {
                padding: 15px 10px;
            }

            .quantity-form {
                flex-direction: column;
                gap: 5px;
            }

            .cart-actions {
                flex-direction: column;
                gap: 20px;
            }

            .navigation-buttons {
                width: 100%;
                justify-content: center;
            }
        }

        @media (max-width: 480px) {
            .header h2 {
                font-size: 2rem;
            }

            .content {
                padding: 20px;
            }

            .cart-table {
                display: block;
                overflow-x: auto;
                white-space: nowrap;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h2>🛒 Giỏ hàng của bạn</h2>
    </div>

    <div class="content">
        <c:choose>
            <c:when test="${empty sessionScope.cart or empty sessionScope.cart.items}">
                <div class="empty-cart">
                    <div class="empty-cart-icon">🛒</div>
                    <h3>Giỏ hàng đang trống</h3>
                    <p>Hãy thêm một số sản phẩm vào giỏ hàng của bạn</p>
                    <a href="<c:url value='/products'/>" class="btn btn-primary">Tiếp tục mua hàng</a>
                </div>
            </c:when>

            <c:otherwise>
                <table class="cart-table">
                    <thead>
                    <tr>
                        <th>Sản phẩm</th>
                        <th>Giá</th>
                        <th>Số lượng</th>
                        <th>Tạm tính</th>
                        <th>Thao tác</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${sessionScope.cart.items}">
                        <tr>
                            <td>
                                <div class="product-info">
                                    <div class="product-name">${item.product.model}</div>
                                    <div class="product-desc">${item.product.description}</div>
                                </div>
                            </td>
                            <td>
                                <div class="price">
                                    <fmt:formatNumber value="${item.product.price}" type="currency" currencySymbol="₫"/>
                                </div>
                            </td>
                            <td>
                                <form method="post" action="<c:url value='/cart'/>" class="quantity-form">
                                    <input type="hidden" name="action" value="update">
                                    <input type="hidden" name="productId" value="${item.product.id}">
                                    <input type="number" name="quantity" value="${item.quantity}" min="1" class="quantity-input">
                                    <button type="submit" class="btn btn-update">Cập nhật</button>
                                </form>
                            </td>
                            <td>
                                <div class="subtotal">
                                    <fmt:formatNumber value="${item.subtotal}" type="currency" currencySymbol="₫"/>
                                </div>
                            </td>
                            <td>
                                <form method="post" action="<c:url value='/cart'/>">
                                    <input type="hidden" name="action" value="remove">
                                    <input type="hidden" name="productId" value="${item.product.id}">
                                    <button type="submit" class="btn btn-remove">Xóa</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <div class="cart-actions">
                    <form method="post" action="<c:url value='/cart'/>">
                        <input type="hidden" name="action" value="clear">
                        <button type="submit" class="btn btn-clear">Xóa toàn bộ giỏ hàng</button>
                    </form>

                    <div class="navigation-buttons">
                        <a href="<c:url value='/products'/>" class="btn btn-secondary">← Tiếp tục mua hàng</a>
                        <a href="#" class="btn btn-primary">Thanh toán →</a>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
