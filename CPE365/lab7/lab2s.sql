/*
  CPE 365 Lab 7a
  Tyler Holland
*/
@clear_mail
@insert_mail
SET AUTOCOMMIT ON
--1
select count(*) from zipcodes;
--2
insert into zipcodes values(1,'A');
select count(*) from zipcodes;
--3
rollback;
select count(*) from zipcodes;
--4
insert into zipcodes values(2, 'B');
select count(*) from zipcodes;
--5
commit;
select count(*) from zipcodes;
--6
savepoint s1;
insert into zipcodes values(3,'C');
select count(*) from zipcodes;
--7
savepoint s2;
insert into zipcodes values(4,'D');
select count(*) from zipcodes;
--8
savepoint s3;
insert into zipcodes values(5,'E');
select count(*) from zipcodes;
--9
rollback to s2;
select count(*) from zipcodes;
--10
rollback;
select count(*) from zipcodes;