CREATE OR REPLACE PACKAGE CustOperations AS
    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_age NUMBER, p_bal NUMBER);
    FUNCTION GetBalance(p_id NUMBER) RETURN NUMBER;
END CustOperations;
/

CREATE OR REPLACE PACKAGE BODY CustOperations AS
    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_age NUMBER, p_bal NUMBER) IS
    BEGIN
        INSERT INTO Customers VALUES (p_id, p_name, p_age, p_bal, 'N');
        COMMIT;
    END AddCustomer;

    FUNCTION GetBalance(p_id NUMBER) RETURN NUMBER IS
        v_bal NUMBER;
    BEGIN
        SELECT balance INTO v_bal FROM Customers WHERE customer_id = p_id;
        RETURN v_bal;
    END GetBalance;
END CustOperations;
/
