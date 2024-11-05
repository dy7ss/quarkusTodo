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
('Buy groceries', 'Milk, eggs, and bread', null),
('Complete Quarkus tutorial', 'Finish the tutorial on Quarkus framework', null),
('Plan weekend trip', 'Find a nice spot for the weekend', null);