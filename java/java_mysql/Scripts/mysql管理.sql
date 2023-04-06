/*Mysql管理
Mysql用户
mysql中的用户，都存储在系统数据库mysql中user表中

其中user表的重要字段说明：
1.host:
允许登录的“位置”，localhost表示该用户只允许本机登录，也可以指定ip地址，比如：192.168.1.100
2.user:用户名：
3.authentication_string：密码，是通过mysql的password0函数加密之后的密码*/

-- 创建用户
-- create user '用户名’@ '允许登录位置' identified by'密码';
CREATE user 'ljw'@'localhost' identified by '123';
-- 说明：创建用户，同时指定密码
-- 
-- 删除用户
-- drop user '用户名' @ '允许登录位置';

-- 查看用户
SELECT * from mysql.`user`;

/*用户修改密码
修改自己的密码：
set password = password（密码）;
修改他人的密码(需要有修改用户密码权限）：
set password for'用户名@?登录位置’=password（密码;*/

/*给用户授权
基本语法：
grant 权限列表 on 库.对象名 to '用户名' @ ’登录位置' [identified by '密码']
说明：
1 权限列表，多个权限用逗号分开
grant select on ...
grant select, delete, create on ...
grant all [privileges] on ...
/表示赋予该用户在该对象上的所有权限;
2.特别说明
*,*：代表本系统中的所有数据库的所有对象(表，视图，存储过程)
库.*：表示某个数据库中的所有数据对象(表，视图，存储过程等）
3.identified by可以省略，也可以写出
（1)如果用户存在，就是修改该用户的密码。
（2)如果该用户不,就是创建该用户！*/

/*回收用户授权
基本语法：
revoke 权限列表 on 库.对象名 from'用户名'@'登录位置'；
权限生效指令
如果权限没有生效，可以执行下面命令
基本语法：
FLUSH PRIVILEGES;*/

grant SELECT ,create on employees.* to 'ljw'@'localhost';

revoke all on employees.* from 'ljw'@'localhost';

-- FLUSH PRIVILEGES;

/*
 在创建用户的时候，如果不指定Host，则为%，%表示表示所有IP都有连接权限
create user xxx:
你也可以这样指定
createuser'xxx"@"192.168.1.%”表示xxx用户在192.168.1.*的ip可以登录mysql
在删除用户的时候，如果host不是%，需要明确指定 '用户‘@’host‘值
*/
