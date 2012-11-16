/**
 *Tyler Holland (tyhollan)
 *CPE 365 AM
 */
DECLARE

  pno_        odetails.pno%TYPE;

  CURSOR odetails_cur IS
      SELECT *
      FROM   odetails
      WHERE  pno = pno_
      order by ono;
  odetails_rec   odetails_cur%ROWTYPE;
  
  TAB CONSTANT VARCHAR2(1):=CHR(9); -- a tab character used for output 
                                    -- formatting
BEGIN
  dbms_output.put_line('Enter value for pno: ');
   pno_ := &PNO;

  DBMS_OUTPUT.PUT_LINE('****The orders for the part you chose are:');
  FOR odetails_rec in odetails_cur LOOP
    EXIT WHEN odetails_cur%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(
          lpad(odetails_cur%ROWCOUNT, 3) || '. ' || odetails_rec.ono || TAB ||
          rpad(odetails_rec.pno, 15) || TAB || odetails_rec.qty);  
    dbms_output.new_line;          
  END LOOP;
  
EXCEPTION
 WHEN OTHERS THEN
    dbms_output.put_line('Error occurred: '|| SQLERRM );

END;
/
