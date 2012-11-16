---------------------------------------------------------------
-- Mail Order Database; Create Tables Script
-- Chapter 2; Oracle Programming -- A Primer
--            by R. Sunderraman
-- Modified by M. Liu, Fall 2008
---------------------------------------------------------------
create table zipcodes (
  zip      number(5),
  city     varchar2(30),
  primary key (zip));

create table employees (
  eno      number(4) not null primary key, 
  ename    varchar2(10),
  zip      number(5) references zipcodes,
  hdate    date);

create table parts(
  pno      number(5) not null primary key,
  pname    varchar2(30),
  qoh      integer check(qoh >= 0),
  price    number(6,2) check(price >= 0.0),
  olevel   integer);

create table customers (
  cno      number(5) not null primary key,
  cname    varchar2(10),
  street   varchar2(30),
  zip      number(5) references zipcodes,
  phone    char(12));
 
create table orders (
  ono      number(5) not null primary key,
  cno      number(5) references customers,
  eno      number(4) references employees,
  received date,
  shipped  date);

create table odetails (
  ono      number(5) not null references orders,
  pno      number(5) not null references parts,
  qty      integer check(qty > 0),
  primary key (ono,pno));
