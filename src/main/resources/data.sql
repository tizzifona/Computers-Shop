-- Stores
INSERT INTO store (name, owner, tax_id) VALUES 
('Tech World', 'Alice Johnson', 'TAX001');

-- Computers
INSERT INTO computer (brand, memory, processor, operating_system, price, store_id) VALUES 
('Dell', 16, 'Intel i7', 'Windows 11', 1200.00, 1),
('HP', 8, 'Intel i5', 'Windows 10', 800.00, 1),
('Apple', 32, 'M1', 'macOS Monterey', 2500.00, 1),
('Lenovo', 16, 'AMD Ryzen 5', 'Windows 11', 1100.00, 1),
('Asus', 8, 'Intel i3', 'Windows 10', 600.00, 1),
('Acer', 16, 'AMD Ryzen 7', 'Windows 11', 1000.00, 1);
