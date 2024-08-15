CREATE TABLE IF NOT EXISTS tb_account (
    id SERIAL PRIMARY KEY,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS tb_sub_account (
    account_id BIGINT,
    account_type VARCHAR(100),
    balance DECIMAL(19, 2) DEFAULT 0,
    created_at TIMESTAMP DEFAULT NOW(),
    PRIMARY KEY (account_id, account_type),
    CONSTRAINT fk_account FOREIGN KEY (account_id) REFERENCES tb_account(id)
);

CREATE TABLE IF NOT EXISTS tb_transaction (
    id SERIAL PRIMARY KEY,
    account_id BIGINT NOT NULL,
    total_amount DECIMAL(19, 2) DEFAULT 0,
    mcc VARCHAR(4) NOT NULL,
    merchant VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    CONSTRAINT fk_account FOREIGN KEY (account_id) REFERENCES tb_account(id)
);

CREATE TABLE IF NOT EXISTS tb_merchant (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    mcc VARCHAR(4) NOT NULL,
    created_at TIMESTAMP DEFAULT NOW()
);