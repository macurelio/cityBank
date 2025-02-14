
CREATE TABLE IF NOT EXISTS transactions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    amount DECIMAL(15,2) NOT NULL,
    currency VARCHAR(10) NOT NULL,
    tax DECIMAL(15,2) NOT NULL
);

INSERT INTO transactions (amount, currency, tax) VALUES (100.00, 'USD', 10.00);
INSERT INTO transactions (amount, currency, tax) VALUES (250.00, 'USD', 25.00);
INSERT INTO transactions (amount, currency, tax) VALUES (500.00, 'USD', 50.00);
