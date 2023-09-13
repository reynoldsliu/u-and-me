-- last edit time: 2023-09-13/17:47

create schema main;
use main;
-- drop schema main;


-- members 許彤
create table members (
	mem_id int primary key auto_increment,
	mem_email varchar(30) UNIQUE not null,
	mem_password varchar(20) not null,
	mem_name varchar(10),
	mem_gender tinyint default 0 not null,  -- 0:不方便透露,1:男,2:女
	mem_city varchar(50),
	mem_dist varchar(50),
	mem_addr varchar(100) not null,
	mem_grade int,
    mem_idcard varchar(10),
    mem_idpic mediumblob,
	mem_phone varchar(15),
	mem_point int,
	mem_sta tinyint default 0 not null, -- 0:正常使用,1:停止使用,
	mem_group tinyint default 0 not null  -- 0:非團主,1:團主
);
select * from members;
INSERT INTO members (mem_id, mem_email, mem_password, mem_name, mem_gender, mem_city,mem_dist,mem_addr, mem_grade, mem_idcard,mem_phone, mem_point, mem_sta, mem_group)
VALUES
  (1,'member1@example.com', 'password1', '許彤彤', 2, '台北市','大安區','復興南路一段123號', 1,'A123456789','0911111111', 100, 1, 0),
  (2,'lynnchiang1220@gmail.com', 'password2', '姜小琳', 2, '新北市','板橋區','文化路二段456號', 2,'B123456789', '0922222222', 400, 0, 0),
  (3,'member3@example.com', 'password3', '陳安安', 2, '高雄市','鳳山區','中山西路789號', 1,'C123456789','0933333333', 550, 1, 0),
  (4,'member4@example.com', 'password4', '劉覽力辰', 1, '台中市','西屯區','文華路三段234號',1,'D123456789','0944444444', 300, 0, 1),
  (5,'member5@example.com', 'password5', '吳蓁蓁', 2, '桃園市','中壢區','永安南路五段567號', 2,'E123456789', '0955555555', 250, 1, 1),
  (6,'member6@example.com', 'password6', '朱小妹', 2, '新竹市','東區','光復路一段890號', 1,'F123456789','0966666666', 50, 0, 0),
  (7,'member7@example.com', 'password7', '斯斯', 1, '彰化縣','彰化市','中山路六段1234號', 3,'G123456789', '0977777777', 50, 1, 0),
  (8,'member8@example.com', 'password8', '阿黃', 0, '雲林縣','斗六市','明德路七段567號', 2,'H123456789', '0988888888', 180, 1, 0),
  (9,'member9@example.com', 'password9', '潘信隆', 2, '嘉義縣','太保市','中正路八段789號', 1,'I123456789', '0999999999', 120, 1, 1),
  (10,'member10@example.com', 'password10', '蕭阿彤', 1, '屏東縣','屏東市','建國路九段234號', 1,'J123456789', '0900000000', 80, 0, 1);
select * from members;

create table hosts (
	host_id int primary key auto_increment,
	host_phone varchar(15) UNIQUE,
	host_email varchar(30) UNIQUE not null,
	host_password varchar(20) not null,
	host_name varchar(10) not null,
	host_sta tinyint default 0 not null  -- 0:正常使用(在職)1:停止使用(停職)
);

select * from hosts;
INSERT INTO hosts (host_id,host_phone, host_email, host_password, host_name, host_sta)
VALUES
  (1,'123456789', 'host1@example.com', 'password1', '大衛師傅', 0),
  (2,'987654321', 'host2@example.com', 'password2', '大吳', 0),
  (3,'111222333', 'host3@example.com', 'password3', '朱佩佩', 0),
  (4,'444555666', 'host4@example.com', 'password4', '劉辰', 0),
  (5,'777888999', 'host5@example.com', 'password5', '吳小蓁', 0),
  (6,'555666777', 'host6@example.com', 'password6', '蕭彤彤', 1),
  (7,'999888777', 'host7@example.com', 'password7', '斯斯', 1),
  (8,'111333555', 'host8@example.com', 'password8', '陳小安', 0),
  (9,'666777888', 'host9@example.com', 'password9', '姜阿琳', 1),
  (10,'222333444', 'host10@example.com', 'password10', '許阿彤', 1);
select * from hosts;


create table group_register(
	mem_id int primary key,
	gr_idcard varchar(10),
	gr_idcard_pic mediumblob
	-- constraint fk_mem_id
    -- foreign key (mem_id) references members(mem_id)
);


-- create schema onlineshoppingmall;
-- use onlineshoppingmall;

 create table orders (
    ord_id int primary key auto_increment,
    mem_id int not null,
    points int,
    ord_fee int,
    recipient_phone varchar(15) not null,
    ord_pay_sta tinyint default 0 not null, -- 0:未付款,1:已付款
    recipient_name varchar(10),
    recipient_addr varchar(30),
    ord_sta tinyint default 0 not null, -- 0:未出貨,1:已出貨,2:已到貨,3:訂單完成,4:訂單取消
    total int,
    checktotal int,
    ord_time timestamp not null default current_timestamp
--  constraint fk_mem_id
--  foreign key(mem_id) references table_name(mem_id)
);
select * from orders;
INSERT INTO orders (ord_id, mem_id, points, ord_fee, recipient_phone, ord_pay_sta, recipient_name, recipient_addr, ord_sta, total, checktotal, ord_time)
VALUES
  (1, 1, 100, 50, '09111111111', 1, 'John', 'Address 1', 0, 150, 150, '2023-07-29 10:00:00'),
  (2, 2, 200, 80, '0922222222', 1, 'Jane', 'Address 2', 1, 280, 280, '2023-07-29 11:30:00'),
  (3, 3, 150, 40, '0933333333', 1, 'Bob', 'Address 3', 3, 190, 190, '2023-07-29 12:45:00'),
  (4, 4, 300, 120, '0944444444', 0, 'Alice', 'Address 4', 4, 420, 420, '2023-07-29 14:20:00'),
  (5, 5, 250, 90, '0955555555', 1, 'Michael', 'Address 5', 1, 340, 340, '2023-07-29 15:10:00'),
  (6, 6, 50, 20, '0966666666', 1, 'Emily', 'Address 6', 3, 70, 70, '2023-07-29 16:30:00'),
  (7, 7, 400, 150, '0977777777', 0, 'David', 'Address 7', 0, 550, 550, '2023-07-29 17:40:00'),
  (8, 8, 180, 60, '0988888888', 1, 'Karen', 'Address 8', 2, 240, 240, '2023-07-29 18:20:00'),
  (9, 9, 120, 40, '0999999999', 1, 'Tom', 'Address 9', 1, 160, 160, '2023-07-29 19:15:00'),
  (10, 10, 80, 30, '0900000000', 0, 'Sara', 'Address 10', 0, 110, 110, '2023-07-29 20:00:00');
