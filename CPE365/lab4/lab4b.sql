/*
  CPE 365 Lab 4
  Tyler Holland
*/

--1.
   select type as TYPE, count(type) as COUNT
   from recipe
   group by type
   order by type;
  
--2.
   select type as TYPE, count(type) as COUNT
   from recipe
   group by type
   having count(type) > 2
   order by type;
  
--3.
   select foodgroup as FOODGROUP, count(distinct rname) as COUNT
   from ingredient inner join contains using(iname) inner join recipe using(rname)
   group by foodgroup
   order by foodgroup;
  
--4.
   select foodgroup as FOODGROUP, count(distinct rname) as COUNT
   from ingredient inner join contains using(iname) inner join recipe using(rname)
   group by foodgroup
   having count(distinct rname) > 3
   order by foodgroup;

--5.
   select(price - (cost*amount))/servings
   from ingredient inner join contains using(iname) inner join recipe using(rname);
  
--6.
   select rname as RNAME, count(foodGroup) as INGREDIENT_COUNT
   from ingredient inner join contains using(iname) inner join recipe using(rname)
   group by rname
   order by rname;
  
--7.
   select max(count(amount)) as MAX_INGR
   from contains
   group by rname;
  
--8.
   select tname, points as SCORE
   from plays_in
   where gnum = 7
   order by points desc;
  
--9.
   select gnum, tname, sum(points) as SCORE
   from plays_in
   group by gnum, tname
   order by gnum, SCORE desc;
  
--10.
   select tname, pid, pname, count(points) as NUM_GAMES
   from player inner join plays_in using(tname, pid)
   where minutes > 0
   group by tname, pid, pname
   having count(*) >= 3
   order by count(points) desc, tname, pid;
   
--11.
   select pname, tname, sum(points)/sum(minutes) as AVG_PT_PER_MIN
   from player inner join plays_in using(tname, pid)
   group by pname, tname
   having sum(minutes) > 0
   order by AVG_PT_PER_MIN desc, pname;

--12.
   select max(sum(points)) as HIGH, min(sum(points)) as LOW
   from plays_in
   where gnum = 1
   group by points;
