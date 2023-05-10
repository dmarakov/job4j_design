select avg(d.price)
from devices as d

select p.name, avg(d.price)
from devices_people as dp
join people as p on dp.people_id = p.id
join devices as d on dp.device_id = d.id
group by p.name
having avg(d.price) > 5000;
