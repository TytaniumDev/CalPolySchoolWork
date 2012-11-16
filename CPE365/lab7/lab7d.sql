/*
  CPE 365 Lab 7d
  Tyler Holland
*/

set AUTOCOMMIT off
whenever oserror 
exit rollback;
whenever sqlerror 
exit rollback;
set isolation level read committed

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
commit;
