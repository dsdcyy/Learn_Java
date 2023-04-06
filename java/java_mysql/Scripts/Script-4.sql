-- 流程控制函数 control
-- if(expr1,expr2,expr3) expr为判断,成立返回expr2,否则返回expr3 
SELECT if(10>2,2,3)l;

-- ifnull(expr1,expr2,expr3) 判断expr1是否为null,如果是，返回expr2,否则返回expr1

SELECT ifnull(1,2);