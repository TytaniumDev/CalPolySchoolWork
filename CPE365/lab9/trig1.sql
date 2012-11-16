/**
 * Lab 9 Part 2 Q 1
 * Tyler Holland (tyhollan)
 * CPE 365
 */
 
CREATE OR REPLACE TRIGGER trig1
BEFORE UPDATE OR DELETE OR INSERT ON odetails
FOR EACH ROW
BEGIN
   dbms_output.put_line('<<<<---- Changing odetails: '|| to_char(sysdate, 'DD-MON-YY HH:MI:SS')
        || ', ' || user || ', ' || :old.ono || ', ');
   IF UPDATING THEN
    dbms_output.put_line('update');
   ELSIF INSERTING THEN
    dbms_output.put_line('insert');
   ELSIF DELETING THEN
    dbms_output.put_line('delete');
   END IF;

END;
/
show errors;