-- This script clears all the tables in the mail-order database 
-- but does not delete the tables themselves
-- Fall 2008, M. Liu
delete from odetails;
delete from orders;
delete from parts;
delete from employees;
delete from customers;
delete from zipcodes;
COMMIT;
-----------------------------------------------------------------