select * from orders;


create table order_details(
	ord_id int,
    prod_id int,
    prod_qty int not null,
	prod_review varchar(50),
    prod_price int not null,
    prod_com_score decimal(2,1),
    primary key(ord_id, prod_id)
--  constraint fk_ord_id
--  foreign key(ord_id) references orders(ord_id),
--  constraint fk_prod_id
--  foreign key(prod_id) references product(prod_id)
    );
select * from order_details;
INSERT INTO order_details (ord_id, prod_id, prod_qty, prod_review, prod_price, prod_com_score)
VALUES
  (1, 101, 2, '溫暖又時尚，冬日必備!', 50, 4.5),
  (1, 102, 1, '高品質，百搭款式。', 30, 4.0),
  (2, 103, 3, '音質一流，舒適好聽。', 20, 4.2),
  (2, 104, 2, '容納一切，時尚又實用。', 25, 4.8),
  (3, 105, 1, '鋒利耐用，廚房必備！', 15, 3.5),
  (3, 106, 4, '超棒的商品品質', 40, 4.7),
  (4, 107, 2, '好實用!', 60, 4.9),
  (4, 108, 1, '購物愉快，回頭客。', 10, 3.9),
  (5, 109, 3, '超滿意，五顆星推薦！', 35, 3.0),
  (5, 110, 2, '熱銷商品，值得信賴。', 45, 4.4);
select * from order_details;



-- 揪團表格建立 宇航
-- create database uandme;
-- use uandme;
create table `group`
(
 group_id int primary key auto_increment,
    mem_id int not null,
    sch_id int not null,
    members int default 0,
    min_member int not null,
    max_member int not null,
    amount int not null,
    theme varchar(32) not null,
    start_date timestamp not null default current_timestamp,
    dep_date timestamp not null,
    deadline timestamp not null,
    group_desc varchar(200) not null,
    notice varchar(500) not null,
    group_sta tinyint not null default 0,
    payment_sta tinyint not null default 0,
    cover mediumblob
    -- constraint fk_mem_id
--     foreign key (mem_id) references members(mem_id),
--
--     constraint fk_sch_id
--     foreign key (sch_id) references schedules(sch_id)
);
insert into `group` values (
1, 1, 1, default, 10, 20,
100000, '緯育4月遊', '2023-03-22 00:00', '2023-05-15 00:00',
'2023-05-01 00:00', 'JAVA集訓營', '進入後肝可能變黑白的',default , 0, null
);
insert into `group`
values
    (101, 101, 201, 5, 3, 8, 1000, 'Hiking Trip', '2023-08-10 09:00:00', '2023-08-15 12:00:00', '2023-08-01 18:00:00', 'A fun hiking trip to the mountains', 'Bring your own water and snacks', 0, 0, null),
    (102, 102, 202, 4, 2, 6, 800, 'Beach Vacation', '2023-09-05 14:00:00', '2023-09-12 10:00:00', '2023-08-25 23:59:59', 'Relax and unwind at the sunny beach', 'Sunscreen is a must', 0, 0, null),
    (103, 103, 203, 6, 4, 10, 1200, 'City Tour', '2023-07-20 11:00:00', '2023-07-25 16:00:00', '2023-07-15 22:00:00', 'Explore the city and visit popular landmarks', 'Comfortable shoes are recommended', 0, 0, null),
    (104, 104, 204, 3, 2, 4, 600, 'Camping Adventure', '2023-08-28 15:00:00', '2023-09-02 09:00:00', '2023-08-20 20:00:00', 'Experience the great outdoors with camping', 'Bring your own tent and sleeping bag', 0, 0, null),
    (105, 105, 205, 7, 5, 12, 1500, 'Cruise Journey', '2023-10-15 13:00:00', '2023-10-25 18:00:00', '2023-10-01 19:00:00', 'Enjoy a luxurious cruise experience', 'Formal attire required for dinner', 0, 0, null),
    (106, 106, 206, 2, 2, 4, 400, 'Skiing Adventure', '2023-12-05 08:00:00', '2023-12-10 16:00:00', '2023-11-25 23:59:59', 'Hit the slopes and have fun skiing', 'Skiing equipment available for rent', 0, 0, null),
    (107, 107, 207, 8, 6, 15, 1800, 'Road Trip', '2023-09-30 10:00:00', '2023-10-10 14:00:00', '2023-09-15 18:00:00', 'Embark on an exciting road trip across the country', 'Prepare some road trip playlists', 0, 0, null),
    (108, 108, 208, 4, 3, 8, 1000, 'Photography Tour', '2023-11-12 09:00:00', '2023-11-18 17:00:00', '2023-11-01 23:59:59', 'Capture stunning landscapes and wildlife with photography', 'Bring your own camera gear', 0, 0, null),
    (109, 109, 209, 6, 4, 10, 1200, 'Foodie Adventure', '2023-10-05 12:00:00', '2023-10-15 20:00:00', '2023-09-25 23:59:59', 'Explore various cuisines and food spots', 'Come hungry and ready to eat', 0, 0, null),
    (110, 110, 210, 3, 2, 5, 700, 'Fishing Trip', '2023-11-25 07:00:00', '2023-11-28 15:00:00', '2023-11-15 19:00:00', 'Enjoy fishing in serene lakes and rivers', 'Fishing equipment will be provided', 0, 0, null);
