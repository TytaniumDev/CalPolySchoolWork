/****************************************************
 PL/SQL anonymous block illustrating basic UPDATE with
 error handling and transactional processing
 M. Liu, Spring 2008
 Two input parameters are expected when this block is run:
     start update <ENO>  <new zipcode>
 ****************************************************/
SET AUTOCOMMIT OFF;
WHENEVER OSERROR EXIT ROLLBACK;
WHENEVER SQLERROR EXIT ROLLBACK;
DECLARE
BEGIN
   commit;

   update Employees
   set zip = &2
   where  eno = &1;
   if (sql%rowcount = 0) then
       raise no_data_found;
   else
      commit;
      dbms_output.put_line('***The update has been made and committed ***');
   end if;
   exception    
      when others then  
      dbms_output.put_line('***There is an error and the update cannot be made.');
      rollback;
END;
/
