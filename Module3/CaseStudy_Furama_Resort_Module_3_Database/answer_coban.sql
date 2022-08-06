USE Furama_Resort_Manager;

-- 2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu 
-- là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
SELECT * 
FROM nhan_vien
WHERE ho_ten LIKE 'H%' OR ho_ten LIKE 'T%' OR ho_ten LIKE 'K%' AND LENGTH(ho_ten) < 15;

-- 3. Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi 
-- và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
SELECT *
FROM khach_hang
WHERE YEAR(CURDATE()) - YEAR(ngay_sinh) BETWEEN 18 AND 50 
AND (dia_chi LIKE '%Đà Nẵng' OR dia_chi LIKE '%Quảng Trị');

-- 4. Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
SELECT kh.ma_khach_hang, kh.ho_ten, COUNT(*) AS so_lan_dat_phong
FROM loai_khach lk
INNER JOIN khach_hang kh ON lk.ma_loai_khach = kh.ma_loai_khach
INNER JOIN hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
WHERE lk.ten_loai_khach = 'Diamond'
GROUP BY kh.ma_khach_hang
ORDER BY so_lan_dat_phong;

-- 5. Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
-- (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) 
-- cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

-- Cách 1:
SET GLOBAL sql_mode =(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));

SELECT kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong, dv.ten_dich_vu,
       hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, (IFNULL(sum(dvdk.gia * hdct.so_luong) + tmp.gia_dv, 0)) tong_tien
FROM
    khach_hang kh
    left JOIN loai_khach lk USING (ma_loai_khach)
    left join hop_dong hd USING (ma_khach_hang)
    left join dich_vu dv USING (ma_dich_vu)
    left JOIN hop_dong_chi_tiet hdct USING (ma_hop_dong)
    left join dich_vu_di_kem dvdk USING (ma_dich_vu_di_kem)
    left JOIN (
        SELECT kh.ma_khach_hang as ma_khach_hang, IFNULL(sum(dv.chi_phi_thue), 0) as gia_dv
        from khach_hang kh
		join hop_dong hd USING (ma_khach_hang)
		join dich_vu dv USING (ma_dich_vu)
        GROUP by kh.ma_khach_hang
    ) tmp USING (ma_khach_hang)
GROUP by kh.ma_khach_hang;

-- Cách 2:
select ho_ten, ifnull(sum(so_luong * gia) + tmp.tong_chi_phi_thue, 0) tong_tien   
from khach_hang kh
left join hop_dong hd using (ma_khach_hang)
left join hop_dong_chi_tiet using (ma_hop_dong)
left join dich_vu_di_kem using (ma_dich_vu_di_kem)
left join
(
	select ma_khach_hang, sum(chi_phi_thue) tong_chi_phi_thue 
    from khach_hang kh1 
    join hop_dong using (ma_khach_hang) 
    join dich_vu using (ma_dich_vu) 
    group by hop_dong.ma_khach_hang
) tmp using (ma_khach_hang)
group by hd.ma_khach_hang;

-- 6. Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu 
-- của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 
-- (Quý 1 là tháng 1, 2, 3).
SELECT dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu
FROM dich_vu dv
INNER JOIN loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
INNER JOIN hop_dong hd ON dv.ma_dich_vu = hd.ma_dich_vu
WHERE NOT EXISTS (
	SELECT *
    FROM hop_dong hd
    WHERE hd.ngay_lam_hop_dong BETWEEN '2021-01-01' AND '2021-03-31' AND dv.ma_dich_vu = hd.ma_dich_vu
)
GROUP BY dv.ma_dich_vu
ORDER BY dv.dien_tich desc;

-- 7. Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu 
-- của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 
-- nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
SELECT dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu
FROM dich_vu dv
INNER JOIN loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
WHERE EXISTS (
	SELECT *
    FROM hop_dong hd
    WHERE YEAR(hd.ngay_lam_hop_dong) = '2020' AND ma_dich_vu = dv.ma_dich_vu)
AND NOT EXISTS (
	SELECT *
    FROM hop_dong hd
    WHERE YEAR(hd.ngay_lam_hop_dong) = '2021' AND ma_dich_vu = dv.ma_dich_vu);
    
-- 8. Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.
-- Cách 1:
SELECT DISTINCT  kh.ho_ten
FROM khach_hang kh;

-- Cách 2:
SELECT kh.ho_ten
FROM khach_hang kh
UNION
SELECT kh.ho_ten
FROM khach_hang kh;

-- Cách 3:
SELECT ho_ten
FROM khach_hang
GROUP BY ho_ten;

-- 9. Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 
-- thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
SELECT MONTH(hd.ngay_lam_hop_dong) AS `MONTH`, COUNT(hd.ma_khach_hang) AS so_luong_khach_hang
FROM khach_hang kh
INNER JOIN hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
WHERE YEAR(hd.ngay_lam_hop_dong) = 2021
GROUP BY `MONTH`
ORDER BY `MONTH`;

-- 10. Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem 
-- (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
SELECT hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc, 
		SUM(IFNULL(hdct.so_luong, 0)) AS so_luong_dich_vu_di_kem
FROM hop_dong hd
LEFT JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
LEFT JOIN dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
GROUP BY hd.ma_hop_dong;

-- 11. Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” 
-- và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
SELECT dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem
FROM dich_vu_di_kem dvdk
INNER JOIN hop_dong_chi_tiet hdct ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
INNER JOIN hop_dong hd ON hdct.ma_hop_dong = hd.ma_hop_dong
INNER JOIN khach_hang kh ON hd.ma_khach_hang = kh.ma_khach_hang
INNER JOIN loai_khach lk ON kh.ma_loai_khach = lk.ma_loai_khach
WHERE lk.ten_loai_khach = 'Diamond' AND (kh.dia_chi LIKE '%Vinh' OR kh.dia_chi LIKE '%Quảng Ngãi');

-- 12. Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), 
-- ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), 
-- tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
SELECT hd.ma_hop_dong, nv.ho_ten AS ho_ten_nhan_vien, kh.ho_ten AS ho_ten_khach_hang, kh.so_dien_thoai AS sdt_khach_hang,
		dv.ma_dich_vu, dv.ten_dich_vu, SUM(IFNULL(hdct.so_luong, 0)) AS so_luong_dich_vu_di_kem, hd.tien_dat_coc
