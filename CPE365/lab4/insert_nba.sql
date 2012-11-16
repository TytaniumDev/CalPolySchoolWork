---------------------------------------------------------------
-- insert_nba.sql 
--    for populating the NBA 2010 final series Database
-- originated by M. Liu,  Fall 2010
---------------------------------------------------------------
start clear_nba
--
insert into  TEAM values
  ('Celtics','E', 'Boston');
insert into  TEAM values
  ('Lakers','W', 'Los Angeles');
--
insert into TEAM_COLOR values
  ('Celtics', 'green');
insert into TEAM_COLOR values
  ('Celtics', 'white');
insert into TEAM_COLOR values
  ('Lakers', 'purple');
insert into TEAM_COLOR values
  ('Lakers', 'yellow');
--
insert into PLAYER values
  ('Lakers', 37, 'Ron Artest', 'SF', '13-NOV-1979', 79, 260, 'St. John''s', 5854000);
insert into PLAYER values
  ('Lakers', 12, 'Shannon Brown', 'SG', '29-NOV-1985', 76, 210, 'Michigan State', 1990000);
insert into PLAYER values
  ('Lakers',24, 'Kobe Bryant', 'SG', '23-AUG-1978', 78, 205, null, 23034375);
insert into PLAYER values
  ('Lakers', 17, 'Andrew Bynum', 'C', '27-OCT-1987', 84, 285, null, 12500000);
insert into PLAYER values
  ('Lakers', 1, 'Jordan Farmar', 'PG', '30-NOV-1986', 74, 180, 'UCLA', 1947240);
insert into PLAYER values
  ('Lakers', 2, 'Derek Fisher', 'PG', '09-AUG-1974', 73, 210, 'Arkansas', 5048000);
insert into PLAYER values
  ('Lakers', 23, 'Tom Gaffney', 'G', '14-NOV-1984', 80, 205, 'Massachusetts', null);
insert into PLAYER values
  ('Lakers', 16, 'Pau Gasol', 'FC', '06-JUL-1980', 84, 250, null, 16452000);
insert into PLAYER values
  ('Lakers', 20, 'Thomas Kelati', 'G', '27-SEP-1982', 77, 200, 'Washington State', null);
insert into PLAYER values
  ('Lakers', 28, 'D.J. Mbenga', 'C', '30-DEC-1980', 84, 255, null, 959111);
insert into PLAYER values
  ('Lakers', 6, 'Adam Morrison', 'SF', '19-JUL-1984', 80, 207, 'Gonzaga', 5257229);
insert into PLAYER values
  ('Lakers', 7, 'Lamar Odom', 'PF', '06-NOV-1979', 82, 230, 'Rhode Island', 7500000);
insert into PLAYER values
  ('Lakers', 21, 'Josh Powell', 'FC', '25-JAN-1983', 81, 240, 'North Carolina State', 959111);
insert into PLAYER values
  ('Lakers', 18, 'Sasha Vujacic', 'SG', '08-MAR-1984', 79, 205, null, 5000000);
insert into PLAYER values
  ('Lakers', 4, 'Luke Walton', 'SF', '28-MAR-1980', 80, 235, 'Arizona', 4840000);

---- Celtics roster
insert into PLAYER values
  ('Celtics', 20, 'Ray Allen', 'SG', '20-JUL-1975', 77, 205, 'Connecticut', 18776860);
insert into PLAYER values
  ('Celtics', 42, 'Tony Allen', 'SG', '11-JAN-1982', 76, 213, 'Oklahoma State', 2500000);
insert into PLAYER values
  ('Celtics', 7, 'Marquis Daniels', 'SG', '07-JAN-1981', 78, 200, 'Auburn', 1990000);
insert into PLAYER values
  ('Celtics', 11, 'Glen Davis', 'PF', '01-JAN-1986', 81, 289, 'LSU', 3000004);
insert into PLAYER values
  ('Celtics', 5, 'Kevin Garnett', 'PF', '19-MAY-1976', 83, 253, null, 16417044);
