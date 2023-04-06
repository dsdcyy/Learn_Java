-- test

-- 商品数据库

/*·商店售货系统表设计案例[先练，再评]
现有一个商店的数据库shop_db，记录客户及其购物情况，由下面三个表组成：
商品goods（商品号goods_id，商品名goods_name，单价unitprice，商品类别
category，供应商provider)；
客户customer（客户号customer_id,姓名name,任址address,电邮email性别sex,身
份证card_ld)；
购买purchase（购买订单号order_id，客户号customer_id,商品号goods_id,购买数
量nums)；
1建表，在定义中要求声明［进行合理设计]:
(1)每个表的主外键;
(2)客户的姓名不能为空值；
店
(3)电邮不能够重复；
SALE
(4)客户的性别[男女]
(5)单价unitprice在1.0-9999.99之间check*/

create database if not EXISTS shop_db
    default character set utf8mb4
    default collate utf8mb4_general_ci;
    
use shop_db;

CREATE table goods
(
    goods_id     int primary key,
    goods_name   varchar(255)                                                 not null default '',
    `unit-price` decimal(6, 2) check ( `unit-price` between 1.0 and 9999.99 ) not null default 0.00,
    category     int                                                          not null default 0,
    provider     varchar(255)                                                 not null default ''

);

create table customer
(
    customer_id char(8) primary key,
    name        varchar(255)        not null default '',
    address     varchar(255),
    email       varchar(255) unique not null default '',
    sex         char(1) check ( sex in ('男', '女') ),
    -- sex enum('男','女') not null,
    card_id     char(18)


);

create table purchase
(
    order_id    int unsigned primary key,
    customer_id char(8) not null,
    goods_id    int     not null,
    nums        int     not null default 0,
    foreign key (`customer_id`) references customer (customer_id),
    foreign key (`goods_id`) references goods (goods_id)
);