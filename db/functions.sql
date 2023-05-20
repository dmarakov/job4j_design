create or replace procedure delete_data()
language 'plpgsql'
as $$
    BEGIN
            delete from products where count = 0;
    END;
$$;

create or replace function f_delete_data(u_id integer)
returns varchar(255)
language 'plpgsql'
as
$$
    declare
        result varchar(255);
    begin
            select into result name from products where id = u_id;
            delete from products where id = u_id;
        return result;
    end;
$$;