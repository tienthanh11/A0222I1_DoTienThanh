drop database if exists book_management;
create database if not exists book_management;
 -- SET FOREIGN_KEY_CHECKS = 0;
--  SET SQL_SAFE_UPDATES = 0;
 
-- drop database thi;
 use book_management;
 create table if not exists book(
book_id int primary key auto_increment,
`name` varchar (100),
author varchar(100),
`description` varchar(100),
quantity int
 );
insert into book (`name`,author,`description`,quantity) values ("Số đỏ","Vũ Trọng Phụng","Nhân vật chính là Xuân tóc đỏ và ...", 10),("Truyện Kiều","Nguyễn Du","Cuộc đời Thúy Kiều", 15);
-- select * from book where author like "%phung" and author like 'vu%';

 create table if not exists student (
student_id int primary key auto_increment,
`name` varchar (100),
class_name varchar (100)
 );
 insert into student (`name`,class_name) values ("Nguyễn Văn A","A11"),("Nguyễn Văn B","A12");
 
create table if not exists card_borrow_book (
card_borrow_book_id varchar(50) primary key,
book_id int,
foreign key (book_id) references book (book_id),
student_id int,
foreign key (student_id) references student(student_id),
`status` bit,
date_borrow date,
date_turn date
);

insert into card_borrow_book(card_borrow_book_id, book_id, student_id, `status`, date_borrow, date_turn) 
values ("MS-0001",1,1,1,"2000-10-05","2000-12-05"), ("MS-0002",2,2,0,"2000-09-05","2000-11-05");
select * from card_borrow_book where book_id = 1; 
-- select * from ground order by area ASC;
-- delete from ground where id = "ABC-13-AC";
-- select * from ground where floors  like "%3%" and type_office_id like "%1%" and  rental_price like "%%";
-- update ground set id = "1", area = 1, status_id = 1, floors =1, type_office_id = 1, `description` = "abc", rental_price = 1, start_date = "1111-11-11", start_date = "1111-11-11" where id = "ABC-12-AC";