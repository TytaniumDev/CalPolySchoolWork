/*
  CPE 365 Lab 4
  Tyler Holland
*/

--1. How many recipes are in this database?
  select count(*) as RECIPE_COUNT
  from recipe;
  
--2.
  select count(*) as INGREDIENT_COUNT
  from contains
  where rname = 'Meatloaf';
  
--3.
  select count(distinct rname) as RECIPE_COUNT
  from ingredient I, contains C
  where I.iname = C.iname and foodGroup = 'dairy';
  
--4.
  select count(*) as INGREDIENT_COUNT
  from contains
  where rname = 'Meatloaf';
  
--5.
  select count(cost * amount) as COST, count(calorie * amount) as CALORIES
  from ingredient inner join contains using(iname) inner join recipe using(rname)
  where rname = 'Garlic Shrimp';
  
--6.
  select count(*) as PLAYER_COUNT
  from player inner join team using(tname)
  where tname = 'Lakers';
  
--7.
  select max(height) as HEIGHT, min(weight) as WEIGHT
  from player
  where tname = 'Lakers';
  
--8.
  select sum(points)/count(pname)
  from player inner join plays_in using(tname)
  where tname = 'Lakers';
  
--9.
  select sum(salary)/count(salary)
  from player
  where tname = 'Lakers';
  
--10.
  select count(gnum) as GAME_COUNT
  from player inner join plays_in using(tname)
  where tname = 'Lakers' and pname = 'Kobe Bryant';
