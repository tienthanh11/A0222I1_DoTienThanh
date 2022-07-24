create database quanlyvatlieu;
use quanlyvatlieu;

create table PhieuXuat (
	SoPX int auto_increment primary key,
    NgayXuat date not null
);

create table VatTu (
	MaVTU int auto_increment primary key,
    TenVTU varchar(50)
);

create table ChiTietPhieuXuat (
	SoPX int,
    MaVTU int,
    DGXuat int,
    SLXuat int,
    primary key(SoPX, MaVTU),
    foreign key(SoPX) references PhieuXuat(SoPX),
    foreign key(MaVTU) references VatTu(MaVTU)
);

create table PhieuNhap (
	SoPN int auto_increment primary key,
    NgayNhap date not null
);

create table ChiTietPhieuNhap (
	MaVTU int,
    SoPN int,
    DGNhap int,
    SLNhap int,
    primary key(MaVTU, SoPN),
    foreign key(MaVTU) references VatTu(MaVTU),
    foreign key(SoPN) references PhieuNhap(SoPN)
);

create table NhaCC (
	MaNCC int auto_increment primary key,
    TenNCC varchar(50),
    DiaChi varchar(30)
);

create table DonDH (
	SoDH int auto_increment primary key,
    NgayDH date not null,
    MaNCC int,
    foreign key(MaNCC) references NhaCC(MaNCC)	
);

create table ChiTietDonDatHang (
	MaVTU int,
    SoDH int,
    primary key(MaVTU, SoDH),
    foreign key(MaVTU) references VatTu(MaVTU),
    foreign key(SoDH) references DonDH(SoDH)
);

create table SoDienThoai (
	MaSDT int auto_increment primary key,
    SDT varchar(20),
	MaNCC int,
    foreign key(MaNCC) references NhaCC(MaNCC)
);