/**
  约束 定义表结构时，用于保证数据完整性的关键字

  数据完整性：保证数据库中存储的数据尽可能的完整和一致

  数据完整性要求：
     数据正确无误(符合现实) ：如年龄>0 and 年龄<150
     同一个表格中数据的和谐统一： 学号和能重复
     不同表格之间的数据完整一致：学生表中记录的老师工号，必须在老师表中存在

  数据完整性的分类：
    域完整性(域指的是属性的值/列的值):: 性别只能是男/女
    实体完整性(表记录的完整性，行数据的一致统一) :: 是个人都有身份证，且不重复
    参照完整性(两个表的数据一致统一) :: 学生表中记录的老师工号，必须在老师表中存在
 */

#  约束1 not null 非空约束
create table tab_1(
    id int not null ,
    name varchar(4) not null
);

insert into tab_1 values (1,"王二");
INSERT INTO tab_1 values (2,null);
# Column 'name' cannot be null

# 约束2 default 默认约束
create table tab_2
(
    id int,
    name varchar(4) default "无名"
);

insert into tab_2(id) values(1);
insert into tab_2 values(2,null);
# 不指定name时，name是默认值
select * from tab_2;

# 约束3 唯一约束
create table tab_3
(
    id int,
    name varchar(4) unique
);
insert into tab_3 values (1,"1");
insert into tab_3 values (1,"1");
# 第二次执行
# Duplicate entry '1' for key 'tab_3.name'

# 约束4 check 检查约束(mysql不支持)
create table tab_4
(
    age int,
    check ( age>0 and age>120)
);
insert into tab_4 values (1);

# 约束5 primary key 主键约束 用于唯一标示当前记录
# 主键不能重复 等价于 unique
# 不能为null 等价于 not null
create table tab_5
(
    id int primary key
);

# 自增约束 auto_increment;
# 当主键不赋值/null时，自动赋值为最大值+1
# 表定义不正确；只能有一个自动列，并且必须将其定义为键
create table tab_6
(
    id int auto_increment primary key

);
show tables ;
create table tab_7
(
    id float auto_increment primary key
);
insert into tab_7 values (null);
insert into tab_7 values (101);
select * from tab_7;


/**
  约束的ddl
 */
create table tab_8
(
    id int
);
# ALTER TABLE table_name MODIFY field_name data_type; 修改字段的数据类型
alter table tab_8 modify id int primary key ;
# 添加主键约束
insert into tab_8 values (1);
insert into tab_8 values (null);
select * from tab_8;
alter table tab_8 modify id int null ;
desc tab_8;

alter table tab_8 drop primary key ;
# 删除主键约束

alter table tab_8 modify id int;
alter table tab_8 change id id float;
# 去掉非空约束


/**
  foreign key 外键约束
  a表中 引用b表的记录  在a表中定义一个列来引用b表的主键列
  a表中的此列---外键列，a表---从表，b表---主表
  如 在学生表中定义一列myTeacher  引用老师表的主键列teacherId
 */
show databases;

use db_266;
show tables ;

create table teacher
(
    id int primary key auto_increment,
    # 主键列 自增
    name varchar(4),
    subject varchar(10)
);

drop table Student;
# 创建表时定义外键约束的格式
# constraint 外键约束名 foreign key(外键列) references 主表名(主键列)
create table Student
(
    id int primary key auto_increment,
    # 主键列 自增
    name varchar(4),
    score float(4,1),
    myStudentId int,
    # 外键列引用teacher表中的主键teacherId
    constraint fk_1 foreign key (myStudentId) references teacher(id)
    # 设置外键约束
);

desc teacher;
desc Student;
#  外键约束 MUL
# 主键约束 PRI
select * from teacher;
select * from Student;
insert into teacher values (1001,'李老师','English');

insert into Student values (1,'yang',10.1,null);
# 外键约束特点1：可以为null
insert into Student values (2,'li',20.1,1001);
insert into Student values (3,'li',20.1,1001);
# 外键约束特点2：可以重复
insert into student values (1,'张',43.1,1002);
# 外键约束特点3：从表中外键列如果有值，此值必须在主键的主键列中存在
# Duplicate entry '1' for key 'student.PRIMARY'
# 不能添加student表中不存在的id
use db_266;
show tables ;
# 创建表之后添加外键约束
# ALTER TABLE students ADD CONSTRAINT fk_class_id FOREIGN KEY (class_id) REFERENCES classes (id);
alter table Student add constraint fk_1 foreign key (myStudentId) references teacher(id);
desc Student;
# 创建表之后删除外键约束
# ALTER TABLE students  DROP FOREIGN KEY fk_class_id;
alter table Student drop foreign key fk_1;


