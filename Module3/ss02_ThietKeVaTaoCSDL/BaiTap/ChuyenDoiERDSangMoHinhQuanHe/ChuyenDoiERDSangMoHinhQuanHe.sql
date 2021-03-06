create database quanlyvatlieu;
use quanlyvatlieu;

CREATE TABLE PhieuXuat (
    SoPX INT AUTO_INCREMENT PRIMARY KEY,
    NgayXuat DATE NOT NULL
);

CREATE TABLE VatTu (
    MaVTU INT AUTO_INCREMENT PRIMARY KEY,
    TenVTU VARCHAR(50)
);

CREATE TABLE ChiTietPhieuXuat (
    SoPX INT,
    MaVTU INT,
    DGXuat INT,
    SLXuat INT,
    PRIMARY KEY (SoPX , MaVTU),
    FOREIGN KEY (SoPX)
        REFERENCES PhieuXuat (SoPX),
    FOREIGN KEY (MaVTU)
        REFERENCES VatTu (MaVTU)
);

CREATE TABLE PhieuNhap (
    SoPN INT AUTO_INCREMENT PRIMARY KEY,
    NgayNhap DATE NOT NULL
);

CREATE TABLE ChiTietPhieuNhap (
    MaVTU INT,
    SoPN INT,
    DGNhap INT,
    SLNhap INT,
    PRIMARY KEY (MaVTU , SoPN),
    FOREIGN KEY (MaVTU)
        REFERENCES VatTu (MaVTU),
    FOREIGN KEY (SoPN)
        REFERENCES PhieuNhap (SoPN)
);

CREATE TABLE NhaCC (
    MaNCC INT AUTO_INCREMENT PRIMARY KEY,
    TenNCC VARCHAR(50),
    DiaChi VARCHAR(30)
);

CREATE TABLE DonDH (
    SoDH INT AUTO_INCREMENT PRIMARY KEY,
    NgayDH DATE NOT NULL,
    MaNCC INT,
    FOREIGN KEY (MaNCC)
        REFERENCES NhaCC (MaNCC)
);

CREATE TABLE ChiTietDonDatHang (
    MaVTU INT,
    SoDH INT,
    PRIMARY KEY (MaVTU , SoDH),
    FOREIGN KEY (MaVTU)
        REFERENCES VatTu (MaVTU),
    FOREIGN KEY (SoDH)
        REFERENCES DonDH (SoDH)
);

CREATE TABLE SoDienThoai (
    MaSDT INT AUTO_INCREMENT PRIMARY KEY,
    SDT VARCHAR(20),
    MaNCC INT,
    FOREIGN KEY (MaNCC)
        REFERENCES NhaCC (MaNCC)
);