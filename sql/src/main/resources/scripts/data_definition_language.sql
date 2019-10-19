# DDL (data definition language)

# add column
ALTER TABLE
employees
ADD COLUMN manager VARCHAR(20);

# remove column
ALTER TABLE 
employees
DROP COLUMN manager;