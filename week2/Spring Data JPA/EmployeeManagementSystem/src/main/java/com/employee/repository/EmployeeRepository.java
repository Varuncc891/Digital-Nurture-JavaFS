package com.employee.repository;

import com.employee.entity.Employee;
import com.employee.projection.EmployeeProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByNameContaining(String name);

    @Query("SELECT e FROM Employee e WHERE e.department.name = :deptName")
    List<Employee> findByDepartmentName(@Param("deptName") String deptName);

    Employee findByEmailNamed(@Param("email") String email);

    Page<Employee> findByNameContaining(String name, Pageable pageable);

    @Query("SELECT e.name as name, e.email as email FROM Employee e")
    List<EmployeeProjection> findAllProjections();
}