select * from `group`;


create table reg_form
(
	form_id int primary key, -- auto_increment
    group_id int , -- not null
    mem_id int , -- not null
    email varchar(32) not null,
    phone varchar(13) not null,
    join_member int not null default 1,
    reg_time timestamp not null default current_timestamp
    -- constraint fk_mem_id
--     foreign key (mem_id) references members(mem_id),
--
--     constraint fk_group_id
--     foreign key (group_id) references `group`(group_id)
);
insert into reg_form values(
1, 1, 1, 'abc@gmail.com', '+886912345678', default, default
);
insert into reg_form (form_id, group_id, mem_id, email, phone)
values
(101, 101, 201, 'member1@example.com', '1234567890'),
(102, 102, 202, 'member2@example.com', '9876543210'),
(103, 103, 203, 'member3@example.com', '4567890123'),
(104, 104, 204, 'member4@example.com', '8901234567'),
(105, 105, 205, 'member5@example.com', '2345678901'),
(106, 106, 206, 'member6@example.com', '7890123456'),
(107, 107, 207, 'member7@example.com', '3456789012'),
(108, 108, 208, 'member8@example.com', '9012345678'),
(109, 109, 209, 'member9@example.com', '6789012345'),
(110, 110, 210, 'member10@example.com', '0123456789');

select * from reg_form;

create table member_detail
(
	detail_id int primary key auto_increment,
    form_id int not null,
    `name` varchar(32) not null,
    citizenship varchar(32) not null,
    idnumber char(10) not null,
    birthday date not null,
    gender enum('男','女') not null default '男',
	refund_sta tinyint not null default 0
--     constraint fk_form_id
--     foreign key (form_id) references reg_form(form_id)
);
insert into member_detail values(
1, 1, '李小明', '臺灣', 'A123456789', '2000-01-01',default, 0
);
insert into member_detail (detail_id ,form_id, `name`, citizenship, idnumber, birthday)
values
(2, 1, 'John Doe', 'USA', 'A123456789', '1990-05-15'),
(3, 2, 'Jane Smith', 'Canada', 'B987654321', '1985-08-20'),
(4, 3, 'Michael Johnson', 'Australia', 'C456789012', '1992-02-10'),
(5, 4, 'Emily Lee', 'South Korea', 'D890123456', '1988-11-05'),
(6, 5, 'David Wang', 'China', 'E234567890', '1995-07-30'),
(7, 6, 'Sophia Chen', 'Taiwan', 'F789012345', '1997-04-25'),
(8, 7, 'James Kim', 'South Korea', 'G345678901', '1987-09-12'),
(9, 8, 'Olivia Tan', 'Singapore', 'H901234567', '1991-03-08'),
(10, 9, 'William Ng', 'Malaysia', 'I678901234', '1993-06-18'),
(11, 10, 'Ava Wong', 'Hong Kong', 'J012345678', '1999-01-22');
select * from member_detail;


-- attractions景點相關表格建立 劉力辰
create table attractions (
attr_id int primary key auto_increment,
attr_veri_sta tinyint,-- deprecated
attr_sta int default 1,-- 預設上架
attr_name varchar(20) not null,
attr_addr varchar(100) not null,
attr_lon float,
attr_lat float,
attr_illa varchar(500),
attr_type varchar(10),
attr_buss_time varchar(200) default '09:00-18:00|09:00-21:00',
attr_cost_range tinyint,
attr_rep varchar(500) -- deprecated
);

-- 更換有效地址Reynolds
INSERT INTO attractions (attr_id, attr_veri_sta, attr_sta, attr_name, attr_addr, attr_lon, attr_lat, attr_illa, attr_type, attr_buss_time, attr_cost_range, attr_rep)
VALUES
  (1, 1, 3, 'Attraction 1', '123 Main St', 12.345, 67.890, 'Description for Attraction 1', '第一類', '9:00 AM - 5:00 PM', 2, 'Representative for Attraction 1'),
  (2, 0, 2, 'Attraction 2', '456 Park Ave', -45.678, 12.345, 'Description for Attraction 2', '第三類', '10:00 AM - 6:00 PM', 1, 'Representative for Attraction 2'),
  (3, 1, 1, 'Attraction 3', '789 Broad St', 98.765, -34.567, 'Description for Attraction 3', '第二類', '8:00 AM - 4:00 PM', 3, 'Representative for Attraction 3'),
  (4, 0, 3, 'Attraction 4', '567 Elm St', -12.345, -78.901, 'Description for Attraction 4', '第一類', '9:30 AM - 5:30 PM', 2, 'Representative for Attraction 4'),
  (5, 1, 2, 'Attraction 5', '234 Oak Ave', 23.456, 45.678, 'Description for Attraction 5', '第三類', '10:30 AM - 6:30 PM', 1, 'Representative for Attraction 5'),
  (6, 0, 1, 'Attraction 6', '678 Pine St', -56.789, 78.901, 'Description for Attraction 6', '第二類', '8:30 AM - 4:30 PM', 3, 'Representative for Attraction 6'),
  (7, 1, 3, 'Attraction 7', '890 Maple Ave', 34.567, -56.789, 'Description for Attraction 7', '第一類', '9:45 AM - 5:45 PM', 2, 'Representative for Attraction 7'),
  (8, 0, 2, 'Attraction 8', '123 Cherry St', -67.890, 98.765, 'Description for Attraction 8', '第三類', '10:45 AM - 6:45 PM', 1, 'Representative for Attraction 8'),
  (9, 1, 1, 'Attraction 9', '456 Plum Ave', 12.345, -12.345, 'Description for Attraction 9', '第二類', '8:45 AM - 4:45 PM', 3, 'Representative for Attraction 9'),
  (10, 0, 3, 'Attraction 10', '789 Orange St', -34.567, 23.456, 'Description for Attraction 10', '第一類', '9:15 AM - 5:15 PM', 2, 'Representative for Attraction 10');

