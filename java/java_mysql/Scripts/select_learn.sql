-- 查询每个部门的平均工资并且平均工资大于60000
SELECT
	a.dept_no,
	avg(b.salary) avg_salary
from
	dept_emp a
join salaries b
		using(emp_no)
group by
	a.dept_no
HAVING
	avg_salary > 60000;
-- charset(str) 返回字符串集
SELECT charset(last_name) from employees; 

-- concat(str1,str2,....) 拼接字符串
select CONCAT(last_name,'job is',' ',gender) from employees; 

-- dual 亚元表，测试使用

SELECT 1+2 from dual;

-- ucase 转大写
SELECT ucase(last_name) from employees;

-- LCASE 转小写
SELECT
	LCASE(last_name)
from
	employees;

-- left（str,length)） 从左边开启截取指定长度字符串
SELECT LEFT (last_name,1) from employees;

-- length(str) 获取字符串长度
SELECT LENGTH (last_name) from employees;

-- REPLACE(字段,替换的字符串,替换完的字符串) 将Staff替换为职员
SELECT
	a.last_name,
	REPLACE(b.title, 'Staff', '职员') job
from
	employees a
join titles b
		using(emp_no)
limit 10;

-- strcmp (str1,str2) 0 相同 1 不同
SELECT STRCMP('hsp','jsp') from dual;
SELECT STRCMP('hsp','hsp') from dual;

-- substring (str,pos,length) 在str上pos位置取出length长度的字符串
SELECT SUBSTRING('hello world',3,6) ;

-- ltrim(str) 去除字符串左边空格 rtrim(str)  去除字符串右边空格 trim(str) 去除字符串中所有空格
 SELECT LTRIM(' 韩顺平 ');
 SELECT RTRIM(' 韩顺平 ');
 SELECT LTRIM(' 韩顺平 ');

-- conv (值，进制，转换后的进制)
SELECT conv(8,10,2) ;

-- format(number,decimal_places) 四舍五入保留指定的小数位
SELECT FORMAT(78.45546,2) a;

-- least 找出最小的数
SELECT LEAST(0,-1,-10,4); 

-- rand 返回0-1之间的随机小数
SELECT RAND(3); 
-- seed 产生固定的随机数



-- 
