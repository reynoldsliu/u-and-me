create schema main;
use main;
-- drop schema main;


-- members 許彤
create table members (
	mem_id int primary key, 
	mem_email varchar(30),
	mem_password varchar(20),
	mem_name varchar(10),
	mem_gender tinyint ,
	mem_addr varchar(100),
	mem_grade int,
	mem_phone varchar(15),
	mem_point int,
	mem_sta tinyint,
	mem_group tinyint
);
select * from members;
INSERT INTO members (mem_id, mem_email, mem_password, mem_name, mem_gender, mem_addr, mem_grade, mem_phone, mem_point, mem_sta, mem_group)
VALUES
  (11,'member1@example.com', 'password1', 'John', 0, 'Address 1', 1, '123456789', 100, 1, 1),
  (2,'member2@example.com', 'password2', 'Jane', 1, 'Address 2', 2, '987654321', 200, 1, 2),
  (3,'member3@example.com', 'password3', 'Bob', 0, 'Address 3', 1, '111222333', 150, 1, 3),
  (4,'member4@example.com', 'password4', 'Alice', 1, 'Address 4', 3, '444555666', 300, 1, 1),
  (5,'member5@example.com', 'password5', 'Michael', 0, 'Address 5', 2, '777888999', 250, 1, 2),
  (6,'member6@example.com', 'password6', 'Emily', 1, 'Address 6', 1, '555666777', 50, 1, 3),
  (7,'member7@example.com', 'password7', 'David', 0, 'Address 7', 3, '999888777', 400, 1, 1),
  (8,'member8@example.com', 'password8', 'Karen', 1, 'Address 8', 2, '111333555', 180, 1, 2),
  (9,'member9@example.com', 'password9', 'Tom', 0, 'Address 9', 1, '666777888', 120, 1, 3),
  (10,'member10@example.com', 'password10', 'Sara', 1, 'Address 10', 1, '222333444', 80, 1, 1);
select * from members;


create table hosts (
	host_id int primary key, 
	host_phone varchar(15),
	host_email varchar(30),
	host_password varchar(20),
	host_name varchar(10),
	host_sta tinyint
);

select * from hosts;
INSERT INTO hosts (host_id,host_phone, host_email, host_password, host_name, host_sta)
VALUES
  (1,'123456789', 'host1@example.com', 'password1', 'John', 1),
  (2,'987654321', 'host2@example.com', 'password2', 'Jane', 1),
  (3,'111222333', 'host3@example.com', 'password3', 'Bob', 1),
  (4,'444555666', 'host4@example.com', 'password4', 'Alice', 1),
  (5,'777888999', 'host5@example.com', 'password5', 'Michael', 1),
  (6,'555666777', 'host6@example.com', 'password6', 'Emily', 1),
  (7,'999888777', 'host7@example.com', 'password7', 'David', 1),
  (8,'111333555', 'host8@example.com', 'password8', 'Karen', 1),
  (9,'666777888', 'host9@example.com', 'password9', 'Tom', 1),
  (10,'222333444', 'host10@example.com', 'password10', 'Sara', 1);
select * from hosts;


-- create schema onlineshoppingmall;
-- use onlineshoppingmall;
 
 create table orders (
    ord_id int primary key,
    mem_id int,
    points int,
    ord_fee int,
    recipient_phone varchar(15),
    ord_pay_sta tinyint,
    recipient_name varchar(10),
    recipient_addr varchar(30),
    ord_sta tinyint,
    total int,
    checktotal int,
    ord_time timestamp
--  constraint fk_mem_id
--  foreign key(mem_id) references table_name(mem_id)
);
select * from orders;
INSERT INTO orders (ord_id, mem_id, points, ord_fee, recipient_phone, ord_pay_sta, recipient_name, recipient_addr, ord_sta, total, checktotal, ord_time)
VALUES
  (1, 1, 100, 50, '123456789', 1, 'John', 'Address 1', 1, 150, 150, '2023-07-29 10:00:00'),
  (2, 2, 200, 80, '987654321', 1, 'Jane', 'Address 2', 1, 280, 280, '2023-07-29 11:30:00'),
  (3, 3, 150, 40, '111222333', 1, 'Bob', 'Address 3', 1, 190, 190, '2023-07-29 12:45:00'),
  (4, 4, 300, 120, '444555666', 1, 'Alice', 'Address 4', 1, 420, 420, '2023-07-29 14:20:00'),
  (5, 5, 250, 90, '777888999', 1, 'Michael', 'Address 5', 1, 340, 340, '2023-07-29 15:10:00'),
  (6, 6, 50, 20, '555666777', 1, 'Emily', 'Address 6', 1, 70, 70, '2023-07-29 16:30:00'),
  (7, 7, 400, 150, '999888777', 1, 'David', 'Address 7', 1, 550, 550, '2023-07-29 17:40:00'),
  (8, 8, 180, 60, '111333555', 1, 'Karen', 'Address 8', 1, 240, 240, '2023-07-29 18:20:00'),
  (9, 9, 120, 40, '666777888', 1, 'Tom', 'Address 9', 1, 160, 160, '2023-07-29 19:15:00'),
  (10, 10, 80, 30, '222333444', 1, 'Sara', 'Address 10', 1, 110, 110, '2023-07-29 20:00:00');
