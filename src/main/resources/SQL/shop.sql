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
insert into product(prod_id,prodcat_id,prod_name,prod_con,prod_pri,prod_qty,prod_sta,prod_spec)
values
(101,2,'日月潭紅茶 | 國際風味獎章 | 50g','台茶18號，茶湯呈現典雅金紅色，茶香中帶有淡淡薄荷肉桂香氣，此香氣更被世界紅茶專家譽為日月潭紅茶特有之「台灣香」',699,0,1,'3入'),
(102,3,'設計師聯名款太陽眼鏡','UandMe與設計師太陽眼鏡款，擷取時尚與文化融入設計，絕對是旅行中不可或缺的配件 ',2999,2,1,'1入'),
(103,4,'大自然的氣息','工作繁忙沒辦法安排假期旅行嗎? 把大自然的氣息帶回去，讓你在家也能有沉浸式的旅行體驗',11111,10,1,'1入'),
(104,2,'冠軍烘培咖啡豆','TCRC 烘焙冠軍特調精品配方豆｜醇厚度：輕盈｜酸度：低酸 風味描述： 焙茶、炒糖甜感、白花香、平衡乾淨',1080,10,1,'2入'),
(105,1,'原住民手工編織包','找回傳統記憶與技藝，手工編織',1680,10,1,'1入'),
(106,1,'Camping 戶外咖啡組','溫度計+濾杯+濾紙+旅行收納包+咖啡杓+單品咖啡豆，六件組',2980,10,0,'1組'),
(107,4,'質感手提行李箱','手提設計適用於各種情境，短程旅行、日常休閒，增添儀式感',3680,10,1,'1入'),
(108,1,'露營必備裝飾燈串','露營帳篷燈串,8 種閃爍模式',480,10,0,'1入'),
(109,3,'睡眠眼罩','遮光睡眠眼罩，改善睡眠品質降低疲勞感',480,10,1,'1入'),
(110,3,'多功能行動電源','雙孔輸出多功能無線充行動電源，22.5W大功率快速充電',1080,10,1,'1入'),
(111,3,'旅行萬用轉接頭','萬國萬用轉接頭，出國旅遊旅行必備',380,10,1,'1入');



select * from cart_list;
insert into cart_list(cart_pri,cart_qty,mem_id,prod_id)
value
(699, 1, 1, 101),
(2999, 1, 1, 102),
(699, 1, 2, 101),
(2999, 1, 2, 102),
(3680, 1, 2, 107),
(11111, 1, 3, 103),
(1680, 1, 4, 105),
(2980, 1, 4, 106),
(2980, 1, 5, 106),
(3680, 1, 5, 107);

select * from product_picture;
insert into product_picture values (
1, 1, null
);

-- 訂單 --
 create table orders (
    ord_id int primary key auto_increment,
    mem_id int not null,
    points int default 1,
    ord_fee int default 80,
    recipient_phone varchar(15) not null,
    ord_pay_sta tinyint default 0 not null, -- 0:未付款,1:已付款
    recipient_name varchar(10),
    recipient_addr varchar(30),
    ord_sta tinyint default 0 not null, -- 0:出貨中,1:訂單完成
    total int,
    checktotal int,
    ord_time timestamp not null default current_timestamp
--  constraint fk_mem_id
--  foreign key(mem_id) references table_name(mem_id)
);
select * from orders;
INSERT INTO orders (ord_id, mem_id, points, ord_fee, recipient_phone, ord_pay_sta, recipient_name, recipient_addr, ord_sta, total, checktotal, ord_time)
VALUES
  (1, 1, 100, 50, '09111111111', 1, '許彤彤', '台北市大安區復興南路一段123號', 0, 1100, 1150, '2023-07-29 10:00:00'),
  (2, 2, 200, 80, '0922222222', 1, '陳安安', '新北市板橋區文化路二段456號', 0, 2200, 2280, '2023-07-29 11:30:00'),
  (3, 3, 150, 40, '0933333333', 1, '吳蓁蓁', '高雄市鳳山區中山西路789號', 0, 1190, 1230, '2023-07-29 12:45:00'),
  (4, 4, 300, 120, '0944444444', 1, '姜琳琳', '台中市西屯區文華路三段234號', 0, 420, 500, '2023-07-29 14:20:00'),
  (5, 5, 250, 90, '0955555555', 1, '劉灰辰', '桃園市中壢區永安南路五段567號', 0, 340, 420, '2023-07-29 15:10:00'),
  (6, 6, 50, 20, '0966666666', 1, '朱佩佩', '新竹市東區光復路一段890號', 0, 799, 850, '2023-07-29 16:30:00'),
  (7, 7, 400, 150, '0977777777', 1, '蔡教授', '彰化縣彰化市中山路六段1234號', 0, 1080, 1120, '2023-07-29 17:40:00'),
  (8, 8, 180, 60, '0988888888', 1, '蕭彤彤', '雲林縣斗六市明德路七段567號', 0, 999, 1079, '2023-07-29 18:20:00'),
  (9, 9, 120, 40, '0999999999', 1, '吳老師', '嘉義縣太保市中正路八段789號', 0, 3210, 3290, '2023-07-29 19:15:00'),
  (10, 10, 80, 30, '0900000000', 1, '蔡小菜', '屏東縣屏東市建國路九段234號', 0, 1110, 1190, '2023-07-29 20:00:00');
select * from orders;

-- 訂單明細 --
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
  (1, 101, 1, '這個商品非常不錯，味道很好。', 50, 4.5),
  (1, 102, 1, '太陽眼鏡很時尚，很喜歡它的設計。', 30, 4.0),
  (2, 101, 1, '溫暖又時尚，冬日必備!', 50, 4.5),
  (2, 102, 1, '這款太陽眼鏡的質量很好，我很滿意。', 30, 4.0),
  (2, 107, 1, '質感手提行李箱的設計很不錯，質量也很好。', 15, 3.5),
  (3, 103, 4, '大自然的氣息帶給我放鬆的感覺。', 40, 4.7),
  (4, 105, 3, '這個包包很有特色，我喜歡它的設計。', 35, 3.0),
  (4, 106, 1, 'Camping咖啡組非常實用，很適合露營。', 10, 3.9),
  (5, 106, 3, '這個咖啡組的內容豐富，很方便。', 35, 3.0),
  (5, 107, 2, '這個行李箱很實用，我很滿意。', 45, 4.4);
select * from order_details;
