set session characteristics as transaction isolation level serializable;
begin transaction;
insert into laptops(vendor,model,ram,available) values('Apple','Macbook Pro',16,true);
insert into laptops(vendor,model,ram,available) values('Apple','Macbook Air',8,true);
savepoint mac_air;
delete from laptops where model = 'Macbook Pro';
rollback to mac_air;