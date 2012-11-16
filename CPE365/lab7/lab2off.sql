@clear_mail
@insert_mail
SET AUTOCOMMIT OFF
--1off
select count(*) from zipcodes;
--2off
insert into zipcodes values(1,'A');
select count(*) from zipcodes;
--3off
rollback;
select count(*) from zipcodes;
--4off
insert into zipcodes values(2, 'B');
select count(*) from zipcodes;
--5off
commit;
select count(*) from zipcodes;
--6off
savepoint s1;
insert into zipcodes values(3,'C');
select count(*) from zipcodes;
--7off
savepoint s2;
insert into zipcodes values(4,'D');
select count(*) from zipcodes;
--8off
savepoint s3;
insert into zipcodes values(5,'E');
select count(*) from zipcodes;
--9off
rollback to s2;
select count(*) from zipcodes;
--10off
rollback;
select count(*) from zipcodes;