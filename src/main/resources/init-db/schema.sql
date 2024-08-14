CREATE TABLE tb_account (
    id SERIAL PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tb_sub_account (
    account_id BIGINT,
    account_type VARCHAR(100),
    balance DECIMAL(19, 2) DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (account_id, account_type),
    CONSTRAINT fk_account FOREIGN KEY (account_id) REFERENCES tb_account(id)
);

INSERT INTO tb_account (id, created_at) VALUES (123, CURRENT_TIMESTAMP), (1, CURRENT_TIMESTAMP), (2, CURRENT_TIMESTAMP);

INSERT INTO tb_sub_account (account_id, account_type, balance, created_at) VALUES
(123, 'FOOD', 5000.00, CURRENT_TIMESTAMP),
(123, 'MEAL', 5000.00, CURRENT_TIMESTAMP),
(123, 'CASH', 5000.00, CURRENT_TIMESTAMP),
(1, 'FOOD', 0, CURRENT_TIMESTAMP),
(1, 'MEAL', 0, CURRENT_TIMESTAMP),
(1, 'CASH', 0, CURRENT_TIMESTAMP),
(2, 'FOOD', 0, CURRENT_TIMESTAMP),
(2, 'MEAL', 10.00, CURRENT_TIMESTAMP),
(2, 'CASH', 3000.00, CURRENT_TIMESTAMP);

CREATE TABLE tb_transaction (
    id SERIAL PRIMARY KEY,
    account_id BIGINT NOT NULL,
    total_amount DECIMAL(19, 2) DEFAULT 0,
    mcc VARCHAR(4) NOT NULL,
    merchant VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_account FOREIGN KEY (account_id) REFERENCES tb_account(id)
);