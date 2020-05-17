# 作业：1 创建老师表：属性 int tid,stirng tname,char tsex,float tsalary,boolean tdy,date tbirthday
show databases ;
use homework;

show tables ;

create table teacher
(
    id int,
    name varchar(10),
    gender char(1),
    salary float(10,3),
    isItAPartyMember boolean,
    birthday date
);

show tables ;
# date yyyy-mm-dd
select * from teacher;
insert into teacher
values (2,'杨2','女',10.1,false,now());

select * from teacher where gender='男';

# UPDATE table_name SET field_name1 = 值1[,字段名2=值2,···] [WHERE 条件表达式]
update teacher set salary=salary+10.5 where gender='男';
#  update teacher set salary=salary10.43where gender='男'
#  update teacher set salary=salary+10.43 where gender='男'


insert into teacher (id, name, gender, salary, isItAPartyMember, birthday) values (3,'张雷','男',65.8,true,'2001-11-23');
# insert into teacher (id, name, gender, salary, isItAPartyMember, birthday) values (3,张雷,男,65.8,true,2001-11-23)
select * from teacher;
# DELETE FROM table_name [WHERE 条件表达式]
delete from teacher where salary>=700;

select * from teacher;

use homework;

show tables ;


update teacher
set name ='张5' ,gender='男'  ,salary=19,isItAPartyMember=false,birthday=NOW()
where id=7;

show tables ;
create table user
(
    name varchar(10) primary key ,
    passWord varchar(10)
);

insert into user (name,passWord)
values ('韩梅梅','abc');

select * from user;



