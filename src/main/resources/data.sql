INSERT INTO tb_account (id, created_at) VALUES (1, NOW()), (2, NOW()), (3, NOW()), (4, NOW());

INSERT INTO tb_sub_account (account_id, account_type, balance, created_at) VALUES
(1, 'FOOD', 5000.00, NOW()),
(1, 'MEAL', 5000.00, NOW()),
(1, 'CASH', 5000.00, NOW()),
(2, 'FOOD', 0, NOW()),
(2, 'MEAL', 0, NOW()),
(2, 'CASH', 0, NOW()),
(3, 'FOOD', 0, NOW()),
(3, 'MEAL', 0, NOW()),
(3, 'CASH', 3000.00, NOW()),
(4, 'FOOD', 0, NOW()),
(4, 'MEAL', 100.0, NOW()),
(4, 'CASH', 0, NOW());

INSERT INTO tb_merchant (id, name, mcc, created_at) VALUES
(1, 'UBER EATS SAO PAULO BR', '5811', NOW());