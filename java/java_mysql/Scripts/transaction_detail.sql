/*）事务细节讨论transaction_detail.sql
1。如果不开始事务，默认情况下，dml操作是自动提交的，不能回滚
2。如果开始一个事务，你没有创建保存点.你可以执行rollback，默认就是回退到
你事务开始的状态
3。你也可以在这个事务中(还没有提交时)创建多个保存点.比如：savepoint
aaa； 执行 dml, savepoint bbb；
4。你可以在事务没有提交前，选择回退到哪个保存点
5.mysql的事务机制需要innodb的存储引擎还可以使用，myisam不好使，
6。开始一个事务 start transaction|set autocommit=off|begin；*/
