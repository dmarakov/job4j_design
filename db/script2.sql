create table employess(
	id serial primary key,
	vendor varchar(255)
);
create table serial_number(
	id serial primary key,
	serial varchar(255)
);
create table hardware(
    id serial primary key,
    name varchar(255),
    employee_id int references employess(id),
	serial_number_id int references serial_number(id)
);
create table applications(
    id serial primary key,
    name varchar(255)
);
create table hardware_applications(
    id serial primary key,
    name varchar(255),
    hardware_id int references hardware(id),
	applications_number_id int references applications(id)
);