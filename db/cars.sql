create table car_bodies (
    id serial primary key,
    name varchar(255)
);

create table car_engines (
    id serial primary key,
    name varchar(255)
);

create table car_transmissions (
    id serial primary key,
    name varchar(255)
);

create table cars (
	id serial primary key,
	name varchar(255),
	body_id int references car_bodies(id),
	engine_id int references car_engines(id),
	transmission_id int references car_transmissions(id)
);

INSERT INTO car_bodies (name)
VALUES
  ('Sedan'),
  ('Hatchback'),
  ('SUV'),
  ('Coupe'),
  ('Convertible'),
  ('Pickup Truck'),
  ('Van'),
  ('Test');

INSERT INTO car_engines (name)
VALUES
  ('1.6L 4-Cylinder'),
  ('2.0L 4-Cylinder'),
  ('2.5L V6'),
  ('3.0L V6'),
  ('5.0L V8'),
  ('Electric Motor'),
  ('Hybrid 1.5L 4-Cylinder'),
  ('Test');

INSERT INTO car_transmissions (name)
VALUES
  ('Manual'),
  ('Automatic'),
  ('CVT'),
  ('Dual-Clutch'),
  ('Test');

INSERT INTO cars (name, body_id, engine_id, transmission_id)
VALUES
  ('Honda Civic', 1, 1, 1),
  ('Toyota Corolla', 1, 2, 2),
  ('Mazda CX-5', 3, 3, 2),
  ('Audi A5', 4, 4, 4),
  ('Ford Mustang', 5, 5, 1),
  ('Tesla Model S', 1, 6, NULL),
  ('Toyota Prius', 1, 7, 3),
  ('Ford F-150', 6, 5, 2),
  ('Mercedes-Benz Sprinter', 7, 4, 2),
  ('Nissan Frontier', 6, 1, 1);

select c.id, c.name, cb.name, ce.name, ct.name
from cars as c
left join car_bodies as cb on c.body_id = cb.id
left join car_engines as ce on c.engine_id = ce.id
left join car_transmissions as ct on c.transmission_id = ct.id;

select cb.name
from cars as c
right join car_bodies as cb on c.body_id = cb.id where c.name is null;

select ce.name
from cars as c
right join car_engines as ce on c.body_id = ce.id where c.name is null;

select ct.name
from cars as c
right join car_transmissions as ct on c.body_id = ct.id where c.name is null;







