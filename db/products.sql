create table type (
    id serial primary key,
    name varchar(255)
);

create table product (
    id serial primary key,
    name varchar(255),
    type_id int references type(id),
	expired_date date,
	price float
);

insert into type (name) values ('СЫР');
insert into type (name) values ('МОЛОКО');
insert into type (name) values ('КОНФЕТЫ');

insert into product (name, type_id, expired_date, price) values('Сыр плавленный', 1, '2023-05-10', 100);
insert into product (name, type_id, expired_date, price) values('Сыр эдам', 1, '2023-05-15', 200);
insert into product (name, type_id, expired_date, price) values('Молоко топленное', 2, '2023-05-14', 70);
insert into product (name, type_id, expired_date, price) values('Мороженое пломбир', 2, '2023-05-05', 40);
insert into product (name, type_id, expired_date, price) values('Конфеты коровка', 3, '2023-05-29', 400);

select p.name from product as p
join type as t on p.type_id = t.id
where t.name like '%СЫР%';

select p.name from product as p
join type as t on p.type_id = t.id
where p.name like '%Мороженое%';

select * from product as p
where expired_date < Now();

select name, price from product
where price = (select max(price) from product);

SELECT t.name, COUNT(type_id)
FROM product as p join type as t on p.type_id = t.id
group by t.name;

SELECT p.name, t.name
FROM product as p join type as t on p.type_id = t.id
where t.name like '%СЫР%' OR t.name like '%МОЛОКО%';

SELECT t.name, COUNT(type_id)
FROM product as p join type as t on p.type_id = t.id
group by t.name
HAVING COUNT(type_id) < 10;

SELECT p.name, t.name, p.expired_date, p.price
FROM product as p join type as t on p.type_id = t.id;