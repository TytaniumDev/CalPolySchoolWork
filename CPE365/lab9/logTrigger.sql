/*********************************************************
 The following table is created for logging changes
 made to the zipcodes table.
 NOTE that by design there are no constraints specified.
 ********************************************************/

drop table zipcodes_change_log cascade constraints; 
create table zipcodes_change_log (
  zip          number(5),
  username     varchar2(30),
  change_date  date,
  change       varchar2(10));
/

--------------------------------------------------
--  A sample trigger for logging changes made to 
--  a table.
--     by M. L. Liu, fall 2008
---------------------------------------------------
CREATE OR REPLACE TRIGGER zipCodes_changes
BEFORE UPDATE OR DELETE OR INSERT ON zipcodes
FOR EACH ROW
BEGIN
   dbms_output.put_line('In who_changes_zipcodes trigger');
   dbms_output.put_line(to_char(sysdate, 'DD-MON-YY, HH:MI:SS')
        || ':' || user || ' is trying to change ZIPCODES.');
   IF UPDATING THEN
      INSERT INTO zipcodes_change_log
         VALUES (:old.zip,user,sysdate,'update');
   ELSIF INSERTING THEN
      INSERT INTO zipcodes_change_log
         VALUES (:new.zip,user,sysdate,'insert');
   ELSIF DELETING THEN
      INSERT INTO zipcodes_change_log
         VALUES(:old.zip,user,sysdate,'delete');
   END IF;

END;
/
show errors;
