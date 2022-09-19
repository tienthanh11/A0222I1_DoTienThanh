CREATE DATABASE casestudty_furama;
USE casestudty_furama;

CREATE TABLE vi_tri (
	ma_vi_tri INT PRIMARY KEY AUTO_INCREMENT,
	ten_vi_tri VARCHAR(45)
);

CREATE TABLE trinh_do (
	ma_trinh_do INT PRIMARY KEY AUTO_INCREMENT,
	ten_trinh_do VARCHAR(45)
);

CREATE TABLE bo_phan (
	ma_bo_phan INT PRIMARY KEY AUTO_INCREMENT,
	ten_bo_phan VARCHAR(45)
);

CREATE TABLE nhan_vien (
	ma_nhan_vien INT PRIMARY KEY AUTO_INCREMENT,
	ho_ten VARCHAR(45),
	ngay_sinh DATE,
	so_cmnd VARCHAR(45),
	luong DOUBLE,
	so_dien_thoai VARCHAR(45),
	email VARCHAR(45),
	dia_chi VARCHAR(45),
	ma_vi_tri INT,
	ma_trinh_do INT,
	ma_bo_phan INT,
	FOREIGN KEY (ma_vi_tri) REFERENCES vi_tri(ma_vi_tri),
	FOREIGN KEY (ma_trinh_do) REFERENCES trinh_do(ma_trinh_do),
	FOREIGN KEY (ma_bo_phan) REFERENCES bo_phan(ma_bo_phan)
);

CREATE TABLE loai_khach (
	ma_loai_khach INT PRIMARY KEY AUTO_INCREMENT,
	ten_loai_khach VARCHAR(45)
);

CREATE TABLE khach_hang (
	ma_khach_hang INT PRIMARY KEY AUTO_INCREMENT,
	ma_loai_khach INT,
	ho_ten VARCHAR(45),
	ngay_sinh DATE,
	gioi_tinh BIT(1),
	so_cmnd VARCHAR(45),
	so_dien_thoai VARCHAR(45),
	email VARCHAR(45),
	dia_chi VARCHAR(45),
	FOREIGN KEY (ma_loai_khach) REFERENCES loai_khach(ma_loai_khach)
);

CREATE TABLE kieu_thue (
	ma_kieu_thue INT PRIMARY KEY AUTO_INCREMENT,
	ten_kieu_thue VARCHAR(45),
    gia_thue DOUBLE
);
CREATE TABLE loai_dich_vu (
	ma_loai_dich_vu INT PRIMARY KEY AUTO_INCREMENT,
	ten_loai_dich_vu VARCHAR(45)
);

CREATE TABLE dich_vu (
	ma_dich_vu INT PRIMARY KEY AUTO_INCREMENT,
	ten_dich_vu VARCHAR(45),
	dien_tich INT,
	chi_phi_thue DOUBLE,
	so_nguoi_toi_da INT,
	ma_kieu_thue INT,
	ma_loai_dich_vu INT,
	tieu_chuan_phong VARCHAR(45),
	mo_ta_tien_nghi_khac VARCHAR(45),
	dien_tich_ho_boi DOUBLE,
	so_tang INT,
	FOREIGN KEY (ma_kieu_thue) REFERENCES kieu_thue(ma_kieu_thue),
	FOREIGN KEY (ma_loai_dich_vu) REFERENCES loai_dich_vu(ma_loai_dich_vu)
);

CREATE TABLE dich_vu_di_kem (
	ma_dich_vu_di_kem INT PRIMARY KEY AUTO_INCREMENT,
	ten_dich_vu_di_kem VARCHAR(45),
	gia DOUBLE,
	don_vi VARCHAR(10),
	trang_thai VARCHAR(45)
);

CREATE TABLE hop_dong (
	ma_hop_dong INT PRIMARY KEY AUTO_INCREMENT,
	ngay_lam_hop_dong DATETIME,
	ngay_ket_thuc DATETIME,
	tien_dat_coc DOUBLE,
	ma_nhan_vien INT,
	ma_khach_hang INT,
	ma_dich_vu INT,
	FOREIGN KEY (ma_nhan_vien) REFERENCES nhan_vien(ma_nhan_vien),
	FOREIGN KEY (ma_khach_hang) REFERENCES khach_hang(ma_khach_hang),
	FOREIGN KEY (ma_dich_vu) REFERENCES dich_vu(ma_dich_vu)
);

