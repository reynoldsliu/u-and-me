create database uandme;
use uandme;

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
    group_sta tinyint not null default 0,
    payment_sta tinyint not null default 0
    -- constraint fk_mem_id
--     foreign key (mem_id) references members(mem_id),
--     
--     constraint fk_sch_id
--     foreign key (sch_id) references schedules(sch_id)
);
insert into `group` values (
1, 1, 1, default, 10, 20,
100000, '緯育4月遊', '2023-03-22 00:00', '2023-05-15 00:00',
'2023-05-01 00:00', 'JAVA集訓營', '進入後肝可能變黑白的', default ,0
);
insert into `group`
values
    (101, 101, 201, 5, 3, 8, 1000, 'Hiking Trip', '2023-08-10 09:00:00', '2023-08-15 12:00:00', '2023-08-01 18:00:00', 'A fun hiking trip to the mountains', 'Bring your own water and snacks', 0, 0),
    (102, 102, 202, 4, 2, 6, 800, 'Beach Vacation', '2023-09-05 14:00:00', '2023-09-12 10:00:00', '2023-08-25 23:59:59', 'Relax and unwind at the sunny beach', 'Sunscreen is a must', 0, 0),
    (103, 103, 203, 6, 4, 10, 1200, 'City Tour', '2023-07-20 11:00:00', '2023-07-25 16:00:00', '2023-07-15 22:00:00', 'Explore the city and visit popular landmarks', 'Comfortable shoes are recommended', 0, 0),
    (104, 104, 204, 3, 2, 4, 600, 'Camping Adventure', '2023-08-28 15:00:00', '2023-09-02 09:00:00', '2023-08-20 20:00:00', 'Experience the great outdoors with camping', 'Bring your own tent and sleeping bag', 0, 0),
    (105, 105, 205, 7, 5, 12, 1500, 'Cruise Journey', '2023-10-15 13:00:00', '2023-10-25 18:00:00', '2023-10-01 19:00:00', 'Enjoy a luxurious cruise experience', 'Formal attire required for dinner', 0, 0),
    (106, 106, 206, 2, 2, 4, 400, 'Skiing Adventure', '2023-12-05 08:00:00', '2023-12-10 16:00:00', '2023-11-25 23:59:59', 'Hit the slopes and have fun skiing', 'Skiing equipment available for rent', 0, 0),
    (107, 107, 207, 8, 6, 15, 1800, 'Road Trip', '2023-09-30 10:00:00', '2023-10-10 14:00:00', '2023-09-15 18:00:00', 'Embark on an exciting road trip across the country', 'Prepare some road trip playlists', 0, 0),
    (108, 108, 208, 4, 3, 8, 1000, 'Photography Tour', '2023-11-12 09:00:00', '2023-11-18 17:00:00', '2023-11-01 23:59:59', 'Capture stunning landscapes and wildlife with photography', 'Bring your own camera gear', 0, 0),
    (109, 109, 209, 6, 4, 10, 1200, 'Foodie Adventure', '2023-10-05 12:00:00', '2023-10-15 20:00:00', '2023-09-25 23:59:59', 'Explore various cuisines and food spots', 'Come hungry and ready to eat', 0, 0),
    (110, 110, 210, 3, 2, 5, 700, 'Fishing Trip', '2023-11-25 07:00:00', '2023-11-28 15:00:00', '2023-11-15 19:00:00', 'Enjoy fishing in serene lakes and rivers', 'Fishing equipment will be provided', 0, 0);
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