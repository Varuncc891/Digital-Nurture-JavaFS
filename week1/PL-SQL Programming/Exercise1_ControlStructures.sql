DECLARE
    CURRENT_YEAR NUMBER := EXTRACT(YEAR FROM SYSDATE);
BEGIN
    FOR REC IN (
        SELECT L.LoanID, L.InterestRate, C.DOB 
        FROM Loans L
        JOIN Customers C ON L.CustomerID = C.CustomerID
    ) LOOP
        IF (CURRENT_YEAR - EXTRACT(YEAR FROM REC.DOB)) > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = REC.LoanID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

DECLARE
BEGIN
    FOR REC IN (
        SELECT CustomerID, Balance FROM Customers
    ) LOOP
        IF REC.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = REC.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

DECLARE
BEGIN
    FOR REC IN (
        SELECT C.Name, L.LoanID, L.EndDate 
        FROM Loans L
        JOIN Customers C ON L.CustomerID = C.CustomerID
        WHERE L.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || REC.Name || ' has loan ' || REC.LoanID || ' due on ' || TO_CHAR(REC.EndDate, 'YYYY-MM-DD'));
    END LOOP;
END;
/
