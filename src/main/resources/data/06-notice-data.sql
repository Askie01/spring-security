INSERT INTO notice (id, title, details, created_at)
VALUES (UUID(), 'Home Loan Interest rates reduced',
        'Home loan interest rates are reduced as per the government guidelines. The updated rates will be effective immediately',
        NOW() - INTERVAL 30 DAY);

INSERT INTO notice (id, title, details, created_at)
VALUES (UUID(), 'Net Banking Offers',
        'Customers who will opt for Internet banking while opening a saving account will get a $50 amazon voucher',
        NOW() - INTERVAL 30 DAY);

INSERT INTO notice (id, title, details, created_at)
VALUES (UUID(), 'Mobile App Downtime',
        'The mobile application of the Askie01 will be down from 2AM-5AM on 12/05/2020 due to maintenance activities',
        NOW() - INTERVAL 30 DAY);

INSERT INTO notice (id, title, details, created_at)
VALUES (UUID(), 'E Auction notice',
        'There will be a e-auction on 12/08/2020 on the Bank website for all the stubborn arrears.Interested parties can participate in the e-auction',
        NOW() - INTERVAL 30 DAY);

INSERT INTO notice (id, title, details, created_at)
VALUES (UUID(), 'Launch of Millennia Cards',
        'Millennia Credit Cards are launched for the premium customers of Askie01. With these cards, you will get 5% cashback for each purchase',
        NOW() - INTERVAL 30 DAY);

INSERT INTO notice (id, title, details, created_at)
VALUES (UUID(), 'COVID-19 Insurance',
        'EazyBank launched an insurance policy which will cover COVID-19 expenses. Please reach out to the branch for more details',
        NOW() - INTERVAL 30 DAY);
