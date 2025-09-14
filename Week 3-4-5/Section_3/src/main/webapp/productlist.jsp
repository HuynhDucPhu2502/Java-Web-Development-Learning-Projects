<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Products - Shop</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            background-color: #f8f9fa;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            line-height: 1.6;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 1rem;
        }

        .header-section {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 2rem 0;
            margin-bottom: 2rem;
            border-radius: 0 0 1rem 1rem;
        }

        .header-content {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .header-title {
            font-size: 2.5rem;
            font-weight: 700;
            margin: 0;
            text-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }

        .cart-btn {
            background: rgba(255,255,255,0.2);
            border: 2px solid rgba(255,255,255,0.3);
            color: white;
            padding: 0.75rem 1.5rem;
            border-radius: 50px;
            font-weight: 600;
            transition: all 0.3s ease;
            text-decoration: none;
            display: inline-flex;
            align-items: center;
            gap: 0.5rem;
        }

        .cart-btn:hover {
            background: rgba(255,255,255,0.3);
            border-color: rgba(255,255,255,0.5);
            color: white;
            transform: translateY(-2px);
            box-shadow: 0 4px 12px rgba(0,0,0,0.15);
        }

        /* Replaced Bootstrap grid with CSS Grid */
        .products-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
            gap: 1.5rem;
            padding: 0 1rem;
        }

        .product-card {
            background: white;
            border: none;
            border-radius: 1rem;
            box-shadow: 0 4px 6px rgba(0,0,0,0.07);
            transition: all 0.3s ease;
            overflow: hidden;
            display: flex;
            flex-direction: column;
        }

        .product-card:hover {
            transform: translateY(-8px);
            box-shadow: 0 12px 24px rgba(0,0,0,0.15);
        }

        .product-image {
            height: 200px;
            width: 100%;
            object-fit: contain;
            padding: 1rem;
            background: #f8f9fa;
            transition: transform 0.3s ease;
        }

        .product-card:hover .product-image {
            transform: scale(1.05);
        }

        .image-placeholder {
            height: 200px;
            display: flex;
            align-items: center;
            justify-content: center;
            background: #f8f9fa;
            font-size: 3rem;
            color: #6c757d;
        }

        .card-body {
            padding: 1.5rem;
            flex: 1;
            display: flex;
            flex-direction: column;
        }

        .product-title {
            font-size: 1.1rem;
            font-weight: 600;
            color: #2d3748;
            margin-bottom: 0.75rem;
            line-height: 1.4;
        }

        .product-price {
            font-size: 1.25rem;
            font-weight: 700;
            color: #e53e3e;
            margin-bottom: 1rem;
        }

        .form-group {
            margin-bottom: 1rem;
        }

        .quantity-controls {
            display: flex;
            justify-content: center;
            margin-bottom: 1rem;
        }

        .quantity-input {
            max-width: 70px;
            border-radius: 0.5rem;
            border: 2px solid #e2e8f0;
            text-align: center;
            font-weight: 600;
            padding: 0.5rem;
            font-size: 1rem;
        }

        .quantity-input:focus {
            outline: none;
            border-color: #667eea;
            box-shadow: 0 0 0 3px rgba(102, 126, 234, 0.1);
        }

        .add-to-cart-btn {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            border: none;
            border-radius: 0.75rem;
            padding: 0.75rem 1.5rem;
            font-weight: 600;
            color: white;
            transition: all 0.3s ease;
            width: 100%;
            margin-bottom: 0.75rem;
            cursor: pointer;
            font-size: 1rem;
        }

        .add-to-cart-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 6px 16px rgba(102, 126, 234, 0.4);
        }

        .detail-link {
            color: #667eea;
            text-decoration: none;
            font-weight: 500;
            font-size: 0.9rem;
            transition: color 0.3s ease;
            text-align: center;
            margin-top: auto;
        }

        .detail-link:hover {
            color: #764ba2;
            text-decoration: underline;
        }

        .empty-state {
            text-align: center;
            padding: 4rem 2rem;
            color: #718096;
            grid-column: 1 / -1;
        }

        .empty-state h3 {
            font-size: 1.5rem;
            margin-bottom: 1rem;
            color: #4a5568;
        }

        /* Added responsive breakpoints for CSS Grid */
        @media (min-width: 768px) {
            .products-grid {
                grid-template-columns: repeat(2, 1fr);
            }
        }

        @media (min-width: 992px) {
            .products-grid {
                grid-template-columns: repeat(3, 1fr);
            }
        }

        @media (max-width: 768px) {
            .header-title {
                font-size: 2rem;
            }

            .header-content {
                flex-direction: column;
                gap: 1rem;
                text-align: center;
            }

            .products-grid {
                padding: 0 0.5rem;
                grid-template-columns: 1fr;
            }
        }
    </style>
</head>
<body>

<div class="header-section">
    <div class="container">
        <!-- Updated class names for pure CSS -->
        <div class="header-content">
            <h1 class="header-title">🛍️ Cửa hàng sản phẩm</h1>
            <a href="<c:url value='/cart'/>" class="cart-btn">
                🛒 Giỏ hàng
            </a>
        </div>
    </div>
</div>

<div class="container">
    <c:choose>
        <c:when test="${empty products}">
            <!-- Updated grid structure for CSS Grid -->
            <div class="products-grid">
                <div class="empty-state">
                    <h3>Không có sản phẩm nào</h3>
                    <p>Hiện tại chưa có sản phẩm nào trong cửa hàng. Vui lòng quay lại sau!</p>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <!-- Replaced Bootstrap row/col with CSS Grid -->
            <div class="products-grid">
                <c:forEach var="p" items="${products}">
                    <div class="product-card">
                        <c:choose>
                            <c:when test="${not empty p.imgUrl}">
                                <img src="${p.imgUrl}" class="product-image" alt="${p.model}">
                            </c:when>
                            <c:otherwise>
                                <div class="image-placeholder">
                                    📦
                                </div>
                            </c:otherwise>
                        </c:choose>

                        <div class="card-body">
                            <h5 class="product-title">${p.model}</h5>
                            <div class="product-price">
                                <fmt:formatNumber value="${p.price}" type="currency" currencySymbol="₫"/>
                            </div>

                            <form method="post" action="<c:url value='/cart'/>">
                                <input type="hidden" name="action" value="add">
                                <input type="hidden" name="productId" value="${p.id}">

                                <!-- Updated form structure for pure CSS -->
                                <div class="quantity-controls">
                                    <input type="number" name="qty" value="1" min="1" max="${p.quantity}"
                                           class="quantity-input"
                                           title="Số lượng (tối đa: ${p.quantity})">
                                </div>

                                <button type="submit" class="add-to-cart-btn">
                                    Thêm vào giỏ hàng
                                </button>
                            </form>

                            <a href="product?id=${p.id}" class="detail-link">
                                Xem chi tiết →
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
