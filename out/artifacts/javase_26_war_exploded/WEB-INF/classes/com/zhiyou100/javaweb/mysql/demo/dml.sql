/**
  dml 表记录的增删改
  dql 查询表的所有记录 select * from 表名;
 */
use db_266;
show databases;
show tables;
select *
from student2;
# 查询表的所有内容

/**
  添加记录1 insert into 表名 values(值1,值2,..); 注意：值必须和表结构一一对应
 */
insert into student2
values ('s002', '韩妹妹', '女', 10, 34.1, '2020-1-1', 'hello',
        load_file('https://gitee.com/Java1123yanglei/myImages/raw/master/uPic/bg2qQHpZ.jpg'), '2020-1-1', '河南省南阳市');
# 一般文件是记录url，不会上传文件到sql

/**
  添加记录2 insert into 表名 (列1,列2,...) values(值1,值2,..); 注意：要一一对应
 */
insert into student2 (id, score)
values ('s003', 20.21);
insert into student2 (id, score)
values ('s004', 30.43),
       ('s005', 54.34),
       ('s006', 98.9);
# 添加多行指定字段的数据
select *
from student2;

/**
  删除记录

  全部删除
  delete from 表名  删除表
  TRUNCATE [TABLE] table_name 删除表

  删除指定行
  DELETE FROM table_name [WHERE 条件表达式]
 */
delete
from student2
where gender IS NULL;
# 删除性别是null的行
delete
from student2
where gender is not NULL;
# 删除性别不是null的行

/**
  修改记录
  UPDATE table_name SET field_name1 = 值1[,字段名2=值2,···] [WHERE 条件表达式]
 */
update student2 set age=30 where age<=30;
# 把student2 表中，年龄小于30的修改为30
update student2 set age=10,gender='男' where gender='女' and age<=30;
# 把student2 中的性别为女，并且age<=30的，age为10，gender为男

select * from student2;