CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    IsVIP CHAR(1) DEFAULT 'N'
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(50),
    Balance NUMBER,
    LastUpdate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(50),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    DurationYears NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(100),
    Salary NUMBER,
    Department VARCHAR2(100),
    HireDate DATE
);

INSERT INTO Customers VALUES (1, 'John Doe', TO_DATE('1955-05-15', 'YYYY-MM-DD'), 12000, 'N');
INSERT INTO Customers VALUES (2, 'Jane Smith', TO_DATE('1975-08-20', 'YYYY-MM-DD'), 8000, 'N');
INSERT INTO Customers VALUES (3, 'Bob Johnson', TO_DATE('1940-12-10', 'YYYY-MM-DD'), 15000, 'N');

INSERT INTO Accounts VALUES (101, 1, 'Savings', 10000, SYSDATE);
INSERT INTO Accounts VALUES (102, 2, 'Checking', 5000, SYSDATE);
INSERT INTO Accounts VALUES (103, 3, 'Savings', 15000, SYSDATE);

INSERT INTO Loans VALUES (201, 1, 50000, 8.5, 5, TO_DATE('2022-01-01', 'YYYY-MM-DD'), TO_DATE('2026-08-01', 'YYYY-MM-DD'));
INSERT INTO Loans VALUES (202, 2, 20000, 7.0, 3, TO_DATE('2024-06-01', 'YYYY-MM-DD'), TO_DATE('2027-06-01', 'YYYY-MM-DD'));
INSERT INTO Loans VALUES (203, 3, 30000, 9.0, 4, TO_DATE('2023-03-01', 'YYYY-MM-DD'), TO_DATE('2026-07-25', 'YYYY-MM-DD'));

INSERT INTO Employees VALUES (301, 'Alice Green', 'Manager', 80000, 'HR', TO_DATE('2018-02-15', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (302, 'Charlie Brown', 'Developer', 60000, 'IT', TO_DATE('2020-07-01', 'YYYY-MM-DD'));
