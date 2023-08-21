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
