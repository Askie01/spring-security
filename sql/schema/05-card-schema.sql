CREATE TABLE card
(
    id               VARCHAR(36) PRIMARY KEY,
    card_number      BIGINT UNIQUE  NOT NULL AUTO_INCREMENT,
    card_type        VARCHAR(100)   NOT NULL,
    total_limit      DECIMAL(10, 2) NOT NULL,
    amount_used      DECIMAL(10, 2) NOT NULL,
    available_amount DECIMAL(10, 2) NOT NULL,
    account_number   BIGINT         NOT NULL,
    created_at       TIMESTAMP DEFAULT NULL
);

ALTER TABLE card
    ADD CONSTRAINT account_number_in_card_table
        FOREIGN KEY (account_number) REFERENCES account (account_number);

ALTER TABLE card
    AUTO_INCREMENT = 1000000000000000;