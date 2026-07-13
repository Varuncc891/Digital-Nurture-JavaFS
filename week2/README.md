# Week 2: Spring Core and Spring Data JPA Hands-On Exercises

This folder contains the complete implementations for the mandatory hands-on exercises of Week 2 and Week 3, covering Spring Core, Dependency Injection, Spring AOP logging, Spring Data JPA entities, JPA auditing, Named/JPQL queries, and projections.

## 1. Spring Core and Maven (LibraryManagement)
*   **Book.java**: Book model containing id, title, and author.
*   **BookRepository.java**: Repository mock class managing local book storage.
*   **BookService.java**: Service class demonstrating setter and constructor Dependency Injection (DI) configurations.
*   **LoggingAspect.java**: AOP logging aspect that tracks method execution times.
*   **applicationContext.xml**: Spring configuration XML containing bean mappings, component scanning, and AspectJ autoproxying.
*   **LibraryManagementApplication.java**: Main testing class verifying DI and AOP execution.

## 2. Spring Data JPA
### A. EmployeeManagementSystem
*   **Employee & Department Entities**: Models with `@OneToMany` and `@ManyToOne` bi-directional mapping, H2 dialect, and JPA Auditing configuration.
*   **EmployeeRepository & DepartmentRepository**: CRUD repository interfaces showing derived, custom JPQL, and Named query methods.
*   **EmployeeController & DepartmentController**: REST endpoints implementing basic CRUD, pagination, sorting, and projections.
*   **EmployeeManagementSystemApplication.java**: Standard Spring Boot entry point.

### B. orm-learn
*   **OrmLearnApplication.java**: Application seeding data and testing Query Methods (`findByNameContainingOrderByNameAsc`), sorting, custom JPQL/HQL, and criteria selections on country, employees, and departments.
*   **Difference.md**: Technical documentation detailing the differences between JPA, Hibernate, and Spring Data JPA.

---

## How to Compile and Run
To run the Maven projects without global Maven installation, a helper script `download_maven.py` is included to fetch Apache Maven locally.

### Step 0: Set Up Local Maven
Run from `week2/`:
```bash
python download_maven.py
```

### 1. Library Management Application
```bash
cd "Spring Core and Maven/LibraryManagement"
../../maven/apache-maven-3.8.8/bin/mvn clean compile exec:java -Dexec.mainClass="com.library.LibraryManagementApplication"
```

### 2. Employee Management System
```bash
cd "Spring Data JPA/EmployeeManagementSystem"
../../maven/apache-maven-3.8.8/bin/mvn clean spring-boot:run
```

### 3. ORM Learn Application
```bash
cd "Spring Data JPA/orm-learn"
../../maven/apache-maven-3.8.8/bin/mvn clean spring-boot:run
```
