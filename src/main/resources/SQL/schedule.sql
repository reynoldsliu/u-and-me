-- schedules行程
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
sch_copy BIT(1) default b'1' not null comment '0:不可複製 1:可以複製',
sch_cost int -- ,
-- constraint fk_schedules_members
-- foreign key (mem_id) references members(mem_id)
);
-- describe schedules;

INSERT INTO schedules (sch_id, sch_name, mem_id, sch_start, sch_end, sch_pub, sch_copy, sch_cost)
VALUES
  (1, 'Meeting 1', 101, '2023-06-21', '2023-06-21', 1, b'1', 0),
  (2, 'Event 1', 102, '2023-06-22', '2023-06-23', 0, b'1', 500),
  (3, 'Appointment 1', 103, '2023-06-24', '2023-06-24', 0, b'0', NULL),
  (4, 'Workshop 1', 104, '2023-06-25', '2023-06-26', 1, b'1', 0),
  (5, 'Conference 1', 105, '2023-06-27', '2023-06-28', 2, b'1', 1000),
  (6, 'Training 1', 106, '2023-06-29', '2023-06-29', 0, b'0', NULL),
  (7, 'Project 1', 107, '2023-06-30', '2023-07-01', 1, b'1', 0),
  (8, 'Seminar 1', 108, '2023-07-02', '2023-07-03', 2, b'1', 800),
  (9, 'Presentation 1', 109, '2023-07-04', '2023-07-04', 0, b'0', NULL),
  (10, 'Task 1', 110, '2023-07-05', '2023-07-05', 1, b'1', 0);
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
schrep_sta tinyint default 0 not null comment '0:審核中 1:已處理 2:已撤銷' -- ,
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
  (2, 102, 2, 'Schedule 2 violates community guidelines.', 202, 2),
  (3, 103, 3, 'Schedule 3 contains offensive language.', 203, 1),
  (4, 104, 1, 'Schedule 1 is a duplicate entry.', NULL, 0),
  (5, 105, 4, 'Schedule 4 has misleading information.', 204, 0),
  (6, 106, 5, 'Schedule 5 is spam.', 205, 1),
  (7, 107, 6, 'Schedule 6 is irrelevant.', NULL, 0),
  (8, 108, 2, 'Schedule 2 has inappropriate content.', 206, 0),
  (9, 109, 7, 'Schedule 7 is a duplicate entry.', NULL, 1),
  (10, 110, 8, 'Schedule 8 violates community guidelines.', 207, 2);
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