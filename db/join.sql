create table departments (
    id serial primary key,
    name varchar(255)
);

create table employees (
    id serial primary key,
    name varchar(255),
	department_id int references departments(id)
);

insert into departments (name) values ('R&D');
insert into departments (name) values ('QA');
insert into departments (name) values ('Support');
insert into departments (name) values ('IT');
insert into employees (name, department_id) values ('Dmitriy', 1);
insert into employees (name, department_id) values ('Sasha', 2);
insert into employees (name, department_id) values ('Lesha', 3);
insert into employees (name, department_id) values ('Masha', 4);
insert into employees (name, department_id) values ('Kolya', 1);

select e.name,d.name from employees e left join departments d on e.department_id = d.id;
select e.name,d.name from employees e right join departments d on e.department_id = d.id;
select e.name,d.name from employees e full join departments d on e.department_id = d.id;
select e.name,d.name from employees e cross join departments d;

select e.name,d.name from departments d left join employees e on e.department_id = d.id;
select e.name,d.name from employees e right join departments d on e.department_id = d.id;
select e.name,d.name (e.name + d.name) as "Employee / department" from employees e cross join departments d;
select t.name,t.gender, (t.name || ' ' || t.gender) as "Name / gender" from teens t cross join teens gender;
