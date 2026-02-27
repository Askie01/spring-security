CREATE TABLE customer
(
    id            VARCHAR(36) PRIMARY KEY,
    firstName     varchar(100) NOT NULL,
    lastName      varchar(100) NOT NULL,
    email         varchar(100) NOT NULL,
    mobile_number varchar(20)  NOT NULL,
    username      varchar(500) NOT NULL,
    password      varchar(500) NOT NULL,
    role          varchar(100) NOT NULL,
    created_at    TIMESTAMP    NOT NULL
);