select * from attractions;

create table attraction_collections (
attr_id int,
mem_id int,

primary key (attr_id, mem_id)
);

insert into attraction_collections(attr_id, mem_id)

values
(1,1);

-- select * from attraction_collections;
-- drop table attraction_collections;

-- drop table attraction_pictures;
create table attraction_pictures (
attr_pic_id int unsigned primary key auto_increment,
attr_id int,
-- constraint fk_attr_id
-- foreign key(attr_id) references attractions(attr_id),
attr_pic_data longtext
);


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

-- 暫時建的會員--


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
prod_pic mediumblob -- ,
-- constraint fk_prod_id
-- foreign key(prod_id) references product (prod_id)
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
(101,2,'日月潭紅茶','台茶18號，茶湯呈現典雅金紅色，茶香中帶有淡淡薄荷肉桂香氣，此香氣更被世界紅茶專家譽為日月潭紅茶特有之「台灣香」',699,10,'3入'),
(102,3,'設計師聯名款太陽眼鏡','UandMe與設計師太陽眼鏡款，擷取時尚與文化融入設計，絕對是旅行中不可或缺的配件 ',2999,10,'1入'),
(103,4,'大自然的氣息','工作繁忙沒辦法安排假期旅行嗎? 把大自然的氣息帶回去，讓你在家也能有沉浸式的旅行體驗',11111,10,'1入'),
(104,2,'冠軍烘培咖啡豆','COFFEE',1080,10,'2入'),
(105,1,'原住民手工編織包','BAGS',1680,10,'1入'),
(106,3,'多功能行動電源','POWERBANK',1080,10,'10入'),
(107,4,'質感手提行李箱','LUGGAGE',3680,10,'10入'),
(108,1,'手沖咖啡旅行組','COFFEEEEE',2980,10,'10入'),
(109,1,'露營必備裝飾燈串','LIGHT',480,10,'1入');


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

insert into product_picture values (
1, 1, null
);

-- article 論壇 珮儀
-- create schema article;

-- 論壇
create table article (
    article_id int primary key, -- auto_increment,
    mem_id int, -- fk, not null
    ac_type_id int, -- fk, not null
    article_title varchar(45) not null,
    article_time datetime not null,
    article_like int not null,
    comment_num int not null,
    article_con varchar(500) not null,
    article_state tinyint default 0 comment '0:顯示 1:不顯示' -- not null
    -- constraint fk_mem_id
    -- foreign key (mem_id) references members(mem_id),
    -- constraint fk_ac_type_id 
    -- foreign key (ac_type_id) references article (ac_type_id)
);
insert into article (article_id, mem_id, ac_type_id, article_title, article_time, article_like, comment_num, article_con, article_state)
values
    (1, 101, 201, '巴黎', '2023-07-28 12:00:00', 50, 10, '這個地方真是太美了，推薦大家來玩！', 0),
    (2, 102, 202, '紐約', '2023-07-28 13:00:00', 30, 5, '遊覽這個城市的名勝古蹟真是太有趣了！', 0),
    (3, 103, 203, '東京', '2023-07-28 14:00:00', 20, 8, '這是第三筆假資料內容', 0),
    (4, 104, 204, '倫敦', '2023-07-28 15:00:00', 40, 12, '美食真的是絕了，我吃了好多好吃的！', 0),
    (5, 105, 205, '羅馬', '2023-07-28 16:00:00', 60, 15, '在這裡度過的時光是我生命中最難忘的時刻。', 0),
    (6, 106, 206, '馬爾代夫', '2023-07-28 17:00:00', 70, 18, '在這裡交到了很多新朋友，真是一次難忘的經歷', 0),
    (7, 107, 207, '巴塞隆納', '2023-07-28 18:00:00', 25, 3, '希望下次還能有機會再來這個美麗的地方。', 0),
    (8, 108, 208, '溫哥華', '2023-07-28 19:00:00', 15, 6, '這裡的風景實在太迷人了，我愛上了這個地方。', 0),
    (9, 109, 209, '首爾', '2023-07-28 20:00:00', 80, 20, '在這裡可以盡情放鬆身心，是個度假的好地方。', 0),
    (10, 110, 210, '悉尼', '2023-07-28 21:00:00', 90, 25, '我在這裡學到了很多關於這個地方的文化和歷史。', 0);
-- select * from article;

-- 貼文標籤
create table article_tag (
    ac_tag_id int primary key ,-- , auto_increment
    ac_tag_name varchar(80), -- uk, not null
    tag_sta tinyint default 0 comment '0:顯示 1:不顯示' -- not null
    
);

insert into article_tag (ac_tag_id, ac_tag_name, tag_sta)
values
	(1,  '佛系文青遊台南', 0),
    (2,  '躺著也中風旅行', 0),
    (3, '吃貨攻佔高雄美食', 0),
    (4,  '無厘頭夢幻島遊', 0),
    (5,  '爆笑登頂阿里山', 0),
    (6,  '急轉彎北海岸之旅', 0),
    (7,  '搞笑DIY野宿洞穴', 0),
    (8,  '廢物們的瘋狂台北', 0),
    (9, '貓奴暴走九份老街', 0),
    (10, '嗨翻雙北夜市趴', 0);

