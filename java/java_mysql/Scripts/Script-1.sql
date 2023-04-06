
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