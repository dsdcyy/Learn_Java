SELECT
	*
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
	dept_no;