-- テーブル作成
-- CREATE TABLE todo (
--     id SERIAL PRIMARY KEY,
--     title VARCHAR(255) NOT NULL,
--     description TEXT,
--     is_completed BOOLEAN DEFAULT FALSE,
--     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
-- );

-- 初期データの挿入
-- INSERT INTO todo (taskId, task, registerDate) VALUES 
-- (1, 'Milk, eggs, and bread', null),
-- (2, 'Finish the tutorial on Quarkus framework', null),
-- (3, 'Find a nice spot for the weekend', null);

INSERT INTO todo (userId, title, registerDate) VALUES 
(1, 'Milk, eggs, and bread', null),
(1, 'Finish the tutorial on Quarkus framework', null),
(1, 'null', 'registerDate'),
(2, 'Find a nice spot for the weekend', null);

INSERT INTO users (userName, email) VALUES 
('taro', 'example@yahoo.co.jp'),
('jiro', 'example@google.com'),
('saburo', 'example@hoge.com');

INSERT INTO tododetail (detailUserId, taskName, status) VALUES
(1, '明細１', '1'),
(1, '明細２', '0'),
(2, '明細３', '1'),
(1, '明細４', '0');
