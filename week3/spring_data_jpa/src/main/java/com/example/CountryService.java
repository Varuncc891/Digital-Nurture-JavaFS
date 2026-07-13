package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found");
        }
        return result.get();
    }

    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void updateCountry(String code, String name) {
        Optional<Country> result = countryRepository.findById(code);
        if (result.isPresent()) {
            Country country = result.get();
            country.setName(name);
            countryRepository.save(country);
        }
    }

    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    @Transactional(readOnly = true)
    public List<Country> searchCountriesByNameContaining(String name) {
        return countryRepository.findByNameContainingOrderByNameAsc(name);
    }

    @Transactional(readOnly = true)
    public List<Country> searchCountriesByNameStartingWith(String alphabet) {
        return countryRepository.findByNameStartingWithOrderByNameAsc(alphabet);
    }
}
