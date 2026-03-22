CREATE TABLE customer_authority
(
    customer_id VARCHAR(36),
    authority   VARCHAR(255)
);

ALTER TABLE customer_authority
    ADD PRIMARY KEY (customer_id, authority);

ALTER TABLE customer_authority
    ADD CONSTRAINT fk_customer_id_in_customer_authority_table
        FOREIGN KEY (customer_id) REFERENCES customer (id);