-- select * from article_tag;
 
 -- 貼文標籤明細
 create table article_tag_detail (
    ac_tag_id int , -- fk
    article_id int , -- fk
    primary key (ac_tag_id, article_id)
    -- constraint fk_ac_tag_id
    -- foreign key (ac_tag_id) references article_tag (ac_tag_id),
    -- constraint fk_article_id
    -- foreign key (article_id) references article (article_id)
);

-- 生成假資料
insert into article_tag_detail (ac_tag_id, article_id)
values
  (1, 101),
  (2, 102),
  (3, 103),
  (4, 104),
  (5, 105),
  (6, 106),
  (7, 107),
  (8, 108),
  (9, 109),
  (10, 110);
-- select * from article_tag_detail;

-- 貼文類別
create table article_type (
    ac_type_id int primary key, -- ai
    ac_type_name varchar(80) -- not null
   
);

insert into article_type (ac_type_id, ac_type_name)
values
	(1, '全部'),
	(2, '行程'),
    (3, '揪團'),
	(4, '商城');
    
 -- select * from article_type;
 create table article_picture
(
	articlepic_id int primary key, -- auto_increment
    article_id int, -- not null
    article_pic mediumblob
--     constraint fk_article_id
--     foreign key (article_id) references `group`(article_id)
);
insert into article_picture values (
1, 1, null
);
insert into article_picture values 
(101, 201, null),
(102, 202, null),
(103, 203, null),
(104, 204, null),
(105, 205, null),
(106, 206, null),
(107, 207, null),
(108, 208, null),
(109, 209, null),
(110, 210, null)
;
 -- 貼文留言
create table article_comment (
    comm_id int primary key,
    article_id int, -- fk
    mem_id int, -- fk
    comment_time datetime, -- not null
    comment_post varchar(800), -- not null
    comment_like int, -- not null
    comment_sta tinyint default 0 comment '0:顯示 1:不顯示' -- not null
    -- constraint fk_article_id
    -- foreign key (article_id) references article (article_id),
    -- constraint fk_mem_id
    -- foreign key (mem_id) references members (mem_id)
);
-- 生成假資料
INSERT INTO article_comment (comm_id, article_id, mem_id, comment_time, comment_post, comment_like, comment_sta)
VALUES
  (1, 101, 201, '2023-07-28 10:00:00', '這個地方真是太美了，推薦大家來玩！', 10, 0),
  (2, 102, 202, '2023-07-28 11:30:00', '好吃到讚！', 20, 0),
  (3, 103, 203, '2023-07-28 12:45:00', '喜歡這裡的氛圍！', 15, 0),
  (4, 104, 204, '2023-07-28 13:20:00', '拍照超好看！', 30, 0),
  (5, 105, 205, '2023-07-28 14:10:00', '推薦這間店！', 25, 0),
  (6, 106, 206, '2023-07-28 15:00:00', '有很多好吃的！', 12, 0),
  (7, 107, 207, '2023-07-28 16:30:00', '風景太漂亮了！', 18, 0),
  (8, 108, 208, '2023-07-28 17:15:00', '非常棒的體驗！', 22, 0),
  (9, 109, 209, '2023-07-28 18:00:00', '值得一遊！', 27, 0),
  (10, 110, 210, '2023-07-28 19:20:00', '很舒服的環境！', 14, 0);
  -- select * from article_comment;
-- 貼文收藏明細
create table article_collection (
    article_id int, -- fk
    mem_id int, -- fk
    ac_follow_date datetime, -- not null
    primary key (article_id, mem_id)
    -- constraint fk_mem_id
    -- foreign key (mem_id) references mem (mem_id),
    -- constraint fk_article_id
    -- foreign key (article_id) references article (article_id)
);
-- 生成假資料
INSERT INTO article_collection (article_id, mem_id, ac_follow_date)
VALUES
  (101, 201, '2023-07-28 10:00:00'),
  (102, 202, '2023-07-28 11:30:00'),
  (103, 203, '2023-07-28 12:45:00'),
  (104, 204, '2023-07-28 13:20:00'),
  (105, 205, '2023-07-28 14:10:00'),
  (106, 206, '2023-07-28 15:00:00'),
  (107, 207, '2023-07-28 16:30:00'),
  (108, 208, '2023-07-28 17:15:00'),
  (109, 209, '2023-07-28 18:00:00'),
  (110, 210, '2023-07-28 19:20:00');
  -- select * from article_collection;


create table qa (
	qa_id int primary key auto_increment,
    qa_title varchar(50)  not null,
    qa_con varchar(500)  not null,
    qa_state tinyint default 0 not null comment '0:下架 1:上架',
    qa_created_time datetime not null default current_timestamp,
    qa_last_updated_time datetime null default current_timestamp
    );

-- select * from qa;

-- drop table qa;

