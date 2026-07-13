package com.example;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "countries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    @NotBlank(message = "Country code cannot be blank")
    @Size(min = 2, max = 2, message = "Country code must be exactly 2 characters")
    private String code;

    @NotBlank(message = "Country name cannot be blank")
    private String name;
}
