-- last edit time: 2023-09-13/17:47

create schema main;
use main;
-- drop schema main;


-- members 許彤
create table members (
	mem_id int primary key auto_increment,
	mem_email varchar(30) UNIQUE not null,
	mem_password varchar(20) not null,
	mem_name varchar(10),
	mem_gender tinyint default 0 not null,  -- 0:不方便透露,1:男,2:女
	mem_city varchar(50),
	mem_dist varchar(50),
	mem_addr varchar(100) not null,
	mem_grade int,
    mem_idcard varchar(10),
    mem_idpic mediumblob,
	mem_phone varchar(15),
	mem_point int,
	mem_sta tinyint default 0 not null, -- 0:正常使用,1:停止使用,
	mem_group tinyint default 0 not null  -- 0:非團主,1:團主
);
select * from members;
INSERT INTO members (mem_id, mem_email, mem_password, mem_name, mem_gender, mem_city,mem_dist,mem_addr, mem_grade, mem_idcard,mem_phone, mem_point, mem_sta, mem_group)
VALUES
  (1,'member1@example.com', 'password1', '許彤彤', 2, '台北市','大安區','復興南路一段123號', 1,'A123456789','0911111111', 100, 1, 0),
  (2,'lynnchiang1220@gmail.com', 'password2', '姜小琳', 2, '新北市','板橋區','文化路二段456號', 2,'B123456789', '0922222222', 400, 0, 0),
  (3,'member3@example.com', 'password3', '陳安安', 2, '高雄市','鳳山區','中山西路789號', 1,'C123456789','0933333333', 550, 1, 0),
  (4,'member4@example.com', 'password4', '劉覽力辰', 1, '台中市','西屯區','文華路三段234號',1,'D123456789','0944444444', 300, 0, 1),
  (5,'member5@example.com', 'password5', '吳蓁蓁', 2, '桃園市','中壢區','永安南路五段567號', 2,'E123456789', '0955555555', 250, 1, 1),
  (6,'member6@example.com', 'password6', '朱小妹', 2, '新竹市','東區','光復路一段890號', 1,'F123456789','0966666666', 50, 0, 0),
  (7,'member7@example.com', 'password7', '斯斯', 1, '彰化縣','彰化市','中山路六段1234號', 3,'G123456789', '0977777777', 50, 1, 0),
  (8,'member8@example.com', 'password8', '阿黃', 0, '雲林縣','斗六市','明德路七段567號', 2,'H123456789', '0988888888', 180, 1, 0),
  (9,'member9@example.com', 'password9', '潘信隆', 2, '嘉義縣','太保市','中正路八段789號', 1,'I123456789', '0999999999', 120, 1, 1),
  (10,'member10@example.com', 'password10', '蕭阿彤', 1, '屏東縣','屏東市','建國路九段234號', 1,'J123456789', '0900000000', 80, 0, 1);
select * from members;

create table hosts (
	host_id int primary key auto_increment,
	host_phone varchar(15) UNIQUE,
	host_email varchar(30) UNIQUE not null,
	host_password varchar(20) not null,
	host_name varchar(10) not null,
	host_sta tinyint default 0 not null  -- 0:正常使用(在職)1:停止使用(停職)
);

select * from hosts;
INSERT INTO hosts (host_id,host_phone, host_email, host_password, host_name, host_sta)
VALUES
  (1,'123456789', 'host1@example.com', 'password1', '大衛師傅', 0),
  (2,'987654321', 'host2@example.com', 'password2', '大吳', 0),
  (3,'111222333', 'host3@example.com', 'password3', '朱佩佩', 0),
  (4,'444555666', 'host4@example.com', 'password4', '劉辰', 0),
  (5,'777888999', 'host5@example.com', 'password5', '吳小蓁', 0),
  (6,'555666777', 'host6@example.com', 'password6', '蕭彤彤', 1),
  (7,'999888777', 'host7@example.com', 'password7', '斯斯', 1),
  (8,'111333555', 'host8@example.com', 'password8', '陳小安', 0),
  (9,'666777888', 'host9@example.com', 'password9', '姜阿琳', 1),
  (10,'222333444', 'host10@example.com', 'password10', '許阿彤', 1);
select * from hosts;


create table group_register(
	mem_id int primary key,
	gr_idcard varchar(10),
	gr_idcard_pic mediumblob
	-- constraint fk_mem_id
    -- foreign key (mem_id) references members(mem_id)
);


