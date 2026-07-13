package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeeApplication implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n===== SEEDING COUNTRIES =====");
        countryService.addCountry(new Country("IN", "India"));
        countryService.addCountry(new Country("US", "United States"));
        countryService.addCountry(new Country("JP", "Japan"));
        countryService.addCountry(new Country("DE", "Germany"));
        countryService.addCountry(new Country("ZA", "South Africa"));
        countryService.addCountry(new Country("ZM", "Zambia"));
        countryService.addCountry(new Country("ZW", "Zimbabwe"));
        countryService.addCountry(new Country("SS", "South Sudan"));
        countryService.addCountry(new Country("GP", "Guadeloupe"));
        
        System.out.println("Countries seeded successfully.");

        System.out.println("\n===== TEST 1: FIND ALL COUNTRIES =====");
        List<Country> allCountries = countryService.getAllCountries();
        allCountries.forEach(System.out::println);

        System.out.println("\n===== TEST 2: FIND COUNTRY BY CODE (IN) =====");
        try {
            Country in = countryService.findCountryByCode("IN");
            System.out.println("Found: " + in);
        } catch (CountryNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n===== TEST 3: SEARCH COUNTRIES CONTAINING 'ou' (SORTED) =====");
        List<Country> containingOu = countryService.searchCountriesByNameContaining("ou");
        containingOu.forEach(System.out::println);

        System.out.println("\n===== TEST 4: SEARCH COUNTRIES STARTING WITH 'Z' =====");
        List<Country> startingWithZ = countryService.searchCountriesByNameStartingWith("Z");
        startingWithZ.forEach(System.out::println);

        System.out.println("\n===== TEST 5: ADD NEW COUNTRY (NZ) =====");
        Country nz = new Country("NZ", "New Zealand");
        countryService.addCountry(nz);
        try {
            System.out.println("Added: " + countryService.findCountryByCode("NZ"));
        } catch (CountryNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n===== TEST 6: UPDATE COUNTRY (NZ) =====");
        countryService.updateCountry("NZ", "New Zealand Updated");
        try {
            System.out.println("Updated: " + countryService.findCountryByCode("NZ"));
        } catch (CountryNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n===== TEST 7: DELETE COUNTRY (NZ) =====");
        countryService.deleteCountry("NZ");
        try {
            countryService.findCountryByCode("NZ");
        } catch (CountryNotFoundException e) {
            System.out.println("Success: " + e.getMessage() + " (NZ was deleted)");
        }
        
        System.out.println("\n===== ALL SPRING DATA JPA TESTS COMPLETED =====\n");
    }
}