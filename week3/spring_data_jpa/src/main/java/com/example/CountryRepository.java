package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {
    List<Country> findByNameContaining(String name);
    List<Country> findByNameContainingOrderByNameAsc(String name);
    List<Country> findByNameStartingWithOrderByNameAsc(String name);
}
