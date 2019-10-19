# DML (data manipulation language)

# insert
INSERT INTO
employees
(first_name , last_name , id_departments)
SELECT
    CONCAT(first_name, ' - duplicate'),
    CONCAT(last_name, ' - duplicate'),
    id_departments
FROM
employees;

# update
UPDATE employees
SET
    first_name = 'Johnny'
WHERE
    id_employees = 3;

# update (multiple tables)
UPDATE employees
        INNER JOIN
    departments ON employees.id_employees = departments.id_departments
SET
    employees.first_name = CONCAT(employees.first_name,
            ' from the HR dept')
WHERE
    departments.name = 'HR';

# delete (multiple tables)
DELETE employees FROM employees
        INNER JOIN
    departments USING (id_departments)
WHERE
    id_departments = 2;