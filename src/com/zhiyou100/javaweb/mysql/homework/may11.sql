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
drop table worker;
create table worker
(
    id               char(4),
    name             varchar(10),
    salary           float(20, 6),
    gander           char(1),
    birthday         date,
    isItAPartyMember boolean,
    department       char(3) comment '部门'
# comment 注释
);
# 创建表：worker: wid wname wsalary wsex wbirthday wdy(是不是党员)
insert into worker
values ('s001', '张三', 2000, '男', '2020-10-1', false, '销售部'),
       ('s002', '李四', 3000, '男', '2020-10-3', false, '销售部'),
       ('s003', '王五', 4000, '男', '2020-10-3', true, '销售部'),
       ('s004', '王路', 2100, '男', '2020-10-3', true, '教学部'),
       ('s005', '王舞', null, '女', '2020-10-3', false, '教学部'),
       ('s006', '赵六', 5000, '男', '2020-10-3', true, '教学部'),
       ('s007', '赵四', 6000, '女', '2020-10-3', false, null),
       ('s008', '王富贵', 7000, '男', '2020-10-3', true, '人事部'),
       ('s009', '李狗蛋', 8000, '女', '2020-10-3', false, '人事部'),
       ('s010', '李瞬水', null, '男', '2020-10-3', false, '人事部');
insert into worker
values ('s011', '张三1', 20000, '男', '2020-10-1', false, '销售部'),
       ('s012', '李四2', 30004, '男', '2020-10-3', false, '销售部'),
       ('s013', '王五3', 40003, '男', '2020-10-3', true, '销售部'),
       ('s014', '王路4', 21030, '男', '2020-10-3', true, '教学部'),
       ('s015', '王舞1', null, '女', '2020-10-3', false, '教学部'),
       ('s016', '赵六4', 50030, '男', '2020-10-3', true, '教学部'),
       ('s017', '赵四5', 60030, '女', '2020-10-3', false, null),
       ('s018', '王富5贵', 70300, '男', '2020-10-3', true, '人事部'),
       ('s019', '李狗1蛋', 80030, '女', '2020-10-3', false, '人事部'),
       ('s010', '李瞬1水', null, '男', '2020-10-3', false, '人事部');
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


/**
  作业：
  获取工资小于1200或者出生日期在1995年后的
  获取工资为null或者部门为null
  获取工资在10000到12000之间的
  获取名字为 张工或者苗工 或者 王工
  获取所有员工信息但是工资倒序，工资相同按年龄升序
  获取名字中含有2
  获取姓为苗的记录
  让素有员工自我介绍，我叫xx 工资xx，我是人
  所有女员工的工资+100
  获取总人数，最高工资，有工资的员工的平均工资，所有员工的普通工资
  获取男员工和女员工的总人数，最高工资
  获取部门信息：部门的名字 部门员工数 部门最高工资 平均工资
  获取每个部门男生的人数
  获取部门信息：部门的名字 部门员工数 部门最高工资 平均工资 要求：平均工资大于12000
 */

select *
from worker
where salary < 1200
   or birthday >= '1996-1-1';
# 获取工资小于1200或者出生日期在1995年后的
select *
from worker
where salary is null
   or department is null;
#   获取工资为null或者部门为null
select *
from worker
where salary between 10000 and 12000;
#   获取工资在10000到12000之间的
select *
from worker
where name like '_工';
#   获取名字为 张工或者苗工 或者 王工
select distinct name
from worker;
# 获取所有名字但不重复
select timestampdiff(year, '2001-11-23', curdate());
# 计算年龄
select *
from worker
order by salary desc, timestampdiff(year, birthday, curdate());
#   获取所有员工信息但是工资倒序，工资相同按年龄升序
select *
from worker
where name like '%2%';
#   获取名字中含有2
select *
from worker
where name like '苗%';
#   获取姓为苗的记录
select concat('我叫', name, '工资', salary, '我是', gander, '人')
from worker;
#   让所  有员工自我介绍，我叫xx 工资xx，我是人
update worker
set salary=salary + 100
where gander = '女';
#   所有女员工的工资+100
select count(*)                      as '总人数',
       max(salary)                   as '最高工资',
       (sum(salary) / count(salary)) as '有工资的的员工的平均工资',
       (sum(salary) / count(*))      as '所有员工的平均工资'
from worker;
#   获取总人数，最高工资，有工资的员工的平均工资，所有员工的普通工资
select count(gander = '男') as '男员工的总人数', count(gander = '女') as '女员工的总人数', max(salary) as '最高工资'
from worker;
#   获取男员工和女员工的总人数，最高工资
select department as '部门名字', count(*) as '部门的员工数', max(salary) as '部门的最高工资', sum(salary) / count(*) as '平均工资'
from worker
group by department;
#   获取部门信息：部门的名字 部门员工数 部门最高工资 平均工资
select department as '部门', count(gander = '男') as '男生的人数'
from worker
group by department;
#   获取每个部门男生的人数
select department as '部门名字', count(*) as '部门的员工数', max(salary) as '部门的最高工资', sum(salary) / count(*) as '平均工资'
from worker
group by department
having '平均工资' > 12000;
#   获取部门信息：部门的名字 部门员工数 部门最高工资 平均工资 要求：平均工资大于12000


/**
  查询语句 查询条件 分组 组条件 排序 分页

  获取每个部门男生的人数和平均工资，只要平均工资大于8000 按人数倒序，只显示前三名
 */
select count(gander='男') "人数", department "部门", avg(ifnull(salary, 0)) "平均工资"
from worker
group by department
having avg(ifnull(salary,0))>8000
order by count(gander='男') desc
limit 0,3;

/*
select 列/聚合数据
from 表
where 行条件
group by 分组列
having 组条件
order by 排序列1 desc/asc,排序列2 desc/asc
limit start,end;
*/