# CRUD operations

# create table
CREATE TABLE employees (
    # id
    # column_name data_type(size) constraints
    id_employees INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,

    # columns
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    id_departments INT(11) UNSIGNED,
    # constraint (column name in current table)
    FOREIGN KEY (id_departments)
        # link foreign table_name (foreign column name)
        REFERENCES departments (id_departments)
);

INSERT INTO
departments # table_name
(id_departments, name) # (table columns)
VALUES
(1, 'HR'),
(2, 'legal'),
(3, 'finance');

# insert data
INSERT INTO
employees # table_name
(first_name, last_name, id_departments) # (table columns)
VALUES
('John','Smith', 1),
('John','Cage', 2),
('Jadine','Mcclain', 3),
('Ibraheem','Mcfadden', 1),
('Kade','Christie', 2);

# select
SELECT
    *
FROM
    employees;

# delete
DELETE FROM employees
WHERE
    employees.id_employees = 4;

# delete table
DROP TABLE employees;