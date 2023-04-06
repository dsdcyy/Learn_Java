
-- 建立主键索引
-- 1 在字段后增加主键约束
CREATE table `order1`
(
    id         int primary key auto_increment,
    goods_name varchar(100) not null default '',
    order_name varchar(100) not null default '',
    nums       int          not null default 0

);

-- 2.
CREATE table `order2`
(
    id         int,
    goods_name varchar(100) not null default '',
    order_name varchar(100) not null default '',
    nums       int          not null default 0

);
ALTER table order2 add primary key (id);

-- 2.
CREATE table `order3`
(
    id         int unique not null,
    goods_name varchar(100) not null default '',
    order_name varchar(100) not null default '',
    nums       int          not null default 0

);
CREATE table `order4`
(
    id         int ,
    goods_name varchar(100) not null default '',
    order_name varchar(100) not null default '',
    nums       int          not null default 0
);

CREATE unique index  uni_index on order4(id);
show index from `order4`;

CREATE table `order5`
(
    id         int ,
    goods_name varchar(100) not null default '',
    order_name varchar(100) not null default '',
    nums       int          not null default 0
);

alter table order5 add unique index uni_index(id);

show index from order5;

drop index id on order5;