-- Stores
INSERT INTO store (id, name, owner, tax_id) VALUES (1, 'Tech World', 'Alice Johnson', 'TAX001');

-- Computers
INSERT INTO computer (id, brand, memory, processor, operating_system, price, store_id) VALUES 
(1, 'Dell', 16, 'Intel i7', 'Windows 11', 1200.00, 1),
(2, 'HP', 8, 'Intel i5', 'Windows 10', 800.00, 1),
(3, 'Apple', 32, 'M1', 'macOS Monterey', 2500.00, 1),
(4, 'Lenovo', 16, 'AMD Ryzen 5', 'Windows 11', 1100.00, 1),
(5, 'Asus', 8, 'Intel i3', 'Windows 10', 600.00, 1),
(6, 'Acer', 16, 'AMD Ryzen 7', 'Windows 11', 1000.00, 1);
