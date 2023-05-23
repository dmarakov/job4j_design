create table laptops(id serial primary key,vendor varchar(255),model text,ram integer,available boolean);
insert into laptops(vendor,model,ram,available) values('Lenovo','T440p',16,true);
insert into laptops(vendor,model,ram,available) values('Lenovo','T450p',8,true);
begin transaction isolation level serializable;
select sum(ram) from laptops;
update laptops set ram = 24 where id = 2;
update laptops set ram = 32 where id = 1;
commit;