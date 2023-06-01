CREATE TABLE customers(
    id serial primary key,
    first_name text,
    last_name text,
    age int,
    country text
);

insert into customers (first_name, last_name, age, country) VALUES ('Alex', 'Ivanov', 20, 'Russia');
insert into customers (first_name, last_name, age, country) VALUES ('Nik', 'Petrov', 35, 'Sweden');
insert into customers (first_name, last_name, age, country) VALUES ('Ivan', 'Sidorov', 50, 'Russia');
insert into customers (first_name, last_name, age, country) VALUES ('Test', 'Petrov', 20, 'France');

select * from customers where age = (select min(age) from customers);

CREATE TABLE orders(
    id serial primary key,
    amount int,
    customer_id int references customers(id)
);

insert into orders (amount, customer_id) VALUES (2, 1);
insert into orders (amount, customer_id) VALUES (4, 1);
insert into orders (amount, customer_id) VALUES (1, 2);
insert into orders (amount, customer_id) VALUES (5, 3);
insert into orders (amount, customer_id) VALUES (8, 4);

select * from customers where customers.id not in (select orders.customer_id from orders);