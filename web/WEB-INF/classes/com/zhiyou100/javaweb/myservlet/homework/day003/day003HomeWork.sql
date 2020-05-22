# 作业：创建一个老师表：tid tname tpwd  创建一个学生表：sid sname sex score
show databases;
use homework;
show tables;
# 创建老师表
create table teacher
(
    teacherId   int primary key auto_increment,
    teacherName varchar(11),
    teacherPwd  varchar(4)
);
# 创建学生表
create table student
(
    studentId     int primary key auto_increment,
    studentName   varchar(11),
    studentGender char(1),
    studentScore  float
);
insert into teacher (teacherId, teacherName, teacherPwd)
values (1001, '王五', '1024'),
       (null, '王六', '1024'),
       (null, '王七', '1024'),
       (null, '王路', '1024'),
       (null, '王八', '1024');

select *
from teacher;

select *
from teacher
where teacherName = '王五'
  and teacherPwd = '1024';

insert into student
values (null, '张3', '男', 65),
       (null, '张4', '女', 65),
       (null, '张5', '男', 65),
       (null, '张6', '女', 65),
       (null, '张7', '男', 65),
       (null, '张8', '男', 65),
       (null, '张9', '男', 65),
       (null, '张10', '女', 65),
       (null, '张11', '男', 65),
       (null, '张12', '男', 65),
       (null, '张12', '女', 65),
       (null, '张14', '男', 65),
       (null, '张15', '男', 65),
       (null, '张16', '女', 65);

select *
from student;

