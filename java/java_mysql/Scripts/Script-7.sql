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
