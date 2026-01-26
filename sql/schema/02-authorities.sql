CREATE TABLE authorities
(
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL
);

ALTER TABLE authorities
    ADD CONSTRAINT fk_username_in_authorities_table
        FOREIGN KEY (username)
            REFERENCES users (username);

ALTER TABLE authorities
    ADD INDEX username_authority_index_in_authorities_table (username, authority);