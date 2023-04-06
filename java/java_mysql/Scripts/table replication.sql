-- 表复制 table replication
-- 创建查询出来的表
create table max_salary_emp_info(

	SELECT
	emp_no,
	a.dept_no,
	name,
	salary
from
	(
	SELECT
		emp_no,
		dept_no,
		CONCAT(first_name, ' ', last_name) name,
		salary
	from
		employees e2
	join dept_emp de2
			using(emp_no)
	join salaries s2
			using (emp_no)) a,
	(
	select
		dept_no,
		max(salary) max_salary
	from
		dept_emp de
	join employees e
			using(emp_no)
	join salaries s
			using(emp_no)
	group by
		dept_no) b
where 
	a.dept_no = b.dept_no
	and a.salary = b.max_salary
);

-- 自我复制 
INSERT into max_salary_emp_info select * from max_salary_emp_info ;

-- 实现去重

-- 复制其它表结构
CREATE table max_salary_emp_info_2 like max_salary_emp_info;

-- 获得去重表数据
INSERT into max_salary_emp_info_2 SELECT DISTINCT * from max_salary_emp_info;

-- 清除原表信息
DELETE from max_salary_emp_info;

-- 从表2重新写回数据给原表
INSERT into max_salary_emp_info SELECT * from max_salary_emp_info_2;

-- 删除临时表
drop table max_salary_emp_info_2;
