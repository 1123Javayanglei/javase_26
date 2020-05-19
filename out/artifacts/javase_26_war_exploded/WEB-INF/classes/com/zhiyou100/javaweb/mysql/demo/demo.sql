show databases;
use homework;
show tables;

create table demo
(
    id      int primary key auto_increment,
    time    time,
    day     date,
    dayTime datetime
);

insert into demo
values (101, now(), now(), now());

select * from demo;