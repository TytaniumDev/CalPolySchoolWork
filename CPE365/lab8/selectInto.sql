/****************************************************
 PL/SQL anonymous block illustrating SELECT INTO, which
 can only be used if ONE ROW is SELECTED.
 M. Liu, Fall 2009
 An input parameter for an employee CNO is expected 
 when this block is run.
 ****************************************************/
DECLARE
   cname_   customers.cname%TYPE;
   cno_     customers.cno%TYPE;
   zip_     customers.zip%TYPE;
   customerCount_   integer := 0;
   customer_row customers%ROWTYPE;
   employees_row employees%ROWTYPE;
   zipcodes_row  zipcodes%ROWTYPE;

BEGIN
   cno_ := &CNO;
   -- Example 1: use INTO to fetch single values
   SELECT C.cname, C.zip INTO cname_, zip_
   FROM customers C
   WHERE  cno = cno_;
   dbms_output.put_line('***The customer name is ' ||  cname_);
   dbms_output.put_line('***The customer zipcode is ' ||  zip_);

   -- Example 2: use INTO to fetch a value returned by a group 
   --            function
   SELECT count(*) INTO customerCount_
   FROM customers;
   dbms_output.put_line('***There are currently ' || 
                        customerCount_ || ' customers.');

   -- Example 3: use INTO to fetch a single row
   SELECT * INTO customer_row
   FROM customers C
   WHERE  cno = cno_;
   dbms_output.put_line('***The customer name is ' ||  
        customer_row.cname || ', The customer address is '
        || customer_row.street);

   -- Example 4: use INTO to fetch a single row; 
   --            illustrating the use of a sub-SELECT
   SELECT * INTO zipcodes_row
   FROM zipcodes
   WHERE zip = (SELECT zip FROM customers WHERE cno = cno_);
   dbms_output.put_line('***The customer lives in ' 
        ||  zipcodes_row.zip || ', ' || zipcodes_row.city);

   -- Example 5: illustrates a BAD use of SELECT INTO
   dbms_output.put_line('***The customers are: ****');
   SELECT * INTO customer_row
   FROM customers;
   -- The statement above will raise an exception because 
   --   it fetches more than one row.

EXCEPTION
   WHEN OTHERS THEN
      dbms_output.put_line('Error occurred: '|| 
                           ': ' || SQLERRM );
END;
/
