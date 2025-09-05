# Write your MySQL query statement below
select s.student_id,s.student_name,subjects.subject_name,count(e.student_id) as
attended_exams from students s cross join subjects left join 
examinations e on e.student_id = s.student_id and e.subject_name = subjects.subject_name 
group by s.student_id,s.student_name,subjects.subject_name
order by s.student_id,s.student_name,subjects.subject_name;