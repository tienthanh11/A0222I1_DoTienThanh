create database studentManagement;

use studentManagement;

create table class (
	class_id int,
    class_name varchar(50),
    primary key(class_id)
);

select c.id, c.`name`
from class c;
select * from class;
insert into class
values(1, 'thanh'), (2, 'hoang');


create table teacher (
	id int primary key auto_increment,
    `name` varchar(50),
    age int,
    country varchar(50)
);

select t.id, t.`name`, t.age
from teacher t;
select * from teacher;
insert into teacher (`name`, age, country)
value ('Tri', 21, 'Đà Nẵng');