select * from orders;




create table order_details(
	ord_id int,
    prod_id int,
    prod_qty int,
	prod_review varchar(50),
    prod_price int,
    prod_com_score decimal,
    primary key(ord_id, prod_id)
--  constraint fk_ord_id
--  foreign key(ord_id) references orders(ord_id),
--  constraint fk_prod_id
--  foreign key(prod_id) references product(prod_id)
    );
select * from order_details;
INSERT INTO order_details (ord_id, prod_id, prod_qty, prod_review, prod_price, prod_com_score)
VALUES
  (1, 101, 2, 'Good product!', 50, 4.5),
  (1, 102, 1, 'Fast delivery!', 30, 4.0),
  (2, 103, 3, 'Nice quality!', 20, 4.2),
  (2, 104, 2, 'Satisfied with the purchase.', 25, 4.8),
  (3, 105, 1, 'Not as expected.', 15, 3.5),
  (3, 106, 4, 'Excellent service!', 40, 4.7),
  (4, 107, 2, 'Highly recommended!', 60, 4.9),
  (4, 108, 1, 'Good value for money.', 10, 3.9),
  (5, 109, 3, 'Average product.', 35, 3.0),
  (5, 110, 2, 'Fast shipping!', 45, 4.4);
select * from order_details;


-- 揪團表格建立 宇航
-- create database uandme;
-- use uandme;
create table `group`
(
	group_id int primary key, -- auto_increment
    mem_id int, -- not null
    sch_id int, -- not null
    members int default 0,-- not null
    min_member int not null,
    max_member int not null,
    amount int not null,
    theme varchar(32) not null,
    `starting` datetime not null,
    dep_date datetime not null,
    deadline datetime not null,
    group_desc varchar(200) not null,
    notice varchar(500) not null,
    group_sta tinyint not null default 0
    -- constraint fk_mem_id
--     foreign key (mem_id) references members(mem_id),
--     
--     constraint fk_sch_id
--     foreign key (sch_id) references schedules(sch_id)
);
insert into `group` values (
1, 1, 1, default, 10, 20,
100000, '緯育4月遊', '2023-03-22 00:00', '2023-05-15 00:00',
'2023-05-01 00:00', 'JAVA集訓營', '進入後肝可能變黑白的', default 
);
insert into `group`
values
    (101, 101, 201, 5, 3, 8, 1000, 'Hiking Trip', '2023-08-10 09:00:00', '2023-08-15 12:00:00', '2023-08-01 18:00:00', 'A fun hiking trip to the mountains', 'Bring your own water and snacks', 0),
    (102, 102, 202, 4, 2, 6, 800, 'Beach Vacation', '2023-09-05 14:00:00', '2023-09-12 10:00:00', '2023-08-25 23:59:59', 'Relax and unwind at the sunny beach', 'Sunscreen is a must', 0),
    (103, 103, 203, 6, 4, 10, 1200, 'City Tour', '2023-07-20 11:00:00', '2023-07-25 16:00:00', '2023-07-15 22:00:00', 'Explore the city and visit popular landmarks', 'Comfortable shoes are recommended', 0),
    (104, 104, 204, 3, 2, 4, 600, 'Camping Adventure', '2023-08-28 15:00:00', '2023-09-02 09:00:00', '2023-08-20 20:00:00', 'Experience the great outdoors with camping', 'Bring your own tent and sleeping bag', 0),
    (105, 105, 205, 7, 5, 12, 1500, 'Cruise Journey', '2023-10-15 13:00:00', '2023-10-25 18:00:00', '2023-10-01 19:00:00', 'Enjoy a luxurious cruise experience', 'Formal attire required for dinner', 0),
    (106, 106, 206, 2, 2, 4, 400, 'Skiing Adventure', '2023-12-05 08:00:00', '2023-12-10 16:00:00', '2023-11-25 23:59:59', 'Hit the slopes and have fun skiing', 'Skiing equipment available for rent', 0),
    (107, 107, 207, 8, 6, 15, 1800, 'Road Trip', '2023-09-30 10:00:00', '2023-10-10 14:00:00', '2023-09-15 18:00:00', 'Embark on an exciting road trip across the country', 'Prepare some road trip playlists', 0),
    (108, 108, 208, 4, 3, 8, 1000, 'Photography Tour', '2023-11-12 09:00:00', '2023-11-18 17:00:00', '2023-11-01 23:59:59', 'Capture stunning landscapes and wildlife with photography', 'Bring your own camera gear', 0),
    (109, 109, 209, 6, 4, 10, 1200, 'Foodie Adventure', '2023-10-05 12:00:00', '2023-10-15 20:00:00', '2023-09-25 23:59:59', 'Explore various cuisines and food spots', 'Come hungry and ready to eat', 0),
    (110, 110, 210, 3, 2, 5, 700, 'Fishing Trip', '2023-11-25 07:00:00', '2023-11-28 15:00:00', '2023-11-15 19:00:00', 'Enjoy fishing in serene lakes and rivers', 'Fishing equipment will be provided', 0);
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
	detail_id int primary key, -- auto_increment
    form_id int , -- not null
    `name` varchar(32) not null,
    citizenship varchar(32) not null,
    idnumber char(10) not null,
    birthday date not null,
    gender enum('男','女') not null default '男'
