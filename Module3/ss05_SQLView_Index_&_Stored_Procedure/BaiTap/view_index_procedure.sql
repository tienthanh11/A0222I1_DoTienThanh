CREATE DATABASE demo;
USE demo;

CREATE TABLE products (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
    productCode VARCHAR(30),
    productName VARCHAR(50),
    productPrice DOUBLE,	
    productAmount INT,
    productDescription VARCHAR(50),
    productStatus VARCHAR(50)
); 

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
INSERT INTO products (productCode, productName, productPrice, productAmount, productDescription, productStatus)
VALUES ('N01', 'tivi', 150000.0, 5, 'chắc bền', 'true'),
       ('N09', 'tủ lạnh', 70000.0, 3, 'đẹp', 'fale'),
       ('N06', 'máy tính', 80000.0, 17, 'bền, dùng lâu', 'true'),
       ('N010', 'điều hòa', 300000.0, 20, 'chắc bền', 'true'),
       ('N011', 'lò vi sóng', 10000.0, 15, 'đẹp', 'false'),
       ('N013', 'máy giặt', 190000.0, 11, 'chắc bền', 'true');
SELECT * FROM products;

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
CREATE UNIQUE INDEX products_code ON products (productCode); 

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
CREATE INDEX products_index ON products (productName, productPrice);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
EXPLAIN SELECT * FROM products WHERE productName = 'tủ lạnh';

-- So sánh câu truy vấn trước và sau khi tạo index
DROP INDEX products_index ON products;

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
CREATE VIEW product_view AS
SELECT productCode, productName, productPrice, productStatus
FROM products;

SELECT * FROM product_view;

-- Tiến hành sửa đổi view
CREATE OR REPLACE VIEW product_vỉew AS 
SELECT productCode, productName, productPrice, productStatus
FROM products;

-- Tiến hành xoá view
-- DROP VIEW product_view;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
DELIMITER //
CREATE PROCEDURE final_all_products()
BEGIN 
	SELECT * FROM products;
END //
DELIMITER ;

CALL final_all_products();	

-- Tạo store procedure thêm một sản phẩm mới
DELIMITER //
CREATE PROCEDURE product_addnew(
	id INT, 
    productCode VARCHAR(30),
    productName VARCHAR(50),
    productPrice DOUBLE,	
    productAmount INT,
    productDescription VARCHAR(50),
    productStatus VARCHAR(50))
BEGIN
	INSERT INTO products
	VALUE (id, productCode, productName, productPrice, productAmount, productDescription, productStatus);
END //
DELIMITER ;

CALL product_addNew(7, 'A10', 'laptop', 14000.0, 5, 'chắc bền', 'true'); 

SELECT * FROM products;

-- tạo store procedure sửa thông tin sản phẩm theo id
DELIMITER //
CREATE PROCEDURE product_edit_id(
	id INT, 
    productCode VARCHAR(30),
    productName VARCHAR(50),
    productPrice DOUBLE,	
    productAmount INT,
    productDescription VARCHAR(50),
    productStatus VARCHAR(50))
BEGIN 
	UPDATE products
    SET productCode = productCode, 
		productName = productName,
        productPrice = productPrice,
        productAmount = productAmount,
        productDescription = productDescription,
        productStatus = productStatus
	WHERE products.id = id;
END //
DELIMITER ;

CALL product_edit_id(6, 'A15', 'Điện thoại', 190000.0, 11, 'chắc bền', 'true');

SELECT * FROM products;

-- tạo store procedure xoá sản phẩn theo id
DELIMITER //
CREATE PROCEDURE product_delete_id (pid int)
BEGIN
	DELETE
    FROM products
    WHERE products.id = pid;
END //	
DELIMITER ;

CALL product_delete_id(6);

SELECT * FROM products;