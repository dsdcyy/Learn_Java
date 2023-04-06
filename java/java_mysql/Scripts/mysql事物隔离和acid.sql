-- mysql事物隔离级别
/*事务隔离级别介绍
1.
多个连接开启各自事务操作数据库中数据时，数据库系统要负
责隔离操作，以保证各个连接在获取数据时的准确性。（通俗解释
如果不考虑隔离性，可能会引发如下问题：
脏读
不可重复读
幻读*/

/*查看事务隔离级别
』查看当前会话隔离级别select@@tx_isolation；8.0  select @@transaction_isolation;
+-------------------------+
| @@transaction_isolation |
+-------------------------+
| REPEATABLE-READ         |
+-------------------------+

脏读（dirtyread）：当一个事务读取另一个事务尚未提交的改变时，产生脏读
不可重复读（nonrepeatableread）：同一查询在同一事务中多次进行，由于其
·他提交事务所做的修改或删除，每次返回不同的结果集，此时发生不可重复读
幻读（phantomread）：同一查询在同一事务中多次进行，由于其他提交事务
所做的插入操作，每次返回不同的结果集，此时发生幻读。
*/
/*
 * mysql事务隔离级别
概念：Mysql隔离级别定义了事务与事务之间的隔离程度。
Mysql隔离级别 脏读 不可重复读 幻读 加锁读
读未提交（Read uncommitted) V V V 不加锁
读已提交（Read committed） X V V 不加锁
可重复读（Repeatable read) X X X 不加锁
可串行化（Serializable）演示 X X X 加锁
重开客户端]
 */
-- 设置事物隔离级别
-- SET SESSION transaction_isolation = 'READ-UNCOMMITTED'; 

-- 查询当前系统事物隔离级别
select @@global.transaction_isolation;
-- 设置当前系统事物隔离级别
-- set global transaction_isolation = '隔离级别';

/*
mysql事务ACID
事务的acid特性
原子性（Atomicity）
原子性是指事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生
一致性（Consistency)
事务必须使数据库从一个一致性状态变换到另外一个一致性状态
隔离性（Isolation）
事务的隔离性是多个用户并发访问数据库时，数据库为每一个用户开启的事
务，不能被其他事务的操作数据所干扰，多个并发事务之间要相互隔离。
持久性（Durability）
持久性是指一个事务一旦被提交，它对数据库中数据的改变就是永久性的
接下来即使数据库发生故障也不应该对其有任何影响
*/



