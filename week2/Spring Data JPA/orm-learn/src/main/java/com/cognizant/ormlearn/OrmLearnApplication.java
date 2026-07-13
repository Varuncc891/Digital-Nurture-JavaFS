package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.repository.DepartmentRepository;
import com.cognizant.ormlearn.repository.SkillRepository;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    private static CountryService countryService;
    private static EmployeeService employeeService;
    private static CountryRepository countryRepository;
    private static EmployeeRepository employeeRepository;
    private static DepartmentRepository departmentRepository;
    private static SkillRepository skillRepository;

    public OrmLearnApplication(CountryService countryService, EmployeeService employeeService,
                               CountryRepository countryRepository, EmployeeRepository employeeRepository,
                               DepartmentRepository departmentRepository, SkillRepository skillRepository) {
        OrmLearnApplication.countryService = countryService;
        OrmLearnApplication.employeeService = employeeService;
        OrmLearnApplication.countryRepository = countryRepository;
        OrmLearnApplication.employeeRepository = employeeRepository;
        OrmLearnApplication.departmentRepository = departmentRepository;
        OrmLearnApplication.skillRepository = skillRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
        testGetAllCountries();
        testSearchCountriesContaining();
        testSearchCountriesStartingWith();
        testGetAllPermanentEmployees();
    }

    private void seedData() {
        countryRepository.save(new Country("IN", "India"));
        countryRepository.save(new Country("US", "United States"));
        countryRepository.save(new Country("ZA", "South Africa"));
        countryRepository.save(new Country("DJ", "Djibouti"));
        countryRepository.save(new Country("LU", "Luxembourg"));
        countryRepository.save(new Country("SS", "South Sudan"));

        Department dept = new Department();
        dept.setName("IT");
        departmentRepository.save(dept);

        Skill skill1 = new Skill();
        skill1.setName("Java");
        skillRepository.save(skill1);

        Skill skill2 = new Skill();
        skill2.setName("Spring");
        skillRepository.save(skill2);

        Employee emp1 = new Employee();
        emp1.setName("John");
        emp1.setSalary(50000);
        emp1.setPermanent(true);
        emp1.setDateOfBirth(new Date());
        emp1.setDepartment(dept);
        emp1.setSkills(new HashSet<>(Arrays.asList(skill1, skill2)));
        employeeRepository.save(emp1);

        Employee emp2 = new Employee();
        emp2.setName("Mary");
        emp2.setSalary(40000);
        emp2.setPermanent(false);
        emp2.setDateOfBirth(new Date());
        emp2.setDepartment(dept);
        emp2.setSkills(new HashSet<>(Collections.singletonList(skill1)));
        employeeRepository.save(emp2);
    }

    private static void testGetAllCountries() {
        System.out.println("\n--- Testing Get All Countries ---");
        List<Country> countries = countryService.getAllCountries();
        countries.forEach(System.out::println);
    }

    private static void testSearchCountriesContaining() {
        System.out.println("\n--- Testing Search Countries Containing 'ou' (Ascending) ---");
        List<Country> countries = countryService.searchCountriesContaining("ou");
        countries.forEach(System.out::println);
    }

    private static void testSearchCountriesStartingWith() {
        System.out.println("\n--- Testing Search Countries Starting With 'U' ---");
        List<Country> countries = countryService.searchCountriesStartingWith("U");
        countries.forEach(System.out::println);
    }

    private static void testGetAllPermanentEmployees() {
        System.out.println("\n--- Testing Get All Permanent Employees (HQL) ---");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        employees.forEach(emp -> {
            System.out.println(emp.getName() + " | Dept: " + emp.getDepartment().getName() + " | Skills: " + emp.getSkills());
        });
    }
}
