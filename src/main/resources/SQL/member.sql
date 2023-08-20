-- create schema member;
 -- use member;

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
