create database QuanLyBanHang_2;
use QuanLyBanHang_2;

create table Customer (
	cID int primary key auto_increment,
    `name` varchar(25),
    cAge tinyint
);

create table `Order` (
	oID int primary key auto_increment,
    cID int,
    oDate datetime,
    oTotalPrice int,
    foreign key(cID) references Customer (cID)
);

create table Product (
	pID int primary key auto_increment,
    pName varchar(25),
    pPrice int
);

create table OrderDetail (
	oID int,
    pID int,
    odQTY int,
    primary key(oID, pID),
    foreign key(oID) references `Order` (oID),
    foreign key(pID) references Product (pID)
);

-- insert into customer
insert into Customer (`name`, cAge)
values ('Minh Quan', 10), ('Ngoc Oanh', 20), ('Hong Ha', 50);

-- insert into order
insert into `Order` (cID, oDate, oTotalPrice)
values (1, '2006-03-21', null), (2, '2006-03-23', null), (1, '2006-03-16', null);

-- insert into product
insert into Product (pName, pPrice)
values ('May Giat', 3), ('Tu Lanh', 5), ('Dieu Hoa', 7), ('Quat', 1), ('Bep Dien', 2);

-- insert into Order Detail
insert into OrderDetail (oID, pID, odQTY) 
values (1,1,3), (1,3,7), (1,4,2), (2,1,1), (3,1,8), (2,5,4), (2,3,3);

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order

select o.oID, o.oDate, o.oTotalPrice
from `Order` o;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách

select c.`name`, p.pName
from Customer c
inner join `Order` o on c.cID = o.cID
inner join OrderDetail od on o.oID = od.oID
inner join Product p on od.pID = p.pID;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào

select c.`name`
from Customer c
inner join `Order` o on c.cID = o.cID
inner join OrderDetail od on o.oID = od.oID
inner join Product p on od.pID = p.pID
where p.pName is null;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. 
-- Giá bán của từng loại được tính = odQTY*pPrice)

select o.oID, o.oDate, sum(p.pPrice * od.odQTY) as GiaTien 
from `Order` o 
inner Join OrderDetail od on o.oID = od.oID
inner join Product p on od.pID = p.pID
group by o.oID;

