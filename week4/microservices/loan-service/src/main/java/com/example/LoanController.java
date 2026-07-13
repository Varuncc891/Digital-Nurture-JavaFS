package com.example;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final List<Loan> loans = Arrays.asList(
            new Loan(1L, "L101", "Home Loan", 250000.0, 15),
            new Loan(2L, "L102", "Car Loan", 30000.0, 5)
    );

    @GetMapping
    public List<Loan> getLoans() {
        return loans;
    }

    @GetMapping("/{id}")
    public Loan getLoanById(@PathVariable Long id) {
        return loans.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Loan not found"));
    }
}

class Loan {
    private Long id;
    private String loanNumber;
    private String type;
    private double amount;
    private int durationYears;

    public Loan() {}

    public Loan(Long id, String loanNumber, String type, double amount, int durationYears) {
        this.id = id;
        this.loanNumber = loanNumber;
        this.type = type;
        this.amount = amount;
        this.durationYears = durationYears;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getLoanNumber() { return loanNumber; }
    public void setLoanNumber(String loanNumber) { this.loanNumber = loanNumber; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public int getDurationYears() { return durationYears; }
    public void setDurationYears(int durationYears) { this.durationYears = durationYears; }
}