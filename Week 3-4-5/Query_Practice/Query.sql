-- Thêm dữ liệu giả vào bảng departments
INSERT INTO departments (name, code) VALUES
('IT', 'IT'),
('HR', 'HR'),
('Finance', 'FIN'),
('Operations', 'OPS');

-- Thêm dữ liệu giả vào bảng employees
INSERT INTO employees (full_name, email, salary, title, department_id, hire_date, termination_date, dob) VALUES
('Alice Johnson', 'alice@example.com', 1200.00, 'Software Developer', 1, '2020-03-01', NULL, '1990-05-15'),
('Bob Smith', 'bob@example.com', 1500.00, 'Senior Developer', 1, '2019-07-11', NULL, '1985-08-22'),
('Charlie Brown', 'charlie@example.com', 1000.00, 'Junior Developer', 1, '2021-01-20', NULL, '1995-12-12'),
('Daisy Green', 'daisy@example.com', 1100.00, 'HR Executive', 2, '2021-05-10', '2023-12-31', '1992-04-23'),
('Evan White', 'evan@example.com', 1300.00, 'HR Manager', 2, '2018-09-15', NULL, '1988-02-10'),
('Fiona Black', 'fiona@example.com', 1250.00, 'HR Assistant', 2, '2020-02-17', NULL, '1994-11-05'),
('George Harris', 'george@example.com', 2000.00, 'Finance Director', 3, '2017-06-01', NULL, '1980-03-30'),
('Helen Moore', 'helen@example.com', 1700.00, 'Accountant', 3, '2019-02-15', NULL, '1991-07-05'),
('Irene Lee', 'irene@example.com', 1550.00, 'Operations Manager', 4, '2016-08-01', NULL, '1987-09-19'),
('Jack King', 'jack@example.com', 1400.00, 'Operations Supervisor', 4, '2020-03-12', NULL, '1992-11-02');