FROM hop_dong hd
LEFT JOIN nhan_vien nv ON hd.ma_nhan_vien = nv.ma_nhan_vien
LEFT JOIN khach_hang kh ON hd.ma_khach_hang = kh.ma_khach_hang
LEFT JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
LEFT JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
LEFT JOIN dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
WHERE (
	ngay_lam_hop_dong BETWEEN '2020-10-01' AND '2020-12-30'
)
AND (
	ngay_lam_hop_dong NOT BETWEEN '2021-01-01'AND '2021-06-30'
)
GROUP BY ma_hop_dong;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
SELECT dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, SUM(hdct.so_luong) AS so_luong_dich_vu_di_kem
FROM dich_vu_di_kem dvdk
INNER JOIN hop_dong_chi_tiet hdct ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
GROUP BY hdct.ma_dich_vu_di_kem
HAVING so_luong_dich_vu_di_kem >= ALL (
	SELECT so_luong
    FROM hop_dong_chi_tiet
);    

-- 14. Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung 
-- (được tính dựa trên việc count các ma_dich_vu_di_kem).
SELECT hd.ma_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, COUNT(dvdk.ma_dich_vu_di_kem) AS so_lan_su_dung
FROM hop_dong hd
INNER JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
INNER JOIN loai_dich_vu ldv ON dv.ma_dich_vu = ldv.ma_loai_dich_vu
INNER JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
INNER JOIN dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
GROUP BY dvdk.ma_dich_vu_di_kem
HAVING so_lan_su_dung = 1;

-- 15. Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, 
-- so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
SELECT nv.ma_nhan_vien, nv.ho_ten, td.ten_trinh_do, bp.ten_bo_phan, nv.so_dien_thoai, nv.dia_chi
FROM nhan_vien nv
INNER JOIN trinh_do td ON nv.ma_trinh_do = td.ma_trinh_do
INNER JOIN bo_phan bp ON nv.ma_bo_phan = bp.ma_bo_phan
INNER JOIN hop_dong hd ON nv.ma_nhan_vien = hd.ma_nhan_vien
WHERE YEAR(ngay_lam_hop_dong) BETWEEN 2020 AND 2021
GROUP BY hd.ma_nhan_vien
HAVING COUNT(hd.ma_nhan_vien) <= 3
ORDER BY hd.ma_nhan_vien;

-- 16. Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
DELETE FROM nhan_vien nv
WHERE NOT EXISTS (
	SELECT *
    FROM hop_dong hd
	WHERE hd.ma_nhan_vien = nv.ma_nhan_vien AND
	YEAR(hd.ngay_lam_hop_dong) BETWEEN 2019 AND 2021
 );
SELECT * FROM nhan_vien;

-- 17. Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
UPDATE khach_hang
SET ma_loai_khach = 1
WHERE ma_loai_khach != 1 AND ma_khach_hang IN (
	SELECT temp.ma_khach_hang 
    FROM (
		SELECT kh.ma_khach_hang
        FROM khach_hang kh
        JOIN hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
        JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
        JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
        JOIN dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
        GROUP BY kh.ma_khach_hang
        HAVING (SUM(IFNULL(dv.chi_phi_thue, 0) + IFNULL(dvdk.gia, 0) * IFNULL(hdct.so_luong, 0)) > 10000000)
	) AS temp 
);

SELECT kh.ma_khach_hang, kh.ho_ten, kh.ma_loai_khach = 1 AS ma_loai_khach
FROM khach_hang kh;

-- 18. Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
-- After set CASCADE
DELETE FROM
    khach_hang kh
WHERE NOT EXISTS (
	SELECT 1
	FROM hop_dong
    WHERE kh.ma_khach_hang = ma_khach_hang AND YEAR(ngay_lam_hop_dong) >= 2021
);

SELECT kh.ma_khach_hang, kh.ho_ten
FROM khach_hang kh; 

-- 19. Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi
UPDATE dich_vu_di_kem
SET gia = gia * 2
WHERE ma_dich_vu_di_kem IN	(
	SELECT tmp.ma_dich_vu_di_kem 
	FROM (
		SELECT dvk.ma_dich_vu_di_kem 
		FROM dich_vu_di_kem dvk
		JOIN hop_dong_chi_tiet hct ON hct.ma_dich_vu_di_kem = dvk.ma_dich_vu_di_kem
        JOIN hop_dong hd ON hd.ma_hop_dong = hct.ma_hop_dong
		WHERE YEAR(hd.ngay_lam_hop_dong) = 2020
		GROUP BY hct.ma_dich_vu_di_kem
		HAVING COUNT(hct.ma_dich_vu_di_kem) >= 1
	) AS tmp
);

SELECT * FROM dich_vu_di_kem;

-- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị bao gồm 
-- id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
SELECT nv.ma_nhan_vien, nv.ho_ten, nv.email, nv.so_dien_thoai, nv.ngay_sinh, nv.dia_chi
FROM nhan_vien nv
UNION ALL
SELECT kh.ma_khach_hang, kh.ho_ten, kh.email, kh.so_dien_thoai, kh.ngay_sinh, kh.dia_chi
FROM khach_hang kh;