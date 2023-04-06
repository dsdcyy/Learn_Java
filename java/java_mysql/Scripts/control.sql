-- 流程控制函数 control
-- if(expr1,expr2,expr3) expr为判断,成立返回expr2,否则返回expr3 
SELECT if(FALSE ,2,3);

-- ifnull(expr1,expr2,expr3) 判断expr1是否为null,如果是，返回expr2,否则返回expr1
SELECT ifnull(1,2);

-- SELECT case when expr1 then expr2 when expr3 then expr4 else expr5 end;

SELECT case when true then 'jack'
				when false then 'tom'
				else 'marry' end h;

CREATE PROCEDURE test_loop(in count int)
BEGIN
		DECLARE var int DEFAULT 1;
		declare `sum` int default 0;
		loop_lable:LOOP
					set var = var + 1;
					set `sum`= `sum`+var;
					if var>=count THEN LEAVE loop_lable;
					END if;
		END loop loop_lable;
		SELECT `sum`;
END;

call test_loop(100);

SELECT
	b.dept_no,a.emp_no,a.name,a.salary
	from
	(
	SELECT
	e.emp_no ,CONCAT(last_name, ' ', first_name) name,
	s.salary
from
	employees e
join salaries s
		using(emp_no)
 ) a
join dept_emp  b
		using(emp_no)
order by
	b.dept_no,
	a.salary desc;
