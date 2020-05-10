/*
 单表查询
 */
show databases;
use db_266;
show tables;
drop table student1;

insert into student1(id, name, age, gender, score)
values ('s110', '张三', 18, '男', 30.4);

select *
from student1;
# 查询所有列 SELECT * FROM tabName
select id, name, age
from student1;
# SELECT fieldName1,fieldName2,... FROM tabName   查询指定字段名

select distinct id, name
from student1;
# 去除重复结果 distinct
/**
  聚合函数
			SELECT COUNT(*) FROM tableName
				COUNT()函数
			SELECT SUM(字段名) FROM tableName
				SUM()函数
			SELECT AVG(字段名) FROM tableName
				AVG()函数
			SELECT MAX(字段名) FROM tableName
				MAX()函数
			SELECT MIN(字段名) FROM tableName
				MIN()函数
		对查询结果进行排序
 */
select count(*), max(score), min(score), avg(age), sum(score)
from student1;
/**
  注意1 max min avg sum 只能操作数字类型的列
  注意2 count(*) 获取总记录数
  注意3 count(列名) 获取非null的记录数
  注意4 avg(列名) 获取非null的所有记录的此列的平均值
  注意4 聚合函数只能是一行数据
 */

/**
  5 别名
  原名 as 别名
  as 可以省略，别名可以加上双引号
 */
select name as myName, id as myId
from student1;
select name "名字", id "id"
from student1;
select name "名字", id "学号"
from student1 s
where s.score > 50;
# 给表起别名

/**
  6 字符串模糊查询：like
  %表示0到多个字符,_表示一个字符
 */
select *
from student1;
select *
from student1
where name like '张_';
# 查询 名字叫 张某 的人
/**
  7 分页查询 ： limit a,b 获取从a条开始总共b条记录
 */
select *
from student1
limit 0,3;
# 获取前三条
select *
from student1
limit 4,6;
# 获取第5到第10条记录

/**
  8 排序 order by 列名 desc/asc
 */
select *
from student1
order by score desc;
# 从高到底
select *
from student1
order by score asc;
# 从低到高 默认
select *
from student1
order by score desc, age asc;
# 分数从高到底，分数相同年龄从小到达

/**
  9 分组： group by 分组列   注意分组后，只能获取分组信息+聚合信息
 */
select gender "性别", count(*) "人数", max(score) "最高分", avg(age) "平均年龄"
from student1
group by gender;

/**
  10 列运算： 支持数字和字符串的简单运算
 */
select score, score + 1, score * 3, score / 3, score % 3
from student1;
# 获取分数+1的结果
update student1
set score=score + 1
where gender = '男';
# 所有男生分数+1

/**
  11 字符串连接运算
 */
select concat("我叫", "苗天宝", "，", "今年34岁了");
select concat('我叫', name, ",我是", "gender", "考了", score, "分！")
from student1;
select concat("hello", null);
# 所有数据和null运算，结果都是null

/**
  12 null 转换: ifnull(列名，值)      如果指定的列值为null，拿指定的值运算
 */
select concat("我的生日是", ifnull(birthday, '2020-1-1'))
from student1;
/**
  SELECT [DISTINCT] * | {fieldName1,fieldName2,...} FROM tableName
	无条件查询
		SELECT * FROM tabName
			查询所有字段名
		SELECT fieldName1,fieldName2,... FROM tabName
			查询指定字段名
	按条件查询
		SELECT * FROM tabName
 WHERE 条件表达式
			带关系运算符的查询
		SELECT * | fieldName FROM tabName   WHERE fieldName [NOT] IN (元素1,元素2,...)
			带in关键子的查询
		SELECT * | fieldName FROM tabName  WHERE fieldName [NOT]  BETWEEN 值1 AND 值2
			带BETWEEN AND 关键字
		SELECT * | fieldName FROM tabName  WHERE fieldName IS [NOT] NULL
			空值查询
		SELECT DISTINCT fieldName FROM tabName
			SELECT DISTINCT fieldName1,fieldName2,~ FROM tabName
				用于多个字段
			带DISTINCT关键字的查询语句 可以查询多个字段名，关系是&&
		SELECT *|{fieldName1,fieldName2~}  FROM tableName [NOT] LIKE '匹配字符串';
			带LIKE 关键字
		SELECT *|{fieldName1,fieldName2~~} FROM tableName WHERE 条件表达式1 AND 条件表达式2 [···AND 条件表达式 n];
			带 AND 关键字的多条件查询
		SELECT *|{fieldName1,fieldName2~~} FROM tableName WHERE 条件表达式1 OR 条件表达式2 [···OR 条件表达式 n];
			带 OR 关键字的多条件查询
		or 和 and一起用
	高级查询
		聚合函数
			SELECT COUNT(*) FROM tableName
				COUNT()函数
			SELECT SUM(字段名) FROM tableName
				SUM()函数
			SELECT AVG(字段名) FROM tableName
				AVG()函数
			SELECT MAX(字段名) FROM tableName
				MAX()函数
			SELECT MIN(字段名) FROM tableName
				MIN()函数
		对查询结果进行排序
 */

