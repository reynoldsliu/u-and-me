-- products 慶琳
-- 商品分類 --
create table product_category(
prodcat_id int primary key auto_increment,
prodcat_name varchar(10) not null
);

-- 商品 --
create table product(
prod_id int primary key auto_increment,
prodcat_id int not null,
prod_name varchar(20) not null,
prod_con varchar(1000),
prod_pri int not null,
prod_qty int,
prod_sta tinyint default 0 not null  not null comment '0:下架 1:上架',
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
prodpic_id int primary key auto_increment,
prod_id int not null,
prod_pic mediumblob,
constraint fk_prod_id
foreign key(prod_id) references product (prod_id) 
);

-- 購物車清單 --
create table cart_list(
cart_pri int not null,
cart_qty int not null,
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
(1, '戶外選品'),
(2, '在地美食'),
(3, '旅遊必備小物'),
(4, '流浪的意義');



select * from product_category;

select * from product;
insert into product(prod_id,prodcat_id,prod_name,prod_con,prod_pri,prod_qty,prod_spec)
values
(101,2,'日月潭紅茶','台茶18號，茶湯呈現典雅金紅色，茶香中帶有淡淡薄荷肉桂香氣，此香氣更被世界紅茶專家譽為日月潭紅茶特有之「台灣香」',699,0,1,'3入'),
(102,3,'設計師聯名款太陽眼鏡','UandMe與設計師太陽眼鏡款，擷取時尚與文化融入設計，絕對是旅行中不可或缺的配件 ',2999,2,1,'1入'),
(103,4,'大自然的氣息','工作繁忙沒辦法安排假期旅行嗎? 把大自然的氣息帶回去，讓你在家也能有沉浸式的旅行體驗',11111,10,1,'1入'),
(104,2,'冠軍烘培咖啡豆','COFFEE',1080,10,1,'2入'),
(105,1,'原住民手工編織包','BAGS',1680,10,1,'1入'),
(106,3,'多功能行動電源','POWERBANK',1080,10,1,'10入'),
(107,4,'質感手提行李箱','LUGGAGE',3680,10,1,'10入'),
(108,1,'手沖咖啡旅行組','COFFEEEEE',2980,10,0,'10入'),
(109,1,'露營必備裝飾燈串','LIGHT',480,10,0,'1入');


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

select * from product_picture;
insert into product_picture values (
1, 1, null
);
