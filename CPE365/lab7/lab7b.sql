/*
  CPE 365 Lab 7b
  Tyler Holland
*/
--1.
insert into parts (pno, pname, qoh, price, olevel)
select 12345, pname, qoh, price, olevel
from parts
where pname = 'Sleeping Beauty';

update odetails
set pno = 12345
where pno =(
  select pno
  from parts
  where pname = 'Sleeping Beauty' and pno != 12345
);

delete
from parts
where pno =(
  select pno
  from parts
  where pname = 'Sleeping Beauty' and pno != 12345
);

select *
from parts;

select *
from odetails;

--2.
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

select *
from odetails;

select *
from orders;

select *
from employees;

select *
from customers;

select *
from zipcodes;