CREATE TABLE Processed_Interests (
    account_id NUMBER,
    interest_amount NUMBER,
    processed_date DATE
);

CREATE OR REPLACE PROCEDURE ProcessInterest IS
    CURSOR c_acc IS SELECT account_id, balance FROM Accounts;
BEGIN
    FOR r_acc IN c_acc LOOP
        INSERT INTO Processed_Interests VALUES (r_acc.account_id, r_acc.balance * 0.05, SYSDATE);
    END LOOP;
    COMMIT;
END;
/
