--insert user data
INSERT INTO users (user_id, username, created_at) values(1, 'shtjdrb', '2024-05-27T11:06:16.5905254');

--insert post data
INSERT INTO post (post_id, user_id, city, title, content, sport, like_count, recruit, created_at) VALUES(1, 1, 'Seoul', 'test', '테스트입니다', 'Soccer', 20, true, '2024-05-27T11:06:16.5905254');