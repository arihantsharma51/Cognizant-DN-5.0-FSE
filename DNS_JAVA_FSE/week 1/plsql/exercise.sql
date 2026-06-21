set SERVEROUTPUT on;    

DECLARE------------------------------------------------------------1
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

SELECT * from LOANS,CUSTOMERS,TRANSACTIONS,ACCOUNTS,EMPLOYEES;

DECLARE-----------------------------------------------------------------------2
    CURSOR C
IS
    SELECT CUSTOMERID,BALANCE from CUSTOMERS;
BEGIN
    for r in c LOOP
        if r.balance>10000 THEN
        update CUSTOMERS
        set ISVIP='TRUE'
        where CUSTOMERID=r.CUSTOMERID;

        dbms_output.put_line('update'||r.CUSTOMERID);
        end if;
    end loop;
end;
/

desc CUSTOMERS;

ALTER TABLE Customers
ADD ISVIP VARCHAR2(10);
commit;

UPDATE Customers
SET Balance=15000
WHERE CustomerID=1;
COMMIT;

DECLARE
    CURSOR C
IS
    select C.CUSTOMERID,C.NAME,l.ENDDATE from CUSTOMERS C
    join LOANS l
    on C.CUSTOMERID = L.CUSTOMERID
    WHERE L.ENDDATE BETWEEN SYSDATE
    AND SYSDATE+30;
begin 
    for r in c LOOP
    DBMS_OUTPUT.PUT_LINE('REMINDER'||R.NAME||'LOAN DUE ON'||TO_CHAR (r.ENDDATE,'DD-MM-YYYY'));
    END LOOP;
END;
/
COMMIT;

