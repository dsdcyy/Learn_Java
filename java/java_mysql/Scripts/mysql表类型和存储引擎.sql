/*
 mysql表类型和存储引擎
基本介绍
1
MySQL的表类型由存储引擎（StorageEngines)
决定，主要包括MyISAM、
innoDB、Memory等。
2。
MySQL数据表主要支持六种类型，分别是：CSV、
Memory、ARCHIVE.
MRG MYISAM.MYISAM.InnoBDB.
3.
这六种又分为两类，一类是”事务安全型”（transaction-safe)，比如：
InnoDB；其余都属于第二类，称为”非事务安全型”
Cnon-transaction-
safe)Imysiam 和 memoryl。
显示当前数据库支持的存储引擎：show engines:engines.sq
show engines:
 */
/* 细节说明
我这里重点给大家介绍三种：MyISAM、InnoDB、MEMORY
1.MyISAM不支持事务、也不支持外键，但其访问速度快，对事务完整性没有要求
2.lnnoDB存储引擎提供了具有提交、回滚和崩溃恢复能力的事务安全。但是比起
MyISAM存储引擎，InnoDB写的处理效率差一些并且会占用更多的磁盘空间以保留
数据和索引。
3.MEMORY存储引擎使用存在内存中的内容来创建表。每个MEMORY表只实际对应
一个磁盘文件。MEMORY类型的表访问非常得快，因为它的数据是放在内存中的，
并且默认使用HASH索引。但是一旦服务关闭，表中的数据就会丢失掉，表的结构还
在。*/
/*
 * 如何选择表的存储引擎
1
如果你的应用不需要事务，处理的只是基本的CRUD操作，那么MyISAM
是不二选择，速度快
2.如果需要支持事务，选择lnnoDB。
3.
Memory存储引擎就是将数据存储在内存中，由于没有磁盘i/o的等待
速度极快。但由于是内存存储引擎，所做的任何修改在服务器重启后都将
消失。(经典用法用户的在线状态0).）
*/
-- 修改存储引擎
-- ALTER TABLE 表名 ENGINE=储存引擎;

 show engines;