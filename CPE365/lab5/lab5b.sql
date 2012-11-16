/*
  CPE 365 Lab 5b
  Tyler Holland
*/

--1.
select
(
  select count(college)
  from player
  where tname = 'Lakers'
) / (
  select count(pname)
  from player
  where tname = 'Lakers'
) as PERCENT
from dual;

--2.
select
(
  select sum(points)
  from plays_in
  where tname = 'Lakers'
) / (
  select count(gnum)
  from game
) as AVERAGE
from dual;

--3.
select count(*) as HOW_MANY
from
(
  select distinct pid, tname
  from plays_in
  where minutes > 10
);

--4.
select pname, height
from player
group by pname, height
having height >= ALL
(
  select max(height)
  from player
)
order by height desc, pname;

--5.
select tname, pname
from player
group by tname, pname, salary
having salary >= ALL
(
  select max(salary)
  from player
)
order by tname, pname;

--6.
select tname, pname
from player
where pid in
(
  select pid
  from plays_in
  where minutes > 0
  group by pid
  having count(gnum) =
  (
    select count(gnum)
    from game
  )
)
group by tname, pname;

--7.
select place
from game
group by place
having count(place) >= ALL
(
  select count(place)
  from game
  group by place
);

--8.
select tname
from
(
  select points, tname, max(gnum)
  from plays_in
  group by tname, points
)
group by points, tname
having points >= ALL
(
  select points
  from plays_in
);
