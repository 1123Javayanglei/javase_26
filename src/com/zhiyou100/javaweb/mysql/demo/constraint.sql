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
