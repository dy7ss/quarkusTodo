-- プロジェクト用テストデータ
INSERT INTO project (id, user_id, title, description, created_at, updated_at) VALUES (1, 1, 'New Project', 'This is a new project.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO task (id, project_id, title, description, status, created_at, updated_at) VALUES (1, 1, 'Task 1', 'This is the first task.', 'TODO', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO task (id, project_id, title, description, status, created_at, updated_at) VALUES (2, 1, 'Task 2', 'This is the second task.', 'IN_PROGRESS', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);