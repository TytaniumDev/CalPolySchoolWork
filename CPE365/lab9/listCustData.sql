/**********************************************************************
 PL/SQL: A stored procedure with a single input parameter.     
         Such a procedure can be executed from sql*plus as follows:
              exec listCustData(1111)
         or from a PL/SQL block/procedure/function as follows:
              listCustData(1111)
 M. Liu, fall 2009
 Note "show errors" on the last line.
***********************************************************************/                           
  CREATE OR REPLACE
  PROCEDURE listCustData(cno_ customers.cno%type
    -- more comma-separated parameters are possible.
                         ) AS
    -- DECLARE (Note: This is a comment.  DO NOT use DECLARE explicitly.
    cname_  customers.cname%type;
    phone_ customers.phone%type;
    city_  zipcodes.city%type;

  BEGIN
    SELECT cname,phone,city
    INTO   cname_, phone_, city_
    FROM   customers,zipcodes
    WHERE  customers.zip = zipcodes.zip and
           customers.cno = cno_;
   
    DBMS_OUTPUT.PUT_LINE('CNO: ' || cno_);
    DBMS_OUTPUT.PUT_LINE('name: ' || cname_);
    DBMS_OUTPUT.PUT_LINE('phone: ' || phone_); 
    DBMS_OUTPUT.PUT_LINE('city: ' || city_);

EXCEPTION
   WHEN OTHERS THEN
      dbms_output.put_line('Error occurred: '|| ': ' || SQLERRM );    
  END;
/
show errors
