INSERT INTO danhmuc (TENDANHMUCH, NGUOIQUANLY, GHICHU)
VALUES ('Thể thao', 'Nguyễn Văn A', 'Danh mục tin tức thể thao'),
       ('Giáo dục', 'Trần Thị B', 'Tin tức về giáo dục'),
       ('Công nghệ', 'Lê Văn C', 'Danh mục tin tức công nghệ'),
       ('Giải trí', 'Phạm Thị D', 'Tin tức showbiz, phim ảnh');


INSERT INTO TINTUC (TIEUDE, NOIDUNGTT, LIENKET, MADM)
VALUES
-- Thể thao (MADM = 1)
('U23 Việt Nam vô địch', 'Đội tuyển U23 Việt Nam vô địch giải đấu quốc tế...', 'https://example.com/tintuc1', 1),
('Messi lập hat-trick', 'Lionel Messi tỏa sáng với cú hat-trick trong trận đấu...', 'https://example.com/tintuc2', 1),
('SEA Games 2025 sắp diễn ra', 'Kỳ SEA Games tiếp theo sẽ tổ chức tại...', 'https://example.com/tintuc3', 1),
('Đội tuyển nữ Việt Nam thắng đậm', 'Tuyển nữ Việt Nam giành chiến thắng 5-0...', 'https://example.com/tintuc4', 1),
('Chung kết Champions League', 'Real Madrid gặp Manchester City tại chung kết...', 'https://example.com/tintuc5', 1),

-- Giáo dục (MADM = 2)
('Bộ GD-ĐT công bố lịch thi tốt nghiệp', 'Kỳ thi tốt nghiệp THPT diễn ra vào tháng 7...', 'https://example.com/tintuc6',
 2),
('Trường ĐH Bách Khoa khai giảng', 'ĐH Bách Khoa tổ chức lễ khai giảng năm học mới...', 'https://example.com/tintuc7',
 2),
('Du học Nhật Bản tăng mạnh', 'Số lượng sinh viên Việt Nam du học Nhật tăng kỷ lục...', 'https://example.com/tintuc8',
 2),
('Chính sách học bổng toàn phần', 'Nhiều trường ĐH công bố học bổng toàn phần...', 'https://example.com/tintuc9', 2),
('AI trong giáo dục', 'Ứng dụng trí tuệ nhân tạo nâng cao chất lượng dạy và học...', 'https://example.com/tintuc10', 2),

-- Công nghệ (MADM = 3)
('Apple ra mắt iPhone mới', 'Apple giới thiệu iPhone mới với nhiều tính năng vượt trội...',
 'https://example.com/tintuc11', 3),
('Samsung công bố Galaxy S', 'Samsung ra mắt Galaxy S thế hệ mới...', 'https://example.com/tintuc12', 3),
('Startup Việt gọi vốn 10 triệu USD', 'Một startup công nghệ Việt vừa gọi vốn thành công...',
 'https://example.com/tintuc13', 3),
('Google ra mắt AI mới', 'Google công bố AI có khả năng xử lý ngôn ngữ vượt trội...', 'https://example.com/tintuc14',
 3),
('Hội nghị công nghệ 4.0', 'Hội nghị quốc tế về chuyển đổi số và công nghệ...', 'https://example.com/tintuc15', 3),

-- Giải trí (MADM = 4)
('Phim bom tấn sắp khởi chiếu', 'Một bộ phim hành động bom tấn sẽ ra mắt trong tháng này...',
 'https://example.com/tintuc16', 4),
('Ca sĩ nổi tiếng ra album mới', 'Album mới của ca sĩ A lập tức leo top BXH...', 'https://example.com/tintuc17', 4),
('Gameshow mới thu hút khán giả', 'Một gameshow giải trí mới đang làm mưa làm gió...', 'https://example.com/tintuc18',
 4),
('Festival âm nhạc quốc tế', 'Sự kiện âm nhạc quốc tế quy tụ hàng trăm nghệ sĩ...', 'https://example.com/tintuc19', 4),
('Diễn viên nổi tiếng kết hôn', 'Thông tin kết hôn của diễn viên B gây sốc...', 'https://example.com/tintuc20', 4);