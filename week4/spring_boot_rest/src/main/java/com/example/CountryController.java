package com.example;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    private Map<String, String> countries = new HashMap<>();

    public CountryController() {
        countries.put("US", "United States");
        countries.put("IN", "India");
    }

    @GetMapping
    public Map<String, String> getAll() {
        return countries;
    }

    @GetMapping("/{code}")
    public String getByCode(@PathVariable String code) {
        return countries.getOrDefault(code.toUpperCase(), "Not Found");
    }

    @PostMapping("/login")
    public String login(@RequestParam String username) {
        return JwtUtil.generateToken(username);
    }
}