create table laptops(
	id serial primary key,
	vendor varchar(255),
	model text,
	ram integer,
	available boolean
);
insert into laptops(vendor,model,ram,available) values('Lenovo','T440p',16,true);
update laptops set model = 'T480s';
delete from laptops;