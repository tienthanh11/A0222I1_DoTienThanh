create database exam_product_management_2;
use exam_product_management_2;

create table `category` (
	id int primary key auto_increment,
    `name` varchar(255) not null
    
);
insert into `category` (`name`) values ('Phone');
insert into `category` (`name`) values ('Television');
insert into `category` (`name`) values ('Motorbike');

create table `product` (
	id int primary key auto_increment,
    `name` varchar(50) not null,
    price double not null,
    quantity int not null,
    color varchar(50) not null,
    `description` varchar(255),
    category int not null,
    foreign key (category) references `category`(id)
);
insert into `product`(`name`, price, quantity,color,category) values('IPhone 11',799,12,'Purple,Yellow,Green',1);
insert into `product`(`name`, price, quantity,color,category) values('Iphone 11 Pro',1100,12,'Green,Black,White',1);
insert into `product`(name, price, quantity,color,category) values('Iphone X',749,13,'Coral,Black,Blue',1);
insert into `product`(name, price, quantity,color,category) values(' Smart TV',1000000,5,'Black',2);
insert into `product`(name, price, quantity,color,category) values(' Samsung Galaxy S10',420,10,'Prism White,Prism Blue,Ceramic Black',1);

create table `category` (
	id int primary key auto_increment,
    `name` varchar(255) not null
    
);
insert into `category` (`name`) values ('Phone');
insert into `category` (`name`) values ('Television');
insert into `category` (`name`) values ('Motorbike');

select * from category;
select * from product p 
join category c on p.category=c.id;