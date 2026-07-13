package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public List<Country> searchCountriesContaining(String name) {
        return countryRepository.findByNameContainingOrderByNameAsc(name);
    }

    @Transactional
    public List<Country> searchCountriesStartingWith(String prefix) {
        return countryRepository.findByNameStartingWith(prefix);
    }
}
