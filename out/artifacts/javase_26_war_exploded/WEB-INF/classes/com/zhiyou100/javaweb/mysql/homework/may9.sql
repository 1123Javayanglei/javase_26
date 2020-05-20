/*
作业：创建一个数据库db_26_2  指定编码集utf-8
      删除数据库db_26_2
      创建一个数据库db_26_2  指定编码集utf-8
      使用数据库db_26_2
      创建表：worker: wid wname wsalary wsex wbirthday wdy(是不是党员)
      插入10条记录
      查询所有记录
      查询男工人的记录
      把女工人的工资统一更改为4000  并且生日值为空
      删除工资少于3000的工人
      删除所有记录
*/
create database db_26_2 character set 'utf8mb4';
# 创建一个数据库db_26_2  指定编码集utf-8
drop database db_26_2;
# 删除数据库db_26_2
create database db_26_2 character set 'utf8mb4';
# 创建一个数据库db_26_2  指定编码集utf-8
use db_26_2;
# 使用数据库db_26_2
create table worker
(
    id               char(4),
    name             varchar(10),
    salary           float(20, 6),
    gander           char(1),
    birthday         date,
    isItAPartyMember boolean
);
# 创建表：worker: wid wname wsalary wsex wbirthday wdy(是不是党员)
insert into worker
values ('s001', '张三', 2000, '男', '2020-10-1', false),
       ('s002', '李四', 3000, '男', '2020-10-3', false),
       ('s003', '王五', 4000, '男', '2020-10-3', true),
       ('s004', '王路', 2100, '男', '2020-10-3', true),
       ('s005', '王舞', 3100, '女', '2020-10-3', false),
       ('s006', '赵六', 5000, '男', '2020-10-3', true),
       ('s007', '赵四', 6000, '女', '2020-10-3', false),
       ('s008', '王富贵', 7000, '男', '2020-10-3', true),
       ('s009', '李狗蛋', 8000, '女', '2020-10-3', false),
       ('s010', '李瞬水', 9000, '男', '2020-10-3', false);
# 插入10条记录
select *
from worker;
# 查询所有记录
select *
from worker
where gander = '男';
# 查询男工人的记录
update worker
set salary=4000,
    birthday=null
where gander = '女';
# 把女工人的工资统一更改为4000  并且生日值为空
delete
from worker
where salary <= 3000;
#       删除工资少于3000的工人
truncate table worker;
#       删除所有记录