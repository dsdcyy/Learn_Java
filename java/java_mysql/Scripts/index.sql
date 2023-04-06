/*mysql素引
说起提高数据库性能，索引是最物美价廉的东西了。不用加内存，不
用改程序，不用调sql，查询速度就可能提高百倍干倍。
·这里我们举例说明索引的好处【构建海量表8000000】（快速体验案例index.sql）
是不是建立一个索引就能解决所有的问题
ename上没有建立索引会怎样？
select * from emp where ename=
axJxC';*/
-- explain 可以查看查询是否走索引
explain SELECT * from employees e  where emp_no  = 50034;
-- 创建索引,索引会占用存储空间
CREATE index employees_index on employees(emp_no);
-- 索引只对使用了索引的列有效

/*索引的原理
没有索引为什么会慢？
使用素引为什么会快？
素引的代价
l.磁盘占用
2.对dml(update delete insert)语句的效率影响*/

/*索引的类型
1. 主键索引，主键自动的为主索引（类型Primarykey)
2. 唯一索素引(UNIQUE)
3.普通索引（INDEX)
4.全文索引（FULLTEXT[适用于MyISAM]
开发中考虑使用：全文搜索Solr和ElasticSearch（ES)*/


/*索引使用
1.添加索引(建小表测试id，name）index_use.sql
create [UNIQUE] index index_name on tblname(col_name[(length])[ASC][DESC]..）；
alter table table_name ADD INDEX [index_name] (indexcol name....
2.添加主键（索引）ALTER TABLE 表名 ADD PRIMARY KEY(列名)
3.删除索引
DROP INDEX index name ON tbl_name
alter table table_name drop index index_name:
4.删除主键索引比较特别：
alter table t_b drop primary key:
*/

 
-- 添加唯一索引 unique index
-- CREATE unique index id_index on employees(emp_no);

-- 添加普通索引 index
-- CREATE  index id_index on employees(emp_no);
-- alter table employees add index id_index (id);

-- 添加主键索引
-- CREATE table employees add primary key (id);

-- 删除索引
-- drop index id_index on employees;

-- 删除主键索引
-- alter table employees drop primary key;

-- 修改索引，先删除，在添加

-- 查看表的索引
show indexes from employees;
show index from employees;
show keys from employees;
desc employees;

/*小结：哪些列上适合使用素引
较频繁的作为查询条件字段应该创建索引
select * from emp where empno = 1
2.
唯一性太差的字段不适合单独创建索引，即使频繁作为查询条
件
select * from emp where sex ='男
3.更新非常频繁的字段不适合创建索引
select * from emp where logincount = 1
4.
不会出现在WHERE子句中字段不该创建索引*/


