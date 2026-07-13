package com.example;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Employee name cannot be blank")
    @Size(min = 2, max = 50, message = "Employee name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Employee email cannot be blank")
    @Email(message = "Employee email must be valid")
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", nullable = false)
    @JsonBackReference
    private Department department;
}
