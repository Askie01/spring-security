INSERT INTO loan (id, loan_number, loan_type, loan_amount, amount_paid, remaining_amount, account_number, created_at)
VALUES (UUID(), 1000000000000000, 'Home', 200000, 50000, 150000, 1000000000000000, NOW());

INSERT INTO loan (id, loan_number, loan_type, loan_amount, amount_paid, remaining_amount, account_number, created_at)
VALUES (UUID(), 1000000000000001, 'Vehicle', 40000, 10000, 30000, 1000000000000000, NOW());

INSERT INTO loan (id, loan_number, loan_type, loan_amount, amount_paid, remaining_amount, account_number, created_at)
VALUES (UUID(), 1000000000000002, 'Home', 50000, 10000, 40000, 1000000000000000, NOW());

INSERT INTO loan (id, loan_number, loan_type, loan_amount, amount_paid, remaining_amount, account_number, created_at)
VALUES (UUID(), 1000000000000003, 'Personal', 10000, 3500, 6500, 1000000000000000, NOW());
