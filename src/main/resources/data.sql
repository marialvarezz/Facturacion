INSERT INTO tax (name, amount, percentage) VALUES ('IVA general', 0.00, 21.00);
INSERT INTO tax (name, amount, percentage) VALUES ('IVA reducido', 0.00, 10.00);
INSERT INTO tax (name, amount, percentage) VALUES ('IVA superreducido', 0.00, 4.00);
INSERT INTO tax (name, amount, percentage) VALUES ('IGIC general (Canarias)', 0.00, 7.00);
INSERT INTO tax (name, amount, percentage) VALUES ('IGIC reducido (Canarias)', 0.00, 3.00);
INSERT INTO tax (name, amount, percentage) VALUES ('IPS general (Ceuta y Melilla)', 0.00, 10.00);
INSERT INTO tax (name, amount, percentage) VALUES ('IPS reducido (Ceuta y Melilla)', 0.00, 4.00);

INSERT INTO customers (name, surname) VALUES
('Carmen', 'Farala'),
('Hugaceo', 'Crujiente'),
('Arantxa', 'Castilla La Mancha');

INSERT INTO invoices (id, invoice_code, date, amount, customer_id) VALUES
(1, 'F0001', '2022-01-01', 100.00, 1),
(2, 'F0002', '2022-01-02', 200.00, 2),
(3, 'F0003', '2022-01-03', 300.00, 3);

INSERT INTO invoice_tax (invoice_id, tax_id, total_tax) VALUES
(1, 1, 21.00),
(2, 1, 42.00),
(2, 2, 14.00),
(3, 1, 63.00),
(3, 3, 30.00);
