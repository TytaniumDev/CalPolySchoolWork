/*****************************************************************
 PL/SQL: A stored procedure with no parameters. 
 M. Liu, fall 2009
 To invoke this procedure from SQL*Plus:
      exec list_parts 
 or from a PL/SQL block/procedure/function as follows:
      listParts()      
*******************************************************************/                           
  CREATE OR REPLACE
  PROCEDURE listParts AS
     -- DECLARE
     CURSOR part_cur IS      
        SELECT * FROM parts;
     part_rec part_cur%rowtype;

  BEGIN
        dbms_output.put_line('***********************');
        dbms_output.put_line('PARTS table: ');
        FOR part_rec in part_cur LOOP
           EXIT WHEN part_cur%NOTFOUND;
           dbms_output.put_line('Part ' || part_rec.pno 
                                || ' ' || part_rec.pname 
                                || ': QOH = ' || part_rec.qoh);
        END LOOP;
        dbms_output.put_line('***********************');

  EXCEPTION 
      WHEN OTHERS THEN
         dbms_output.put_line('Error occurred: '|| ': ' || SQLERRM );              
  END;

/
show errors
