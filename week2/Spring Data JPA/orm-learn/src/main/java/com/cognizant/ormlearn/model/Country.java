package com.cognizant.ormlearn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    private String code;
    private String name;
}