insert into qa(qa_id, qa_title, qa_con, qa_state) values
(1,'如何註冊遊&ME帳戶？','創建遊&ME帳號完全免費，您可透過email註冊：1.進入遊&ME首頁，點選右上方『登入/註冊』，選擇下方『註冊』。2.填寫您的電子信箱以及預設密碼，點選『註冊』。3.至您的電子信箱內查收驗證信件，點選信件中的網址顯示『聯絡信箱驗證成功』。4.至遊&ME點選右上方『登入/註冊』，輸入您的帳號密碼登入後即可建立行程及訂購商品。',1),
(2,'如何重置會員帳號的密碼？','1.忘記密碼:如果您因忘記密碼無法登入遊&ME，請於登入畫面點選『忘記密碼』，輸入您註冊遊&ME帳號時所使用的電子郵件地址，您將收到一封含有重置密碼鏈結，進行密碼修改。2.修改密碼:您可以登入會員後，在【帳號設定】中更改密碼。',1),
(3,'如何更改我在遊&ME使用的電子郵件地址呢？','很抱歉，因遊&ME的登入帳號為您的e-mail ，故無法更改e-mail地址。',1),
(4,'為什麼我沒有收到電子郵件提示或確認郵件？','請先至垃圾信件確認，有時候您的電子信箱有可能將遊&ME的訊息誤判為垃圾信，也建議您為了避免發生這種情況，您可以將我們的郵件從垃圾箱移除，並將遊&ME的MAIL添加至您的通訊錄。',1),
(5,'如何搜索行程？','進入遊&ME後，可以直接選擇您想要旅行的地點，我們將列出所有行程供您參考，同時您也可以利用我們的篩選條件來進行搜尋，您可以按城市、主題、時間長度等來縮小您的搜尋範圍，搜尋結果將同步於清單欄位，以便您找到最適合您的行程。',1),
(6,'如何使用我的景點收藏清單？','請利用我們收藏功能，每個景點都有個收藏符號，當點選時將列入您的收藏清單，您隨時可進入收藏清單查看比較。若要取消收藏，請再次點選收藏符號，即可取消收藏。',1),
(7,'申請成為揪團團主有哪些要求或條件？','作為揪團的團主，通常需要具備一些基本要求，例如年齡限制、完整的個人資料填寫，以及同意遵守相關的使用條款和規範。另外，您的揪團計劃也需要符合我們的揪團平台政策。具體的要求可能因平台而異，建議您在申請前仔細閱讀相關條款和說明。',1),
(8,'我想要發起一個揪團活動，該怎麼做？','在我們的揪團功能中，您可以點選「發起揪團」按鈕，填寫揪團表單，包括個人資料、活動名稱、日期、目的地等，然後點選「確認發起」即可成功進入創建揪團審核，審核完畢會再通知揪團團主。',1),
(9,'如何刪除評論或修改顯示名稱？','請您留意，我們的每則評論都是真確與真實的，當您填寫評論後，您的會員預設照片與您的會員名稱將會顯示在您的評論前方。填寫評論並送出時，評論將立即刊登於遊&ME該商品評論中，一旦填寫後就無法刪除與修改，請您諒解與了解。',0),
(10,'為什麼我選的東西不能結帳？','請您留意下方「須重新確認商品」，若選購商品中有售罄、已過出發日、暫不提供的商品，系統將會提醒您重新確認。',0);


-- schedules行程 薪安
-- create schema schedules;
-- use schedules;
-- drop schema schedules;


-- 行程
create table schedules(
sch_id int primary key auto_increment,
sch_name varchar(50) not null,
mem_id int not null,
sch_start date not null,
sch_end date not null,
sch_pub tinyint default 0 not null comment '0:私人檢視 1:共同編輯 2:公開檢視',
sch_copy BIT(1) default b'1' not null comment '0:不可複製 1:可以複製',
sch_cost int -- ,
-- constraint fk_schedules_members
-- foreign key (mem_id) references members(mem_id)
);
-- describe schedules;

INSERT INTO schedules (sch_name, mem_id, sch_start, sch_end, sch_pub, sch_copy, sch_cost)
VALUES
  ('台北之旅', 1, '2023-08-01', '2023-08-05', 2, b'1', 5000),
  ('高雄行', 2, '2023-09-10', '2023-09-15', 0, b'1', 3500),
  ('花蓮探索', 1, '2023-10-20', '2023-10-25', 1, b'0', 4500),
  ('台中一日遊', 3, '2023-11-05', '2023-11-05', 2, b'1', NULL),
  ('墾丁之旅', 2, '2023-12-10', '2023-12-15', 0, b'0', 6000),
  ('九份老街', 1, '2023-01-08', '2023-01-08', 2, b'1', 800),
  ('太魯閣國家公園', 4, '2023-02-14', '2023-02-20', 1, b'0', NULL),
  ('台東海線', 3, '2023-03-25', '2023-03-30', 2, b'1', 4800),
  ('澎湖輕旅行', 2, '2023-04-12', '2023-04-17', 0, b'0', 5500),
  ('雪隧一日遊', 1, '2023-05-09', '2023-05-09', 2, b'1', NULL),
  ('綠島環島', 5, '2023-06-20', '2023-06-25', 1, b'0', 6200),
  ('金門遊', 4, '2023-07-05', '2023-07-10', 2, b'1', 4100),
  ('夜宿阿里山', 3, '2023-08-15', '2023-08-20', 0, b'0', NULL),
  ('基隆景點', 2, '2023-09-18', '2023-09-23', 1, b'1', 3800),
  ('新竹一日遊', 1, '2023-10-10', '2023-10-10', 2, b'1', 900),
  ('苗栗小旅行', 3, '2023-11-28', '2023-11-28', 0, b'0', 1100),
  ('台南古蹟', 4, '2023-12-05', '2023-12-05', 2, b'1', NULL),
  ('宜蘭好遊玩', 5, '2023-01-15', '2023-01-15', 1, b'0', 2400),
  ('南投之旅', 2, '2023-02-22', '2023-02-22', 2, b'1', 1300),
  ('屏東行', 1, '2023-03-30', '2023-03-30', 0, b'0', 1900),
  ('樂園一日遊', 3, '2023-04-09', '2023-04-09', 2, b'1', NULL);

-- select * from schedules;

-- 行程細節
create table schedule_de(
schde_id int primary key auto_increment,
sch_id int not null,
attr_id int,
schde_starttime datetime,
schde_staytime time,
schde_transtime time,
schde_trans tinyint default 1 not null comment '0:步行 1:自駕車 2:大眾運輸',
schde_costname varchar(50),
schde_cost int,
schde_remark varchar(500) -- ,
-- constraint fk_schedule_de_schedules
-- foreign key (sch_id) references schedules(sch_id),
-- constraint fk_schedule_de_attractions
-- foreign key(attr_id) references attractions(attr_id)
);
-- describe schedule_de;

