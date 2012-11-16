/*
 CPE 365
 Tyler Holland
 */
-- 1. List each row in the RECIPE table, in increasing alphabetical order of rname.
 select *
 from RECIPE
 order by rname;
 
-- 2. List each row in the INGREDIENT table, in increasing alphabetical order of rname.
 select *
 from INGREDIENT
 order by iname;
 
-- 3. List each row in the CONTAINS table, in increasing alphabetical order of
--    rname then increasing alphabetical order of iname.
 select *
 from CONTAINS
 order by rname, iname;

-- 4.
 select rname
 from CONTAINS
 where iname = 'salt'
 order by rname;
 
-- 5.
 select rname
 from CONTAINS
 where iname <> 'salt'
 order by rname;
 
-- 6.
 select rname
 from CONTAINS
 where iname = 'salt'
 union
 select rname
 from CONTAINS
 where iname = 'pepper'
 order by rname;
 
-- 7.
 select rname
 from CONTAINS
 where iname = 'salt'
 intersect
 select rname
 from CONTAINS
 where iname = 'pepper'
 order by rname;
 
-- 8.
 select rname
 from CONTAINS
 where iname = 'salt'
 minus
 select rname
 from CONTAINS
 where iname = 'pepper'
 order by rname;
 
-- 9.
 select rname
 from CONTAINS
 where iname != 'salt'
 intersect
 select rname
 from CONTAINS
 where iname != 'pepper'
 order by rname;
-- 10.
 select C.rname, I.iname, C.amount, I.foodGroup
 from CONTAINS C, INGREDIENT I
 where C.iname = I.iname
 order by C.rname, I.iname;
 
-- 11.
 select rname, iname, amount, foodGroup
 from CONTAINS natural join INGREDIENT
 order by rname, iname;
 
-- 12.
 select R.rname, R.type
 from CONTAINS C, RECIPE R
 where C.rname = R.rname AND C.iname = 'salt'
 order by R.rname;
 
-- 13.
 select rname, type
 from CONTAINS inner join RECIPE using (rname)
 where iname = 'salt'
 order by rname;
 
-- 14.
 select rname
 from CONTAINS inner join INGREDIENT using (iname)
 where foodGroup = 'dairy'
 order by rname;
 
-- 15.
 select rname
 from CONTAINS
 minus
 select rname
 from CONTAINS inner join INGREDIENT using (iname)
 where foodGroup = 'dairy'
 order by rname;
 
-- 16.
 select DISTINCT rname, price
 from CONTAINS inner join RECIPE using (rname) inner join INGREDIENT using (iname)
 where foodGroup = 'dairy'
 order by rname;
 
-- 17.
 select iname
 from INGREDIENT
 minus
 select A.iname
 from INGREDIENT A, INGREDIENT B
 where A.cost > B.cost
 order by iname;
