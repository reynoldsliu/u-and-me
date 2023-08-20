-- products 慶琳
-- 商品分類 --
create table product_category(
prodcat_id int primary key,
prodcat_name varchar(10)
);

-- 商品 --
create table product(
prod_id int primary key,

prodcat_id int,

prod_name varchar(20),
prod_con varchar(1000),
prod_pri int,
prod_qty int,
prod_sta tinyint default 0,

prod_spec varchar(20)

-- constraint fk_prodcat_id
-- foreign key (prodcat_id) references product_category(prodcat_id)
);

-- 商品收藏明細 --
create table product_collection(
prod_id int,
mem_id int,
primary key (prod_id, mem_id)
-- constraint fk_prod_id
-- foreign key (prod_id) references product (prod_id),
-- constraint fk_mem_id
-- foreign key (mem_id) references members (member_id)
);

-- 商品圖片庫 --
create table product_picture(
prodpic_id int primary key,
prod_id int,
prod_pic mediumblob,
constraint fk_prod_id
foreign key(prod_id) references product (prod_id) 
);

-- 購物車清單 --
create table cart_list(
cart_pri int,
cart_qty int,
mem_id int,
prod_id int,
primary key (mem_id, prod_id)
-- constraint fk_mem_id
-- foreign key (mem_id) references members (member_id),
-- constraint fk_prod_id
-- foreign key (prod_id) references product (prod_id)
);

select * from product_category;
insert into product_category(prodcat_id,prodcat_name)
values
(001, '伴手禮'),
(002, '紀念品'),
(003, '特色小物'),
(004, '手作工藝'),
(005, '食品'),
(006, '旅行配件'),
(007, '北部'),
(008, '中部'),
(009, '南部'),
(010, '東部');


select * from product_category;

select * from product;
insert into product(prod_id,prod_name,prod_con,prod_pri,prod_qty,prod_spec)
values
(1,'太陽餅','台中名產',299,10,'10入'),
(2,'鐵觀音','貓空茶葉',999,10,'2入'),
(3,'日月潭紅茶','日月潭必買',799,10,'1入'),
(4,'南投國姓咖啡','台灣咖啡',1080,10,'10入'),
(5,'原住民編織包','原住民手作編織品',880,10,'10入'),
(6,'行動電源','旅行配件',980,10,'10入'),
(7,'轉接頭','旅行必備',199,10,'1入'),
(8,'衣物收納袋','旅行小物',220,10,'3入'),
(9,'行李吊牌','行李箱小物',300,10,'1入'),
(10,'剝皮辣椒','新鮮',200,10,'1入');


select * from product_collection;
insert into product_collection(prod_id,mem_id)
value
-- (1,1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

select * from cart_list;
insert into cart_list(cart_pri,cart_qty,mem_id,prod_id)
value
(299, 1, 1, 2),
(200, 3, 2, 2),
(150, 1, 3, 3),
(300, 4, 4, 4),
(120, 2, 5, 5),
(180, 1, 6, 6),
(250, 3, 7, 7),
(90, 2, 8, 8),
(270, 4, 9, 9),
(160, 3, 10, 10);
