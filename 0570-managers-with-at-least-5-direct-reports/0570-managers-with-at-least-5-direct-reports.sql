# Write your MySQL query statement below
select emp1.name from employee emp1  cross join employee emp2
on emp1.id = emp2.managerId group by emp1.Id,emp1.name having count(emp2.id) >= 5;