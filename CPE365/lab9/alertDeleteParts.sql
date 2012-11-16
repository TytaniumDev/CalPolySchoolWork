CREATE OR REPLACE TRIGGER alertDeleteParts
AFTER DELETE ON parts
FOR EACH ROW
BEGIN
dbms_output.put_line('ALERT: part ' || :old.pno
 || 'has been deleted by ' || USER || ' on ' 
 || to_char(sysdate, 'DD-MON-YY, HH:MI:SS'));
END;
/
SHOW ERRORS;
