INSERT INTO account_transaction (id, account_number, title, transaction_type, transaction_amount,
                                 closing_balance, created_at)
VALUES (UUID(), 1000000000000000, 'Coffee Shop', 'Withdrawal', 30, 34500, NOW() - INTERVAL 7 DAY);

INSERT INTO account_transaction (id, account_number, title, transaction_type, transaction_amount,
                                 closing_balance, created_at)
VALUES (UUID(), 1000000000000000, 'Uber', 'Withdrawal', 100, 34400, NOW() - INTERVAL 6 DAY);

INSERT INTO account_transaction (id, account_number, title, transaction_type, transaction_amount,
                                 closing_balance, created_at)
VALUES (UUID(), 1000000000000000, 'Self Deposit', 'Deposit', 500, 34900, NOW() - INTERVAL 5 DAY);

INSERT INTO account_transaction (id, account_number, title, transaction_type, transaction_amount,
                                 closing_balance, created_at)
VALUES (UUID(), 1000000000000000, 'Ebay', 'Withdrawal', 600, 34300, NOW() - INTERVAL 4 DAY);

INSERT INTO account_transaction (id, account_number, title, transaction_type, transaction_amount,
                                 closing_balance, created_at)
VALUES (UUID(), 1000000000000000, 'Online Transfer', 'Deposit', 700, 35000,
        NOW() - INTERVAL 3 DAY);

INSERT INTO account_transaction (id, account_number, title, transaction_type, transaction_amount,
                                 closing_balance, created_at)
VALUES (UUID(), 1000000000000000, 'Amazon.com', 'Withdrawal', 100, 34900, NOW() - INTERVAL 2 DAY);
