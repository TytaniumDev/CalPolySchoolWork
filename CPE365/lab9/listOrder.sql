/**
 * Lab 9 Part 1 Q 1
 * Tyler Holland (tyhollan)
 * CPE 365
 */
 
CREATE OR REPLACE PROCEDURE listOrder(ono_ odetails.ono%type)
AS
--DECLARE
  cursor order_cur IS
    select *
    from odetails
    where ono = ono_
    order by ono, pno;
  order_rec order_cur%ROWTYPE;
  
  throwaway_ odetails.ono%TYPE;

BEGIN
 select ono
 into throwaway_
 from orders
 where ono = ono_;
 
 for order_rec in order_cur loop
  exit when order_cur%notfound;
  dbms_output.put_line('ONO ' || ono_ || ', PNO: ' ||
    order_rec.pno || ', QTY: ' || order_rec.qty);
  end loop;
 
EXCEPTION
 WHEN OTHERS THEN
  dbms_output.put_line('Error occurred: ' || SQLERRM);
 END;
/
show errors
