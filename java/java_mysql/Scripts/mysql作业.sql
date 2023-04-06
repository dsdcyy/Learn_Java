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
		
-- 列出薪资大于'd001'部门所有员工的薪资的员工姓名和薪资
SELECT
	CONCAT(e.first_name , ' ', e.last_name) name,s.salary 
from
	employees e
join salaries s
		using(emp_no)
WHERE
	s.salary >(
	SELECT
		max(s.salary)
	from
		salaries s
	join dept_emp de
			using(emp_no)
	WHERE
		de.dept_no = 'd001'
);
-- 列出每个部门工作的人数和平均薪资
SELECT
	de.dept_no ,
	COUNT(DISTINCT de.emp_no) nums,
	AVG(s.salary) avg_sal
from
	dept_emp de
join salaries s
		using(emp_no)
group by
	de.dept_no ;

-- 列出各种工作的最低工资
SELECT
	t.title ,
	min(s.salary)
FROM
	titles t
join salaries s using(emp_no)
group by
	t.title ;
use tmp;

CREATE table departments
(
    departmentid int primary key,
    deptname     varchar(100) unique not null
);

CREATE table class
(
    classid    int primary key,
    subject    varchar(100),
    deptname   varchar(100),
    enrolltime int,
    nums       int,
    foreign key (deptname) references departments (deptname)
);

create table students
(
    studentid int primary key,
    name      varchar(100) not null default '',
    age       int          not null,
    classid   int,
    foreign key (classid) references class (classid)
);

insert into departments
values (001, '数学'),
       (002, '计算机'),
       (003, '化学'),
       (004, '中文'),
       (005, '经济');
insert into class
values (101, '软件', '计算机', 1995, 20),
       (102, '微电子', '计算机', 1996, 30),
       (111, '无机化学', '化学', 1995, 29),
       (112, '高分子化学', '化学', 1996, 25),
       (121, '统计数学', '数学', 1995, 20),
       (131, '现代语言', '中文', 1996, 20),
       (141, '国际贸易', '经济', 1997, 30),
       (142, '国际金融', '经济', 1996, 14);

insert into students
values (8101, '张三', 18, 101),
       (8102, '钱四', 16, 121),
       (8103, '王玲', 17, 131),
       (8105, '李飞', 19, 102),
       (8109, '赵四', 18, 141),
       (8110, '李可', 20, 142),
       (8201, '张飞', 18, 111),
       (8302, '周瑜', 16, 112),
       (8203, '王亮', 17, 111),
       (8305, '董庆', 19, 102),
       (8409, '赵龙', 18, 101),
       (8510, '李丽', 20, 142);
-- =查询姓李的学生
SELECT * from students WHERE name like '李%';
-- 查找开设专业超过一个的系
SELECT count(subject) nums from class group by deptname HAVING nums>1; 
-- 列出人数大于30的系的编号和名字
SELECT
	departmentid,
	stu_num
from
	departments d
join (
	SELECT
		deptname,
		sum(nums) stu_num
	from
		class c
	group by
		c.deptname
	having
		stu_num> 30) b
		using(deptname);
-- 增加系
insert into departments
values (006, '物理系');
-- 学生退学
begin;
UPDATE
	class
set
	nums = nums-1
WHERE
	classid = (
	SELECT
		classid
	from
		students
	WHERE
		name = '张三');
delete
from students
where name = '张三';
SELECT '张三退学成功...';
commit;
SELECT * from class c  ;
SELECT * FROM  students;


