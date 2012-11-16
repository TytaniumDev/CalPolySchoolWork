DROP TABLE TEAM cascade constraints;
CREATE TABLE TEAM
(
  tname varchar2(10) PRIMARY KEY,
  conference CHAR(1) NOT NULL,
  city varchar2(15)
);

DROP TABLE TEAM_COLOR cascade constraints;
CREATE TABLE TEAM_COLOR
(
  tname varchar(10),
  color varchar(12),
  FOREIGN KEY (tname) REFERENCES TEAM (tname),
  PRIMARY KEY (tname, color)
);

DROP TABLE PLAYER cascade constraints;
CREATE TABLE PLAYER
(
  tname varchar(10),
  pid numeric(2,0) CHECK (pid > 0),
  pname varchar(20),
  position varchar(3),
  bdate date,
  height numeric(3,0) CHECK (height > 0),
  weight numeric(3,0) CHECK (weight > 0),
  college varchar(20),
  salary numeric(12,2) CHECK (salary > 0),
  FOREIGN KEY (tname) REFERENCES TEAM (tname),
  PRIMARY KEY (tname, pid)
);

DROP TABLE CAPTAIN cascade constraints;
CREATE TABLE CAPTAIN
(
  tname varchar(10),
  pid numeric(2,0),
  FOREIGN KEY (tname, pid) REFERENCES PLAYER,
  PRIMARY KEY (tname, pid)
);

DROP TABLE GAME cascade constraints;
CREATE TABLE GAME
(
  gnum numeric(1,0) PRIMARY KEY CHECK (gnum > 0),
  dateTime date,
  place varchar(15)
);

DROP TABLE PLAYS_IN cascade constraints;
CREATE TABLE PLAYS_IN
(
  gnum numeric(1,0),
  tname varchar(10),
  pid numeric(2,0),
  minutes numeric(3,0) CHECK (minutes >= 0),
  points numeric(3,0) CHECK (points >= 0),
  starter char(1) CHECK (starter = 'Y' OR starter = 'N'),
  FOREIGN KEY (tname, pid) REFERENCES PLAYER,
  FOREIGN KEY (gnum) REFERENCES GAME (gnum),
  PRIMARY KEY (tname, pid, gnum)
);
