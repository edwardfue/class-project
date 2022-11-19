/*
Project 3
Edward Fuentes
Nov 10 2022
*/
SELECT * 
FROM employee;

/*
1) Retrieve all last names of all employees
*/
SELECT lname
FROM employee;

/*
2) Write an insert statement to add your name 
(the name you have listed on CUNYfirst) to the employee table. 
For the SSN field, please make up a fake SSN such 123456789. DO NOT USE your real SSN. 
You can choose any department you want for your information
*/
INSERT INTO employee (fname, minit, lname, ssn, dno) 
VALUES ('Edward', 'F', 'Fuentes', '132456789', '7');


/*
3) Retrieve the names of all employees in 
department 5 who work more than 10 hours per 
week on the ProductX project.
*/

SELECT fname, minit, lname, hours
FROM employee, works_on, project
WHERE pname= 'ProductX' AND dno = '5' AND hours >'10' 
AND ssn= essn AND pno = pnumber;

/*
4) List the names of all employees who have a 
dependent with the same first name as themselves.
*/

SELECT fname, minit, lname
FROM employee
WHERE EXISTS(SELECT * 
FROM dependent
WHERE essn = ssn);

/*
5) Find the names of all employees who are directly 
supervised by ‘Franklin Wong’.
*/
SELECT e.fname, e.minit, e.lname
FROM employee e, employee m
WHERE e.superssn = m.ssn AND m.fname = 'Franklin' AND
m.lname = 'Wong'; 

/*
6) For each department whose average employee salary is more than $30,000, 
retrieve the department name and the number of employees working for that department.
*/
SELECT dname, COUNT(*)
FROM department, employee
WHERE dnumber = dno
GROUP BY dname
HAVING AVG(salary) > 30000;

/*
7)Retrieve the number of male employees in 
each department making more than $30,000
*/
SELECT sex, dname, count(*)
FROM employee, department
WHERE dno =dnumber AND sex='M' AND dno 
IN(SELECT dno FROM employee GROUP BY dno
HAVING AVG(salary) > 30000)
GROUP BY dname;

/*
8) Retrieve the names of all employees who work in the department 
that has the employee with the highest salary among all employees.
*/
SELECT fname, minit, lname, salary 
FROM employee
WHERE dno= 
(SELECT dno FROM employee WHERE salary= (SELECT MAX(salary) FROM employee));
/*
9) Retrieve the names of all employees whose supervisor’s 
supervisor has ‘888665555’ for Ssn.
*/
SELECT s.fname, s.minit, s.lname
FROM employee s
WHERE s.superssn IN (
SELECT s.ssn 
FROM employee s
WHERE s.superssn = '888665555');

/*
10) Retrieve the names of employees who make at least 
$10,000 more than the employee who is paid the least in the company
*/
SELECT fname, minit, lname
From employee 
WHERE salary >= 10000  + (SELECT MIN(salary) FROM employee);
