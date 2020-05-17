/**
  创建一个学生表：
    student： sid 学号,name 姓名,gender 性别,id 班级编号,score 分数,level 级别(班长/学生 一个班级只有一个班长)
  创建一个班级表
    class: class: id 班级编号,name 班级名称,classTraining 班训

  创建20个学生，4个班级，3个班长，2个学生的id为null，一个班级没有学生
  获取所有班长的信息
  获取所有班级的平均分，最高分和班级信息
  获取所有学生及其班级的信息
  获取每个班级的最高分的学生的信息
  获取班训中含有 '好' 字的所有学生的信息
  获取每个学生的信息及其与平均分之间的差距
  获取每个学生及其班长的信息
  获取不和张三同一个班级的学生的信息
  获取和张三班的任意一个学生相同分数的学生的信息
  */

show databases;
create database homework;
use homework;
create table student
(
    studentId       int primary key,
    studentName     varchar(10),
    studentGender   char(1),
    studentScore    float(5, 2),
    studentPosition boolean,
    # 班长不能为唯一
    myClassId       int
    # 预备主键
);
#   创建一个学生表：
#     student： sid 学号,name 姓名,gender 性别,id 班级编号,score 分数,position 级别(班长/学生 一个班级只有一个班长)
create table class
(
    classId       int primary key,
    className     varchar(10),
    classTraining text
);
#   创建一个班级表
#     class: class: id 班级编号,name 班级名称,classTraining 班训

alter table student
    add constraint fk_1 foreign key (myClassId) references class (classId);
# ALTER TABLE students ADD CONSTRAINT fk_class_id FOREIGN KEY (class_id) REFERENCES classes (id);
# 给myClassId 字段添加外键约束

insert into class
values (001, '第1班', '只要坚持不懈，嘲笑你的人，迟早会被你笑死。'),
       (002, '第2班', '真正的勇士，敢于直面银行卡上的余额，敢于正视磅秤上的数字。'),
       (003, '第3班', '远方的路，除了未知，还有绝望。'),
       (004, '第7班', '谁说我不会乐器？我退堂鼓打的可好了。')
;
select *
from class;
insert into student (myClassId, studentName, studentGender, studentScore, studentPosition, studentId)
values (001, '张1', '男', 10.5, false, 001),
       (001, '张2', '女', 30, false, 002),
       (001, '张3', '男', 110, false, 003),
       (004, '张4', '女', 63, false, 004),
       (001, '张5', '男', 84, false, 005),
       (001, '张6', '女', 57, false, 006),
       (004, '张7', '男', 45, false, 007),
       (001, '张8', '女', 50.5, true, 008),
       (002, '张9', '男', 11.5, false, 009),
       (002, '李1', '女', 16.5, false, 0010),
       (002, '李2', '女', 105, true, 0011),
       (002, '李3', '男', 175, false, 0012),
       (002, '李4', '女', 87, false, 0013),
       (002, '李5', '男', 104, false, 0014),
       (004, '李6', '女', 60.5, false, 0015),
       (004, '李7', '男', 13, false, 0016),
       (004, '李8', '女', 141, true, 0017),
       (004, '李9', '男', 115, false, 0018),
       (null, '王1', '女', 65, false, 0019),
       (null, '王2', '男', 1.5, false, 0020)
;
select *
from student;
#   创建20个学生，4个班级，3个班长，2个学生的id为null，一个班级没有学生
select *
from student
where studentPosition = true;
#   获取所有班长的信息

select (select avg(ifnull(studentScore, 0)) from student) "平均分",
       (select max(ifnull(studentScore, 0)) from student) "最高分",
       classId,
       className,
       classTraining
from class;
# 错误
select avg(ifnull(s.studentScore, 0)) 平均分, max(ifnull(s.studentScore, 0)) "最高分", count(*) "总人数", c.*
from student s,
     class c
where s.myClassId = c.classId
group by c.classId;
#   获取所有班级的平均分，最高分和班级信息
select *
from student s
         left join class t on s.myClassId = t.classId
union
select *
from student s
         right join class t on s.myClassId = t.classId;

select c.*, s.*
from class c,
     student s
where c.classId = s.myClassId;
#   获取所有学生及其班级的信息

select myClassId "班级", studentScore "最高分", studentId, studentName, studentPosition, studentScore
from student
where studentScore in (SELECT MAX(ifnull(studentScore, 0)) FROM student group by myClassId);
#   获取每个班级的最高分的学生的信息
select *
from student
where myClassId = (select classId from class where classTraining like '%好%');
#   获取班训中含有 '好' 字的所有学生的信息
select *, (select avg(ifnull(studentScore, 0)) from student) - studentScore "和平均分的差距"
from student;
#   获取每个学生的信息及其与平均分之间的差距
select myClassId, studentName
from student
where studentPosition = true;
# 班长信息
# 1,张8
# 2,李2
# 4,李8
select *, case myClassId when 1 then "张8" when 2 then "李2" when 4 then "李8" else "没有班长" end "班长"
from student;
# 是在写不了，只能用判断了

select *
from student
where studentPosition = false;
# 学生的信息
select *
from student
where studentPosition = true;
# 班长的信息

select *
from student s,
     student ss
where s.studentPosition = true
  and ss.studentPosition = false
  and ss.myClassId = s.myClassId;
# 获取学生和班长的信息
select *
from (select * from student where studentPosition = false) s
         left join student ss on ss.studentPosition = true and ss.myClassId = s.myClassId;
# 获取所有学生和班长的信息


#   获取每个学生及其班长的信息
select *
from student
where myClassId not in (select myClassId from student where studentName = '张3');
#   获取不和张三同一个班级的学生的信息

select myClassId
from student
where studentName = '张3';
# 获取张3的cid
# 获取张三版的学生的分数
select studentScore
from student
where myClassId in (select myClassId from student where studentName = '张3');


select *
from student
where studentScore in
      (select studentScore from student where myClassId in (select myClassId from student where studentName = '张3'))
  and myClassId not in (select myClassId from student where studentName = '张3');
#   获取和张三班的任意一个学生相同分数的学生的信息