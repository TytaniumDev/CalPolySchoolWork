select count(*) from TEAM;
select count(*) from TEAM_COLOR;
select count(*) from PLAYER;
select count(*) from CAPTAIN;
select count(*) from GAME;
select count(*) from PLAYS_IN;

---- The tuples below should not be allowed to be inserted -----
insert into TEAM values ('AVeryLongName', 'X', null);
insert into TEAM values ('Celtics', 'X', null);
insert into TEAM values ('Alpha', null, null);
insert into TEAM values ('Alpha', 'X', 'AVeryVeryVeryLongName');

insert into TEAM_COLOR values ('X', 'teal');
insert into TEAM_COLOR values ('Lakers', 'AVeryVeryLongName');
insert into TEAM_COLOR values ('Lakers', 'yellow');

insert into PLAYER values
  ('Lakers', 23, 'Matt Foo', 'G', '14-NOV-1984', 80, 205, 'Massachusetts', null);
insert into PLAYER values
  ('Lakers', 0, 'Matt Foo', 'G', '14-NOV-1984', 80, 205, 'Massachusetts', null);
insert into PLAYER values
  ('Lakers', 101, 'Matt Foo', 'G', '14-NOV-1984', 80, 205, 'Massachusetts', null);
insert into PLAYER values
  ('Lakers', 100, 'Matt Foo', 'XXXX', '14-NOV-1984', 80, 205, 'Massachusetts', null);
insert into PLAYER values
  ('Lakers', 100, 'Matt Foo', 'F', '32-NOV-1984', 80, 205, 'Massachusetts', null);
insert into PLAYER values
  ('Lakers', 100, 'Matt Foo', 'G', '14-NOV-1984', 0, 205, 'Massachusetts', null);
insert into PLAYER values
  ('Lakers', 100, 'Matt Foo', 'G', '14-NOV-1984', 80, 0, 'Massachusetts', null);
insert into PLAYER values
  ('Lakers', 100, 'Matt Foo', 'G', '14-NOV-1984', 80, 200, 'Massachusetts', 0);
insert into PLAYER values
  ('Lakers', 100, 'Matt Foo', 'G', '14-NOV-1984', 80, 200, 'Massachusetts', 
    12345678901.12);

insert into CAPTAIN values ('Lakers', 24);
insert into CAPTAIN values ('Celtic', 20);
insert into CAPTAIN values ('Lakers', 99);

insert into GAME values (0, null, null);
insert into GAME values (1, null, null);
insert into GAME values (8, '0-NOV-1984', null);
insert into GAME values (8, 'not a date', null);
insert into GAME values (8, null, 'Not a good place at all');

insert into PLAYS_IN values(7, 'Celtics', 5, 35, 16, 'Y');
insert into PLAYS_IN values(8, 'Celtics', 5, 35, 16, 'Y');
insert into PLAYS_IN values(7, 'Celtics', 5, 35, 16, 'Y');
insert into PLAYS_IN values(7, 'Celtic', 5, 35, 16, 'Y');
insert into PLAYS_IN values(7, 'Celtics', 95, 35, 16, 'Y');
insert into PLAYS_IN values(7, 'Celtics', 5, -5, 16, 'Y');
insert into PLAYS_IN values(7, 'Celtics', 5, 35, -1, 'Y');
insert into PLAYS_IN values(7, 'Celtics', 5, 35, -1, 'y');
--------------------------------------------------------------
select count(*) from TEAM;
select count(*) from TEAM_COLOR;
select count(*) from PLAYER;
select count(*) from CAPTAIN;
select count(*) from GAME;
select count(*) from PLAYS_IN;

