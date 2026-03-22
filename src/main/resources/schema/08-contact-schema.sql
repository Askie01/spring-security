CREATE TABLE contact
(
    id         VARCHAR(36) PRIMARY KEY,
    first_name VARCHAR(50)   NOT NULL,
    last_name  VARCHAR(50)   NOT NULL,
    email      VARCHAR(100)  NOT NULL,
    subject    varchar(500)  NOT NULL,
    message    varchar(2000) NOT NULL,
    created_at TIMESTAMP DEFAULT NULL
);