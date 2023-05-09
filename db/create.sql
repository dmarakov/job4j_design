create table role (
    id serial primary key,
    name varchar(255)
);
create table users (
    id serial primary key,
    name varchar(255),
    role int references role(id)
);
create table rules (
    id serial primary key,
    name text
);
create table role_rules (
    id serial primary key,
    role int references role(id),
    rule int references rules(id)
);
create table category (
    id serial primary key,
    name varchar(255)
);
create table state (
    id serial primary key,
    name varchar(255)
);
create table item (
    id serial primary key,
    name varchar(255),
    users int references users(id),
    category int references category(id),
    state int references state(id)
);
create table comments (
    id serial primary key,
    name varchar(255),
    item int references item(id)
);
create table attachs (
    id serial primary key,
    name varchar(255),
    item int references item(id)
);