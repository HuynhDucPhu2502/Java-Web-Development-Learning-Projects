-- CATEGORIES
INSERT INTO categories (id, name) VALUES
(1, 'Điện thoại'),
(2, 'Laptop'),
(3, 'Phụ kiện'),
(4, 'Nhà bếp'),
(5, 'Thời trang');

-- CUSTOMERS
INSERT INTO customers (id, name, customer_since, is_active, phone_number) VALUES
(1, 'Nguyễn Văn A', '2023-01-10', 1, '0912345678'),
(2, 'Trần Thị B', '2023-03-05', 1, '0988123456'),
(3, 'Lê Văn C', '2024-02-20', 1, '0933666777'),
(4, 'Phạm Thị D', '2024-06-01', 0, '0909123123'),
(5, 'Hoàng Văn E', '2025-01-15', 1, '0977665544');

-- PRODUCTS
INSERT INTO products (id, name, price, in_stock, category_id, is_active) VALUES
(1, 'iPhone 15',          25000000, 1, 1, 1),
(2, 'Galaxy S24',         21000000, 1, 1, 1),
(3, 'MacBook Air M3',     32000000, 1, 2, 1),
(4, 'Dell XPS 13',        29000000, 1, 2, 1),
(5, 'Tai nghe Bluetooth',   500000, 1, 3, 1),
(6, 'Sạc nhanh 65W',        700000, 1, 3, 1),
(7, 'Nồi chiên không dầu', 2500000, 1, 4, 1),
(8, 'Máy xay sinh tố',     1500000, 1, 4, 1),
(9, 'Áo thun nam',          200000, 1, 5, 1),
(10,'Quần jean nữ',         350000, 1, 5, 1);

-- ORDERS
INSERT INTO orders (id, date, customer_id) VALUES
(1, '2025-11-01', 1),
(2, '2025-11-02', 2),
(3, '2025-11-03', 1),
(4, '2025-11-04', 3),
(5, '2025-11-05', 5);

-- ORDERLINES
INSERT INTO orderlines (id, product_id, order_id, amount, purchase_price) VALUES
(1, 1, 1, 1, 25000000),
(2, 5, 1, 2,   450000),  -- giảm giá nhẹ
(3, 3, 2, 1, 32000000),
(4, 6, 2, 1,   700000),
(5, 7, 3, 1, 2500000),
(6, 5, 3, 1,   500000),
(7, 9, 4, 3,   190000),  -- giá KM
(8, 10,4, 1,   340000),
(9, 2, 5, 1, 21000000),
(10,6, 5, 2,   680000);

-- COMMENTS
INSERT INTO comments (id, text, product_id) VALUES
(1, 'Sản phẩm dùng rất tốt, pin trâu.',          1),
(2, 'Màn hình đẹp nhưng hơi nóng khi chơi game.',2),
(3, 'Nhẹ, pin trâu, gõ phê.',                    3),
(4, 'Thiết kế đẹp, build chắc.',                 4),
(5, 'Âm thanh ổn trong tầm giá.',                5),
(6, 'Sạc nhanh như quảng cáo.',                  6),
(7, 'Chiên không dầu ăn đỡ ngán.',               7),
(8, 'Áo mặc thoáng, form đẹp.',                  9),
(9, 'Quần jean co giãn thoải mái.',             10),
(10,'Đóng gói cẩn thận, giao nhanh.',            1);