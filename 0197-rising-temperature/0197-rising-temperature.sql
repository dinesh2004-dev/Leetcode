# Write your MySQL query statement below
select today.id from weather today cross join weather yesterday
where datediff(today.recordDate,yesterday.recordDate) = 1 and 
today.temperature > yesterday.temperature;