insert into PLAYER values
  ('Celtics', 43, 'Kendrick Perkins', 'C', '10-NOV-1984', 82, 280, null, 4750000);
insert into PLAYER values
  ('Celtics', 34, 'Paul Pierce', 'SF', '13-OCT-1977', 79, 235, 'Kansas', 19795712);
insert into PLAYER values
  ('Celtics', 9, 'Rajon Rondo', 'PG', '22-FEB-1986', 73, 171, 'Kentucky', 2094923);
insert into PLAYER values
  ('Celtics', 30, 'Rasheed Wallace', 'FC', '17-SEP-1974', 83, 230, 'North Carolina', 5854000);
insert into PLAYER values
  ('Celtics', 13, 'Shelden Williams', 'PF', '21-OCT-1983', 81, 250, 'Duke', 825497);
insert into PLAYER values
  ('Celtics', 40, 'Michael Finley', 'G-F', '06-MAR-1973', 79, 225, 'Wisconsin', null);
insert into PLAYER values
  ('Celtics', 4, 'Nate Robinson', 'G', '31-MAY-1984', 79, 225, 'Washington', null);
--
insert into CAPTAIN values
  ('Lakers', 24);
insert into CAPTAIN values
  ('Celtics', 34);

-- Game 1
insert into GAME values
  (1, to_date('JUN 03 2010 2100', 'MON DD YYYY HH24:MI'), 'Los Angeles');
insert into GAME values
  (2, to_date('JUN 06 2010 2000', 'MON DD YYYY HH24:MI'), 'Los Angeles');
insert into GAME values
  (3, to_date('JUN 08 2010 2100', 'MON DD YYYY HH24:MI'), 'Boston');
insert into GAME values
  (4, to_date('JUN 10 2010 2100', 'MON DD YYYY HH24:MI'), 'Boston');
insert into GAME values
  (5, to_date('JUN 13 2010 2000', 'MON DD YYYY HH24:MI'), 'Boston');
insert into GAME values
  (6, to_date('JUN 15 2010 2100', 'MON DD YYYY HH24:MI'), 'Los Angeles');
insert into GAME values
  (7, to_date('JUN 17 2010 2100', 'MON DD YYYY HH24:MI'), 'Los Angeles');
--
insert into PLAYS_IN values
  (1, 'Celtics', 5, 35, 16, 'Y');
insert into PLAYS_IN values
  (1, 'Celtics', 34, 46, 24, 'Y');
insert into PLAYS_IN values
  (1, 'Celtics', 43, 24, 8, 'Y');
insert into PLAYS_IN values
  (1, 'Celtics', 20, 27, 12, 'Y');
insert into PLAYS_IN values
  (1, 'Celtics', 9, 40, 13, 'Y');
insert into PLAYS_IN values
  (1, 'Celtics', 30, 18, 9, 'N');
insert into PLAYS_IN values
  (1, 'Celtics', 42, 17, 4, 'N');
insert into PLAYS_IN values
  (1, 'Celtics', 40, 2, 0, 'N');
insert into PLAYS_IN values
  (1, 'Celtics', 4, 13, 0, 'N');
insert into PLAYS_IN values
  (1, 'Celtics', 11, 19, 3, 'N');
---
insert into PLAYS_IN values
  (1, 'Lakers', 37, 33, 15, 'Y');
insert into PLAYS_IN values
  (1, 'Lakers', 16, 47, 23, 'Y');
insert into PLAYS_IN values
  (1, 'Lakers', 17, 28, 10, 'Y');
insert into PLAYS_IN values
  (1, 'Lakers', 24, 39, 30, 'Y');
insert into PLAYS_IN values
  (1, 'Lakers', 2, 28, 9, 'Y');

insert into PLAYS_IN values
  (1, 'Lakers', 7, 21, 5, 'N');
insert into PLAYS_IN values
  (1, 'Lakers', 4, 5, 0, 'N');
