/*
 多表查询
 */

create database myDatabase_26;
use myDatabase_26;

create table teacher
# 创建主表
(
    teacherId      int primary key auto_increment,
    # 主键列，自增
    teacherName    varchar(4),
    teacherSubject varchar(10)
);

create table student
# 创建从表
(
    studentId    int primary key auto_increment,
    # 主键列自增
    studentName  varchar(4),
    studentScore float(5, 1),
    myTeacherId  int,
    # 外键列来引用teacher表的teacherId
    constraint fk_1 foreign key (myTeacherId) references teacher (teacherId)
);

insert into teacher (teacherName, teacherSubject)
values ('李老师', 'English'),
       ('王老师', 'java'),
       ('张老师', 'big data'),
       ('杨老师', 'Chinese'),
       ('赵老师', 'math');
insert into student(studentName, studentScore, myTeacherId)
VALUES ('张三', 20.1, 1),
       ('张三', 20.1, 2),
       ('张三', 20.1, 1),
       ('李四', 20.1, 3),
       ('李四', 20.1, 4),
       ('李四', 20.1, 1),
       ('王五', 20.1, 1),
       ('王五', 20.1, 2),
       ('王五', 20.1, 3);
insert into student
values (102, '王三', 20.4, null);

insert into teacher
values (null, '王', null);


/**
  多表查询：多表查询，同时查询多个表的记录
  方式1：合并结果集
  方式2：联合查询
  方式3：子查询
 */

/**
  方式1 合并结果集：把两个结果结婚合并为一个结果集
  select1 union select2 去重
  select1 union all  select2 保留重复

 */
select teacherId, teacherName
from teacher;
select studentId, studentName
from student;

select teacherId, teacherName
from teacher
union
select studentId, studentName
from student;
# 去重
select teacherId, teacherName
from teacher
union all
select studentId, studentName
from student;
# 不去重复

/**
  方式2 连接查询
  笛卡尔集 ：让两个表的所有集合都互相见一次面
  行：表1的行数*表2的行数
  列：表1的列+表2的列
 */
select *
from teacher,
     student;
# 两个表的笛卡尔积

select *
from student,
     teacher
where student.myTeacherId = teacher.teacherId;
# 通过主表的主键列=从表的外键列 来去除垃圾的笛卡尔积

/**
  连接查询情况1：内连接
    方言格式：select 列 from 表1,表2 where 表1.列=表2.列、
    标准格式：select 列 from 表1 inner join 表2 on 表1.列=表2.列
 */


# 获取学生及其老师的信息(有关系的)
select *
from student s,
     teacher t
where s.myTeacherId = t.teacherId;
select *
from student s
         inner join teacher t on s.myTeacherId = t.teacherId;


/**
  连接查询情况2：左连接
  格式 select 列 from 表1 left join 表2  on 表1.列= 表2.列
 */
# 获取所有的学生及其老师的信息
select *
from student s
         left join teacher t on s.myTeacherId = t.teacherId;
/**
 连接查询情况2：右连接
  格式 select 列 from 表1 right join 表2  on 表1.列= 表2.列
 */
# 获取所有老师和学生的信息
select *
from student s
         right join teacher t on s.myTeacherId = t.teacherId;

# 获取所有的学生和所有的老师的信息
select *
from student s
         left join teacher t on s.myTeacherId = t.teacherId
union
select *
from student s
         right join teacher t on s.myTeacherId = t.teacherId;


/**
  子查询 select中套select
 */

/**
  子select的位置：where后做条件
 */

select *
from student;
select *
from teacher;
#  获取分数最高的学生的信息
select max(studentScore)
from student;
# 获取最高分
select *
from student
where studentScore = (select max(studentScore) from student);
# 聚合函数不能出现在条件中


# 获取陈老师的所有学生的信息
select teacherId
from teacher
where teacherName = '李老师';
# 获取李老师的tid
select *
from student
where myTeacherId = (select teacherId from teacher where teacherName = '李老师');
# 查找

/**
  子select的位置2：from后面作为一张表
 */
# 获取陈老师的信息及其所有学生的信息
select *
from teacher
where teacherName = '李老师';
# 李老师的信息
select *
from student s,
     teacher t
where t.teacherName = '李老师'
  and s.myTeacherId = t.teacherId;

select *
from student s,
     (select * from teacher t where t.teacherName = '李老师') tc
where s.myTeacherId = tc.teacherId;

/**
  子select的位置3：在select后面
 */
#  获取所有学生的平均分，及其每个学生的信息，及其和平均分之间的差距
select avg(ifnull(studentScore, 0)) "平均分"
from student;
# 平均分
select ifnull(studentScore, 0) - (select avg(ifnull(studentScore, 0)) "平均分" from student) "差距"
from student;

# 差距
select (select avg(ifnull(studentScore, 0)) "平均分" from student)                           "平均分",
       ifnull(studentScore, 0) - (select avg(ifnull(studentScore, 0)) "平均分" from student) "差距",
       studentId,
       studentName,
       studentScore,
       myTeacherId
from student;

select (select avg(ifnull(studentScore, 0)) myavg from student)                     "平均分",
       ifnull(studentScore, 0) - (select avg(ifnull(studentScore, 0)) from student) "差距",
       studentId,
       studentName,
       studentScore,
       myTeacherId
from student;


/**
  在where后面作为条件时可以使用的运算符/关键字
  子查询可以使用的比较运算符 = != > >= < <= /=
    比较运算符适用于：子查询获取的是单值
 */
#  获取所有比张三分数高的人的信息
select *
from student
where studentScore > (select studentScore from student where studentName = '张三' limit 0,1);
/**
  子查询可以使用的关键字 any、all
 */
#  获取所有比叫张三的分数高的信息
select *
from student
where studentScore > all (select studentScore from student where studentName = '张三');
# 获取任意个比叫张三的分数高的信息
select *
from student
where studentScore > (select min(studentScore) from student where studentName = '张三');
select *
from student
where studentScore > any (select studentScore from student where studentName = '张三');

/**
  子查询可以使用关键字 in, not in
 */
#  获取和任意一个叫张三的学生分数相同的学生的信息
select *
from student
where studentScore in (select studentScore from student where studentName = '张三')
  and studentName != '张三';
#  获取和任意一个叫张三的学生分数不相同的学生的信息
select *
from student
where studentScore not in (select studentScore from student where studentName = '张三')
  and studentName != '张三';
# 获取和3、5号相同分数并且相同老师的学生的信息
select myTeacherId, studentScore
from student
where studentId = 3
   or studentId = 5;
select *
from student s
where (studentScore, myTeacherId) in
      (select studentScore, myTeacherId from student where studentId = 3 or studentId = 5)
  and studentId != 3
  and studentId != 5;




