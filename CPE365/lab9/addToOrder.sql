/**
 * Lab 9 Part 1 Q 3
 * Tyler Holland (tyhollan)
 * CPE 365
 */
 
CREATE OR REPLACE PROCEDURE addToOrder(ono_ odetails.ono%type,
    pno_ odetails.pno%type, qty_ odetails.qty%type, commit_ boolean)
AS
--DECLARE
  orderValue_ parts.price%type;
  pname_ parts.pname%type;
  qoh_ parts.qoh%type;
  cno_ orders.cno%type;
  eno_ orders.eno%type;
  rec_ orders.received%type;
  ship_ orders.shipped%type;
  
BEGIN
 dbms_output.put_line('**** Before the change ****');
 select pname, qoh
 into pname_, qoh
 from parts
 where pno = pno_;
 dbms_output.put_line('Part ' || pno_ || ' ' || pname_ || ': QOH = ' ||  qoh_);
 select cno, eno, received, shipped
 into cno_, eno_, rec_, ship_
 from orders
 where ono = ono_;
 select orderValue(ono_)
 into orderValue_
 from dual;
 
 dbms_output.put_line('ONO: ' || ono_ || ', CNO: ' || cno_ || ', ENO: ' || eno_
    || ', RECEIVED: ' || to_char(rec_, 'DD-MON-YY') || ', SHIPPED: ' || to_char(ship_, 'DD-MON-YY')
    || ', ORDER VALUE: ' || orderValue_);
    
 exec listOrder(ono_);
 
 if(qoh_ < qty_)
 then dbms_output.put_line('Insufficient quantity on hand.');
 END;
 else
 
 update parts
 set qoh = qoh_ - qty_
 where pno = pno_;
 
 insert into orders values(ono_, pno_, qty_);
 end if;
 
 dbms_output.put_line('**** After the change ****');
 
 select pname, qoh
 into pname_, qoh
 from parts
 where pno = pno_;
 dbms_output.put_line('Part ' || pno_ || ' ' || pname_ || ': QOH = ' ||  qoh_);
 select cno, eno, received, shipped
 into cno_, eno_, rec_, ship_
 from orders
 where ono = ono_;
 select orderValue(ono_)
 into orderValue_
 from dual;
 
 dbms_output.put_line('ONO: ' || ono_ || ', CNO: ' || cno_ || ', ENO: ' || eno_
    || ', RECEIVED: ' || to_char(rec_, 'DD-MON-YY') || ', SHIPPED: ' || to_char(ship_, 'DD-MON-YY')
    || ', ORDER VALUE: ' || orderValue_);
    
 exec listOrder(ono_);
 
  if(commit_)
  then commit;
  dbms_output.put_line('COMMIT made');
  else rollback;
  dbms_output.put_line('ROLLBACK made');
  end if;
 
 EXCEPTION
 WHEN OTHERS THEN
  dbms_output.put_line('Error occurred: ' || SQLERRM);
  if(commit_)
  then commit;
  else rollback;
  end if;
 END;
/
show errors