insert into PLAYS_IN values
  (1, 'Lakers', 12, 17, 6, 'N');
insert into PLAYS_IN values
  (1, 'Lakers', 18, 8, 0, 'N');
insert into PLAYS_IN values
  (1, 'Lakers', 1, 13, 4, 'N');

-- Game 2 
insert into PLAYS_IN values
  (2, 'Celtics', 5, 24, 6, 'Y');
insert into PLAYS_IN values
  (2, 'Celtics', 34, 40, 10, 'Y');
insert into PLAYS_IN values
  (2, 'Celtics', 43, 32, 12, 'Y');
insert into PLAYS_IN values
  (2, 'Celtics', 20, 44, 32, 'Y');
insert into PLAYS_IN values
  (2, 'Celtics', 9, 42, 19, 'Y');
insert into PLAYS_IN values
  (2, 'Celtics', 30, 18, 7, 'N');
insert into PLAYS_IN values
  (2, 'Celtics', 13, 4, 0, 'N');
insert into PLAYS_IN values
  (2, 'Celtics', 42, 12, 2, 'N');
insert into PLAYS_IN values
  (2, 'Celtics', 4, 6, 7, 'N');
insert into PLAYS_IN values
  (2, 'Celtics', 11, 18, 8, 'N');
---
insert into PLAYS_IN values
  (2, 'Lakers', 37, 41, 6, 'Y');
insert into PLAYS_IN values
  (2, 'Lakers', 16, 42, 25, 'Y');
insert into PLAYS_IN values
  (2, 'Lakers', 17, 39, 21, 'Y');
insert into PLAYS_IN values
  (2, 'Lakers', 24, 34, 21, 'Y');
insert into PLAYS_IN values
  (2, 'Lakers', 2, 35, 6, 'Y');

insert into PLAYS_IN values
  (2, 'Lakers', 7, 15, 3, 'N');
insert into PLAYS_IN values
  (2, 'Lakers', 12, 15, 2, 'N');
insert into PLAYS_IN values
  (2, 'Lakers', 18, 7, 3, 'N');
insert into PLAYS_IN values
  (2, 'Lakers', 1, 13, 7, 'N');

-- Game 3 
insert into PLAYS_IN values
  (3, 'Lakers', 37, 23, 2, 'Y');
insert into PLAYS_IN values
  (3, 'Lakers', 16, 39, 13, 'Y');
insert into PLAYS_IN values
  (3, 'Lakers', 17, 29, 9, 'Y');
insert into PLAYS_IN values
  (3, 'Lakers', 24, 44, 29, 'Y');
insert into PLAYS_IN values
  (3, 'Lakers', 2, 43, 16, 'Y');

insert into PLAYS_IN values
  (3, 'Lakers', 7, 28, 12, 'N');
insert into PLAYS_IN values
  (3, 'Lakers', 4, 13, 2, 'N');
insert into PLAYS_IN values
  (3, 'Lakers', 12, 16, 4, 'N');
-- insert into PLAYS_IN values
--  (3, 'Lakers', 1, 8, 2, 'N');
--
insert into PLAYS_IN values
  (3, 'Celtics', 5, 32, 25, 'Y');
insert into PLAYS_IN values
  (3, 'Celtics', 34, 34, 15, 'Y');
insert into PLAYS_IN values
  (3, 'Celtics', 43, 22, 5, 'Y');
insert into PLAYS_IN values
  (3, 'Celtics', 20, 42, 2, 'Y');
insert into PLAYS_IN values
  (3, 'Celtics', 9, 42, 11, 'Y');
-- 
insert into PLAYS_IN values
  (3, 'Celtics', 30, 19, 2, 'N');
insert into PLAYS_IN values
  (3, 'Celtics', 42, 20, 7, 'N');
insert into PLAYS_IN values
  (3, 'Celtics', 4, 6, 5, 'N');
insert into PLAYS_IN values
  (3, 'Celtics', 11, 24, 12, 'N');

-- Game 4 
insert into PLAYS_IN values
  (4, 'Lakers', 37, 42, 9, 'Y');
