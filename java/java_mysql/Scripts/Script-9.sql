-- check 约束

CREATE table test_check
(
    id   int primary key,
    name varchar(32),
    sex  char(1) check (sex in ('男', '女'))
);
-- 添加数据
INSERT into test_check values(1,'张三','男'),(2,'小红','女');

SELECT * from test_check;
