<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Chi tiết sách</title>
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

        .customer-info {
            background: #f8fafc;
            padding: 1.5rem;
            border-radius: 12px;
            border-left: 4px solid #4f46e5;
        }

        .customer-info p {
            margin-bottom: 0.75rem;
            font-size: 1.1rem;
        }

        .customer-info p:last-child {
            margin-bottom: 0;
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

        img {
            border-radius: 12px;
            box-shadow: 0 8px 25px rgba(0, 0, 0, 0.15);
            transition: transform 0.3s;
        }

        img:hover {
            transform: scale(1.05);
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

            .content > div:first-child {
                display: block !important;
                gap: 1rem !important;
            }

            .content > div:first-child > div:first-child {
                margin-bottom: 1rem;
            }

            .customer-info {
                padding: 1rem;
            }

            .customer-info p {
                font-size: 1rem;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h2>📖 Chi tiết sách</h2>
    </div>

    <div class="content">
        <c:choose>
            <c:when test="${not empty book}">
                <div style="display: grid; grid-template-columns: 1fr 2fr; gap: 2rem; align-items: start;">
                    <div style="text-align: center;">
                        <img src="${book.imgUrl}" alt="cover" width="200" style="max-width: 100%;"/>
                    </div>
                    <div>
                        <h2 style="color: #4f46e5; margin-bottom: 1rem;">${book.title}</h2>
                        <div class="customer-info">
                            <p><strong>📝 Tác giả:</strong> ${book.author}</p>
                            <p><strong>💰 Giá:</strong> <span
                                    style="color: #059669; font-size: 1.25rem; font-weight: bold;">${book.price} USD</span>
                            </p>
                        </div>
                    </div>
                </div>

                <div class="nav-links" style="margin-top: 2rem;">
                    <a href="books">← Quay lại danh sách</a>
                </div>
            </c:when>
            <c:otherwise>
                <div class="empty-state">
                    <h3>❌ Không tìm thấy sách</h3>
                    <div class="nav-links">
                        <a href="books">← Quay lại danh sách</a>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
