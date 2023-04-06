-- mysql作业
-- 显示所有雇员名及其全年年收入 13月（工资+补助）,并且指定列别名‘年收入’
SELECT
	CONCAT(first_name, ' ', last_name) name,
	salary * 13 年收入
from
	employees e
join salaries s
		using(emp_no);  
		
-- 4.限制查询数据。
-- （1）显示工资超过60000的雇员姓名和工资。
SELECT
	CONCAT(first_name, ' ', last_name) name,
	salary
from
	employees e
join salaries s
		using(emp_no)
WHERE
	s.salary > 60000;  	
	
-- （2）显示工资不在1500到2850之间的所有雇员名及工资
SELECT
	CONCAT(first_name, ' ', last_name) name,
	salary
from
	employees e
join salaries s
		using(emp_no)
WHERE
	s.salary not BETWEEN 50000 and 70000;
-- （3）显示编号为30000的雇员姓名及所在部门编号。
SELECT
	e.emp_no ,
	CONCAT(first_name, ' ', last_name) name,
	dept_no
from
	employees e
join dept_emp de
		using(emp_no) WHERE e.emp_no = 30000;	
-- （4）显示部门d001和d003中工资超过50000的雇员名及工资。
SELECT
	CONCAT(first_name, ' ', last_name) name,
	s.salary
from
	employees e
join salaries s
		using(emp_no)
join dept_emp de
		using(emp_no)
WHERE
	de.dept_no in ('d001', 'd003')
	and s.salary > 50000;
SELECT CONCAT(first_name, ' ', last_name) name from employees e order by name ;
-- 列出员工数大于20000人的部门
SELECT
	dept_no,
	COUNT(emp_no) nums
from
	dept_emp de
group by
	dept_no
having
	nums>20000; 
-- 列出薪资比Kyoichi Maliniak 多的所有员工

SELECT
	e.*,
	s.salary
from
	employees e
join salaries s
		using(emp_no)
WHERE
	s.salary > (
	SELECT
		MAX(s.salary) sal
	from
		salaries s
	join employees e
			using(emp_no)
	WHERE
		CONCAT(e.first_name , ' ', e.last_name) = 'Kyoichi Maliniak'

);
-- 列出所有’Engineer‘的姓名及其部门id

SELECT
	CONCAT(e.first_name , ' ', e.last_name) name ,
	de.dept_no
from
	employees e
join dept_emp de
		using(emp_no)
join titles t
		using(emp_no) where t.title = 'Engineer';
-- 列出最低薪资小于38850的各种工作
SELECT
	t.title,
	min(salary) min_sal
from
	salaries s
join titles t
		using(emp_no)
group by
	t.title
HAVING
	min_sal < 38850;

-- 列出在’doo9‘工作的员工的姓名

SELECT
	CONCAT(e.first_name , ' ', e.last_name) name
from
	employees e
join dept_emp de
		using(emp_no)
WHERE
	de.dept_no = 'd009';

-- 查询薪资大于全公司平均薪资的所有员工
SELECT
	e.*,
	s.salary
from
	employees e
join salaries s
		using(emp_nSELECT
		avg(s.salary)
	from
		salaries so)
WHERE
	s.salary > (
	SELECT
		avg(s.salary)
	from
		salaries s );