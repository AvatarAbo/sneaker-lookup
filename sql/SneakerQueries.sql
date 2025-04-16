INSERT INTO [dbo].[Sneaker] ([Year], [Brand], [Model], [Colorway], [Type])
VALUES
(2016, 'Nike', 'Air Jordan 1', 'Black/Varsity Red-White', 'Basketball'),
(2015, 'Nike', 'Air Jordan 1', 'Black/Starfish-Sail', 'Basketball'),
(2018, 'Nike', 'Air Jordan 1', 'White/Dark Powder Blue-Cone', 'Basketball'),
(2018, 'Nike', 'Air Jordan 1', 'Voltage Purple/Voltage Purple', 'Skateboarding'),
(2024, 'Nike', 'Air Force 1 Low', 'White/White/Midnight Navy/Dark Powder Blue', 'Basketball'),
(2012, 'Nike', 'Air Foamposite 1', 'Obsidian/Anthracite-Black', 'Basketball'),
(2017, 'Adidas', 'Yeezy Boost 350 V2', 'White/Core Black/Red', 'Lifestyle'),
(2016, 'Adidas', 'Yeezy Boost 350 V2', 'Steeple Gray/Beluga/Solar Red', 'Lifestyle'),
(2019, 'Adidas', 'UltraBoost 1.0', 'Collegiate Purple/Cloud White/Sand', 'Running'),
(2021, 'Adidas', 'Campus 80s', 'Chalk Purple/Footwear White', 'Lifestyle'),
(2020, 'New Balance', '992', 'Pink/Red-Burgundy', 'Running'),
(2021, 'New Balance', '1300', 'Green/Grey', 'Running'),
(2019, 'Vans', 'Sk8-Hi', 'Gryffindor/Multi', 'Skateboarding')
;

delete from [dbo].[Sneaker];

select * from [dbo].[Sneaker];



INSERT INTO [dbo].[Product] ([StoreId], [StoreName], [Website], [Address], [SneakerId], [ShoeSize], [Quantity], [Price], [ReleaseDate])
VALUES
(23, 'Champs Sports', 'https://www.champssports.com', '1030 Southcenter Mall, Tukwila, WA 98188', 1, '8.5', 9000, 225.00, '2016-09-03'),
(23, 'Champs Sports', 'https://www.champssports.com', '1030 Southcenter Mall, Tukwila, WA 98188', 1, '9', 5000, 160.00, '2016-09-03'),
(23, 'Champs Sports', 'https://www.champssports.com', '1030 Southcenter Mall, Tukwila, WA 98188', 6, '11', 13000, 230.00, '2017-02-25'),
(42, 'Footlocker', 'https://www.footlocker.com/', '3500 S Meridian, Spc 320, Puyallup, WA 98373', 6, '10.5', 2000, 230.00, '2017-02-25'),
(55, 'Footlocker', 'https://www.footlocker.com/', '1100 Bellevue Sq, Bellevue, WA 98004', 4, '13', 16000, 100.00, '2018-12-17'),
(55, 'Footlocker', 'https://www.footlocker.com/', '1100 Bellevue Sq, Bellevue, WA 98004', 11, '8', 50000, 169.99, '2020-02-14')
;

delete from [dbo].[Product];

select * from [dbo].[Product];



INSERT INTO [dbo].[Catalog] ([SneakerId], [ShoeSize], [YearAcquired], [Condition], [MarketValue])
VALUES
(1, '8.5', 2023, 'FAIR', 64.00),
(4, '9.5', 2021, 'FAIR', 96.00),
(6, '9.5', 2024, 'DS', 230.00),
(7, '12', 2023, 'POOR', 46.00),
(11, '7', 2020, 'GOOD', 138.00);

delete from [dbo].[Catalog];

select * from [dbo].[Catalog];