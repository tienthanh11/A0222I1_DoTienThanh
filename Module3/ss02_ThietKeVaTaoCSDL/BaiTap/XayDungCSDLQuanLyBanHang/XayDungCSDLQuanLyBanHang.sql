create database QuanLyBanHang;
use QuanLyBanHang;

create table Customer (
	cID int primary key auto_increment,
    cName varchar(50),
    cAge int
);

create table `Order` (
	oID int primary key auto_increment,
    cID int,
    oDate datetime,
    oTotalPrice double,
    foreign key(cID) references Customer(cID)
);

create table Product (
	pID int primary key auto_increment,
    pName varchar(50),
    pPrice double
);

create table OrderDetail (
	oID int,
    pID int,
    odQTY varchar(30),
    primary key(oID, pID),
    foreign key(oID) references `Order`(oID),
    foreign key(pID) references Product(pID)
);