CREATE TABLE hop_dong_chi_tiet (
	ma_hop_dong_chi_tiet INT PRIMARY KEY AUTO_INCREMENT,
	ma_hop_dong INT,
	ma_dich_vu_di_kem INT,
	so_luong INT,
	FOREIGN KEY (ma_hop_dong) REFERENCES hop_dong(ma_hop_dong),
	FOREIGN KEY (ma_dich_vu_di_kem) REFERENCES dich_vu_di_kem(ma_dich_vu_di_kem)
);

INSERT INTO vi_tri (ten_vi_tri)
VALUE ('Lễ tân'), ('Phục vụ'), ('Chuyên viên'), ('Giám sát'), ('Quản lý'), ('Giám đốc');
SELECT * FROM vi_tri;

INSERT INTO trinh_do (ten_trinh_do)
VALUES ('Trung cấp'), ('Cao đẳng'), ('Đại học'), ('Sau đại học');
SELECT * FROM trinh_do;

INSERT INTO bo_phan (ten_bo_phan)
VALUES ('Sale - Marketing'), ('Hành chính'), ('Phục vụ'), ('Quản lý');
SELECT * FROM bo_phan;

INSERT INTO nhan_vien (ho_ten , ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, 
						ma_trinh_do, ma_bo_phan)