--     constraint fk_form_id
--     foreign key (form_id) references reg_form(form_id)
);
insert into member_detail values(
1, 1, '李小明', '臺灣', 'A123456789', '2000-01-01',default
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

create table group_rep
(
	group_rep_id int primary key, -- auto_increment
    mem_id int, --  not null
    group_id int,-- not null
    hosts_id int,
    reason varchar(500) not null,
    group_rep_sta TINYINT not null default 0
    -- constraint fk_mem_id
--     foreign key (mem_id) references members(mem_id),
--     
--     constraint fk_group_id
--     foreign key (group_id) references `group`(group_id),
--     
--     constraint fk_host_id
--     foreign key (host_id) references hosts(host_id)
);
insert into group_rep values (
1, 1, 1, 1, 'QQ', default
);
insert into group_rep (group_rep_id, mem_id, group_id, hosts_id, reason)
values
(2, 101, 201, 301, 'One of the group members is not cooperative.'),
(3, 102, 202, 302, 'The host is not fulfilling their responsibilities.'),
(4, 103, 203, 303, 'There is a conflict between two group members.'),
(5, 104, 204, 304, 'The group schedule conflicts with my other commitments.'),
(6, 105, 205, 305, 'The group activities do not match my interests.'),
(7, 106, 206, 306, 'I am experiencing health issues and cannot participate.'),
(8, 107, 207, 307, 'The group size is too large for me.'),
(9, 108, 208, 308, 'I am unable to afford the group expenses.'),
(10, 109, 209, 309, 'There is a lack of communication within the group.'),
(11, 110, 210, 310, 'I have unexpected personal matters to attend to.');
select * from group_rep;

create table group_picture
(
	group_pic_id int primary key, -- auto_increment
    group_id int, -- not null
    froup_pic mediumblob
--     constraint fk_group_id
--     foreign key (group_id) references `group`(group_id)
);
insert into group_picture values (
1, 1, null
);
insert into group_picture values 
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
select * from group_picture;

-- attractions景點相關表格建立 劉力辰
create table attraction_type(
attr_type_id int primary key,
attr_type_name varchar(10)
);

insert into attraction_type(attr_type_id, attr_type_name)
values
(1,"第一類"),
(2,"第二類"),
(3,"第三類");
-- select * from attraction_type;
-- drop table attraction_type;

create table attractions (
attr_id int primary key,
attr_veri_sta tinyint,
attr_sta int,
attr_name varchar(20),
attr_addr varchar(100),
attr_lon float,
attr_lat float,
attr_illa varchar(500),
attr_type_id int,
-- constraint attr_type_id
-- foreign key(attr_type_id) references attraction_type(attr_type_id)

attr_buss_time varchar(100),
attr_cost_range tinyint,
attr_rep varchar(500)
);

INSERT INTO attractions (attr_id, attr_veri_sta, attr_sta, attr_name, attr_addr, attr_lon, attr_lat, attr_illa, attr_type_id, attr_buss_time, attr_cost_range, attr_rep)
VALUES 
  (1, 1, 3, 'Attraction 1', '123 Main St', 12.345, 67.890, 'Description for Attraction 1', 1, '9:00 AM - 5:00 PM', 2, 'Representative for Attraction 1'),
  (2, 0, 2, 'Attraction 2', '456 Park Ave', -45.678, 12.345, 'Description for Attraction 2', 3, '10:00 AM - 6:00 PM', 1, 'Representative for Attraction 2'),
  (3, 1, 1, 'Attraction 3', '789 Broad St', 98.765, -34.567, 'Description for Attraction 3', 2, '8:00 AM - 4:00 PM', 3, 'Representative for Attraction 3'),
  (4, 0, 3, 'Attraction 4', '567 Elm St', -12.345, -78.901, 'Description for Attraction 4', 1, '9:30 AM - 5:30 PM', 2, 'Representative for Attraction 4'),
  (5, 1, 2, 'Attraction 5', '234 Oak Ave', 23.456, 45.678, 'Description for Attraction 5', 3, '10:30 AM - 6:30 PM', 1, 'Representative for Attraction 5'),
  (6, 0, 1, 'Attraction 6', '678 Pine St', -56.789, 78.901, 'Description for Attraction 6', 2, '8:30 AM - 4:30 PM', 3, 'Representative for Attraction 6'),
  (7, 1, 3, 'Attraction 7', '890 Maple Ave', 34.567, -56.789, 'Description for Attraction 7', 1, '9:45 AM - 5:45 PM', 2, 'Representative for Attraction 7'),
  (8, 0, 2, 'Attraction 8', '123 Cherry St', -67.890, 98.765, 'Description for Attraction 8', 3, '10:45 AM - 6:45 PM', 1, 'Representative for Attraction 8'),
  (9, 1, 1, 'Attraction 9', '456 Plum Ave', 12.345, -12.345, 'Description for Attraction 9', 2, '8:45 AM - 4:45 PM', 3, 'Representative for Attraction 9'),
  (10, 0, 3, 'Attraction 10', '789 Orange St', -34.567, 23.456, 'Description for Attraction 10', 1, '9:15 AM - 5:15 PM', 2, 'Representative for Attraction 10');
  
select * from attractions;
-- drop table attractions;


-- create table members(
-- mem_id int primary key,
-- mem_name varchar(20)
-- );

-- insert into members(mem_id, mem_name)
-- values
-- (1,"Andy");

-- drop table member;
-- select * from member;

create table attraction_collections (
attr_id int,
mem_id int,

attr_col_illa varchar(500)

-- primary key (attr_id, mem_id),
-- foreign key(mem_id) references members(mem_id),
-- foreign key(attr_id) references attractions(attr_id)

);

insert into attraction_collections(attr_id, mem_id, attr_col_illa)

values
(1,1,"第一個會員的第一筆收藏");

-- select * from attraction_collections;
-- drop table attraction_collections;

-- drop table attraction_pictures;
create table attraction_pictures (
attr_pic_id int unsigned primary key,
attr_id int,
-- constraint fk_attr_id
-- foreign key(attr_id) references attractions(attr_id),
attr_pic_data mediumblob
);

insert into attraction_pictures(attr_pic_id, attr_id, attr_pic_data)
values
(1,1,LOAD_FILE('/tomcat.jpg'));
-- select attr_pic_id from attraction_pictures where fk_attr_id = 1;
-- delete from attraction_pictures where attr_pic_id = 1;
-- alter table attraction_pictures drop foreign key fk_attr_id;

create table attraction_comments(
attr_id int,
mem_id int,
attr_com_score decimal(2,1),
attr_com varchar(500)
-- foreign key(attr_id) references attractions(attr_id),
-- foreign key(mem_id) references members(mem_id)
);

insert into attraction_comments(attr_id, mem_id, attr_com_score, attr_com)
values
(1,1,0.1,"景點沒廁所");

-- select * from attraction_comments;


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
prod_price int,
prod_qty int,
prod_sta tinyint default 0,

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
insert into product(prod_id,prod_name,prod_con,prod_price,prod_qty,prod_spec)
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

 
-- 貼文內容檢舉
create table article_rep (
    atc_report_id int primary key, -- ai
    mem_id int, -- fk
    article_id int, -- fk
    comm_id int, -- fk
    ac_tag_id int, -- fk
    host_id int, -- fk
    report_time datetime, -- not null

    report_reason varchar(800) ,-- not nulluser

    report_state tinyint -- not null
    -- constraint fk_mem_id
    -- foreign key (mem_id) references mem (mem_id),
    -- constraint fk_article_id
    -- foreign key (article_id) references article (article_id),
    -- constraint fk_comm_id
    -- foreign key (comm_id) references article_comment (comm_id),
    -- constraint fk_host_id
    -- foreign key (host_id) references host (host_id),
    -- constraint fk_ac_tag_id
    -- foreign key (ac_tag_id) references article_tag (ac_tag_id)
);

-- 生成假資料
INSERT INTO article_rep (atc_report_id, mem_id, article_id, comm_id, ac_tag_id, host_id, report_time, report_reason, report_state)
VALUES
  (1, 201, 101, 1, 1, 301, '2023-07-28 10:00:00', '貼文內容涉及不當言詞', 1),
  (2, 202, 102, 2, 2, 302, '2023-07-28 11:30:00', '留言內容含有廣告', 0),
  (3, 203, 103, 3, 3, 303, '2023-07-28 12:45:00', '貼文含有不實資訊', 1),
  (4, 204, 104, 4, 4, 304, '2023-07-28 13:20:00', '侵犯他人智慧財產權', 1),
  (5, 205, 105, 5, 5, 305, '2023-07-28 14:10:00', '不當評論他人外貌', 0),
  (6, 206, 106, 6, 1, 301, '2023-07-28 15:00:00', '帳號冒充他人身分', 1),
  (7, 207, 107, 7, 2, 302, '2023-07-28 16:30:00', '騷擾他人用戶', 1),
  (8, 208, 108, 8, 3, 303, '2023-07-28 17:15:00', '含有色情內容', 0),
  (9, 209, 109, 9, 4, 304, '2023-07-28 18:00:00', '違反社群守則', 1),
  (10, 210, 110, 10, 5, 305, '2023-07-28 19:20:00', '騷擾他人用戶', 0);
  -- select * from article_rep;
  
-- create schema customerservice 宇彤;
-- use customerservice;

create table chat (
	chat_id int primary key, -- auto_increment
    mem_id int, -- not null
    host_id int,
    chat_time datetime not null,
    chat_type tinyint default 6 not null comment '0:會員 1:商城 2:景點行程 3:活動 4:論壇 5:揪團 6:其他',
    chat_point tinyint not null comment '0:會員 1:客服',
    chat_con varchar(500)
    -- constraint fk_chat_mem_id
    -- foreign key (mem_id) references members (mem_id)
    -- constraint fk_chat_host_id
    -- foreign key (host_id) references hosts (host_id)
    );

-- select * from chat;

insert into chat(chat_id, mem_id, host_id, chat_time, chat_type, chat_point, chat_con) values
(1,1,null,'2023-07-28 14:22:00',6,1,'歡迎來到我們的客服聊天室！請選擇您要詢問的類別，輸入相應的數字編號：0-會員 1-商城 2-景點行程 3-活動 4-論壇 5-揪團 6-其他，您可以直接回復數字，我們將竭誠為您提供所需的幫助與資訊。將立即為您轉接至客服人員，與您進行連線並提供支援。感謝您使用我們的服務！若不幸是在非客服時間內聯繫我們，請您不要擔心，我們將安排客服人員在營業時間內盡快回覆您的訊息。請您耐心等待，我們會儘快與您取得聯繫。'),
(2,1,null,'2023-07-28 14:22:10',6,0,'2'),
(3,1,1,'2023-07-28 14:22:15',2,1,'您好，這裡是客服人員Jane，很高興能夠為您提供幫助！請問有什麼問題或需要我們協助解決的事情嗎？請隨時告訴我們您的需求，我們會全力以赴為您提供最好的服務。'),
(4,1,1,'2023-07-28 14:24:15',2,0,'你好，我是新會員，我想要在你們的旅遊行程平台上建立一個行程。能告訴我在哪建立行程的流程嗎？'),
(5,1,1,'2023-07-28 14:25:20',2,1,'歡迎加入我們的旅遊行程平台！建立行程很簡單，首先，請在會員中心點選「建立旅遊行程」按鈕。然後，填寫行程的基本資訊，如目的地、日期等。接著，您可以在行程內容中添加景點、活動、餐廳等細節。最後，點選「儲存」即可完成行程建立。'),
(6,1,1,'2023-07-28 14:28:10',2,0,'謝謝指引！在建立行程時，可以自訂行程的名稱嗎？'),
(7,1,1,'2023-07-28 14:29:10',2,1,'當然可以！在填寫行程基本資訊時，有一個欄位是「行程名稱」，您可以在那裡輸入您想要的名稱，讓行程更具個人化。'),
(8,1,1,'2023-07-28 14:30:00',2,0,'如果我想和朋友分享我建立的行程，該怎麼辦？'),
(9,1,1,'2023-07-28 14:35:00',2,1,'您可以在行程詳細頁面上，找到分享按鈕，點選後可以選擇分享到社交媒體或通過郵件分享給朋友。這樣他們就可以看到您的行程安排了。'),
(10,1,1,'2023-07-28 14:36:00',2,0,'好的，謝謝!');


create table qa (
	qa_id int primary key, -- auto_increment
    qa_title varchar(50)  not null,
    qa_con varchar(500)  not null,
    qa_state tinyint default 0 not null comment '0:下架 1:上架'
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
sch_id int primary key, -- auto_increment
sch_name varchar(50) not null,
mem_id int, -- not null
sch_start date not null,
sch_end date not null,
sch_pub tinyint default 0 not null comment '0:私人檢視 1:共同編輯 2:公開檢視',
sch_copy tinyint default 0 not null comment '0:不可複製 1:可複製',
sch_cost int -- ,
-- constraint fk_schedules_members
-- foreign key (mem_id) references members(mem_id)
);
-- describe schedules;

INSERT INTO schedules (sch_id, sch_name, mem_id, sch_start, sch_end, sch_pub, sch_copy, sch_cost)
VALUES
  (1, 'Meeting 1', 101, '2023-06-21', '2023-06-21', 1, 1, 0),
  (2, 'Event 1', 102, '2023-06-22', '2023-06-23', 0, 1, 500),
  (3, 'Appointment 1', 103, '2023-06-24', '2023-06-24', 0, 0, NULL),
  (4, 'Workshop 1', 104, '2023-06-25', '2023-06-26', 1, 1, 0),
  (5, 'Conference 1', 105, '2023-06-27', '2023-06-28', 2, 1, 1000),
  (6, 'Training 1', 106, '2023-06-29', '2023-06-29', 0, 0, NULL),
  (7, 'Project 1', 107, '2023-06-30', '2023-07-01', 1, 1, 0),
  (8, 'Seminar 1', 108, '2023-07-02', '2023-07-03', 2, 1, 800),
  (9, 'Presentation 1', 109, '2023-07-04', '2023-07-04', 0, 0, NULL),
  (10, 'Task 1', 110, '2023-07-05', '2023-07-05', 1, 1, 0);
-- select * from schedules;

-- 行程細節
create table schedule_de(
schde_id int primary key, -- auto_increment
sch_id int, -- not null
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

INSERT INTO schedule_de (schde_id, sch_id, attr_id, schde_starttime, schde_staytime, schde_transtime, schde_trans, schde_costname, schde_cost, schde_remark)
VALUES
  (1, 1, 101, '2023-06-21 09:00:00', '01:30:00', '00:30:00', 1, 'Parking Fee', 100, 'Remark 1'),
  (2, 1, 102, '2023-06-21 10:30:00', '02:00:00', '00:45:00', 2, 'Public Transport', 50, 'Remark 2'),
  (3, 1, 103, '2023-06-21 12:30:00', '01:00:00', '00:15:00', 0, NULL, NULL, NULL),
  (4, 2, 104, '2023-06-22 14:00:00', '03:00:00', '00:30:00', 1, 'Toll Fee', 200, 'Remark 4'),
  (5, 2, 105, '2023-06-22 17:30:00', '02:30:00', '00:45:00', 1, 'Gasoline', 80, 'Remark 5'),
  (6, 2, 106, '2023-06-22 20:15:00', '01:00:00', '00:15:00', 0, NULL, NULL, NULL),
  (7, 3, 107, '2023-06-23 08:30:00', '01:30:00', '00:30:00', 2, 'Train Ticket', 120, 'Remark 7'),
  (8, 3, 108, '2023-06-23 10:00:00', '02:00:00', '00:45:00', 2, 'Bus Ticket', 30, 'Remark 8'),
  (9, 3, 109, '2023-06-23 12:00:00', '01:00:00', '00:15:00', 0, NULL, NULL, NULL),
  (10, 4, 110, '2023-06-24 09:30:00', '02:00:00', '00:30:00', 1, 'Parking Fee', 100, 'Remark 10');
-- select * from schedule_de;
  
-- 行程檢舉
create table schedule_rep(
schrep_id int primary key, -- auto_increment
mem_id int, -- not null
sch_id int,
schrep_con varchar(500) not null,
host_id int,
schrep_sta tinyint default 0 not null comment '0:檢舉未處理 1:檢舉已處理' -- ,
-- constraint fk_schedule_rep_members
-- foreign key (mem_id) references members(mem_id),
-- constraint fk_schedule_rep_schedules
-- foreign key (sch_id) references schedules(sch_id),
-- constraint fk_schedule_rep_hosts
-- foreign key (host_id) references hosts(host_id)
);
-- describe schedule_rep;

INSERT INTO schedule_rep (schrep_id, mem_id, sch_id, schrep_con, host_id, schrep_sta)
VALUES
  (1, 101, 1, 'Schedule 1 has inappropriate content.', 201, 0),
  (2, 102, 2, 'Schedule 2 violates community guidelines.', 202, 0),
  (3, 103, 3, 'Schedule 3 contains offensive language.', 203, 1),
  (4, 104, 1, 'Schedule 1 is a duplicate entry.', NULL, 0),
  (5, 105, 4, 'Schedule 4 has misleading information.', 204, 0),
  (6, 106, 5, 'Schedule 5 is spam.', 205, 1),
  (7, 107, 6, 'Schedule 6 is irrelevant.', NULL, 0),
  (8, 108, 2, 'Schedule 2 has inappropriate content.', 206, 0),
  (9, 109, 7, 'Schedule 7 is a duplicate entry.', NULL, 1),
  (10, 110, 8, 'Schedule 8 violates community guidelines.', 207, 0);
-- select * from schedule_rep;

-- 行程標籤
create table schedule_tag(
schtag_id int primary key, -- auto_increment
schtag_name varchar(20) unique not null
);
-- describe schedule_tag;

INSERT INTO schedule_tag (schtag_id, schtag_name)
VALUES
  (1, 'Tag 1'),
  (2, 'Tag 2'),
  (3, 'Tag 3'),
  (4, 'Tag 4'),
  (5, 'Tag 5'),
  (6, 'Tag 6'),
  (7, 'Tag 7'),
  (8, 'Tag 8'),
  (9, 'Tag 9'),
  (10, 'Tag 10');
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
  (1, 101),
  (1, 102),
  (2, 103),
  (3, 104),
  (4, 105),
  (4, 106),
  (5, 107),
  (6, 108),
  (7, 109),
  (7, 110);
-- select * from schedule_tag_list;

-- activity活動
-- create schema activity;
-- use activity;


-- 活動
create table activity(
activ_id int primary key auto_increment,
activ_pic mediumblob not null,
activ_name varchar(20) not null,
activ_con varchar(500) not null,
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
psytresult_name varchar(20) not null,
psytresult_con varchar(500) not null
);
-- describe  psytest_result;

INSERT INTO psytest_result (psytresult_id, psytresult_name, psytresult_con)
VALUES
    (1, '測試結果1', '這是測試結果1的描述'),
    (2, '測試結果2', '這是測試結果2的描述'),
    (3, '測試結果3', '這是測試結果3的描述'),
    (4, '測試結果4', '這是測試結果4的描述'),
    (5, '測試結果5', '這是測試結果5的描述');
