package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.projection.EmployeeProjection;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        return employeeRepository.findById(id).map(emp -> {
            emp.setName(employeeDetails.getName());
            emp.setEmail(employeeDetails.getEmail());
            emp.setDepartment(employeeDetails.getDepartment());
            return ResponseEntity.ok(employeeRepository.save(emp));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        return employeeRepository.findById(id).map(emp -> {
            employeeRepository.delete(emp);
            return ResponseEntity.ok().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Employee> searchEmployees(@RequestParam String name) {
        return employeeRepository.findByNameContaining(name);
    }

    @GetMapping("/department")
    public List<Employee> getByDepartment(@RequestParam String deptName) {
        return employeeRepository.findByDepartmentName(deptName);
    }

    @GetMapping("/email")
    public Employee getByEmailNamed(@RequestParam String email) {
        return employeeRepository.findByEmailNamed(email);
    }

    @GetMapping("/paginated")
    public Page<Employee> getPaginatedEmployees(
            @RequestParam String name,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy) {
        return employeeRepository.findByNameContaining(name, PageRequest.of(page, size, Sort.by(sortBy)));
    }

    @GetMapping("/projections")
    public List<EmployeeProjection> getProjections() {
        return employeeRepository.findAllProjections();
    }
}
