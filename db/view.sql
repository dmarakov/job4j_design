create view show_student_with_max_order
as SELECT s.name AS student_name
FROM students AS s
JOIN orders AS o ON s.id = o.student_id
GROUP BY s.name
ORDER BY COUNT(*) DESC
LIMIT 1;