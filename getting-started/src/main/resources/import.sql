-- テーブル作成
-- CREATE TABLE todo (
--     id SERIAL PRIMARY KEY,
--     title VARCHAR(255) NOT NULL,
--     description TEXT,
--     is_completed BOOLEAN DEFAULT FALSE,
--     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
-- );

-- 初期データの挿入
INSERT INTO todo (taskId, task, registerDate) VALUES 
(1, 'Milk, eggs, and bread', null),
(2, 'Finish the tutorial on Quarkus framework', null),
(3, 'Find a nice spot for the weekend', null);