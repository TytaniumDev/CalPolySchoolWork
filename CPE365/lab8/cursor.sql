/***************************************************************
   PL/SQL: An anonymous block that illustrates the use of a 
           cursor to SELECT multiple rows.
   Also illustrated is optional output formatting.                   
  M. Liu, Fall 2009                                             
****************************************************************/
DECLARE
  -- Declare a basic cursor for use with fetching rows 
  -- successively from the customers table.
  CURSOR cust_cur IS
      SELECT *
      FROM  customers
      ORDER BY cno;
  cust_rec   cust_cur%ROWTYPE;

  -- Declare another cursor for use with fetching rows 
  -- successively from the orders table for orders made
  -- by a particular customer whose CNO is obtained as input.
  CURSOR order_cur IS
      SELECT *
      FROM   orders
      WHERE  cno = &cno;
  order_rec   order_cur%ROWTYPE;

  TAB CONSTANT VARCHAR2(1):=CHR(9); -- a tab character used for output 
                                    -- formatting

BEGIN
  -- List all customers
  DBMS_OUTPUT.PUT_LINE('****The customers are:');
  FOR cust_rec in cust_cur LOOP
    EXIT WHEN cust_cur%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(
          lpad(cust_cur%ROWCOUNT, 3) || '. ' || cust_rec.cno || TAB ||
          rpad(cust_rec.cname, 15) || TAB || cust_rec.phone);    
          /* The lpad function pads the argument string to the left
             with blank */  
  END LOOP;

  DBMS_OUTPUT.PUT_LINE('****The orders made by the customer you chose:');
  FOR order_rec in order_cur LOOP
    EXIT WHEN order_cur%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(
          lpad(order_cur%ROWCOUNT, 3) || '. ' || order_rec.ono || TAB ||
          rpad(order_rec.cno, 15) || TAB || order_rec.eno);      
  END LOOP;
  
END;
/
