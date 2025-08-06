# Write your MySQL query statement below
select id,movie,description,round(rating,2) as rating from cinema where id % 2 = 1 and description not like "%boring%" order by rating desc;