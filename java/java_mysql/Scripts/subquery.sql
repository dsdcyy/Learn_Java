-- subquery 子查询
-- 
SELECT * from dept_emp a where dept_no  in (
	SELECT
	de.dept_no
from
	dept_emp de
join employees e
		using(emp_no)
where
	CONCAT(e.first_name, ' ', e.last_name) = 'Georgi Facello'
);

-- 223 查询每个部门中最高工资的员工的员工编号,部门编号,名字,薪资

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
		using (emp_no)
where
	(dept_no,
	salary) in (
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
		dept_no);

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
	and a.salary = b.max_salary;

-- all 比较的是所有结果

-- 查找大于d001部门的所有员工薪资的员工名字，薪资，部门编号
	
SELECT
	CONCAT(first_name, ' ', last_name) name,
	salary,
	dept_no
from
	employees e
join salaries s
		using(emp_no)
join dept_emp de
		using(emp_no)
where
	salary > all(
	SELECT
		salary
	from
		salaries s2
	join dept_emp de2
			using(emp_no)
	WHERE
		dept_no = 'd001') ;
	
-- 多列子查询	
-- = 只能比较返回一行数据的子查询
-- in 可以比较返回多行数据的子查询
-- 查询Itzchak Ramaiah所在的部门和工作	的其它部门员工
SELECT
	emp_no,
	dept_no,
	CONCAT(first_name, ' ', last_name) name,
	salary,
	title
from
	employees e2
join dept_emp de2
		using(emp_no)
join salaries s2
		using (emp_no)
join titles t
		using(emp_no)
where
	(dept_no,
	title) in (
	SELECT
		de.dept_no,
		t.title
	from
		dept_emp de
	join titles t
			using(emp_no)
	join employees e
			using(emp_no)
	where
		CONCAT(e.first_name, ' ', e.last_name)= 'Itzchak Ramaiah')
AND  
	CONCAT(first_name, ' ', last_name) != 'Itzchak Ramaiah';

-- 查找所有高于本部门平均薪资的本部门员工信息

SELECT
	e2.emp_no,
	dept_no,
	CONCAT(first_name, ' ', last_name) name,
	salary,
	title,
	a.avg_salary
from
	employees e2
join dept_emp de2
		using(emp_no)
join salaries s2
		using (emp_no)
join titles t
		using(emp_no)
join (
	SELECT
		de.dept_no,
		avg(salary) avg_salary
	from
		salaries s
	join dept_emp de
			using(emp_no)
	GROUP by
		de.dept_no) a
		USING (dept_no)
where
	salary > a.avg_salary;

-- 查询每个部门工资最高的人员信息

SELECT
	e2.emp_no,
	dept_no,
	CONCAT(first_name, ' ', last_name) name,
	salary,
	title
from
	employees e2
join dept_emp de2
		using(emp_no)
join salaries s2
		using (emp_no)
join titles t
		using(emp_no)
WHERE (dept_no,salary) in (SELECT
		de.dept_no,
		max(salary) max_salary
	from
		salaries s
	join dept_emp de
			using(emp_no)
	GROUP by
		de.dept_no);
	
-- 查询每个部门的信息，部门编号,人数
SELECT
	dept_no,
	COUNT(emp_no) 人数
from
	dept_emp de
join employees e
		using(emp_no)
group by
	dept_no
order by
	人数 desc;
	
