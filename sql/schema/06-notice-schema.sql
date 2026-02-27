CREATE TABLE notice
(
    id         VARCHAR(36) PRIMARY KEY,
    title      VARCHAR(200) NOT NULL,
    details    VARCHAR(500) NOT NULL,
    created_at TIMESTAMP    NOT NULL
);