INSERT INTO schedule_de (sch_id, attr_id, schde_starttime, schde_staytime, schde_transtime, schde_trans, schde_costname, schde_cost, schde_remark)
VALUES
  (1, 1, '2023-06-21 08:00:00', '00:45:00', '00:30:00', 1, '早餐花費', 100, '特色早餐'),
  (1, 4, '2023-06-21 9:15:00', '02:00:00', '00:45:00', 1, '展覽門票', 250, NULL),
  (1, 10, '2023-06-21 12:00:00', '01:00:00', '00:30:00', 1, '熱炒店', NULL, NULL),
  (1, 5, '2023-06-21 13:30:00', '02:00:00', '00:35:00', 0, NULL, NULL, '老街漫步'),
  (2, 2, '2023-04-09 08:30:00', '01:30:00', '00:40:00', 1, '遊樂園門票', 300, NULL),
  (2, 6, '2023-04-09 10:40:00', '01:00:00', '00:20:00', 2, '午餐', 200, '享受美味的午餐'),
  (2, 8, '2023-04-09 12:00:00', '01:30:00', '00:30:00', 1, NULL, 180, NULL),
  (2, 7, '2023-04-09 14:00:00', '02:30:00', '00:45:00', 1, '咖啡店', 80, '高雄放鬆喝咖啡'),
  (3, 3, '2023-12-05 09:00:00', '01:15:00', '00:20:00', 0, '古蹟門票', 150, '參觀古蹟'),
  (3, 9, '2023-12-05 10:30:00', '01:00:00', '00:30:00', 2, '午餐', 180, NULL),
  (3, 8, '2023-12-05 12:00:00', '01:45:00', '00:15:00', 0, '畫廊門票', 200, NULL),
  (3, 5, '2023-12-05 14:00:00', '02:15:00', '00:40:00', 1, NULL, 220, NULL),
  (4, 1, '2023-10-10 09:00:00', '01:35:00', '00:25:00', 0, '博物館門票', 180, '參觀博物館'),
  (4, 3, '2023-10-10 11:00:00', '01:30:00', '01:00:00', 1, '午餐', 160, NULL),
  (4, 4, '2023-10-10 13:30:00', '01:30:00', '00:20:00', 1, NULL, NULL, NULL),
  (4, 5, '2023-10-10 15:20:00', '02:15:00', '00:45:00', 1, NULL, NULL, '散步休息'),
  (5, 1, '2023-08-15 05:00:00', '01:30:00', '01:00:00', 1, NULL, NULL, '看日出'),
  (5, 2, '2023-08-15 07:30:00', '01:00:00', '00:10:00', 0, '吃早餐', 80, '好吃早餐店'),
  (5, 9, '2023-08-15 08:40:00', '02:00:00', '00:35:00', 1, NULL, NULL, NULL);
-- select * from schedule_de;

-- 行程檢舉
create table schedule_rep(
schrep_id int primary key auto_increment,
mem_id int not null,
sch_id int,
schrep_con varchar(500) not null,
host_id int,
schrep_sta tinyint default 0 not null comment '0:審核中 1:已處理 2:已撤銷' -- ,
-- constraint fk_schedule_rep_members
-- foreign key (mem_id) references members(mem_id),
-- constraint fk_schedule_rep_schedules
-- foreign key (sch_id) references schedules(sch_id),
-- constraint fk_schedule_rep_hosts
-- foreign key (host_id) references hosts(host_id)
);
-- describe schedule_rep;

INSERT INTO schedule_rep (mem_id, sch_id, schrep_con, host_id, schrep_sta)
VALUES
  (10, 3, '這個行程根本就是假的，都是廣告', 5, 0),
  (15, 7, '我去過這個景點，根本不像照片那樣漂亮', 8, 0),
  (8, 1, '行程內容不清楚，請提供更多細節', 6, 0),
  (14, 9, '行程主辦人不守時，浪費我寶貴的時間', 5, 0),
  (12, 4, '景點閉門了，不能進去', 7, 0),
  (11, 6, '這個行程超級無聊，浪費我一天', 9, 0),
  (13, 2, '行程內容不符實際，感到被欺騙', 8, 0),
  (9, 5, '行程取消了，但沒有通知我', 7, 0),
  (7, 3, '行程組織混亂，沒有計劃', 6, 0),
  (10, 1, '行程主辦人不負責任，沒有安排好', 5, 0),
  (8, 7, '這個行程的交通安排很差', 9, 0),
  (15, 4, '主辦人太粗心，遺失了我的訂單', 8, 0),
  (11, 2, '行程中的餐點質量太差', 7, 0),
  (12, 6, '行程太短，沒有盡興玩', 5, 0),
  (13, 5, '主辦人沒有提供承載資訊', 9, 0),
  (14, 1, '這個行程不適合家庭', 7, 0),
  (9, 3, '行程安排太趕，無法好好欣賞景點', 6, 0),
  (7, 2, '主辦人根本不懂這個行程', 5, 0),
  (10, 4, '行程內容太枯燥，沒有趣味', 9, 0),
  (8, 6, '我遺失了我的貴重物品在行程中', 7, 0);
-- select * from schedule_rep;

-- 行程標籤
create table schedule_tag(
schtag_id int primary key auto_increment,
schtag_name varchar(20) unique not null
);
-- describe schedule_tag;

