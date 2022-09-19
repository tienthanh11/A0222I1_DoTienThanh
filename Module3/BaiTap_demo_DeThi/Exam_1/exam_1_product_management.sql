create database exam_product_management;
use exam_product_management;
set foreign_key_checks = 0;
set sql_safe_updates = 0;

create table if not exists category (
	category_id int primary key auto_increment,
    category_name varchar(50)
);

insert into category (category_name)	
values ('Phone'), ('Television'), ('Motobike');

-- drop table product
create table if not exists product (
	product_id int primary key auto_increment,
	product_name varchar(50),
    product_price double,
    product_quantity int,
    product_color varchar(50),
    product_describe varchar(250),
    category_id int,
    constraint fk_category_id foreign key(category_id) references category(category_id) on delete cascade
);

insert into product(product_name, product_price, product_quantity, product_color, product_describe, category_id)
values ('Iphone 14 Pro Max', 5000, 12, 'Purple,Yellow,Green', 'good and beautiful', 1),
	   ('Iphone 15', 11000, 12, 'Green,Black,White','good and beautiful', 1),
       ('Iphone X',749,13,'Coral,Black,Blue','good and beautiful' , 1),
       ('Smart TV',1000,5,'Black','beautiful' ,2),
       ('Samsung Galaxy S10',420,10,'Prism White,Prism Blue,Ceramic Black', 'beautiful' , 1),
       ('Ducati',14000,10,'Prism White,Prism Blue,Ceramic Black','beautiful', 3),
       ('R15',6400,10,'Prism White,Prism Blue,Ceramic Black','beautiful', 3);

select * from product;
select * from product p 
join category c on p.category_id=c.category_id;
