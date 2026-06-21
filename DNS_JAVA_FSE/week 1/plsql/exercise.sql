set SERVEROUTPUT on;    
DECLARE
    CURSOR c
IS
    select CUSTOMERID,DOB from CUSTOMERS;
    var number;
BEGIN
    for r in c LOOP
        var:= Floor(MONTHS_BETWEEN(sysdate,r.DOB)/12);
        if var>60 THEN
            update LOANS
            set INTERESTRATE=INTERESTRATE-1
            where CUSTOMERID =r.CUSTOMERID;

            DBMS_OUTPUT.PUT_LINE('discount applied'||r.CUSTOMERID);
        end if;
    end loop;
end;
/
SELECT * from LOANS;