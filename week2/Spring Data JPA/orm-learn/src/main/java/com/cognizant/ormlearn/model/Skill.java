package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "skill")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "skills")
    @ToString.Exclude
    private List<Employee> employees;
}
