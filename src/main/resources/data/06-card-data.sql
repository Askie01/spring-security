INSERT INTO card (id, card_number, card_type, total_limit, amount_used, available_amount, account_number, created_at)
VALUES (UUID(), 1000000000000000, 'Credit', 10000, 500, 9500, 1000000000000000, NOW());

INSERT INTO card (id, card_number, card_type, total_limit, amount_used, available_amount, account_number, created_at)
VALUES (UUID(), 1000000000000001, 'Credit', 7500, 600, 6900, 1000000000000000, NOW());

INSERT INTO card (id, card_number, card_type, total_limit, amount_used, available_amount, account_number, created_at)
VALUES (UUID(), 1000000000000002, 'Credit', 20000, 4000, 16000, 1000000000000000, NOW());
