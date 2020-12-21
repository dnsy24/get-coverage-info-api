###How to create two tables in MySQL WorkBench and connect it to the project

> create new schema: getcoverage_db

  -  USE getcoverage_db;

> create 2 tables with code snippet below 

CREATE TABLE customers (
id int NOT NULL AUTO_INCREMENT,
name varchar(15),
lastname varchar(25),
provider varchar(25),
amount int,
additional_coverage varchar(20),
PRIMARY KEY (id)
);

CREATE TABLE durations (
id int NOT NULL AUTO_INCREMENT,
begin_date varchar(25),
end_date varchar(25),
FOREIGN KEY (id) references customers(id)
);

> populate both tables with mock data with code snippet below

INSERT INTO getcoverage_db.customers (name, lastname, provider, amount, additional_coverage)
VALUES
('Kyle', 'Reeze', 'AmeriHealth', 998, 'Dental'),
('John', 'McLeane', 'Horizon', 1054, 'n/a'),
('Rita', 'Shtym', 'United Health', 998, 'Eyes'),
('Linda', 'Kvas', 'Cigna Health', 675, 'Dental'),
('Edward', 'Pulkis', 'Humana', 1270, 'Dental');

INSERT INTO getcoverage_db.durations (begin_date, end_date)
VALUES
('2020-04-15', '2021-04-12'),
('2020-01-01', '2020-12-30'),
('2020-01-15', '2020-12-14'),
('2019-04-01', '2020-03-30'),
('2018-11-20', '2019-11-19');

> connect your new schema `getcoverage_db` as data source to the project in your favorite IDE
    