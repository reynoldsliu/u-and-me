-- schedules行程
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
  ('台中一日游', 3, '2023-11-05', '2023-11-05', 2, b'1', NULL),
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