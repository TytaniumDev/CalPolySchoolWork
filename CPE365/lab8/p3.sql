/**
 *Tyler Holland (tyhollan)
 *CPE 365 AM
 * Three input parameters are expected when this block is run:
 *   start p3 <new ONO> <new CNO> <new ENO>
 */
 
SET AUTOCOMMIT OFF;
WHENEVER OSERROR CONTINUE ROLLBACK;
WHENEVER SQLERROR CONTINUE ROLLBACK;
SET ISOLATION LEVEL READ COMMITTED
DECLARE

  CURSOR orders_cur IS
      SELECT *
      FROM   orders
      order by ono;
  orders_rec   orders_cur%ROWTYPE;
  
  TAB CONSTANT VARCHAR2(1):=CHR(9); -- a tab character used for output 
                                  -- formatting
                                  
BEGIN
   commit;
   
   insert into orders
   values (&1, &2, &3, to_date(sysdate, 'DD-MON-YY'), null);
   
   if (sql%rowcount = 0) then
       raise no_data_found;
   else
      commit;
      dbms_output.put_line('***The insertion has been made temporarily:');
      FOR orders_rec in orders_cur LOOP
      EXIT WHEN orders_cur%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE(
            lpad(orders_cur%ROWCOUNT, 3) || '. ' || orders_rec.ono || TAB ||
                 orders_rec.cno || TAB || orders_rec.eno, || TAB ||
                 to_char(orders_rec.received, 'DD-MON-YY') || TAB || 
                 to_char(orders_rec.shipped, 'DD-MON-YY')); 
      dbms_output.new_line;          
      END LOOP;
      rollback;
      dbms_output.put_line('***The orders table before exit:');
      FOR orders_rec in orders_cur LOOP
      EXIT WHEN orders_cur%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE(
            lpad(orders_cur%ROWCOUNT, 3) || '. ' || orders_rec.ono || TAB ||
                 orders_rec.cno || TAB || orders_rec.eno, || TAB ||
                 to_char(orders_rec.received, 'DD-MON-YY') || TAB || 
                 to_char(orders_rec.shipped, 'DD-MON-YY')); 
      dbms_output.new_line;          
      END LOOP;
   end if;
   
   exception    
      when others then  
      dbms_output.put_line('***There is an error and the update cannot be made.');
      rollback;
   
   
END;
/
