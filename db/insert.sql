insert into role (name) values ('Administrator');
insert into users (name,role) values ('dima',1);
insert into rules (name) values ('Create item');
insert into role_rules (role,rule) values (1,1);
insert into category (name) values ('ASAP');
insert into state (name) values ('In Progress');
insert into item (name, users, category, state) values ('Lose internet connection',1,1,1);
insert into comments (name,item) values ('Hello world',1);
insert into attachs (name,item) values ('Very Important File.txt',1);