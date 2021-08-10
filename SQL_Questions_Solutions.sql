-- 1) 4th Highest salary in Specific Dept or all Dept
SELECT salary FROM 
(SELECT DISTINCT salary FROM employee_system.employee
ORDER BY salary DESC LIMIT 3) AS Result
ORDER BY salary LIMIT 1;
-------------
SELECT salary, dept_id FROM 
(SELECT DISTINCT salary, dept_id FROM employee_system.employee
GROUP BY dept_id ORDER BY salary DESC LIMIT 3) AS Result GROUP BY dept_id
ORDER BY salary LIMIT 1;
--------------
-- 2) Eldest/Youngest in Specific Dept or all Dept
SELECT dept_id,employee_id, age 
FROM 
(SELECT dept_id, employee_id, age, 
DENSE_RANK() OVER (PARTITION BY dept_id ORDER BY age) age_rank 
from employee_system.employee
) sub_query where age_rank = 1;
-- 3) Sort Av. Dept Salary in desc order
SELECT AVG(salary), dept_id FROM 
employee_system.employee GROUP BY dept_id ORDER BY AVG(salary);
--------------
-- 4) Highest strength -> Which dept?
SELECT employee_system.department.name, COUNT(*) AS emp_count
FROM employee_system.employee
INNER JOIN employee_system.department
ON employee.dept_id=department.dept_id
GROUP BY department.name
ORDER BY emp_count DESC LIMIT 1;
--------------
-- Who will become 60 by next year?
SELECT
employee.employee_id, employee.name
FROM
employee_system.employee
WHERE
dob<= date_sub(current_date(), INTERVAL 59 YEAR);
drop table `employee`;
