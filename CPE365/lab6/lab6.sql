/*
  CPE 365 Lab 6
  Tyler Holland
*/
--1.
select to_char(bdate, 'MON DD, YYYY') as BIRTHDAY
from player
where pname = 'Kobe Bryant' and tname = 'Lakers';

--2.
select floor(months_between(sysdate, bdate)/12) as AGE
from player
where pname = 'Kobe Bryant' and tname = 'Lakers';

--3.
select pname, 
       to_char(bdate, 'MON DD, YYYY') as BIRTHDAY, 
       floor(months_between(sysdate, bdate)/12) as AGE
from player
where tname = 'Lakers'
order by AGE desc, pname;

--4.
select pname, 
       floor(months_between(sysdate, bdate)/12) as AGE
from player
where floor(months_between(sysdate, bdate)/12) =
(
  select min(floor(months_between(sysdate, bdate)/12))
  from player
  where tname = 'Lakers'
) 
order by pname;

--5.
select floor(months_between(sysdate, bdate)/12) as AGE
from
(
  select bdate, floor(months_between(sysdate, bdate)/12) as AGE
  from player
  where tname = 'Lakers'
  having count(*) >= 2 
  group by bdate
)
order by AGE desc;

--6.
select to_char(dateTime, 'MON DD, YYYY') as THE_DATE, to_char(dateTime, 'HH12AM') as TIME
from game;

--7.
select B.gnum, to_char(trunc(B.dateTime) - trunc(A.dateTime)) as DAYS_BETWEEN
from game A, game B
where B.gnum - A.gnum = 1
order by gnum;

--8.
select B.gnum, to_char(trunc(B.dateTime) - trunc(A.dateTime)) as DAYS_BETWEEN
from game A, game B
where B.gnum - A.gnum = 1 and to_char(trunc(B.dateTime) - trunc(A.dateTime)) >= ALL
(
  select to_char(trunc(B.dateTime) - trunc(A.dateTime))
  from game A, game B
  where B.gnum - A.gnum = 1
)
order by gnum;

--9.
select (B.gnum + 1) as GAME_NUM
from game A, game B
where B.gnum - A.gnum = 1 and to_char(trunc(B.dateTime) - trunc(A.dateTime)) >= ALL
(
  select to_char(trunc(B.dateTime) - trunc(A.dateTime))
  from game A, game B
  where B.gnum - A.gnum = 1
)
order by GAME_NUM;

--10.
select ((sum(to_char(trunc(B.dateTime) - trunc(A.dateTime))))/count(*)) as Average
from game A, game B
where B.gnum - A.gnum = 1;
