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

DECLARE-----------------------------------------------------------------------3
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

CREATE OR REPLACE PROCEDURE SafeTransferFunds(------------------------------------------------------4
    p_from_acc NUMBER,
    p_to_acc NUMBER,
    p_amount NUMBER
)
IS
    v_balance NUMBER;
    insufficient_funds EXCEPTION;
BEGIN
    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_acc;

    IF v_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_acc;

    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_acc;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Transfer Successful');

EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer Failed: Insufficient Balance');

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Unexpected Error: ' || SQLERRM);
END;
/

CREATE OR REPLACE PROCEDURE UpdateSalary(-------------------------------------------------5
    p_empid NUMBER,
    p_percent NUMBER
)
IS
    v_count NUMBER;
BEGIN

    SELECT COUNT(*)
    INTO v_count
    FROM Employees
    WHERE EmployeeID = p_empid;

    IF v_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('Employee Not Found');
    ELSE
        UPDATE Employees
        SET Salary = Salary + (Salary * p_percent / 100)
        WHERE EmployeeID = p_empid;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Salary Updated Successfully');
    END IF;

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

SELECT * FROM Customers;

SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE AddNewCustomer----------------------------------------------------6
(
    p_CustomerID IN NUMBER,
    p_Name       IN VARCHAR2,
    p_DOB        IN DATE,
    p_Balance    IN NUMBER
)
IS

BEGIN

    INSERT INTO Customers
    (
        CustomerID,
        Name,
        DOB,
        Balance
    )
    VALUES
    (
        p_CustomerID,
        p_Name,
        p_DOB,
        p_Balance
    );

    DBMS_OUTPUT.PUT_LINE(
    'Customer Added Successfully.');

EXCEPTION

    WHEN DUP_VAL_ON_INDEX THEN

        DBMS_OUTPUT.PUT_LINE(
        'Error: Customer ID already exists.');

    WHEN OTHERS THEN

        DBMS_OUTPUT.PUT_LINE(
        'Unexpected Error: '
        || SQLERRM);

END;
/