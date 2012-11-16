/**
 *Tyler Holland (tyhollan)
 *CPE 365 AM
 */
DECLARE
   parts_row   parts%ROWTYPE;
   pno_        parts.pno%TYPE;

BEGIN

   dbms_output.put_line('Enter value for pno: ');
   pno_ := &PNO;
   
   SELECT * INTO parts_row
   FROM parts
   WHERE pno = (SELECT pno FROM parts WHERE pno = pno_);
   dbms_output.put_line(parts_row.pname);
   dbms_output.new_line;
   dbms_output.put_line('price is ' || parts_row.price);
   dbms_output.new_line;
   dbms_output.put_line('QOH is ' || parts_row.qoh);
   
EXCEPTION
   WHEN OTHERS THEN
      dbms_output.put_line('Error occurred: '|| SQLERRM );
END;
/
