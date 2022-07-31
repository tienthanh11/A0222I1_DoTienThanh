-- Tạo view

CREATE VIEW customer_views AS
SELECT customerNumber, customerName, phone
FROM customers;

SELECT * FROM customer_views;

-- Cập nhật view

CREATE OR REPLACE VIEW view_name AS
SELECT customerNumber, customerName, contactFirstName, contactLastName, phone
FROM customers
WHERE city = 'Nantes';

SELECT * FROM view_name;

-- Xoá view

-- DROP VIEW customer_views;

-- DROP VIEW view_name;
