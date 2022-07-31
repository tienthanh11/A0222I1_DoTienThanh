create database quanlysinhvien_6;
use quanlysinhvien_6;

create table Class (
	ClassID int not null auto_increment primary key,
    ClassName varchar(60) not null,
    StartDate datetime not null,
	`Status` bit
);

create table Student (
	StudentID int not null auto_increment primary key,
    StudentName varchar(30) not null,
    Address varchar(50),
    Phone varchar(20),	
    `Status` bit,
    ClassID int,
    foreign key(ClassID) references Class(ClassID)
);

create table `Subject` (
	SubID int not null auto_increment primary key,
    SubName varchar(30) not null,
    Credit tinyint not null default 1 check (Credit >= 1),
    `Status` bit default 1
);

create table Mark (
	MarkID int not null auto_increment primary key,
    SubID int not null,
    StudentID int not null,
    Mark float default 0 check (Mark between 0 and 100),
    ExamTimes tinyint default 1, 
    unique(SubID, StudentID),
    foreign key(SubID) references `Subject`(SubID),
    foreign Key(StudentID) references Student(StudentID)
);

insert into Class
values (1, 'A1', '2008-12-20', 1);
insert into Class
values (2, 'A2', '2008-12-22', 1);
insert into Class
values (3, 'B3', current_date, 0);

insert into Student (StudentName, Address, Phone, `Status`, ClassID)
values ('Hung', 'Ha noi', '0912113113', 1, 1);
insert into Student (StudentName, Address, `Status`, ClassID)
values ('Hoa', 'Hai phong', 1, 1);
insert into Student (StudentName, Address, Phone, `Status`, ClassID)
values ('Manh', 'HCM', '0123123123', 0, 2);

insert into `Subject`
values (1, 'CF', 5, 1),
	   (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
	   (4, 'RDBMS', 10, 1);

insert into Mark (SubID, StudentID, Mark, ExamTimes)
values (1, 1, 8, 1),
	   (1, 2, 10, 2),
	   (2, 1, 12, 1);
       
-- Hiển thị danh sách tất cả các học viên

select *
from student;

-- Hiển thị danh sách các học viên đang theo học.

select *
from student
where Status = true; 

-- Hiển thị danh sách các môn học có thời gian học nhỏ hơn 10 giờ.

select *
from subject
where Credit < 10;

-- Hiển thị danh sách học viên lớp A1

select s.StudentID, s.StudentName, c.ClassName
from Student s
join Class c
on s.ClassID = c.ClassID
where c.ClassName = 'A1';

-- Hiển thị điểm môn CF của các học viên.

select s.StudentID, s.StudentName, sub.SubName, m.Mark
from Student s
join Mark m
on s.StudentID = m.StudentID
join Subject sub
on m.SubID = sub.SubID
where sub.SubName = 'CF';

-- Hiển thị số lượng sinh viên ở từng nơi

select Address, count(StudentID) as `Số lượng học viên`
from Student
group by Address;

-- Tính điểm trung bình các môn học của mỗi học viên

select s.StudentID, s.StudentName, avg(Mark)
from Student s
join Mark m on s.StudentID = m.StudentID
group by s.StudentID, s.StudentName;

-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15

select s.StudentID, s.StudentName, avg(Mark)
from Student s
join Mark m on s.StudentID = m.StudentID
group by s.StudentID, s.StudentName
having avg(Mark) > 15;

-- Hiển thị thông tin các học viên có điểm trung bình lớn nhất.

select s.StudentID, s.StudentName, avg(Mark)
from Student s
join Mark m on s.StudentID = m.StudentID
group by s.StudentID, s.StudentName
having avg(Mark) >= all (select avg(Mark) from Mark m group by m.StudentID);

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.

-- Cách 1:
select *
from `subject`
where Credit = (select max(sub.Credit) from `subject` sub);
-- Cách 2:
select sub.SubID, sub.SubName, max(Credit) as Credit,  sub.`Status`
from `subject` sub
where  Credit = (select max(Credit) from `subject`);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.

select sub.SubID, sub.SubName, max(Mark)
from `subject` sub
inner join Mark m
on sub.SubID = m.SubID;

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần

select s.StudentID, s.StudentName, avg(m.Mark)
from student s
inner join Mark m
on s.StudentID = m.StudentID
group by s.StudentID
order by Mark desc;
