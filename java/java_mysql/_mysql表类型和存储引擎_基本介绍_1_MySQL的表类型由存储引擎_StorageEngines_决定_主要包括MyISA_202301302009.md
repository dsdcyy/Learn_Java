|Engine|Support|Comment|Transactions|XA|Savepoints|
|------|-------|-------|------------|--|----------|
|ndbcluster|NO|Clustered, fault-tolerant tables||||
|FEDERATED|NO|Federated MySQL storage engine||||
|MEMORY|YES|Hash based, stored in memory, useful for temporary tables|NO|NO|NO|
|InnoDB|DEFAULT|Supports transactions, row-level locking, and foreign keys|YES|YES|YES|
|PERFORMANCE_SCHEMA|YES|Performance Schema|NO|NO|NO|
|MyISAM|YES|MyISAM storage engine|NO|NO|NO|
|ndbinfo|NO|MySQL Cluster system information storage engine||||
|MRG_MYISAM|YES|Collection of identical MyISAM tables|NO|NO|NO|
|BLACKHOLE|YES|/dev/null storage engine (anything you write to it disappears)|NO|NO|NO|
|CSV|YES|CSV storage engine|NO|NO|NO|
|ARCHIVE|YES|Archive storage engine|NO|NO|NO|
