create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create or replace function tax()
    returns trigger as
$$
    begin
        update products
        set price = price + (price * 0.2)
        where id in (select id from inserted);
        return new;
    end;
$$
LANGUAGE 'plpgsql';

create trigger tax_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure tax();

    create or replace function tax_before()
    returns trigger as
$$
    begin
        new.price = new.price + (new.price * 0.2);
        return new;
    end;
$$
LANGUAGE 'plpgsql';

create trigger tax_trigger_before
    before insert
    on products
    for each row
    execute procedure tax_before();


create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

create or replace function add_history_row()
    returns trigger as
$$
    begin
        insert into history_of_price (name, price, date)
        values (NEW.name, NEW.price, now());
        return new;
    end;
$$
LANGUAGE 'plpgsql';

create trigger update_history
    after insert on products
    for each row
    execute procedure add_history_row();
