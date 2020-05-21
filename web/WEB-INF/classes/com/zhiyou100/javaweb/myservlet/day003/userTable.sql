show databases;
# 查看数据库
use Demo001;
# 使用Demo001数据库
show tables;
# 查看表
create table tab_user
(
    userId       int primary key auto_increment,
    userName     varchar(11),
    userPassword char(6),
    userGender   char(1),
    userScore    int default 0
);
# 创建表
insert into tab_user (userId, userName, userPassword, userGender, userScore)
values
       (1001, '韩梅梅', '1234', '女', 100),
       (null, '韩非子', '1234', '女', 200),
       (null, '韩学', '1234', '女', 120),
       (null, '韩更', '1234', '女', 140)
       ;
# 插入数据
select * from tab_user;

select * from tab_user where userName='h' and userPassword='242';

