-- 部门平均工资前3的结果
SELECT
	dept_no 部门编号,
	count(emp_no) 部门人数,
	avg(salary) 部门平均薪资
from
	(
	select
		emp_no,
		salary,
		dept_no
	from
		employees e
	join salaries s
			using(emp_no)
	join dept_emp de
			using(emp_no) ) b
group by
	dept_no
ORDER by
	部门平均薪资 desc
limit 3;