CREATE TABLE loan
(
    id               VARCHAR(36) PRIMARY KEY,
    loan_number      BIGINT UNIQUE  NOT NULL AUTO_INCREMENT,
    loan_type        VARCHAR(100)   NOT NULL,
    total_loan       DECIMAL(10, 2) NOT NULL,
    amount_paid      DECIMAL(10, 2) NOT NULL,
    remaining_amount DECIMAL(10, 2) NOT NULL,
    account_number   BIGINT         NOT NULL,
    created_at       TIMESTAMP      NOT NULl
);

ALTER TABLE loan
    ADD CONSTRAINT fk_account_number_in_loan_table
        FOREIGN KEY (account_number) REFERENCES account (account_number);

ALTER TABLE loan
    AUTO_INCREMENT = 1000000000000000;