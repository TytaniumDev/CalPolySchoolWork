/*****************************************************************
 PL/SQL: A stored procedure for canceling an order.
 M. Liu, fall 2009
 To invoke this procedure from SQL*Plus:
      exec cancelOrder(ONO, true/false)
*******************************************************************/ 
-- NOTE: The transaction setting commands are not part of the stored
--       module.  They need to be set in the environment that the
--       procedure/function is called.
SET AUTOCOMMIT OFF;  -- semi-colon
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE; -- semi-colon
WHENEVER OSERROR CONTINUE ROLLBACK; -- semi-colon
--WHENEVER SQLERROR CONTINUE ROLLBACK; -- semi-colon
                          
CREATE OR REPLACE
PROCEDURE cancelOrder (ono_  orders.ono%TYPE, switch boolean) AS
-- DECLARE
     CURSOR order_cur IS      
        SELECT * FROM orders;
     order_rec order_cur%rowtype;
BEGIN
   listParts( );
   -- The stored procedure listParts was created using listParts.sql
   dbms_output.put_line('Removing order with ONO ' || ono_);

   -- Check that the order exists; if not, an exception will be raised
   SELECT * INTO order_rec
   FROM orders
   WHERE ono = ono_;

   UPDATE parts P
   SET qoh = qoh + (SELECT qty
                    FROM   odetails D
                    WHERE  ono = ono_
                           AND D.pno = P.pno);
   DELETE FROM odetails
      WHERE  ono = ono_;  
   DELETE FROM orders
      WHERE  ono = ono_; 

   -- List the parts table to show that the QOHs have been updated
   listParts();  
   -- list remaining orders   
   dbms_output.put_line('ORDERS table: ');
   FOR order_rec in order_cur LOOP
      EXIT WHEN order_cur%NOTFOUND;
      dbms_output.put_line('ONO: ' || order_rec.ono);
   END LOOP;
   dbms_output.put_line('***********************');
   IF (switch) THEN
      COMMIT;
      dbms_output.put_line('COMMIT made');
   ELSE   
      ROLLBACK;
      dbms_output.put_line('ROLLBACK made');
   END IF;
EXCEPTION 
   WHEN OTHERS THEN
      dbms_output.put_line('Error occurred: '|| ': ' || SQLERRM );                           
   ROLLBACK;   
   dbms_output.put_line('ROLLBACK made');
END;

/
show errors
