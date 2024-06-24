--insert user data
INSERT INTO users (user_id, user_name, created_at) values('shtjdrb', 'shtjdrb123', now());
INSERT INTO users (user_id, user_name, created_at) values('ohhyun', 'oh123', now());

--insert post data
INSERT INTO post (post_id, user_id, city, title, content, sport, like_count, recruit, created_at) VALUES(0, 'shtjdrb', 'Seoul', 'test1', '테스트입니다', 'Soccer', 20, true, now());
INSERT INTO post (post_id, user_id, city, title, content, sport, like_count, recruit, created_at) VALUES(1, 'ohhyun', 'Seoul', 'test2', '테스트입니다', 'Baseball', 25, false, now());
INSERT INTO post (post_id, user_id, city, title, content, sport, like_count, recruit, created_at) VALUES(2, 'shtjdrb', 'Seoul', 'test3', '테스트입니다', 'Soccer', 390, false, now());
INSERT INTO post (post_id, user_id, city, title, content, sport, like_count, recruit, created_at) VALUES(3, 'shtjdrb', 'Busan', 'test4', '테스트입니다', 'Baseball', 210, false, now());
INSERT INTO post (post_id, user_id, city, title, content, sport, like_count, recruit, created_at) VALUES(4, 'shtjdrb', 'Seoul', 'test5', '테스트입니다', 'Baseball', 21, false, now());
INSERT INTO post (post_id, user_id, city, title, content, sport, like_count, recruit, created_at) VALUES(5, 'shtjdrb', 'Seoul', '테스트1', '테스트입니다', 'Baseball', 8, false, now());
INSERT INTO post (post_id, user_id, city, title, content, sport, like_count, recruit, created_at) VALUES(6, 'shtjdrb', 'Seoul', '테스트2', '테스트입니다', 'Baseball', 15, false, now());