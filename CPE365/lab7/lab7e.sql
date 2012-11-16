/*
  CPE 365 Lab 7e
  Tyler Holland
*/

set AUTOCOMMIT off
whenever oserror 
exit rollback;
whenever sqlerror 
exit rollback;
set isolation level serializable

delete
from odetails
where ono IN(
  select ono
  from orders
  where eno IN(
    select eno
    from employees
    where zip = 67226
  ) or cno IN(
  select cno
  from customers
  where zip = 67226
  )
);

delete
from orders
where eno IN(
  select eno
  from employees
  where zip = 67226
) or cno IN(
  select cno
  from customers
  where zip = 67226
);

delete
from employees
where zip = 67226;

delete
from customers
where zip = 67226;

delete
from zipcodes
where zip = 67226;
commit;
