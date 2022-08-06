USE Furama_Resort_Manager;

-- 21. Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” 
-- và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.
CREATE VIEW v_nhan_vien AS 
SELECT nv.ma_nhan_vien, nv.ho_ten, nv.ngay_sinh, nv.so_cmnd, nv.luong, nv.so_dien_thoai, nv.email, nv.dia_chi
FROM nhan_vien nv
JOIN hop_dong hd ON nv.ma_nhan_vien = hd.ma_nhan_vien
JOIN khach_hang kh ON hd.ma_khach_hang = kh.ma_khach_hang
WHERE (nv.dia_chi LIKE "%Hải Châu%") AND (hd.ngay_lam_hop_dong = '2019-12-12')
GROUP BY hd.ma_hop_dong
HAVING COUNT(hd.ma_hop_dong) >= 1;
SELECT * FROM v_nhan_vien;

-- 22. Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” 
-- đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.
-- P1:
UPDATE nhan_vien
SET dia_chi = "Liên Chiểu"
WHERE ma_nhan_vien IN (
	SELECT ma_nhan_vien
    FROM v_nhan_vien
);
-- P2:
UPDATE v_nhan_vien SET dia_chi = "Liên Chiểu";

-- 23. Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào 
-- đó với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.

DELIMITER $$
CREATE PROCEDURE sp_xoa_khach_hang (ma_khach_hang INT)
BEGIN
	DELETE FROM khach_hang 
    WHERE ma_khach_hang = ma_khach_hang;
END $$
DELIMITER ;

-- 24. Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong 
-- với yêu cầu sp_them_moi_hop_dong phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, 
-- với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
DELIMITER $$
CREATE PROCEDURE sp_them_moi_hop_dong (
	p_ma_hop_dong INT,
    p_ngay_lam_hop_dong DATETIME,
    p_ngay_ket_thuc DATETIME, 
    p_tien_dat_coc DOUBLE, 
    p_ma_nhan_vien INT,
    p_ma_khach_hang INT,
    p_ma_dich_vu INT)
BEGIN
DECLARE lastid INT;
SELECT max(ma_hop_dong) INTO lastid 
FROM hop_dong;
if (p_ma_hop_dong <> lastid + 1) THEN
 SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'Invalid Id';
ELSEIF (p_ngay_lam_hop_dong is null) THEN
 SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'Invalid Start Date';
 ELSEIF (p_ma_nhan_vien not in (select ma_nhan_vien from nhan_vien)) then
 SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'Invalid Ma Nhan Vien';
  ELSEIF (p_ma_khach_hang not in (select ma_khach_hang from khach_hang)) then
 SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'Invalid Mha Khach Hang';
  ELSEIF (p_ma_dich_vu not in (select ma_dich_vu from dich_vu)) then
 SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'Invalid Ma Dich Vu';
else INSERT INTO hop_dong (
  ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, 
  ma_nhan_vien, ma_khach_hang, ma_dich_vu
) VALUE(
  p_ma_hop_dong, p_ngay_lam_hop_dong, p_ngay_ket_thuc, p_tien_dat_coc, 
  p_ma_nhan_vien, p_ma_khach_hang, p_ma_dich_vu
);
end if;
END $$
DELIMITER ;

-- 25.	Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong thì hiển thị tổng số lượng bản ghi 
-- còn lại có trong bảng hop_dong ra giao diện console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.

DELIMITER //
CREATE TRIGGER tr_xoa_hop_dong AFTER
DELETE ON hop_dong 
FOR EACH ROW
BEGIN
	SET @sl = (
		SELECT COUNT(*)
        FROM hop_dong
	);
	SIGNAL SQLSTATE '01000' SET MESSAGE_TEXT = @sl;
END //
DELIMITER ;

-- 26.	Tạo Trigger có tên tr_cap_nhat_hop_dong khi cập nhật ngày kết thúc hợp đồng, 
-- cần kiểm tra xem thời gian cập nhật có phù hợp hay không, với quy tắc sau: 
-- Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. 
-- Nếu dữ liệu hợp lệ thì cho phép cập nhật, nếu dữ liệu không hợp lệ thì in ra thông báo 
-- “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.
DELIMITER //
CREATE TRIGGER tr_cap_nhat_hop_dong AFTER
UPDATE ON hop_dong 
FOR EACH ROW
BEGIN
	IF NEW.ngay_lam_hop_dong + 2 > NEW.ngay_ket_thuc THEN 
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày';
    END IF;
END //
DELIMITER ;

-- 27. Tạo Function thực hiện yêu cầu sau:
-- a. Tạo Function func_dem_dich_vu: Đếm các dịch vụ đã được sử dụng với tổng tiền là > 2.000.000 VNĐ.
-- b. Tạo Function func_tinh_thoi_gian_hop_dong: 
-- Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến lúc kết thúc hợp đồng mà khách hàng 
-- đã thực hiện thuê dịch vụ (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, 
-- không xét trên toàn bộ các lần làm hợp đồng). Mã của khách hàng được truyền vào như là 1 tham số của function này.
-- Câu a:
DELIMITER //
CREATE FUNCTION func_dem_dich_vu()
RETURNS INT
DETERMINISTIC
BEGIN 
	DECLARE result INT;
    SELECT COUNT(*) INTO result
    FROM (
		SELECT SUM(dv.chi_phi_thue) AS tong_tien
        FROM dich_vu dv
        JOIN hop_dong hd ON dv.ma_dich_vu = hd.ma_dich_vu
        WHERE tong_tien > 2000000
        GROUP BY dv.ma_dich_vu
    ) AS temp;
	RETURN result;
END //
DELIMITER ;
-- Câu b:
DELIMITER //
CREATE FUNCTION func_tinh_thoi_gian_hop_dong(p_ma_khach_hang INT)
RETURNS INT
DETERMINISTIC
BEGIN 
	DECLARE result INT;
	SELECT MAX(temp.thoi_gian) INTO result
    FROM (
		SELECT DATEDIFF(hd.ngay_ket_thuc, hd.ngay_lam_hop_dong) AS thoi_gian 
        FROM hop_dong hd
        WHERE ma_khach_hang = p_ma_khach_hang
    ) AS temp;
	RETURN result;
END //
DELIMITER ;

-- 28. Tạo Stored Procedure sp_xoa_dich_vu_va_hd_room để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là 
-- “Room” từ đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó (tức là xóa các bảng ghi trong bảng dich_vu) 
-- và xóa những hop_dong sử dụng dịch vụ liên quan (tức là phải xóa những bản gi trong bảng hop_dong) 
-- và những bản liên quan khác.

DELIMITER $$
CREATE PROCEDURE sp_xoa_dich_vu_va_hd_room()
BEGIN
	SET @myvar := (
		SELECT GROUP_CONCAT(hd.ma_hop_dong SEPARATOR ',')  
        FROM dich_vu dv
		JOIN loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
		JOIN hop_dong hd ON dv.ma_dich_vu = hd.ma_dich_vu
		WHERE ldv.ten_loai_dich_vu = 'Room' AND  YEAR(hd.ngay_lam_hop_dong) BETWEEN 2015 and 2020
        );

	DELETE FROM hop_dong_chi_tiet  
    WHERE FIND_IN_SET(ma_hop_dong, @myvar);
	DELETE FROM hop_dong  
    WHERE FIND_IN_SET(ma_hop_dong, @myvar);
	DELETE from dich_vu
	WHERE ma_dich_vu in ( 
		SELECT DISTINCT ma_dich_vu
		FROM hop_dong
		WHERE FIND_IN_SET(ma_hop_dong, @myvar));
END $$
DELIMITER ;