create database demo_user_management;
use demo_user_management;

create table users (
	id int(11) not null auto_increment,
    `name` varchar(50) not null,
    email varchar(50) not null,
    country varchar(50),
    primary key(id)
);

insert into users(`name`, email, country)
values('Minh', 'minh@codegym.vn', 'Việt Nam');
insert into users(`name`, email, country) 
values('Kante','kante@che.uk','Kenia');

DELIMITER $$
CREATE PROCEDURE get_user_by_id(IN user_id INT)
BEGIN
	SELECT users.`name`, users.email, users.country
    FROM users
    WHERE users.id = user_id;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE insert_user(
	IN user_name varchar(50),
    IN user_email varchar(50),
    IN user_country varchar(50)
)
BEGIN
	INSERT INTO users(`name`, email, country)
    VALUES(user_name, user_email, user_country);
END $$
DELIMITER ;



-- Tạo mới 2 bảng Permission và User_Permission trong MySql
create table Permision (
	id int(11) primary key,
    `name` varchar(11)
);

create table User_Permision (
	user_id int(11),
	permision_id int(11)
);

insert into Permision(id, `name`) values(1, 'add');		
insert into Permision(id, `name`) values(2, 'edit');
insert into Permision(id, `name`) values(3, 'delete');
insert into Permision(id, `name`) values(4, 'view');