INSERT INTO schedule_tag (schtag_name)
VALUES
  ('台北'),('桃園'), ('台中'), ('彰化'), ('南投'),
  ('台東'), ('高雄'), ('新北'), ('基隆'), ('新竹'),
  ('苗栗'), ('雲林'), ('嘉義'), ('台南'), ('屏東'),
  ('花蓮'), ('宜蘭'), ('澎湖'), ('金門'), ('馬祖'),
  ('賞夜景'), ('古蹟'), ('自然風景'), ('登山健行'), ('溫泉'),
  ('沙灘海灘'), ('美食小吃'), ('復古老街'), ('藝文表演'),
  ('購物血拼'), ('水上活動'), ('動植物園'), ('博物館'),
  ('主題樂園'), ('咖啡廳'), ('酒吧夜店'), ('夜間燈光秀'),
  ('台灣必遊景點'), ('輕鬆休閒'), ('生態保護'),
  ('歷史文化'), ('夜市逛街'),('賞花賞蝶'), ('自然生態'),
  ('藝文展覽'), ('遊樂園'), ('古蹟探訪'),
  ('夏日戲水'), ('森林浴'), ('潛水探險'), ('農村體驗'),
  ('親子共遊'), ('攝影寫真'), ('美食美酒'),  ('生態漁村'),
  ('衝浪滑翔'), ('叢林探險'), ('宗教祈福'),  ('咖啡香氛'),
  ('遠足露營'), ('城市探險'), ('海岸風光'),  ('極限運動'),
  ('靈秀山水'), ('懸崖峭壁'), ('露天風呂'),  ('夜間市集'),
  ('湖泊景觀'), ('賞鳥生態'), ('文創市集'),('城市街拍'),
  ('DIY自己做'), ('參訪工廠'),('自駕遊'), ('浪漫約會') ,('星空觀賞');
-- select * from schedule_tag;

-- 行程標籤清單
create table schedule_tag_list(
sch_id int,
schtag_id int,
constraint pk_schedule_tag_list primary key(sch_id, schtag_id) -- ,
-- constraint fk_schedule_tag_list_schedules
-- foreign key (sch_id) references schedules(sch_id),
-- constraint fk_schedule_tag_list_schedule_tag
-- foreign key (schtag_id) references schedule_tag(schtag_id),
);
-- describe schedule_tag_list;

INSERT INTO schedule_tag_list (sch_id, schtag_id)
VALUES
  (1, 5),(1, 8),(1, 10),
  (2, 3),(2, 2),(2, 8),
  (3, 4),(3, 9),(3, 10),
  (4, 6),(4, 7),(4, 5),
  (5, 1),(5, 7),(5, 4),
  (6, 2),(6, 9),(6, 8),
  (7, 2),(7, 7),(7, 5),
  (8, 6),(8, 9),(8, 10),
  (9, 3),(9, 6),(9, 9),
  (10, 1),(10, 2),(10, 3);
-- select * from schedule_tag_list;

-- activity活動
-- create schema activity;
-- use activity;


-- 活動
create table activity(
activ_id int primary key auto_increment,
activ_pic mediumblob not null,
activ_name varchar(100) not null,
activ_con varchar(1000) not null,
activ_starttime datetime not null,
activ_endtime datetime,
activ_sta tinyint default 0 not null  -- 0:下架 1:上架
);
-- describe activity;

-- INSERT INTO activity (activ_pic, activ_name, activ_con, activ_starttime, activ_endtime, activ_sta)
-- VALUES
--     (LOAD_FILE('/image1.jpg'), '家庭野餐日', '在公園中享受愉快的野餐時光，與家人一起共度美好時光。', '2023-07-28 10:00:00', '2023-07-28 12:00:00', 1),
--     (LOAD_FILE('/image2.jpg'), '水上運動嘉年華', '來一場充滿刺激與樂趣的水上運動盛宴，感受水上樂園的魅力。', '2023-07-29 15:00:00', '2023-07-29 18:00:00', 1),
--     (LOAD_FILE('/path/to/image3.jpg'), '城市探險之旅', '探索城市的角落與文化，發現城市中的瑰寶與故事。', '2023-07-30 09:30:00', '2023-07-30 11:30:00', 0),
--     (LOAD_FILE('/path/to/image4.jpg'), '瑜伽與冥想工作坊', '學習瑜伽和冥想的技巧，平衡身心，感受寧靜與放鬆。', '2023-08-01 14:00:00', '2023-08-01 16:00:00', 1),
--     (LOAD_FILE('/path/to/image5.jpg'), '小吃美食節', '品嚐來自世界各地的美食，滿足你的味蕾。', '2023-08-02 13:00:00', '2023-08-02 15:00:00', 1);


-- 活動推薦行程
create table activity_schedule_recommendation(
sch_id int, 
activ_id int,
constraint pk_activity_schedule_recommendation primary key(sch_id, activ_id)
-- constraint fk_sch_id foreign key (sch_id) references schedules(sch_id),
-- constraint fk_activ_id foreign key (activ_id) references activity(activ_id)
);
-- describe activity_schedule_recommendation;

INSERT INTO activity_schedule_recommendation (sch_id, activ_id)
VALUES
    (1, 1), -- 假設這裡的sch_id和activ_id在schedules表和activity表中都存在
    (1, 2),
    (2, 3),
    (2, 4),
    (3, 5);


-- 心理測驗結果
create table psytest_result(
psytresult_id int primary key, 
psytresult_name varchar(100) not null,
psytresult_con varchar(1000) not null
);
-- describe  psytest_result;

INSERT INTO psytest_result (psytresult_id, psytresult_name, psytresult_con)
VALUES
    (1, '測試結果1', '這是測試結果1的描述'),
    (2, '測試結果2', '這是測試結果2的描述'),
    (3, '測試結果3', '這是測試結果3的描述'),
    (4, '測試結果4', '這是測試結果4的描述'),
    (5, '測試結果5', '這是測試結果5的描述');
