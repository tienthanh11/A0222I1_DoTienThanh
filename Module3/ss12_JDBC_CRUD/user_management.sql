create database demo_user_management;
use demo_user_management;

create table users (
	id int(3) not null auto_increment,
    `name` varchar(120) not null,
    email varchar(220) not null,
    country varchar(120),
    primary key(id)
);

insert into users(`name`, email, country)
values('Minh', 'minh@codegym.vn', 'Viet Nam');
insert into users(`name`, email, country) 
values('Kante','kante@che.uk','Kenia');