CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01, LastUpdate = SYSDATE
    WHERE AccountType = 'Savings';
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary * (1 + p_bonus_percentage / 100)
    WHERE Department = p_department;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account;
    
    IF v_balance >= p_amount THEN
        UPDATE Accounts SET Balance = Balance - p_amount, LastUpdate = SYSDATE WHERE AccountID = p_from_account;
        UPDATE Accounts SET Balance = Balance + p_amount, LastUpdate = SYSDATE WHERE AccountID = p_to_account;
        COMMIT;
    ELSE
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance for transfer.');
    END IF;
END;
/
