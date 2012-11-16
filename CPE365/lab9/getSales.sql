/***************************************************************
 PL/SQL: illustrates a stored Function  
 The function created returns the sales figure of an employee.
 Parameter: eno
 Return value: a numeric dollar value of the sales made, or NULL
               if no such employee.
 M. Liu, Fall 2009                                      
 **************************************************************/
CREATE OR REPLACE  FUNCTION getSales(eno_  employees.eno%type)    
   RETURN NUMBER  -- NUMBER is an Oracle type equivalent to NUMERIC
AS    
-- DECLARE
     returnVal NUMERIC(7,2);
   BEGIN
      SELECT SUM (qty*price) INTO   returnVal
      FROM   orders O, odetails D, parts P
      WHERE  O.ono = D.ono and D.pno = P.pno and O.eno = eno_;
      RETURN (returnVal);    
   EXCEPTION
      WHEN OTHERS THEN
         returnVal := null;  
         RETURN (returnVal);  
   END; 
/
SHOW ERRORS
