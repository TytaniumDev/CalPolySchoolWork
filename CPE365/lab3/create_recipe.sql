---------------------------------------------------------------
-- Recipe Database; Create Tables Script
-- Created by M. Liu, Fall 2010
---------------------------------------------------------------
drop table recipe cascade constraints;
-- If the table recipe does not already exist, the statement
--   above will cause a harmless error message.
create table recipe (
  rname    varchar2(20),
  type     varchar2(15) not null,
  price    numeric(5,2) check (price > 0),
  servings integer check (servings > 0),
  primary key (rname)
);

drop table ingredient cascade constraints;
create table ingredient (
  iname      varchar2(20) primary key,
  foodGroup  varchar2(15),
  cost       numeric(6,2) check (cost > 0),
  calorie    numeric(5,2) check (calorie >= 0)
);

drop table contains cascade constraints;
create table contains(
  rname    varchar2(20),
  iname    varchar2(20) references ingredient, 
  amount   numeric(6,3) check (amount > 0),
  foreign key (rname) references recipe (rname),
  primary key (rname, iname)
);