insert into PLAYS_IN values
  (4, 'Lakers', 16, 44, 21, 'Y');
insert into PLAYS_IN values
  (4, 'Lakers', 17, 12, 2, 'Y');
insert into PLAYS_IN values
  (4, 'Lakers', 24, 43, 33, 'Y');
insert into PLAYS_IN values
  (4, 'Lakers', 2, 31, 6, 'Y');

insert into PLAYS_IN values
  (4, 'Lakers', 7, 39, 10, 'N');
insert into PLAYS_IN values
  (4, 'Lakers', 12, 11, 5, 'N');
insert into PLAYS_IN values
  (4, 'Lakers', 18, 7, 0, 'N');
insert into PLAYS_IN values
  (4, 'Lakers', 1, 11, 3, 'N');
-- 
insert into PLAYS_IN values
  (4, 'Celtics', 5, 27, 13, 'Y');
insert into PLAYS_IN values
  (4, 'Celtics', 34, 36, 19, 'Y');
insert into PLAYS_IN values
  (4, 'Celtics', 43, 25, 6, 'Y');
insert into PLAYS_IN values
  (4, 'Celtics', 20, 41, 12, 'Y');
insert into PLAYS_IN values
  (4, 'Celtics', 9, 31, 10, 'Y');
-- 
insert into PLAYS_IN values
  (4, 'Celtics', 30, 22, 3, 'N');
insert into PLAYS_IN values
  (4, 'Celtics', 7, 0, 0, 'N');
insert into PLAYS_IN values
  (4, 'Celtics', 42, 18, 3, 'N');
insert into PLAYS_IN values
  (4, 'Celtics', 4, 17, 12, 'N');
insert into PLAYS_IN values
  (4, 'Celtics', 11, 22, 18, 'N');

-- Game 5 
insert into PLAYS_IN values
  (5, 'Lakers', 37, 34, 7, 'Y');
insert into PLAYS_IN values
  (5, 'Lakers', 16, 38, 12, 'Y');
insert into PLAYS_IN values
  (5, 'Lakers', 17, 32, 6, 'Y');
insert into PLAYS_IN values
  (5, 'Lakers', 24, 44, 38, 'Y');
insert into PLAYS_IN values
  (5, 'Lakers', 2, 34, 9, 'Y');

insert into PLAYS_IN values
  (5, 'Lakers', 7, 26, 8, 'N');
insert into PLAYS_IN values
  (5, 'Lakers', 4, 7, 0, 'N');
insert into PLAYS_IN values
  (5, 'Lakers', 12, 0, 0, 'N');
insert into PLAYS_IN values
  (5, 'Lakers', 18, 10, 5, 'N');
insert into PLAYS_IN values
  (5, 'Lakers', 1, 14, 1, 'N');
-- 
insert into PLAYS_IN values
  (5, 'Celtics', 5, 36, 18, 'Y');
insert into PLAYS_IN values
  (5, 'Celtics', 34, 43, 27, 'Y');
insert into PLAYS_IN values
  (5, 'Celtics', 43, 32, 4, 'Y');
insert into PLAYS_IN values
  (5, 'Celtics', 20, 40, 12, 'Y');
insert into PLAYS_IN values
  (5, 'Celtics', 9, 38, 18, 'Y');
-- 
insert into PLAYS_IN values
  (5, 'Celtics', 30, 15, 5, 'N');
insert into PLAYS_IN values
  (5, 'Celtics', 42, 13, 4, 'N');
insert into PLAYS_IN values
  (5, 'Celtics', 4, 10, 4, 'N');
insert into PLAYS_IN values
  (5, 'Celtics', 11, 13, 0, 'N');

-- Game 6 
insert into PLAYS_IN values
  (6, 'Celtics', 5, 31, 12, 'Y');
insert into PLAYS_IN values
  (6, 'Celtics', 34, 34, 13, 'Y');
