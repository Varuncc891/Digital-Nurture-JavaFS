CREATE TABLE Accounts (
    account_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    balance NUMBER
);

INSERT INTO Accounts VALUES (101, 1, 5000);
INSERT INTO Accounts VALUES (102, 2, 200);

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_acc IN NUMBER,
    p_to_acc   IN NUMBER,
    p_amount   IN NUMBER
) IS
    v_bal NUMBER;
    insufficient_funds EXCEPTION;
BEGIN
    SELECT balance INTO v_bal FROM Accounts WHERE account_id = p_from_acc;
    IF v_bal < p_amount THEN
        RAISE insufficient_funds;
    END IF;

    UPDATE Accounts SET balance = balance - p_amount WHERE account_id = p_from_acc;
    UPDATE Accounts SET balance = balance + p_amount WHERE account_id = p_to_acc;
    COMMIT;
EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Insufficient funds error');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('General transfer error');
END;
/
