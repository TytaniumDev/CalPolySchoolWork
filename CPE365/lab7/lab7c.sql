/*
  CPE 365 Lab 7c
  Tyler Holland
*/

set AUTOCOMMIT OFF
whenever oserror
exit rollback;
whenever sqlerror
exit rollback;

select *
from zipcodes;

select *
from customers;
