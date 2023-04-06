/*
什么是事务
事务用于保证数据的一致性，它由一组相关的dml语句组成，该组的dml语句要么全
部成功，要么全部失败。如：转账就要用事务来处理，用以保证数据的一致性。

事务和锁
当执行事务操作时（dml语句），mysql会在表上加锁，防止其它用户改表的数据
这对用户来讲是非常重要的

mysql数据库控制台事务的几个重要操作(基本操作transaction.sql)
1.
start transaction | begin-- 开始一个事务

2.
savepoint保存点名--设置保存点

3.
rollbackto保存点名－-回退事务

4.
rollback--回退全部事务

5.
commit --提交事务，所有的操作生效,不能回退

细节：
1.
没有设置保存点
2.
多个保存点
3.
存储引擎
4.
开始事务方式
*/
CREATE table test_raid(
id int,
name varchar(20)
);

-- 开始事物
start transaction;
-- 设置保存点 a
savepoint a;
-- 插入一条数据
insert into test_raid values(1,'jack');
-- 设置保存点 b
savepoint b;
-- 插入一条数据
insert into test_raid values(2,'tom');
-- 查询表记录
select * from tmp.test_raid;
-- 回退到保存点 b rolback to a
rollback to b;
-- 回退到保存点 a;
rollback to a;
-- 回退到开始事物之前的状态 rollback
rollback;
-- 提交事物,提交后无法回退事物
commit;

/*回退事务
在介绍回退事务前，先介绍一下保存知（savepoint)保存点是事务中的点.用于取消
部分事务，当结束事务时，会自动的删除该事务所定义的所有保存点，
当执行回退事务时，通过指定保存点可以回退到指定的点，这里我们作图说明

提交事务
使用commit语句可以提交事务.当执行了commit语句子后，会确认事务的变化、结
束事务、删除保存点、释放锁，数据生效。当使用commit语句结束事务子后，其
它会话将可以查看到事务变化后的新数据*/

