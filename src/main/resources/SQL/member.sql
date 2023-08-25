
--力辰我新增了第12行
create table members (
	mem_id int primary key, 
	mem_email varchar(30),
	mem_password varchar(20),
	mem_name varchar(10),
	mem_gender tinyint ,
	mem_addr varchar(100),
	mem_grade int,
	mem_idcard varchar(10),
	mem_phone varchar(15),
	mem_point int,
	mem_sta tinyint,
	mem_group tinyint
);
--假資料也有更新
select * from members;
INSERT INTO members (mem_id, mem_email, mem_password, mem_name, mem_gender, mem_addr, mem_grade,mem_idcard, mem_phone, mem_point, mem_sta, mem_group)
VALUES
  (1,'member1@example.com', 'password1', 'tong', 2, 'Address 1', 1,'Q224000999', '0911111111', 100, 1, 0),
  (2,'member2@example.com', 'password2', 'lynn', 2, 'Address 2', 2,'Q224034567', '0922222222', 400, 0, 0),
  (3,'member3@example.com', 'password3', 'sian', 2, 'Address 3', 1,'A212869345','0933333333', 550, 1, 0),
  (4,'member4@example.com', 'password4', 'reynolds', 1, 'Address 4', 3,'P225483628','0944444444', 300, 2, 1),
  (5,'member5@example.com', 'password5', 'Katie', 2, 'Address 5', 2,'C224000999', '0955555555', 250, 1, 1),
  (6,'member6@example.com', 'password6', 'jas', 2, 'Address 6', 1,'R224000999','0966666666', 50, 0, 0),
  (7,'member7@example.com', 'password7', 'henry', 1, 'Address 7', 3,'K224000999', '0977777777', 50, 1, 0),
  (8,'member8@example.com', 'password8', 'David', 0, 'Address 8', 2,'M224000999', '0988888888', 180, 1, 0),
  (9,'member9@example.com', 'password9', 'hazel', 2, 'Address 9', 1,'J224000999', '0999999999', 120, 1, 1),
  (10,'member10@example.com', 'password10', 'tou', 1, 'Address 10', 1,'L224000999', '0900000000', 80, 2, 1);
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
  (1,'123456789', 'host1@example.com', 'password1', 'DavidWu', 0),
  (2,'987654321', 'host2@example.com', 'password2', 'tongtong', 0),
  (3,'111222333', 'host3@example.com', 'password3', 'lynnchiang', 0),
  (4,'444555666', 'host4@example.com', 'password4', 'touchen', 0),
  (5,'777888999', 'host5@example.com', 'password5', 'jasmine', 0),
  (6,'555666777', 'host6@example.com', 'password6', 'KatieWu', 1),
  (7,'999888777', 'host7@example.com', 'password7', 'sianchen', 1),
  (8,'111333555', 'host8@example.com', 'password8', 'hazelchen', 0),
  (9,'666777888', 'host9@example.com', 'password9', 'henry', 1),
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






create table product(
prod_id int primary key
);

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
