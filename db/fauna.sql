create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);
insert into fauna (name, avg_age, discovery_date) values ('dragonfly', 1000, '1793-09-01');
insert into fauna (name, avg_age, discovery_date) values ('Tempfishtemp', 1500, '1960-09-20');
insert into fauna (name, avg_age, discovery_date) values ('Bear', 13000, '1800-09-20');
insert into fauna (name, avg_age, discovery_date) values ('Unknown Creature', 50000, null);

select * from fauna where name like '%fish%';
select * from fauna where avg_age > 10000 AND avg_age < 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '1950-09-20';