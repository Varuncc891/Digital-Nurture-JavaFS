CREATE TABLE Customers (
    customer_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    age NUMBER,
    balance NUMBER,
    is_vip CHAR(1) DEFAULT 'N'
);

INSERT INTO Customers VALUES (1, 'Alice', 66, 12000, 'N');
INSERT INTO Customers VALUES (2, 'Bob', 50, 8000, 'N');

DECLARE
    CURSOR c_cust IS SELECT customer_id, age, balance FROM Customers;
BEGIN
    FOR r_cust IN c_cust LOOP
        IF r_cust.age > 60 THEN
            UPDATE Customers SET balance = balance + 100 WHERE customer_id = r_cust.customer_id;
        END IF;
        
        IF r_cust.balance > 10000 THEN
            UPDATE Customers SET is_vip = 'Y' WHERE customer_id = r_cust.customer_id;
        END IF;
    END LOOP;
    COMMIT;
END;
/
