create schema main;
use main;
drop schema main;
drop schema onlineshoppingmall;

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

create table hosts (
	host_id int primary key, 
	host_phone varchar(15),
	host_email varchar(30),
	host_password varchar(20),
	host_name varchar(10),
	host_sta tinyint
);

select * from members;
insert into members(mem_id, mem_email, mem_password, mem_name, mem_gender)
values (1, 'annie980117@icloud.com', '980117', '多蕊咪', 2);
select * from members;

-- create schema onlineshoppingmall;
-- use onlineshoppingmall;
 
 create table orders (
    ord_id int primary key,
    fk_mem_id int,
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
    -- foreign key(fk_mem_id) references member.members(mem_id)
);
create table product(
prod_id int primary key
);

create table order_details(
	fk_ord_id int,
    fk_prod_id int,
    prod_qty int,
	prod_review varchar(50),
    prod_price int,
    prod_com_score decimal,
    primary key(fk_ord_id, fk_prod_id),
    foreign key(fk_ord_id) references orders(ord_id),
	foreign key(fk_prod_id) references product(prod_id)
    );
select * from orders;
insert into orders(ord_id, fk_mem_id, points, total, checktotal)
values (1, 7, 17, 117, 117);
select * from orders;

-- attractions景點相關表格建立
create table attraction_type(
attr_type_id int primary key,
attr_type_name varchar(10)
);

insert into attraction_type(attr_type_id, attr_type_name)
values
(1,"第一類"),
(2,"第二類"),
(3,"第三類"),
(4,"第四類");
-- select * from attraction_type;
-- drop table attraction_type;

create table attractions (
attr_id int primary key,
attr_veri_sta tinyint,
attr_sta int,
attr_name varchar(20),
-- attr_addr varchar(100),
-- attr_lon float,
-- attr_lat float,
-- attr_illa varchar(500),
attr_type_id int,
-- constraint attr_type_id
foreign key(attr_type_id) references attraction_type(attr_type_id)

-- attr_buss_time varchar(100),
-- attr_cost_range tinyint,
-- attr_rep varchar(500)
);
select * from attractions;
-- drop table attractions;

insert into attractions(attr_id, attr_veri_sta, attr_sta, attr_name, attr_type_id)
values
(1,0,0,'attr_01',1),
(2,0,0,'attr_02',2),
(3,0,0,'attr_03',3),
(4,0,0,'attr_04',4);

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
fk_attr_id int,
fk_mem_id int,
attr_col_illa varchar(500),
primary key (fk_attr_id, fk_mem_id),
foreign key(fk_mem_id) references members(mem_id),
foreign key(fk_attr_id) references attractions(attr_id)

);

insert into attraction_collections(fk_attr_id, fk_mem_id, attr_col_illa)
values
(1,1,"第一個會員的第一筆收藏");

-- select * from attraction_collections;
-- drop table attraction_collections;

-- drop table attraction_pictures;
create table attraction_pictures (
attr_pic_id int unsigned primary key,
attr_id int,
constraint fk_attr_id
foreign key(attr_id) references attractions(attr_id),
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
attr_com varchar(500),
foreign key(attr_id) references attractions(attr_id),
foreign key(mem_id) references members(mem_id)
);

insert into attraction_comments(attr_id, mem_id, attr_com_score, attr_com)
values
(1,1,0.1,"景點沒廁所");

-- select * from attraction_comments;