-- create schema onlineshoppingmall;
-- use onlineshoppingmall;

 create table orders (
    ord_id int primary key auto_increment,
    mem_id int not null,
    points int,
    ord_fee int,
    recipient_phone varchar(15) not null,
    ord_pay_sta tinyint default 0 not null, -- 0:未付款,1:已付款
    recipient_name varchar(10),
    recipient_addr varchar(30),
    ord_sta tinyint default 0 not null, -- 0:未出貨,1:已出貨,2:已到貨,3:訂單完成,4:訂單取消
    total int,
    checktotal int,
    ord_time timestamp not null default current_timestamp
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



-- 揪團表格建立 宇航
-- create database uandme;
-- use uandme;
create table `group`
(
	group_id int primary key auto_increment, --
    mem_id int not null, --
    sch_id int not null, --
    members int default 0 not null,--
    min_member int not null,
    max_member int not null,
    amount int not null,
    theme varchar(32) not null,
    start_date timestamp not null,
    dep_date timestamp not null,
    deadline timestamp not null,
    group_desc varchar(200) not null,
    notice varchar(500) not null,
    group_sta tinyint not null default 0,
    payment_sta tinyint not null default 0,
    cover mediumblob
    -- constraint fk_mem_id
--     foreign key (mem_id) references members(mem_id),
--
--     constraint fk_sch_id
--     foreign key (sch_id) references schedules(sch_id)
);
insert into `group` (group_id, mem_id, sch_id, members, min_member, max_member, amount, theme, start_date, dep_date, deadline, group_desc, notice, group_sta, payment_sta)
values
    (1, 4, 17, 9, 10, 20, 2000, '台南古蹟遊', '2023-09-14 21:13:18', '2023-10-14 08:00:00', '2023-10-04 08:00:00', '探索臺南古城，品味古蹟魅力，古井、神壇、寺廟、城牆，歷史與文化交織，令人難忘的旅程。', '台南，是台灣充滿歷史與文化底蘊的城市，擁有眾多令人嘆為觀止的古蹟，它們見證了台灣數百年的變遷，每一座古蹟都散發著濃厚的古老氛圍，是一個絕佳的旅遊目的地。

首先，台南安平古堡是一個不可錯過的地方。這座荷蘭時期的堡壘建於17世紀，如今已成為一個歷史博物館，展示了當時的生活和文化。

遊客可以在堡壘的城牆上漫步，俯瞰海景，感受當地的過去。

另一個必訪之處是台南孔廟，它建於1665年，是台灣最古老的孔廟之一。這個寺廟不僅是儒家學問的重要場所，也是一個美麗的建築，充滿了雕刻和壁畫。

另外，台南的億載金城也是一個迷人的古蹟。這座城牆建於18世紀，保護著當時的城市免受外來入侵。現在，遊客可以在城牆上漫步，欣賞城市的美景。

除此之外，台南還有許多古老的寺廟、古井和古老的街區，都值得一遊。在這個城市裡，你將有機會體驗到台灣的歷史和文化，並品味到當地的美食。

總之，台南的古蹟旅遊絕對是一個充滿教育和文化價值的旅程，讓你深入了解台灣的歷史，同時也享受當地的風土人情。無論你是歷史愛好者還是文化探索者，台南都會讓你流連忘返。',
 0, 0),
	(2, 1, 15, 6, 4, 10, 1288, '新竹一日遊', '2023-09-14 21:27:18', '2023-12-14 08:00:00', '2023-10-14 08:00:00', '探索新竹風光，尋訪科學城、美食街，體驗文化融合，一日遊充滿驚喜與樂趣。', '來到新竹一日遊，您將迎接充滿驚喜和樂趣的冒險。早上，您可以開始您的旅程，參觀新竹市最著名的地標之一 - 東門城。這座城門建於1826年，是新竹市的象徵，提供了豐富的歷史故事。

接下來，您可以前往新竹市區的美食街區，如東大路美食街，品嚐當地的美食。新竹以其道地的臺灣小吃而聞名，您可以嘗試肉圓、魚丸湯、米粉湯等當地特色菜餚。

午後，您可以參觀新竹國際藝術村，這個藝術聚落充滿創意和藝術氛圍，您可以欣賞當地藝術家的作品，並參加藝術工作坊。

如果您對科學和技術感興趣，不要錯過新竹科學園區。這個現代化的科技據點擁有各種科技公司和研究機構，您可以參觀一些科學展示和實驗。

傍晚時分，您可以前往新竹海港夜市，品味臺灣的夜市美食，包括現炸的雞排、珍珠奶茶和各種海鮮料理。夜市也是體驗當地文化和購物的好地方。

新竹一日遊將帶給您多姿多彩的體驗，無論您是尋找歷史、藝術、科技還是美食，都能在這個城市找到滿足。不論您是獨自旅行、與朋友一同，或是家庭出遊，新竹都將為您提供難忘的回憶。',
 0, 0),
	(3, 1, 1, 3, 30, 60, 6666, '台北之旅', '2023-09-14 21:34:11', '2023-11-14 08:00:00', '2023-10-14 08:00:00', '品味台北美食，探索文化遺產，購物樂趣，一趟精彩之旅，等著您親身體驗。' ,'來到臺北，您將開啟一段豐富多彩的旅程，這座城市結合了現代風華和悠久歷史，滿足了各種旅遊需求。

首先，您可以參觀臺北的文化遺產，如國立故宮博物院，這是世界上最重要的博物館之一，擁有無數珍貴的中國藝術品。

隨後，您可以參觀士林官邸，這座日式官邸融合了東西文化，充滿迷人的花園和建築。

接著，不要忘了品味臺北的美食。臺北是臺灣的美食之都，您可以品嘗到各種小吃，如小籠包、牛肉麵、鹹酥雞等。夜市也是必去之地，如饒河夜市、士林夜市，讓您品味當地風味。

臺北還擁有現代化的購物中心，如信義區的101大樓和東區的微風廣場，供您購物愉悅。如果您喜歡藝術和文創，可以參觀華山1914文創園區，探索當代藝術和手工藝品。

最後，別忘了體驗臺北的夜生活。夜店、酒吧、音樂表演場所遍佈城市，讓您盡情狂歡。

總之，臺北之旅充滿驚喜和多樣性，不管您喜歡歷史、美食、購物還是夜生活，這座城市都會滿足您的期待。臺北是一個令人難以忘懷的地方，等著您來探索。',
0, 0),
	(4, 1, 10, 2, 1, 10, 877, '雪隧一日遊', '2023-09-14 21:38:56', '2023-11-14 08:00:00', '2023-10-14 08:00:00', '探訪雪隧美景，尋找大自然的奇蹟，一日遊滿載驚喜與自然之美。', '雪隧一日遊是臺灣北部地區的絕佳選擇，帶您進入大自然的奇妙世界。出發早晨，您將前往位於新竹縣尖石鄉的雪山隧道，

    這條隧道被譽為是臺灣最美的公路之一。沿途您將欣賞到壯觀的山川風光、翠綠的森林以及清澈的溪流。

雪山隧道的特色之一是其穿越山脈的設計，您將駕駛穿越隧道，緩緩爬升至山頂，一路上能夠看到壯觀的巖壁和瀑布。到達山頂後，您可以在雪山主峰周圍漫步，欣賞到壯觀的高山風光。

如果您是登山愛好者，還可以考慮挑戰雪山主峰，這是臺灣第二高峰，提供了一個具有挑戰性的登山體驗。

除了自然景觀，雪隧地區還擁有豐富的原住民文化。您可以參觀當地的部落，瞭解他們的生活方式、藝術和傳統飲食。

一日遊的結束，您可以在當地餐廳品嚐當地美食，如山豬肉、野菜和特色甜品。這個經驗將為您的雪隧之旅畫下美好的句點。

總之，雪隧一日遊將帶給您難忘的大自然體驗，讓您逃離城市的繁忙，沉浸在山林和原住民文化之中。這是一個能讓您重新充電，感受自然之美的絕佳選擇。',
 0, 0),
	(5, 1, 6, 3, 10, 20, 2000, '九份老街', '2023-09-14 21:43:04', '2024-01-14 08:00:00', '2023-11-14 08:00:00', '漫步九份老街，古色古香，小吃美食，感受台灣獨特的文化氛圍，一趟充滿回憶的旅程。', '九份老街位於臺灣新北市瑞芳區，是一個充滿懷舊風情和獨特魅力的旅遊目的地。這條老街保存著日治時代的古老建築和文化，令人彷彿穿越時光隧道。

首先，九份老街以其山城的特殊地理位置而聞名，擁有壯觀的山海景觀。您可以漫步於狹窄的巷弄之間，欣賞維多利亞式建築和日本風格的房屋。

這裡的街景彷彿是一部老式臺灣電影的場景，帶您回到了過去。

在九份，您絕對不能錯過的是品嚐當地小吃。試試傳統的擔仔麵、芋圓、貢丸湯和花生冰淇淋。這裡的小吃多彩多姿，滿足了各種味蕾。

此外，您可以參觀九份金瓜石礦坑博物館，瞭解當地的礦業歷史。九份曾經是一個繁忙的金礦區，博物館展示了礦業工具、文物和礦坑的歷史。

傍晚時分，您可以在老街上欣賞到美麗的夜景。燈籠點亮的老街在夜晚顯得格外浪漫，而且您還可以嘗試參與放天燈的傳統活動，讓您的旅程更加難忘。

總之，九份老街是一個充滿歷史、文化和美食的寶庫，讓您深入體驗臺灣的獨特之處。無論您是喜愛攝影、美食、或是文化探索，這個迷人的地方都會滿足您的各種旅遊愛好。',
 0, 0),
	(6, 3, 8, 2, 1, 30, 4234, '台東海線', '2023-09-14 22:08:03', '2023-10-25 08:00:00', '2023-10-18 08:00:00', '探索台東海線，沿著海岸線欣賞美麗景色，享受寧靜海濱，感受大自然的美。', '台東海線，位於台灣東部，是一條令人嚮往的海岸線旅遊路線，充滿自然美景和獨特文化。這條路線貫穿台東縣，擁有令人驚艷的海岸風光和豐富的人文景點。\n\n首先，您可以從台東市出發，前往知本溫泉區，享受溫泉泡湯的悠閒。接著，您可以沿著海線前進，欣賞壯觀的太平洋景色，沙灘和岩石海岸。\n\n沿途還有許多美麗的海灣和觀景點，如三仙台、石梯坪等，提供了絕佳的拍照機會。\n\n台東海線也是台灣原住民文化的一個重要地區。您可以參觀東部的原住民部落，了解他們的傳統文化、手工藝品和美食。部落居民熱情好客，讓您深入體驗台灣原住民的獨特生活方式。\n\n如果您喜歡探險，不要忘了參加一些戶外活動，如衝浪、海釣、健行等。台東的自然環境豐富多樣，讓您可以盡情享受大自然的美麗。\n\n最後，在台東海線的旅程中，您可以品嘗當地的美食，包括新鮮的海鮮、特色小吃和台灣咖啡。這些美食將豐富您的味蕾體驗，讓您感受到台東的獨特風味。\n\n總之，台東海線是一條充滿驚喜和美麗的旅遊路線，適合喜愛自然、文化和探險的遊客。在這裡，您將有機會深入了解台灣東部地區的獨特之處，並創造難忘的回憶。', 0, 0),
	(7, 3, 4, 2, 1, 20, 2888, '台中一日遊', '2023-09-14 22:13:14', '2023-11-20 08:00:00', '2023-10-22 08:00:00', '品味台中美食，參觀文化景點，一日遊充實有趣，絕對讓您愉快滿載而歸。', '台中一日遊是一趟豐富多彩的旅程，這座城市擁有令人驚艷的景點、美食和文化。\n\n早上，您可以前往彩虹眷村，這個彩色的村落是由老兵家屬所繪製而成，充滿藝術氛圍。您可以在這裡拍照、品味街頭小吃，並了解台灣的歷史。\n\n接下來，您可以前往台中國家歌劇院，這座現代化的建築是台灣最重要的表演藝術場地之一，不僅有出色的音樂和表演，還擁有令人印象深刻的建築設計。\n\n午餐時間，您可以前往台中的逢甲夜市，這是台灣最大的夜市之一，擁有各種美食選擇，\n\n包括炸雞排、珍珠奶茶、臭豆腐等。夜市也是一個購物的好地方，您可以找到各種小吃、衣物、飾品等。\n\n下午，您可以參觀台中的一些博物館，如國立台灣美術館或國立自然科學博物館，深入了解藝術和科學。\n\n傍晚時分，您可以前往台中港區，欣賞夕陽和夜景。這裡有許多海鮮餐廳，讓您品嘗新鮮的海產。\n\n最後，如果您有時間，可以參觀台中市區的夜景，如一中街和草悟道，這些地方在夜晚充滿繁華和活力。\n\n總之，台中一日遊提供了豐富的文化、美食和娛樂選擇，無論您是藝術愛好者、美食家還是探索者，都能在這座城市找到滿足。台中的多樣性和活力將確保您度過一個難忘的一日遊。', 0, 0),
	(8, 3, 21, 0, 10, 21, 2144, '樂園一日遊', '2023-09-14 22:15:49', '2023-11-27 08:00:00', '2023-10-30 08:00:00', '體驗樂園刺激，玩樂無極限，一日遊充滿歡笑和刺激，絕對令您流連忘返。', '一日遊適合所有年齡層的遊客，充滿樂趣和刺激。樂園是一個讓您放鬆身心，逃離現實世界的理想之地。\n\n早上，您可以開始您的一日遊，參觀樂園的主要景點。這包括遊樂設施，如雲霄飛車、旋轉木馬、碰碰車，以及主題遊樂區，\n\n如童話世界、未來城市等。不論您是喜歡刺激的高空遊樂設施還是更喜歡輕鬆的家庭娛樂，樂園都有適合您的選擇。\n\n中午，您可以品嚐樂園的美食。樂園通常提供各種美食選擇，包括快餐、主題餐廳和小吃攤位。您可以嘗試當地特色菜肴，或是享受園內的美味午餐。\n\n下午，您可以繼續遊覽樂園，參加各種表演和娛樂活動。樂園經常有精彩的表演，如煙火秀、魔術表演、音樂演出等，讓您度過愉快的時光。\n\n傍晚時分，您可以參加樂園的夜間活動，如夜間遊行、燈光秀等。樂園在夜晚變得格外美麗，充滿繽紛的燈飾和氛圍。\n\n無論您是單獨旅行、與家人一同，還是和朋友結伴而來，樂園一日遊都將為您提供難忘的體驗。\n\n這是一個讓您盡情玩樂、放鬆心情的好地方，無論您是大人還是孩子，都能找到樂趣。不要錯過這個機會，在樂園度過充實的一日遊！', 0, 0);
	select * from `group`;


create table reg_form
(
	form_id int primary key, -- auto_increment
    group_id int not null,
    mem_id int not null,
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
insert into reg_form values
	(1, 1, 6, 'member6@example.com', '0928378987', 3, '2023-09-14 23:07:37'),
    (2, '1', '7', '456@gmail.com', '0988777666', '5', '2023-09-14 23:14:23'),
    (3, '1', '7', '456@gmail.com', '0928378987', '1', '2023-09-14 23:15:36'),
    (4, '2', '7', '456@gmail.com', '0928378987', '6', '2023-09-15 01:41:39'),
    (5, '3', '7', '12352@gmail.com', '0928378987', '3', '2023-09-15 01:44:02'),
    (6, '4', '7', 'henryak57913@gmail.com', '0928378987', '2', '2023-09-15 01:47:08'),
    (7, '5', '7', '12352@gmail.com', '0928378987', '2', '2023-09-15 01:52:36'),
    (8, '11', '7', '12352@gmail.com', '0928378987', '2', '2023-09-15 02:05:29'),
    (9, '12', '7', '456@gmail.com', '0928378987', '2', '2023-09-15 02:06:04');


select * from reg_form;

create table member_detail
(
	detail_id int primary key auto_increment,
    form_id int not null,
    `name` varchar(32) not null,
    idnumber char(10) not null,
    birthday date not null,
    gender enum('男','女') not null default '男',
	refund_sta tinyint not null default 0,
    reason varchar(200),
    `account` varchar(22),
    refund_date timestamp on update CURRENT_TIMESTAMP,
    refund int
--     constraint fk_form_id
--     foreign key (form_id) references reg_form(form_id)
);
insert into member_detail values
	('1', '1', '測試', 'H123456778', '1997-01-16', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('2', '1', '測試', 'D123456778', '2000-01-23', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('3', '1', '測試', 'A123456778', '1987-06-24', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('4', '2', '測試', 'H123456778', '2007-12-22', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('5', '2', '測試', 'H123456778', '1992-01-25', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('6', '2', '測試', 'D123456778', '1997-08-23', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('7', '2', '測試', 'A123456778', '1999-12-31', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('8', '2', '測試', 'F123456778', '1999-09-24', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('9', '3', '測試', 'H123456778', '1994-01-12', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('10', '4', '測試二', 'A123456778', '2023-08-15', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('11', '4', '測試二', 'D123456778', '2023-07-15', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('12', '4', '測試二', 'A123456789', '2023-07-15', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('13', '4', '測試二', 'H123456778', '2023-08-15', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('14', '4', '測試二', 'A123456789', '2023-04-15', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('15', '4', '測試二', 'A123456789', '2023-05-15', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('16', '5', '測試三', 'H123456778', '2023-08-15', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('17', '5', '測試三', 'H123456778', '2023-07-15', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('18', '5', '測試三', 'D123456778', '2023-07-15', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('19', '6', '測試四', 'H123456778', '2023-07-15', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('20', '6', '測試四', 'H123456778', '2023-08-15', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('21', '7', '測試五', 'H123456778', '2023-07-15', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('22', '7', '測試五', 'A123456778', '2023-07-15', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('23', '8', '測試六', 'A123456778', '2023-08-15', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('24', '8', '測試六', 'H123456778', '2023-08-15', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('25', '9', '測試七', 'H123456778', '2023-06-15', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL),
    ('26', '9', '測試七', 'A123456778', '2023-07-15', '男', '0', NULL, NULL, '2023-09-15 02:35:50', NULL);

select * from member_detail;


-- attractions景點相關表格建立 劉力辰
create table attractions (
attr_id int primary key auto_increment,
attr_veri_sta tinyint,-- deprecated
attr_sta int default 1,-- 預設上架
attr_name varchar(20) not null,
attr_addr varchar(100) not null,
attr_lon float,
attr_lat float,
attr_illa varchar(500),
attr_type varchar(100),
attr_buss_time varchar(200) default '09:00-18:00|09:00-21:00',
attr_cost_range tinyint,
attr_rep varchar(500) -- deprecated
);

-- 更換有效地址Reynolds
INSERT INTO attractions (attr_id, attr_veri_sta, attr_sta, attr_name, attr_addr, attr_lon, attr_lat, attr_illa, attr_type, attr_buss_time, attr_cost_range, attr_rep)
VALUES
  (1, 1, 1, '中壢緯育', '台灣桃園市中壢區復興路緯育TibaMe附設中壢職訓中心', 121.225, 24.9576, '暫無描述', 1, '0830~1800|0830~2200', 2, 'no report record'),
  (2, 1, 1, '台北101', '台灣台北市信義區市府路台北101購物中心', 121.564, 25.0341, '暫無描述', 2, '1100~2130|1100~2130', 2, 'no report record'),
  (3, 1, 1, '基隆廟口夜市', '台灣基隆市玉田里仁三路基隆廟口夜市', 121.744, 25.1282, '暫無描述', 2, '0800~0000|1200~0000|1200~0000|1200~0000|1200~0000|1200~0000|1200~0000', 2, 'no report record'),
  (4, 1, 1, '清華大學', '台灣新竹市光復路二段清華大學', 120.997, 24.7961, '暫無描述', 2, '暫無資料', 2, 'no report record'),
  (5, 1, 1, '宮原眼科', '台灣台中市中區中山路宮原眼科', 120.684, 24.1378, '暫無描述', 2, '1000~2100|1000~2100|1000~2100|1000~2100|1000~2100|1000~2100|1000~2100', 2, 'no report record'),
  (6, 1, 1, '鳳山高中', '台灣高雄市鳳山區光復路二段鳳山高中', 120.346, 22.6298, '暫無描述', 2, '暫無資料', 2, 'no report record'),
  (7, 1, 1, '阿里山國家森林遊樂區', '台灣嘉義縣阿里山國家森林遊樂區', 120.803, 23.511, '暫無描述', 2, '暫無資料', 2, 'no report record'),
  (8, 1, 1, '合歡山南峰', '台灣南投縣合歡山南峰', 121.269, 24.1243, '暫無描述', 2, '暫無資料', 2, 'no report record'),
  (9, 1, 1, '中央大學', '台灣桃園市中壢區中大路中央大學', 121.195, 24.9682, '暫無描述', 2, '0800~1700|0800~1700|0800~1700|0800~1700|0800~1700', 2, 'no report record'),
  (10, 1, 1, '中壢火車站', '台灣桃園市中壢區中正路中壢火車站', 121.226, 24.9537, '暫無描述', 2, '暫無資料', 2, 'no report record');

select * from attractions;

create table attraction_collections (
attr_id int,
mem_id int,

primary key (attr_id, mem_id)
);

insert into attraction_collections(attr_id, mem_id)
values
(1,1),(2,1),(3,1),
(2,2),(3,2),(4,2),
(3,3),(4,3),(5,3),
(4,4),(5,4),(6,4),
(5,5),(6,5),(7,5),
(6,6),(7,6),(8,6),
(7,7),(8,7),(9,7),
(8,8),(9,8),(10,8),
(9,9),(10,9),(1,9),
(10,10),(1,10),(2,10);

-- select * from attraction_collections;
-- drop table attraction_collections;

-- drop table attraction_pictures;
create table attraction_pictures (
attr_pic_id int unsigned primary key auto_increment,
attr_id int,
-- constraint fk_attr_id
-- foreign key(attr_id) references attractions(attr_id),
attr_pic_data longtext
);


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

-- 暫時建的會員--


-- 商品收藏明細 --
create table product_collection(
prod_id int,
mem_id int,
primary key (prod_id, mem_id)
-- constraint fk_prod_id
-- foreign key (prod_id) references product (prod_id),
-- constraint fk_mem_id
-- foreign key (mem_id) references members (member_id)
);

-- 商品圖片庫 --
create table product_picture(
prodpic_id int primary key auto_increment,
prod_id int not null,
prod_pic mediumblob -- ,
-- constraint fk_prod_id
-- foreign key(prod_id) references product (prod_id)
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
insert into product(prod_id,prodcat_id,prod_name,prod_con,prod_pri,prod_qty,prod_spec)
values
(101,2,'日月潭紅茶','台茶18號，茶湯呈現典雅金紅色，茶香中帶有淡淡薄荷肉桂香氣，此香氣更被世界紅茶專家譽為日月潭紅茶特有之「台灣香」',699,10,'3入'),
(102,3,'設計師聯名款太陽眼鏡','UandMe與設計師太陽眼鏡款，擷取時尚與文化融入設計，絕對是旅行中不可或缺的配件 ',2999,10,'1入'),
(103,4,'大自然的氣息','工作繁忙沒辦法安排假期旅行嗎? 把大自然的氣息帶回去，讓你在家也能有沉浸式的旅行體驗',11111,10,'1入'),
(104,2,'冠軍烘培咖啡豆','COFFEE',1080,10,'2入'),
(105,1,'原住民手工編織包','BAGS',1680,10,'1入'),
(106,3,'多功能行動電源','POWERBANK',1080,10,'10入'),
(107,4,'質感手提行李箱','LUGGAGE',3680,10,'10入'),
(108,1,'手沖咖啡旅行組','COFFEEEEE',2980,10,'10入'),
(109,1,'露營必備裝飾燈串','LIGHT',480,10,'1入');


select * from cart_list;
insert into cart_list(cart_pri,cart_qty,mem_id,prod_id)
value
(299, 1, 1, 2),
(200, 3, 2, 2),
(150, 1, 3, 3),
(300, 4, 4, 4),
(120, 2, 5, 5),
(180, 1, 6, 6),
(250, 3, 7, 7),
(90, 2, 8, 8),
(270, 4, 9, 9),
(160, 3, 10, 10);

insert into product_picture values (
1, 1, null
);

-- article 論壇 珮儀
-- create schema article;

CREATE DATABASE  IF NOT EXISTS `main`;
USE `main`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: main
-- ------------------------------------------------------
-- Server version	8.0.33

/*!50503 SET NAMES utf8 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `article_id` int NOT NULL AUTO_INCREMENT,
  `mem_id` int DEFAULT '888',
  `ac_type_id` int DEFAULT NULL,
  `article_title` varchar(45) NOT NULL,
  `article_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `article_like` int DEFAULT '0',
  `comment_num` int DEFAULT '0',
  `article_con` varchar(1000) NOT NULL,
  `article_state` tinyint DEFAULT '1',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
INSERT INTO `article` VALUES
 (1,4,3,'日月潭是台灣最美的湖泊嗎','2023-09-02 16:00:00',8,9,'日月潭被譽為該國最美的湖泊之一。它位於南投縣，被認為是自然之美的極致體現。湖泊呈現出一個月亮和太陽的形狀，因此得名日月潭。您可以在湖上乘坐遊船，欣賞周圍山脈的壯觀美景，或者品味當地美味的小吃。日月潭是放鬆心情和品味自然之美的理想之地。',1,NULL),
 (3,3,3,'九份 - 台灣的小威尼斯','2023-09-02 16:00:00',10,7,'九份是一個風景如畫的小村莊，坐落在山坡上，俯瞰著台灣北海岸的海灣。這個地方因其曲折的街道和懸崖上的茶館而聞名。您可以漫遊於狹窄的巷道中，品味當地的小吃，並欣賞夕陽下的壯麗海景。九份也是知名的電影《悲情城市》的取景地，吸引了眾多的影迷。',0,NULL),
 (5,2,1,'金門 - 歷史與自然的結合','2023-09-02 16:00:00',2,7,'金門是台灣的離島之一，以其豐富的歷史和自然美景而聞名。這裡保存著許多古老的寺廟和碉樓，是了解台灣歷史的好地方。此外，您還可以在金門的沙灘上度過一個寧靜的下午，或者品味當地美食，如海鮮和花生酥餅。',1,NULL),
 (6,1,2,'玉山 - 台灣之巔','2023-09-02 16:00:00',1,8,'玉山是台灣最高的山脈，也是一個受歡迎的登山目的地。挑戰者可以嘗試攀登玉山主峰，一路上欣賞壯觀的自然風景，包括高山湖泊和冰河地形。峰頂的觀景台是欣賞整個台灣風景的理想之地。',1,NULL),
 (7,6,3,'墾丁 - 海灘樂','2023-09-03 07:15:33',1,5,'墾丁是台灣南部的一個熱門海灘度假勝地，擁有美麗的沙灘和藍色的海洋。這裡還有水上活動，如衝浪和浮潛，以及著名的墾丁大街，提供美味的當地小吃和購物。夜晚，您可以參加沙灘派對，享受音樂和娛樂。',1,NULL),
 (8,6,2,'布拉格風格小鎮 - 阿里山的童話世界','2023-09-02 16:00:00',1,5,'布拉格風格小鎮是阿里山的一個獨特景點，它的建築和風格仿照捷克首都布拉格。這個小鎮有著歐洲風情的建築、街道和咖啡廳，讓您感覺彷彿置身於歐洲童話故事中。您可以在這裡漫遊，品味美味的咖啡和點心，感受不同的文化風情',1,NULL),
 (9,6,1,'花蓮七星潭 - 海岸美景','2023-09-03 07:15:33',1,5,'花蓮七星潭是台灣東部海岸的一個美麗景點，以其清澈的海水和壯觀的海岸線而聞名。您可以在這裡享受寧靜的海灘，或者選擇參加水上活動，如衝浪和滑翔翼飛行。七星潭也是觀賞日出的好地方，一大早，太陽升起時的景色令人難以置信。',1,NULL),
 (10,6,2,'九族文化村 - 原住民文化之旅','2023-09-03 07:15:38',9,6,'九族文化村是一個原住民文化主題村莊，位於南投縣。在這裡，您可以了解台灣不同原住民部落的文化、藝術和傳統。村莊內有民族表演、手工藝品和傳統美食，讓您深入了解台灣多元的文化。此外，村莊周圍還有美麗的自然景色，如翠綠的山脈和湖泊。',1,NULL),
 (11,6,3,'九份老街 - 遠離塵囂的小巷弄','2023-09-03 07:15:33',1,5,'九份老街是台灣一個受歡迎的觀光勝地，這裡的小巷弄充滿著懷舊的氛圍。您可以品味當地的小吃，如芋圓冰和魚丸湯，同時欣賞古老的建築和擁擠的巷道。這個地方是《悲情城市》電影的拍攝地，吸引了許多影迷前來朝聖。',1,NULL),
 (12,6,1,'東北角海岸 - 自然奇觀之旅','2023-09-03 07:15:33',1,5,'台灣東北角海岸以其令人驚嘆的自然奇觀而聞名。您可以參觀野柳地質公園，觀察到壯觀的岩石風化現象，如女王頭和陰陽海。這個地區還有美麗的海灘，如福隆和貢寮，是放鬆和沐浴陽光的理想場所。',1,NULL),
 (13,6,1,'高雄蓮池潭 - 寧靜的湖泊之旅','2023-09-03 07:15:33',1,5,'高雄蓮池潭是一個寧靜的湖泊，坐落在綠意盎然的山區中。您可以租一艘小船，在湖上划船，欣賞湖光山色。這個地方也是賞荷花的好地方，每年夏天，成片的荷花盛開在湖面上，美不勝收。',1,NULL),
 (14,6,2,'金瓜石 - 礦業歷史之旅','2023-09-02 16:00:00',4,5,'金瓜石是台灣一個歷史豐富的地方，曾經是黃金礦業的中心。您可以參觀金瓜石黃金博物館，了解礦業歷史，還可以參觀廢棄礦坑和礦坑湖泊。這個地區的山脈也是徒步愛好者的好去處，提供壯觀的山間風景。',1,NULL),
 (15,5,3,'佛光山 - 寧靜的靈修之旅','2023-09-03 07:15:33',1,7,'佛光山是台灣一個寧靜的佛教寺廟，位於高雄市郊。這個寺廟擁有壯觀的建築和花園，提供遊客一個冥想和靈修的好場所。您可以參觀寺廟內的佛像，欣賞山脈和大自然的美麗景色。',1,NULL),
 (16,4,1,'大溪老街 - 古色古香的小鎮','2023-09-03 07:15:33',1,4,'大溪老街是一個保存完好的古老小鎮，位於新北市。這裡有許多古老的建築、廟宇和懷舊的街道，讓您彷彿穿越時光回到過去。您可以品味當地的小吃，如鳳梨酥和米糕，同時欣賞古老的文化遺產。',1,NULL),
 (17,5,1,'澎湖群島 - 藍色的海洋天堂','2023-09-02 16:00:00',1,3,'澎湖群島是台灣的離島之一，以其美麗的海洋景觀而聞名。您可以參觀白沙灣、澎湖環島公路和七美島，欣賞壯觀的海岸線和碧藍的海水。這裡還有豐富的海洋生態，是浮潛和潛水的熱門地點。',1,NULL),
 (18,4,2,'嘉義阿里山森林鐵路 - 蒸汽火車之旅','2023-09-02 16:00:00',1,2,'嘉義阿里山森林鐵路是一條令人難忘的蒸汽火車路線，穿越壯麗的山區。這趟火車之旅將帶您穿越茶園、瀑布和樹林，欣賞大自然的美景。火車站還有茶葉購物和茶品品味的機會。',1,NULL),
 (19,3,1,'東港植物園 - 熱帶植物之旅','2023-09-02 16:00:00',1,3,'東港植物園是台灣一個獨特的植物園，擁有各種熱帶和亞熱帶植物。您可以在這裡漫遊於叢林中，欣賞熱帶花卉、蕨類植物和奇特的樹木。這個園區也有許多觀景台，提供壯觀的山景。',1,NULL),
 (20,3,3,'阿美族部落 - 原住民文化之旅','2023-09-02 16:00:00',1,3,'台東縣的阿美族部落是原住民文化的寶庫。您可以參觀部落的傳統房屋、工藝品和藝術品，了解阿美族的生活方式和傳統。部落周圍還有美麗的自然景色，如太魯閣國家公園，是徒步和探險的好地方。',1,NULL),
 (21,2,3,'日月潭 - 大自然的湖泊寶石','2023-09-03 16:00:00',1,15,'日月潭是台灣最大的淡水湖泊，坐落在南投縣。您可以在湖上划船、騎自行車環湖，或欣賞湖泊周圍的壯觀山脈。此外，您還可以品味當地的特色美食，如碗粿和紅茶。',0,NULL),(22,2,1,'高雄六合夜市 - 美食之旅','2023-09-04 10:22:23',1,7,'高雄六合夜市是台灣最大的夜市之一，提供各種美食和小吃。您可以品嚐到台灣知名的小吃，如美食攤、珍珠奶茶和炸雞排。這個夜市也是購物和娛樂的好地方，吸引了許多遊客。',1,NULL),
 (23,1,2,'台東太麻里部落 - 海洋文化之旅','2023-09-04 10:22:25',1,0,'台東太麻里部落位於台灣東海岸，以其豐富的海洋文化而聞名。您可以參觀漁村、海洋博物館和海洋活動中心，了解當地漁業和海洋生態。此外，這個地方也是衝浪和海灘活動的好去處。',1,NULL),
 (54,1,2,'<li >he</li><li >he</li>','2023-09-13 06:31:48',0,0,'&lt;li &gt;he&lt;/li&gt;&lt;li &gt;he&lt;/li&gt;',1,NULL),
 (56,6,2,'qw','2023-09-14 17:09:08',0,0,'qw',1,NULL),(57,6,2,'qw','2023-09-14 17:09:10',0,0,'qw',1,NULL),
 (58,6,2,'as','2023-09-14 17:16:47',0,0,'ds',1,NULL),(59,6,3,'s','2023-09-14 17:23:11',0,0,'w',1,NULL);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_collection`
--

DROP TABLE IF EXISTS `article_collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_collection` (
  `article_id` int DEFAULT NULL,
  `mem_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_collection`
--

LOCK TABLES `article_collection` WRITE;
/*!40000 ALTER TABLE `article_collection` DISABLE KEYS */;
INSERT INTO `article_collection` VALUES (3,2),(5,3),(7,1),(8,1),(9,2),(10,2),(11,2),(12,2),(14,1),(52,1),(5,1),(6,1),(1,1),(5,6);
/*!40000 ALTER TABLE `article_collection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_comment`
--

DROP TABLE IF EXISTS `article_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_comment` (
  `comm_id` int NOT NULL AUTO_INCREMENT,
  `article_id` int DEFAULT NULL,
  `mem_id` int DEFAULT NULL,
  `comment_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `comment_post` varchar(1000) NOT NULL,
  `comment_sta` tinyint DEFAULT '1',
  PRIMARY KEY (`comm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_comment`
--

LOCK TABLES `article_comment` WRITE;
/*!40000 ALTER TABLE `article_comment` DISABLE KEYS */;
INSERT INTO `article_comment` VALUES
(1,3,3,'2023-09-04 08:11:06','這篇文章太讚了，完全被感動到！',1),
(2,21,2,'2023-09-04 08:11:06','真的太棒了，作者辛苦了！',1),
(3,1,2,'2023-09-04 08:11:06','這個商品太爛了吧',1),
(4,13,1,'2023-09-04 08:11:06','這個景點我去過，非常推薦！',1),
(5,12,2,'2023-09-04 08:11:06','這個地方的風景太美了！',1),
(6,14,6,'2023-09-04 08:11:06','下次去一定要安排這個行程。',1),
(7,21,2,'2023-09-04 08:11:06','有沒有人要一起揪團？',1),
(8,3,2,'2023-09-04 08:11:06','我報名了，期待能認識新朋友！',1),
(9,3,6,'2023-09-04 08:11:06','這次揪團的活動看起來很精彩。',1),
(10,5,9,'2023-09-04 08:11:06','論壇專區的內容都很有趣。',1),
(11,21,10,'2023-09-04 08:11:06','請問有沒有關於旅行的討論？',1),
(12,15,7,'2023-09-04 08:11:06','大家對於旅行的看法是什麼？',1),
(13,19,9,'2023-09-04 08:11:06','請問客服專區的聯絡方式？',1),
(14,22,8,'2023-09-04 08:11:06','有人試過聯絡客服嗎？',1),
(15,6,2,'2023-09-04 08:11:06','對於網站的建議可以在這裡提出。',1),
(16,21,6,'2023-09-04 08:11:06','搜尋功能真的很方便！',1),
(17,1,9,'2023-09-04 08:11:06','我經常在這個網站上找資訊。',1),
(18,8,8,'2023-09-04 08:11:06','希望這個網站越來越好用。',1),
(19,9,5,'2023-09-04 08:11:06','我也是一位購物狂，哈哈。',1),
(20,16,7,'2023-09-04 08:11:06','這個商城的商品種類真的很多。',1),
(21,1,8,'2023-09-04 08:11:06','今天又下單了，希望快點收到。',1),
(22,16,52,'2023-09-04 08:11:06','謝謝分享這個優惠碼！',1),
(23,11,3,'2023-09-04 08:11:06','我剛剛用了，省了不少錢。',1),
(24,6,2,'2023-09-04 08:11:06','下次有優惠別忘了告訴大家。',1),
(25,20,6,'2023-09-04 08:11:06','這個行程規劃得很周到。',1),
(26,12,3,'2023-09-04 08:11:06','我參加過類似的行程，很推薦。',1),
(27,1,4,'2023-09-04 08:11:06','CP值超低，差評不推薦',1),
(28,9,14,'2023-09-04 08:11:06','我也很期待這個活動。',1),
(29,15,6,'2023-09-04 08:11:06','有人一起參加嗎？',1),
(30,1,12,'2023-09-04 08:11:06','葉佩雯?',1),
(31,21,7,'2023-09-04 08:11:06','這個文章內容很精彩！',1),
(32,18,6,'2023-09-04 08:11:06','作者的觀點很獨特。',1),
(33,7,4,'2023-09-04 08:11:06','我對這個話題也很感興趣。',1),
(34,3,5,'2023-09-04 08:11:06','喜歡這篇文章的風格。',1),
(35,17,7,'2023-09-04 08:11:06','文章中的建議都很實用。',1),
(36,15,6,'2023-09-04 08:11:06','期待更多類似的內容。',1),
(37,6,8,'2023-09-04 08:11:06','謝謝分享這個旅遊建議。',1),
(38,18,5,'2023-09-04 08:11:06','我正計劃著要去這個地方。',1),
(39,7,3,'2023-09-04 08:11:06','希望有個愉快的旅程。',1),
(40,9,3,'2023-09-04 08:11:06','這個揪團活動我有參加過。',1),
(41,22,5,'2023-09-04 08:11:06','大家玩得很開心。',1),
(42,22,4,'2023-09-04 08:11:06','這次的活動一定不會失望。',1),
(43,21,2,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(44,3,7,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(45,7,8,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(46,7,7,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(47,7,5,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(48,16,3,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(49,9,9,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(50,15,1,'2023-09-04 08:11:06','我也想參加這個活動，有人一起嗎？',1),
(51,3,7,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(52,22,6,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(53,3,8,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(54,21,7,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(55,8,8,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(56,13,6,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(57,12,8,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(58,20,6,'2023-09-04 08:11:06','這篇文章太讚了，完全被感動到！',1),
(59,15,4,'2023-09-04 08:11:06','真的太棒了，作者辛苦了！',1),
(60,13,4,'2023-09-04 08:11:06','我也想參加這個活動，有人一起嗎？',1),
(61,1,15,'2023-09-04 08:11:06','我也喜歡!!!!!推薦有需要的人入手~~',1),
(62,5,11,'2023-09-04 08:11:06','這個地方的風景太美了！',1),
(63,17,10,'2023-09-04 08:11:06','下次去一定要安排這個行程。',1),
(64,21,15,'2023-09-04 08:11:06','有沒有人要一起揪團？',1),
(65,10,15,'2023-09-04 08:11:06','我報名了，期待能認識新朋友！',1),
(66,22,15,'2023-09-04 08:11:06','這次揪團的活動看起來很精彩。',1),
(67,20,15,'2023-09-04 08:11:06','論壇專區的內容都很有趣。',1),
(68,11,15,'2023-09-04 08:11:06','請問有沒有關於旅行的討論？',1),
(69,14,15,'2023-09-04 08:11:06','大家對於旅行的看法是什麼？',1),
(70,21,15,'2023-09-04 08:11:06','請問客服專區的聯絡方式？',1),
(71,1,15,'2023-09-04 08:11:06','有人試過聯絡客服嗎？',1),
(72,1,15,'2023-09-04 08:11:06','對於網站的建議可以在這裡提出。',1),
(73,21,15,'2023-09-04 08:11:06','搜尋功能真的很方便！',1),
(74,12,15,'2023-09-04 08:11:06','我經常在這個網站上找資訊。',1),
(75,11,15,'2023-09-04 08:11:06','希望這個網站越來越好用。',1),
(76,11,15,'2023-09-04 08:11:06','我也是一位購物狂，哈哈。',1),
(77,8,15,'2023-09-04 08:11:06','這個商城的商品種類真的很多。',1),
(78,13,15,'2023-09-04 08:11:06','今天又下單了，希望快點收到。',1),
(79,9,15,'2023-09-04 08:11:06','謝謝分享這個優惠碼！',1),
(80,15,15,'2023-09-04 08:11:06','我剛剛用了，省了不少錢。',1),
(81,3,15,'2023-09-04 08:11:06','下次有優惠別忘了告訴大家。',1),
(82,13,15,'2023-09-04 08:11:06','這個行程規劃得很周到。',1),
(83,18,15,'2023-09-04 08:11:06','我參加過類似的行程，很推薦。',1),
(84,1,7,'2023-09-04 08:11:06','希望這次的行程一切順利。',1),
(85,3,15,'2023-09-04 08:11:06','我也很期待這個活動。',1),
(86,8,15,'2023-09-04 08:11:06','有人一起參加嗎？',1),
(87,11,15,'2023-09-04 08:11:06','請問活動地點在哪裡？',1),
(88,19,15,'2023-09-04 08:11:06','這個文章內容很精彩！',1),
(89,14,7,'2023-09-04 08:11:06','作者的觀點很獨特。',1),
(90,10,22,'2023-09-04 08:11:06','我對這個話題也很感興趣。',1),
(91,21,15,'2023-09-04 08:11:06','喜歡這篇文章的風格。',1),
(92,10,7,'2023-09-04 08:11:06','文章中的建議都很實用。',1),
(93,5,7,'2023-09-04 08:11:06','期待更多類似的內容。',1),
(94,10,37,'2023-09-04 08:11:06','謝謝分享這個旅遊建議。',1),
(95,21,7,'2023-09-04 08:11:06','我正計劃著要去這個地方。',1),
(96,22,7,'2023-09-04 08:11:06','希望有個愉快的旅程。',1),
(97,12,15,'2023-09-04 08:11:06','這個揪團活動我有參加過。',1),
(98,19,7,'2023-09-04 08:11:06','大家玩得很開心。',1),
(99,17,7,'2023-09-04 08:11:06','這次的活動一定不會失望。',1),
(100,16,2,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(101,5,10,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(102,21,7,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(103,3,3,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(104,14,6,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(105,22,6,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(106,21,3,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(107,6,6,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(108,6,7,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(109,15,6,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(110,5,7,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(111,21,7,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(112,8,21,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(113,10,7,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(114,14,6,'2023-09-04 08:11:06','論壇專區的內容都很多元。',1),
(171,1,6,'2023-09-13 15:19:17','真的嗎?',1),
(172,5,6,'2023-09-14 18:42:36','nice',1);
/*!40000 ALTER TABLE `article_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_like`
--

DROP TABLE IF EXISTS `article_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_like` (
  `article_id` int DEFAULT NULL,
  `mem_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_like`
--

LOCK TABLES `article_like` WRITE;
/*!40000 ALTER TABLE `article_like` DISABLE KEYS */;
INSERT INTO `article_like` VALUES (3,2),(5,3),(6,1),(7,1),(9,2),(10,2),(11,2),(12,2),(14,1),(8,1),(52,1),(1,1),(5,6);
/*!40000 ALTER TABLE `article_like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_picture`
--

DROP TABLE IF EXISTS `article_picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_picture` (
  `articlepic_id` int NOT NULL AUTO_INCREMENT,
  `article_id` int DEFAULT NULL,
  `article_pic` mediumblob,
  `article_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`articlepic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_picture`
--

LOCK TABLES `article_picture` WRITE;

/*!40000 ALTER TABLE `article_picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_type`
--

DROP TABLE IF EXISTS `article_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_type` (
  `ac_type_id` int NOT NULL,
  `ac_type_name` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`ac_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_type`
--

LOCK TABLES `article_type` WRITE;
/*!40000 ALTER TABLE `article_type` DISABLE KEYS */;
INSERT INTO `article_type` VALUES (1,'全部'),(2,'行程'),(3,'揪團'),(4,'商城');
/*!40000 ALTER TABLE `article_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-15 11:05:48



create table qa (
	qa_id int primary key auto_increment,
    qa_title varchar(50)  not null,
    qa_con varchar(500)  not null,
    qa_state tinyint default 0 not null comment '0:下架 1:上架',
    qa_created_time datetime not null default current_timestamp,
    qa_last_updated_time datetime null default current_timestamp
    );

-- select * from qa;

-- drop table qa;

insert into qa(qa_id, qa_title, qa_con, qa_state) values
(1,'如何註冊遊&ME帳戶？','創建遊&ME帳號完全免費，您可透過email註冊：1.進入遊&ME首頁，點選右上方『登入/註冊』，選擇下方『註冊』。2.填寫您的電子信箱以及預設密碼，點選『註冊』。3.至您的電子信箱內查收驗證信件，點選信件中的網址顯示『聯絡信箱驗證成功』。4.至遊&ME點選右上方『登入/註冊』，輸入您的帳號密碼登入後即可建立行程及訂購商品。',1),
(2,'如何重置會員帳號的密碼？','1.忘記密碼:如果您因忘記密碼無法登入遊&ME，請於登入畫面點選『忘記密碼』，輸入您註冊遊&ME帳號時所使用的電子郵件地址，您將收到一封含有重置密碼鏈結，進行密碼修改。2.修改密碼:您可以登入會員後，在【帳號設定】中更改密碼。',1),
(3,'如何更改我在遊&ME使用的電子郵件地址呢？','很抱歉，因遊&ME的登入帳號為您的e-mail ，故無法更改e-mail地址。',1),
(4,'為什麼我沒有收到電子郵件提示或確認郵件？','請先至垃圾信件確認，有時候您的電子信箱有可能將遊&ME的訊息誤判為垃圾信，也建議您為了避免發生這種情況，您可以將我們的郵件從垃圾箱移除，並將遊&ME的MAIL添加至您的通訊錄。',1),
(5,'如何搜索行程？','進入遊&ME後，可以直接選擇您想要旅行的地點，我們將列出所有行程供您參考，同時您也可以利用我們的篩選條件來進行搜尋，您可以按城市、主題、時間長度等來縮小您的搜尋範圍，搜尋結果將同步於清單欄位，以便您找到最適合您的行程。',1),
(6,'如何使用我的景點收藏清單？','請利用我們收藏功能，每個景點都有個收藏符號，當點選時將列入您的收藏清單，您隨時可進入收藏清單查看比較。若要取消收藏，請再次點選收藏符號，即可取消收藏。',1),
(7,'申請成為揪團團主有哪些要求或條件？','作為揪團的團主，通常需要具備一些基本要求，例如年齡限制、完整的個人資料填寫，以及同意遵守相關的使用條款和規範。另外，您的揪團計劃也需要符合我們的揪團平台政策。具體的要求可能因平台而異，建議您在申請前仔細閱讀相關條款和說明。',1),
(8,'我想要發起一個揪團活動，該怎麼做？','在我們的揪團功能中，您可以點選「發起揪團」按鈕，填寫揪團表單，包括個人資料、活動名稱、日期、目的地等，然後點選「確認發起」即可成功進入創建揪團審核，審核完畢會再通知揪團團主。',1),
(9,'如何刪除評論或修改顯示名稱？','請您留意，我們的每則評論都是真確與真實的，當您填寫評論後，您的會員預設照片與您的會員名稱將會顯示在您的評論前方。填寫評論並送出時，評論將立即刊登於遊&ME該商品評論中，一旦填寫後就無法刪除與修改，請您諒解與了解。',0),
(10,'為什麼我選的東西不能結帳？','請您留意下方「須重新確認商品」，若選購商品中有售罄、已過出發日、暫不提供的商品，系統將會提醒您重新確認。',0);


-- schedules行程 薪安
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
  ('台中一日遊', 3, '2023-11-05', '2023-11-05', 2, b'1', NULL),
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

-- activity活動
-- create schema activity;
-- use activity;


-- 活動
create table activity(
activ_id int primary key auto_increment,
activ_pic mediumblob not null,
activ_name varchar(100) not null,
activ_con varchar(1000) not null,
activ_starttime datetime not null,
activ_endtime datetime,
activ_sta tinyint default 0 not null  -- 0:下架 1:上架
);
-- describe activity;

-- INSERT INTO activity (activ_pic, activ_name, activ_con, activ_starttime, activ_endtime, activ_sta)
-- VALUES
--     (LOAD_FILE('/image1.jpg'), '家庭野餐日', '在公園中享受愉快的野餐時光，與家人一起共度美好時光。', '2023-07-28 10:00:00', '2023-07-28 12:00:00', 1),
--     (LOAD_FILE('/image2.jpg'), '水上運動嘉年華', '來一場充滿刺激與樂趣的水上運動盛宴，感受水上樂園的魅力。', '2023-07-29 15:00:00', '2023-07-29 18:00:00', 1),
--     (LOAD_FILE('/path/to/image3.jpg'), '城市探險之旅', '探索城市的角落與文化，發現城市中的瑰寶與故事。', '2023-07-30 09:30:00', '2023-07-30 11:30:00', 0),
--     (LOAD_FILE('/path/to/image4.jpg'), '瑜伽與冥想工作坊', '學習瑜伽和冥想的技巧，平衡身心，感受寧靜與放鬆。', '2023-08-01 14:00:00', '2023-08-01 16:00:00', 1),
--     (LOAD_FILE('/path/to/image5.jpg'), '小吃美食節', '品嚐來自世界各地的美食，滿足你的味蕾。', '2023-08-02 13:00:00', '2023-08-02 15:00:00', 1);


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
psytresult_name varchar(100) not null,
psytresult_con varchar(1000) not null
);
-- describe  psytest_result;

INSERT INTO psytest_result (psytresult_id, psytresult_name, psytresult_con)
VALUES
    (1, '測試結果1', '這是測試結果1的描述'),
    (2, '測試結果2', '這是測試結果2的描述'),
    (3, '測試結果3', '這是測試結果3的描述'),
    (4, '測試結果4', '這是測試結果4的描述'),
    (5, '測試結果5', '這是測試結果5的描述');
