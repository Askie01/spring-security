CREATE TABLE account
(
    id             VARCHAR(36) PRIMARY KEY,
    account_number BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
    account_type   VARCHAR(100)  NOT NULL,
    branch_address VARCHAR(200)  NOT NULL,
    customer_id    VARCHAR(36)   NOT NULL,
    created_at     TIMESTAMP     NOT NULL
);

ALTER TABLE account
    ADD CONSTRAINT fk_customer_id_in_account_table
        FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE account
    AUTO_INCREMENT = 1000000000000000;