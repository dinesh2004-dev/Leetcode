# Write your MySQL query statement below
select mgr.employee_id,mgr.name,count(emp1.reports_to) as reports_count,
round(avg(emp1.age)) as average_age from employees emp1 join employees mgr
on mgr.employee_id = emp1.reports_to group by mgr.employee_id
order by mgr.employee_id;