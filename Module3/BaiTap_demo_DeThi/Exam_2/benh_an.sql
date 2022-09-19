create database benh_an;
use benh_an;
DROP Table if exists `benh_nhan`;
create table `benh_nhan`(
	id varchar(25) primary key,
    name varchar(100) not null
);
DROP Table if exists `benh_an`;

create table `benh_an`(
	id varchar(25) primary key,
    date_in date not null,
    date_out date not null,
    reason varchar(255) not null,
    id_benh_nhan varchar(25) not null,
    foreign key(id_benh_nhan) references `benh_nhan`(id)
);
ALTER TABLE `benh_an`.`benh_an` 
DROP FOREIGN KEY `benh_an_ibfk_1`;
ALTER TABLE `benh_an`.`benh_an` 
ADD CONSTRAINT `benh_an_ibfk_1`
  FOREIGN KEY (`id_benh_nhan`)
  REFERENCES `benh_an`.`benh_nhan` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
 
INSERT INTO `benh_an`.`benh_nhan` (`id`, `name`) VALUES ('BN-435', 'Nguyễn Văn A');
INSERT INTO `benh_an`.`benh_nhan` (`id`, `name`) VALUES ('BN-123', 'Nguyễn Văn B');
INSERT INTO `benh_an`.`benh_nhan` (`id`, `name`) VALUES ('BN-984', 'Nguyễn Văn C');
INSERT INTO `benh_an`.`benh_nhan` (`id`, `name`) VALUES ('BN-153', 'Nguyễn Văn D');

  
INSERT INTO `benh_an`.`benh_an` (`id`, `date_in`, `date_out`, `reason`, `id_benh_nhan`) VALUES ('BA-001', '2019/05/01', '2020/05/01', 'Ung thư giai đoạn cuối', 'BN-435');
INSERT INTO `benh_an`.`benh_an` (`id`, `date_in`, `date_out`, `reason`, `id_benh_nhan`) VALUES ('BA-112', '2018-05-05', '2019-05-05', 'Suy thận mạn', 'BN-123');
INSERT INTO `benh_an`.`benh_an` (`id`, `date_in`, `date_out`, `reason`, `id_benh_nhan`) VALUES ('BA-223', '2020-01-01', '2021-01-01', 'Covid 19', 'BN-984');
INSERT INTO `benh_an`.`benh_an` (`id`, `date_in`, `date_out`, `reason`, `id_benh_nhan`) VALUES ('BA-444', '2021-06-30', '2022-06-30', 'Ung thư phổi giai đoạn cuối', 'BN-153');

INSERT INTO `benh_an`.`benh_an` (`id`, `date_in`, `date_out`, `reason`, `id_benh_nhan`) VALUES ('BA-012', '2019/05/01', '2020/05/01', 'Ung thư giai đoạn cuối', 'BN-435');
INSERT INTO `benh_an`.`benh_an` (`id`, `date_in`, `date_out`, `reason`, `id_benh_nhan`) VALUES ('BA-113', '2018-05-05', '2019-05-05', 'Suy thận mạn', 'BN-123');
INSERT INTO `benh_an`.`benh_an` (`id`, `date_in`, `date_out`, `reason`, `id_benh_nhan`) VALUES ('BA-224', '2020-01-01', '2021-01-01', 'Covid 19', 'BN-984');
INSERT INTO `benh_an`.`benh_an` (`id`, `date_in`, `date_out`, `reason`, `id_benh_nhan`) VALUES ('BA-445', '2021-06-30', '2022-06-30', 'Ung thư phổi giai đoạn cuối', 'BN-153');

INSERT INTO `benh_an`.`benh_an` (`id`, `date_in`, `date_out`, `reason`, `id_benh_nhan`) VALUES ('BA-013', '2019/05/01', '2020/05/01', 'Ung thư giai đoạn cuối', 'BN-435');
INSERT INTO `benh_an`.`benh_an` (`id`, `date_in`, `date_out`, `reason`, `id_benh_nhan`) VALUES ('BA-114', '2018-05-05', '2019-05-05', 'Suy thận mạn', 'BN-123');
INSERT INTO `benh_an`.`benh_an` (`id`, `date_in`, `date_out`, `reason`, `id_benh_nhan`) VALUES ('BA-225', '2020-01-01', '2021-01-01', 'Covid 19', 'BN-984');
INSERT INTO `benh_an`.`benh_an` (`id`, `date_in`, `date_out`, `reason`, `id_benh_nhan`) VALUES ('BA-446', '2021-06-30', '2022-06-30', 'Ung thư phổi giai đoạn cuối', 'BN-153');

SELECT * from `benh_nhan`;
select * from `benh_nhan` where id='BN-435';
select * from `benh_an`;

select * from `benh_an` ba join `benh_nhan` bn on ba.id_benh_nhan=bn.id where limit 0,2; 
select SQL_CALC_FOUND_ROWS * from `benh_an` ba join `benh_nhan` bn on ba.id_benh_nhan=bn.id limit 0,2;
select found_rows();
select SQL_CALC_FOUND_ROWS * from `benh_an` ba join `benh_nhan` bn on ba.id_benh_nhan=bn.id where ba.reason  like concat('%','Ung','%') limit 0,5;

select  ba.id, bn.id from `benh_an` ba join `benh_nhan` bn on ba.id_benh_nhan=bn.id;
select count(id) from `benh_nhan` where id='BN-435';