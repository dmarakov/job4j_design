select i.name, u.name from item
as i  join users as u on u.users = i.id

select c.name, i.name from comments
as i join item as c on i.item = c.id

select i.name, u.name, c.name, s.name from item
as i join users as u on i.users = u.id
join category as c on i.category = c.id
join state as s on i.state = s.id