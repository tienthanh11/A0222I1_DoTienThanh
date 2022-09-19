create database if not exists exam_module_3;
use exam_module_3;

create table status_stage(
id int auto_increment primary key,
`name` varchar(50)
);

create table type_stage(
id int auto_increment primary key,
`name` varchar(50)
);

create table mat_bang(
id varchar(50) primary key,
`area` int,
status_id int,
stage int,
type_stage_id int,
text_stage varchar(50),
price int,
date_in date,
date_out date,
foreign key (status_id) references status_stage(id),
foreign key (type_stage_id) references type_stage(id)
);

insert into status_stage (id, `name`) values (1, 'empty'),(2, 'ha_tang'),(3, 'full');
insert into type_stage (id, `name`) values (1, 'share'),(2, 'full-stack');

INSERT INTO mat_bang VALUES 
("BN221", 22, 1, 15, 2,"", 1900000, '2020-11-20', '2020-11-28'),
("BN312", 32, 3, 12, 1,"", 1900000, '2020-11-20', '2020-11-28'),
("BN314", 42, 2, 1, 2,"", 2900000, '2020-11-20', '2020-11-28');

DROP procedure IF EXISTS `searchAll`;

DELIMITER $$
USE `exam_module_3`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `searchAll`(id_search varchar(50), stage_search int, date_in_search varchar(50), date_out_search varchar(50))
BEGIN
if stage_search = 0  then 
select * from mat_bang where id like concat('%' , id_search , '%') and stage like '%%' and date_in like concat('%' , date_in_search ,'%') and date_out like concat('%' , date_out_search , '%');
else
select * from mat_bang where id like concat('%' , id_search, '%') and stage = stage_search and date_in like concat('%' ,date_in_search,'%') and date_out like concat('%' ,date_out_search, '%');
end if;
END$$

DELIMITER ;
;
