DECLARE
    CURSOR c_users IS SELECT customer_id, name FROM Customers;
    r_user c_users%ROWTYPE;
BEGIN
    OPEN c_users;
    LOOP
        FETCH c_users INTO r_user;
        EXIT WHEN c_users%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Customer: ' || r_user.name);
    END LOOP;
    CLOSE c_users;
END;
/
