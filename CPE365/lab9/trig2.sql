/**
 * Lab 9 Part 2 Q 2
 * Tyler Holland (tyhollan)
 * CPE 365
 */
 
CREATE OR REPLACE TRIGGER trig2
AFTER UPDATE ON parts
FOR EACH ROW
BEGIN
  if (:new.qoh <= :new.olevel)
  then dbms_output.put_line('<<<<---- Time to stock part ' || :new.pno);
  end if;
END;
/
SHOW ERRORS 