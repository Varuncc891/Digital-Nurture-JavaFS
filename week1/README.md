# Week 1: Java FSE Hands-On Exercises
This folder contains the complete implementations for the mandatory hands-on exercises of Week 1, covering Design Patterns and Principles, Data Structures and Algorithms, PL/SQL Programming, JUnit & Mockito (TDD), and SLF4J Logging.

All implementations are flat (no nested package subdirectories) and comment-free to maintain direct clarity and learning.

## 1. Design Patterns and Principles
### Exercise 1: Singleton Pattern (SingletonPatternExample)
*   **Logger.java**: Thread-safe Logger utility using private constructor, volatile static instance, and double-checked locking lazy initialization.
*   **SingletonTest.java**: Test client validating instance uniqueness.

### Exercise 2: Factory Method Pattern (FactoryMethodPatternExample)
*   **Document.java**: Product interface defining open(), save(), close().
*   **WordDocument.java, PdfDocument.java, ExcelDocument.java**: Concrete Product implementations.
*   **DocumentFactory.java**: Abstract Creator defining the factory method createDocument().
*   **WordDocumentFactory.java, PdfDocumentFactory.java, ExcelDocumentFactory.java**: Concrete Creator implementations.
*   **FactoryMethodTest.java**: Test client demonstrating document instantiation.

## 2. Data Structures and Algorithms
### Exercise 2: E-commerce Platform Search Function (EcommerceSearch)
*   **Product.java**: Product model class with basic attributes.
*   **SearchAlgorithms.java**: Linear search ($O(N)$) and binary search ($O(\log N)$) implementations.
*   **SearchTest.java**: Test client sorting products and benchmarking execution times.

### Exercise 7: Financial Forecasting (FinancialForecasting)
*   **FinancialForecasting.java**: Recursive algorithm predicting future values.
*   **ForecastingTest.java**: Test client executing the recursive growth predictor.

## 3. PL/SQL Programming (PL-SQL Programming)
### Exercise 1: Control Structures
*   **schema.sql**: Creates Customers, Accounts, Transactions, Loans, and Employees tables, and populates sample data.
*   **Exercise1_ControlStructures.sql**: PL/SQL blocks for three scenarios:
    1. 1% discount to loan interest rates for customers over 60 years old.
    2. Promotes customers with a balance > $10,000 to VIP status.
    3. Displays reminders for loans due within the next 30 days.

### Exercise 3: Stored Procedures
*   **Exercise3_StoredProcedures.sql**: Stored procedures for three scenarios:
    1. ProcessMonthlyInterest applying 1% interest to savings accounts.
    2. UpdateEmployeeBonus updating department salaries by a bonus percentage.
    3. TransferFunds transferring money checking balance requirements.

## 4. TDD using JUnit5 and Mockito (JUnit and Mockito)
*   **AssertionsTest.java**: Basic assertions (assertEquals, assertTrue, assertFalse, assertNull, assertNotNull) as in Exercise 3.
*   **AAATest.java**: AAA pattern demonstration using setup and teardown test fixtures (@BeforeEach, @AfterEach) as in Exercise 4.
*   **ExternalApi.java & MyService.java**: Helper classes mimicking service dependency.
*   **MyServiceTest.java**: Mockito mocking, stubbing, and interaction verification as in Exercises 1 & 2.

## 5. SLF4J Logging Framework (SLF4J Logging)
*   **LoggingExample.java**: Basic logging showing error and warning level logging using SLF4J loggers as in Exercise 1.

## How to Compile and Run
To run the Java projects without IDE overhead, a helper script download_jars.py is included to fetch the required standalone JARs (JUnit 5, Mockito, and SLF4J Simple) into a local lib/ directory.

### Step 0: Download Dependency Jars
Run the following from the root directory:
```bash
python week1/download_jars.py
```

### 1. Singleton Pattern Example
```bash
cd "week1/Design Patterns and Principles/SingletonPatternExample"
javac *.java
java SingletonTest
```

### 2. Factory Method Pattern Example
```bash
cd "week1/Design Patterns and Principles/FactoryMethodPatternExample"
javac *.java
java FactoryMethodTest
```

### 3. E-commerce Search Function
```bash
cd "week1/Data Structures and Algorithms/EcommerceSearch"
javac *.java
java SearchTest
```

### 4. Financial Forecasting Tool
```bash
cd "week1/Data Structures and Algorithms/FinancialForecasting"
javac *.java
java ForecastingTest
```

### 5. JUnit and Mockito Tests
```bash
cd "week1/JUnit and Mockito"
javac -cp "../lib/*" *.java
java -jar ../lib/junit-platform-console-standalone-1.10.2.jar -cp ".;../lib/*" --scan-class-path
```

### 6. SLF4J Logging Application
```bash
cd "week1/SLF4J Logging"
javac -cp "../lib/*" *.java
java -cp ".;../lib/*" LoggingExample
```
