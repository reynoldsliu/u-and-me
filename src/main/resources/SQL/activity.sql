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

INSERT INTO activity (activ_pic, activ_name, activ_con, activ_starttime, activ_endtime, activ_sta)
VALUES
    (LOAD_FILE('/image1.jpg'), '家庭野餐日', '在公園中享受愉快的野餐時光，與家人一起共度美好時光。', '2023-07-28 10:00:00', '2023-07-28 12:00:00', 1),
    (LOAD_FILE('/image2.jpg'), '水上運動嘉年華', '來一場充滿刺激與樂趣的水上運動盛宴，感受水上樂園的魅力。', '2023-07-29 15:00:00', '2023-07-29 18:00:00', 1),
    (LOAD_FILE('/path/to/image3.jpg'), '城市探險之旅', '探索城市的角落與文化，發現城市中的瑰寶與故事。', '2023-07-30 09:30:00', '2023-07-30 11:30:00', 0),
    (LOAD_FILE('/path/to/image4.jpg'), '瑜伽與冥想工作坊', '學習瑜伽和冥想的技巧，平衡身心，感受寧靜與放鬆。', '2023-08-01 14:00:00', '2023-08-01 16:00:00', 1),
    (LOAD_FILE('/path/to/image5.jpg'), '小吃美食節', '品嚐來自世界各地的美食，滿足你的味蕾。', '2023-08-02 13:00:00', '2023-08-02 15:00:00', 1);


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
