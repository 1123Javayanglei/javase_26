/**
  ddl 表结构定义语言 
 */
show databases;
# 查看所有数据库
create database db_266 character set = 'utf8mb4';
# 创建数据库,编码集不能设置成utf8，要设置成urf8mb4
use db_266;
# 使用db_266 数据库
show variables like '%char%';
# 显示与当前数据库相关的的所有编码集
show tables;
# 查看表
create table tab_1
# 创建表
(

    id   int,
    name varchar(4),
    sex  char(1)
    #     如果不是最后一个字段，需要用 ',' 分隔
);
drop table tab_1;
# 删除tab_1

/**
  创建一个学生表，学号、姓名、性别、年龄、分数、出生年日、是否为党员、自我介绍、图片、注册时间
 */
use db_266;
create table student1(
                         id char(4),
                         name varchar(4),
                         gender char(1),
                         age tinyint,
                         score float(4,1),
                         birthday date,
                         selfIntroduction text,
                         image blob,
                         registrationTime datetime
);

desc  student1;
# 显示表结构
show columns from student1;
# 显示表结构

alter table student1 add  sdy boolean;
# 添加一列

alter table student1 drop sdy;
# 删除一列

alter table student1 rename to student2;
# 修改表名

desc student2;

alter table student2 add saddress varchar(100);

alter table student2 change saddress address varchar(50);
# 修改列名

alter table student2 change address address char(50);
# 修改列类型
alter table student2 modify address char(20);
# 修改列类型

