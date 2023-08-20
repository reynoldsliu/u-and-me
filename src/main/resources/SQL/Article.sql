-- article 論壇
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
    report_reason varchar(800) ,-- not null
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



