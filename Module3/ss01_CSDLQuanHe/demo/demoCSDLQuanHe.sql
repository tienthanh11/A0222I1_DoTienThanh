CREATE DATABASE if not exists a0222i1;
use a0222i1;

CREATE TABLE student (
	id int,
    `name` varchar(50),
    birthday date
);

-- thêm mới
insert into student
values(1, 'thanh', '2001-01-01');

insert into student(id, name , birthday)
values (2, 'thanh2', '2001-01-01'),
	   (3, 'thanh3', '2001-01-01');
       
-- lấy thông tin
select s.id, s.`name`
from student s;
select * from student;

-- thay đổi thông tin
update student
set name = 'thanh1', birthday = '2000-12-26'
where id = 1;

-- xoá thông record
delete from student
where name = 'thanh3';

-- thêm mới 1 trường
alter table student
add column `point` int;

-- xoá bảng
-- drop table student;

-- xoá csdl
-- drop database a0222i1;



