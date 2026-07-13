package com.example;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @PostMapping
    public Country createCountry(@Valid @RequestBody Country country) {
        return countryRepository.save(country);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Country> getCountryByCode(@PathVariable String code) {
        return countryRepository.findById(code)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with code: " + code));
    }

    @PutMapping("/{code}")
    public ResponseEntity<Country> updateCountry(@PathVariable String code, @Valid @RequestBody Country countryDetails) {
        Country country = countryRepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with code: " + code));
        country.setName(countryDetails.getName());
        return ResponseEntity.ok(countryRepository.save(country));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteCountry(@PathVariable String code) {
        Country country = countryRepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with code: " + code));
        countryRepository.delete(country);
        return ResponseEntity.ok().build();
    }
}
