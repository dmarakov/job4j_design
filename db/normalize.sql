create table genders (
    id serial primary key,
    name varchar(255)
);

create table users (
    id serial primary key,
    name varchar(50),
    gender int references genders(id)
);

create table address (
    user_id int references users(id),
    address_1 varchar(255),
    address_2 varchar(255)
);

create table movies (
    id serial primary key,
    address_1 varchar(255),
    address_2 varchar(255)
);



create table user_to_movies (
    id serial primary key,
    user_id int references users(id) unique,
    movies_id int references movies(id) unique
);
