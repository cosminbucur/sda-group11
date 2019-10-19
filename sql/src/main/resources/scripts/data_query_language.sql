# DQL (data query language)

# select particular columns
SELECT
    first_name, last_name       # column names
FROM
    persons;    # table

# select distinct
SELECT DISTINCT
    first_name
FROM
    persons;

# where clause
SELECT
    first_name, last_name, birth_date
FROM
    persons
WHERE
    first_name = 'jon';

# select as
SELECT
    first_name AS name,
    last_name AS surname
FROM
    persons;

# select not null *
SELECT
    COUNT(birth_date) AS 'persons
    that have date of birthed filled'
FROM
    persons;

# group by
SELECT
    first_name, # first column
    COUNT(*) AS 'occurences count'  # second column
FROM
    persons
GROUP BY first_name;

# having
SELECT
    first_name AS 'we have two or more people with such name!'
FROM
    persons
GROUP BY first_name
HAVING COUNT(*) > 1;