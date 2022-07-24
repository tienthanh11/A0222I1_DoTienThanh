create database if not exists a0222i1_database_desgin;
use a0222i1_database_desgin;
create table class_type(
	id int primary key auto_increment,
	`name` varchar(50)
);

create table class(
	id int auto_increment,
	`name` varchar(50),
	primary key(id),
	class_type_id int,
	foreign key(class_type_id) references class_type(id)
);

create table jame(
	`account` varchar(50) primary key,
	`password` varchar(50)
);

create table student(
	id int primary key auto_increment,
	`name` varchar(50),
	gender boolean,
	birthday date,
	email varchar(50),
	`point` float,
	`account` varchar(50),
	foreign key(`account`) references jame(`account`),
	class_id int,
	foreign key(class_id) references class(id)
);
create table instructor (
	id int primary key auto_increment,
	`name` varchar(50),
	birthday date,
	salary float
);

create table instructor_class (
	class_id int,
	instructor_id int,
	primary key(class_id,instructor_id),
	foreign key(class_id) references class(id),
	foreign key(instructor_id) references instructor(id),
	start_day date
)