insert into PLAYS_IN values
  (6, 'Celtics', 43, 7, 0, 'Y');
insert into PLAYS_IN values
  (6, 'Celtics', 20, 36, 19, 'Y');
insert into PLAYS_IN values
  (6, 'Celtics', 9, 33, 10, 'Y');

insert into PLAYS_IN values
  (6, 'Celtics', 30, 17, 0, 'N');
insert into PLAYS_IN values
  (6, 'Celtics', 7, 4, 5, 'N');
insert into PLAYS_IN values
  (6, 'Celtics', 13, 14, 0, 'N');
insert into PLAYS_IN values
  (6, 'Celtics', 42, 17, 2, 'N');
insert into PLAYS_IN values
  (6, 'Celtics', 40, 3, 0, 'N');
insert into PLAYS_IN values
  (6, 'Celtics', 4, 16, 6, 'N');
insert into PLAYS_IN values
  (6, 'Celtics', 11, 27, 0, 'N');
---
insert into PLAYS_IN values
  (6, 'Lakers', 37, 32, 15, 'Y');
insert into PLAYS_IN values
  (6, 'Lakers', 16, 41, 17, 'Y');
insert into PLAYS_IN values
  (6, 'Lakers', 17, 16, 2, 'Y');
insert into PLAYS_IN values
  (6, 'Lakers', 24, 40, 26, 'Y');
insert into PLAYS_IN values
  (6, 'Lakers', 2, 15, 4, 'Y');

insert into PLAYS_IN values
  (6, 'Lakers', 7, 28, 8, 'N');
insert into PLAYS_IN values
  (6, 'Lakers', 21, 8, 0, 'N');
insert into PLAYS_IN values
  (6, 'Lakers', 4, 6, 0, 'N');
insert into PLAYS_IN values
  (6, 'Lakers', 12, 19, 4, 'N');
insert into PLAYS_IN values
  (6, 'Lakers', 18, 14, 9, 'N');
insert into PLAYS_IN values
  (6, 'Lakers', 28, 3, 0, 'N');
insert into PLAYS_IN values
  (6, 'Lakers', 1, 17, 4, 'N');

-- Game 7 
insert into PLAYS_IN values
  (7, 'Celtics', 5, 38, 17, 'Y');
insert into PLAYS_IN values
  (7, 'Celtics', 34, 46, 18, 'Y');
insert into PLAYS_IN values
  (7, 'Celtics', 30, 36, 11, 'Y');
insert into PLAYS_IN values
  (7, 'Celtics', 20, 45, 13, 'Y');
insert into PLAYS_IN values
  (7, 'Celtics', 9, 45, 14, 'Y');
-- 
-- insert into PLAYS_IN values
--  (7, 'Celtics', 44, 1, 0, 'N');
insert into PLAYS_IN values
  (7, 'Celtics', 42, 5, 0, 'N');
insert into PLAYS_IN values
  (7, 'Celtics', 4, 4, 0, 'N');
insert into PLAYS_IN values
  (7, 'Celtics', 11, 21, 6, 'N');
--
insert into PLAYS_IN values
  (7, 'Lakers', 37, 46, 20, 'Y');
insert into PLAYS_IN values
  (7, 'Lakers', 16, 42, 19, 'Y');
insert into PLAYS_IN values
  (7, 'Lakers', 17, 19, 2, 'Y');
insert into PLAYS_IN values
  (7, 'Lakers', 24, 45, 23, 'Y');
insert into PLAYS_IN values
  (7, 'Lakers', 2, 30, 10, 'Y');

insert into PLAYS_IN values
  (7, 'Lakers', 7, 35, 7, 'N');
insert into PLAYS_IN values
  (7, 'Lakers', 21, 1, 0, 'N');
insert into PLAYS_IN values
  (7, 'Lakers', 12, 5, 0, 'N');
insert into PLAYS_IN values
  (7, 'Lakers', 18, 5, 2, 'N');
insert into PLAYS_IN values
  (7, 'Lakers', 1, 13, 0, 'N');



