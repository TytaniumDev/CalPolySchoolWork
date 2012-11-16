/*
  CPE 365 Lab 7a
  Tyler Holland
*/
--1.
CREATE OR REPLACE VIEW GAME_SCORES as
   select gnum, tname, sum(points) as SCORE
   from plays_in
   group by gnum, tname;
--2.
select view_name
from USER_VIEWS;

--3.
select GNUM, TNAME, SCORE
from GAME_SCORES
order by gnum, score desc;

--4.
update plays_in
set points = (points - 5)
where pid = 24 and tname = 'Lakers' and gnum =
(
  select max(gnum)
  from plays_in
);

--5.
select GNUM, TNAME, SCORE
from GAME_SCORES
order by gnum, score desc;

--6.
drop view GAME_SCORES;

--7.
drop sequence GNUM_SEQ;
create sequence GNUM_SEQ
start with 8
increment by 1;

--8.
insert into game
values (gnum_seq.nextVal, to_date('June 19 2009 07:30 PM', 'MONTH DD YYYY HH12:MI AM'), 'Nipomo');

insert into game
values (gnum_seq.nextVal, to_date('June 21 2009 10:15 AM', 'MONTH DD YYYY HH12:MI AM'), 'Chicago');

--9.
select gnum, to_char(datetime, 'MONTH DD YYYY HH12:MI AM') as DATETIME, place
from game
order by gnum;

--10.
delete from game
where gnum = 9 or gnum = 8;

--11.
select gnum, to_char(datetime, 'MONTH DD YYYY HH12:MI AM') as DATETIME, place
from game
order by gnum;


--12.
drop sequence gnum_seq;