VALUES ('Nguyễn Văn An', '1970-11-07',	'456231786', 10000000, '0901234121', 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng',	1, 3, 1),
       ('Lê Văn Bình', '1997-04-09', '654231234', 7000000, '0934212314', 'binhlv@gmail.com', '22 Yên Bái, Đà Nẵng', 1, 2, 2),
       ('Hồ Thị Yến', '1995-12-12', '999231723', 14000000, '0412352315', 'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', 1, 3, 2),
       ('Võ Công Toản', '1980-04-04', '123231365', 17000000, '0374443232', 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', 1, 4, 4),
       ('Nguyễn Bỉnh Phát', '1999-12-09', '454363232', 6000000, '0902341231', 'phatphat@gmail.com', '43 Yên Bái, Đà Nẵng', 2, 1, 1),
       ('Khúc Nguyễn An Nghi', '2000-11-08', '964542311', 7000000, '0978653213', 'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', 2, 2, 3),
       ('Nguyễn Hữu Hà', '1993-01-01', '534323231', 8000000, '0941234553', 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 3, 2),
       ('Nguyễn Hà Đông', '1989-09-03', '234414123', 9000000, '0642123111', 'donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội', 2, 4, 4),
       ('Tòng Hoang', '1982-09-03', '256781231', 6000000, '0245144444', 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', 2, 4, 4),
       ('Nguyễn Công Đạo', '1994-01-08', '755434343', 8000000, '0988767111', 'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai', 2, 3, 2);
SELECT * FROM nhan_vien;

INSERT INTO loai_khach (ten_loai_khach) 
VALUES ('Diamond'), ('Platinium'), ('Gold'), ('Silver'), ('Member');
SELECT * FROM loai_khach;	

INSERT INTO khach_hang (ma_loai_khach, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, so_dien_thoai, email, dia_chi)	
VALUES (5, 'Nguyễn Thị Hào', '1970-11-07', 0, '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng'),
	   (3, 'Phạm Xuân Diệu', '1992-08-08', 1, '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị'),
       (1, 'Trương Đình Nghệ', '1990-02-27', 1, '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh'),
       (1, 'Dương Văn Quan', '1981-07-08', 1, '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng'),
       (4, 'Hoàng Trần Nhi Nhi', '1995-12-09', 0, '795453345', '0312345678', 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai'),
       (4, 'Tôn Nữ Mộc Châu', '2005-12-06', 0, '732434215', '0988888844', 'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng'),
       (1, 'Nguyễn Mỹ Kim', '1984-04-08', 0, '856453123', '0912345698', 'kimcuong84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh'),
       (3, 'Nguyễn Thị Hào', '1999-04-08', 0, '965656433', '0763212345', 'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum'),
       (1, 'Trần Đại Danh', '1994-07-01', 1, '432341235', '0643343433', 'danhhai99@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi'),
       (2, 'Nguyễn Tâm Đắc', '1989-07-01', 1, '344343432', '0987654321', 'dactam@gmail.com', '22 Ngô Quyền, Đà Nẵng');
SELECT * FROM khach_hang;

INSERT INTO kieu_thue (ten_kieu_thue, gia_thue)
VALUES ('theo năm', 25000),('theo tháng', 3000),('theo ngày', 1500),('theo giờ', 500);
SELECT * FROM kieu_thue;

INSERT INTO loai_dich_vu (ten_loai_dich_vu)
VALUES ('Villa'), ('House'), ('Room');
SELECT * FROM loai_dich_vu;

INSERT INTO dich_vu (ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, ma_kieu_thue, 
					 ma_loai_dich_vu, tieu_chuan_phong, mo_ta_tien_nghi_khac, dien_tich_ho_boi, so_tang)
VALUES ('Villa Beach Front', 25000, 10000000, 10, 3, 1, 'vip', 'Có hồ bơi', 500, 4),
       ('House Princess 01', 14000, 5000000, 7, 2, 2, 'vip', 'Có thêm bếp nướng', null, 3),
       ('Room Twin 01', 5000, 1000000, 2, 4, 3, 'normal', 'Có tivi', null, null),
       ('Villa No Beach Front', 22000, 9000000, 8, 3, 1, 'normal', 'Có hồ bơi', 300, 3),
       ('House Princess 02', 10000, 4000000, 5, 3, 2, 'normal', 'Có thêm bếp nướng', null, 2),
       ('Room Twin 02', 3000, 900000, 2, 4, 3, 'normal', 'Có tivi', null, null);
SELECT * FROM dich_vu;

INSERT INTO dich_vu_di_kem (ten_dich_vu_di_kem, gia, don_vi, trang_thai)
VALUES ('Karaoke', 10000, 'giờ', 'tiện nghi, hiện tại'),
	   ('Massage', 18000, 'giờ', 'tiện nghi, hiện tại'),
       ('Thuê xe máy', 10000, 'chiếc', 'hỏng 1 xe'),
       ('Thuê xe đạp', 20000, 'chiếc', 'tốt'),
       ('Buffet buổi sáng', 15000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
       ('Buffet buổi trưa', 90000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
       ('Buffet buổi tối', 16000, 'suất', 'đầy đủ đồ ăn, tráng miệng');
SELECT * FROM dich_vu_di_kem;

INSERT INTO hop_dong (ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu)
VALUES ('2021-12-08', '2020-12-08', 0, 3, 1, 3),
       ('2020-07-14', '2020-07-21', 200000, 7, 3, 1),
       ('2021-03-15', '2021-03-17', 50000, 3, 4, 2),
       ('2021-01-14', '2021-01-18', 100000, 7, 5, 5),
       ('2021-07-14', '2021-07-15', 0, 7, 2, 6),
       ('2021-06-01', '2021-06-03', 0, 7, 7, 6),
       ('2021-09-02', '2021-09-05', 100000, 7, 4, 4),
       ('2021-06-17', '2021-06-18', 150000, 3, 4, 1),
       ('2020-11-19', '2020-11-19', 0, 3, 4, 3),
       ('2021-04-12', '2021-04-14', 0, 10, 3, 5),
       ('2021-04-25', '2021-04-25', 0, 2, 2, 1),
       ('2021-05-25', '2021-05-27', 0, 7, 10, 1);
SELECT * FROM hop_dong;

INSERT INTO hop_dong_chi_tiet (ma_hop_dong, ma_dich_vu_di_kem, so_luong)
VALUES (2, 4, 5), (2, 5, 8), (2, 6, 15), (3, 1, 1), (3, 2, 11), (1, 3, 1), (1, 2, 2), (12, 2, 2);
SELECT * FROM hop_dong_chi_tiet;

select ma_dich_vu,ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,ma_kieu_thue, 
		tieu_chuan_phong,mo_ta_tien_nghi_khac,so_tang
from dich_vu;