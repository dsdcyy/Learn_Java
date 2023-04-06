-- encryption 加密函数

-- user() 当前用户
SELECT user();

-- DATABASE() 当前使用的数据库
SELECT DATABASE();

-- md5(str) 为字符串计算出md5 32的字符转，用于加密
SELECT md5('123');

CREATE table users_encryption(
	id int,
	name varchar(32) not null default '',
	pwd char(32) not null default ''
);

SELECT * from users_encryption;

-- mysql默认使用的加密 password
SELECT PASSWORD('ljw');
