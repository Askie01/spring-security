CREATE TABLE customer
(
    id            VARCHAR(36) PRIMARY KEY,
    first_name    VARCHAR(100)        NOT NULL,
    last_name     VARCHAR(100)        NOT NULL,
    email         VARCHAR(100) UNIQUE NOT NULL,
    mobile_number VARCHAR(20) UNIQUE  NOT NULL,
    username      VARCHAR(500) UNIQUE NOT NULL,
    password      VARCHAR(500)        NOT NULL,
    role          VARCHAR(100)        NOT NULL,
    created_at    TIMESTAMP           NOT NULL
);