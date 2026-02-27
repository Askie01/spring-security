CREATE TABLE account_transaction
(
    id                 VARCHAR(36) PRIMARY KEY,
    account_number     BIGINT       NOT NULL,
    title              VARCHAR(200) NOT NULL,
    transaction_type   VARCHAR(100) NOT NULL,
    transaction_amount DECIMAL      NOT NULL,
    closing_balance    DECIMAL      NOT NULL,
    created_at         TIMESTAMP    NOT NULL
);

ALTER TABLE account_transaction
    ADD CONSTRAINT fk_account_id_in_account_transaction_table
        FOREIGN KEY (account_number) REFERENCES account (account_number);