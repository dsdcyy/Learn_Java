-- current_date() 返回当前日期
SELECT current_date(); 

-- CURRENT_TIME() 返回当前时间
SELECT CURRENT_TIME(); 

-- CURRENT_TIMESTAMP() 返回当前时间戳
SELECT CURRENT_TIMESTAMP(); 

-- now()返回当前时间
SELECT now();

-- date(datetime) 返回时间的日期部分
SELECT date(now());

-- DATE_ADD(date,interval d_value d_type) 时间加法计算 INTERVAL 10 minute 10分钟
SELECT DATE_ADD(now(),INTERVAL 10 minute) ;

-- DATE_ADD(date,interval d_value d_type) 时间减法计算
SELECT DATE_SUB(now(),INTERVAL 10 minute) ;

-- DATEDIFF 返回日期相差天数
-- 计算日期天数差 你活到80睡还剩多少天
SELECT
	DATEDIFF(DATE_ADD('1998-10-10', INTERVAL 80 year) , now()) ;

SELECT TIMEDIFF('11:22:33','07:55:22');

-- year|month|day (datetime) 返回对应的值
SELECT year(now()),MONTH(now()),day(now());

-- unix_timetamp()返回1970-1-1的秒数
SELECT UNIX_TIMESTAMP(); 

-- unix_timetamp()秒数转换为指定格式的日期 '%Y-%m-%d %H:%i:%s'
SELECT FROM_UNIXTIME(1674905586,'%Y-%m-%d %H:%i:%s') ;

