-- view
-- 基本概念
/*1.视图是一个虚拟表，其内容由查询定义。同真实的表
一样，视图包含列，其数据来自对应的真实表(基表)
2.视图和基表关系的示意图*/

/*
对视图的总结
1.视图是根据基表来创建的视图是虚拟的表
2.视图也有列，数据来自基表
3.通过视图可以修改基表的数据
4.基表的改变，也会影响到视图的数据
 */
/*视图的基本使用
1.创建视图
create view 视图名 as select语句;
2.更新视图
alter view视图名 as select语句;
3.查看创建视图指令
SHOW CREATE VIEW 视图名;
4.删除视图指令
drop view 视图名1,视图名2;
*/
-- 创建视图
create view emp_view
as
select
	emp_no,
	CONCAT(first_name, ' ', last_name) name,
	title job ,
	dept_no
from
	employees
join titles t
		using(emp_no)
join dept_emp de
		using(emp_no);
		
SELECT * from emp_view;	

-- 修改视图
-- update emp_view set name = 'jack' where emp_no = 10384;

-- 视图最佳实践
-- 1.安全。一些数据表有着重要的信息。有些字段是保密的，不能让用户直接看到。这
-- 时就可以创建一个视图，在这张视图中只保留一部分字段。这样，用户就可以查询
-- 自己需要的字段，不能查看保密的字段。
-- 2.性能。关系数据库的数据常常会分表存储，使用外键建立这些表的之间关系。这时
-- 数据库查询通常会用到连接（JOIN）。这样做不但麻烦，效率相对也比较低。如果
-- 建立一个视图，将相关的表和字段组合在一起，就可以避免使用JOIN查询数据。
-- 。
-- 3.灵活。如果系统中有一张旧的表，这张表由于设计的问题，即将被废弃。然而，很
-- 多应用都是基于这张表，不易修改。这时就可以建立一张视图，视图中的数据直接
-- 映射到新建的表。这样，就可以少做很多改动，也达到了升级数据表的目的。


alter view emp_view as
select
	emp_no,
	CONCAT(first_name, ' ', last_name) name,
	title job ,
	salary,
	dept_no
from
	employees
join titles t
		using(emp_no)
join dept_emp de
		using(emp_no)
join salaries
		using(emp_no);
		
SELECT * from emp_view;	

