package com.example;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final List<Account> accounts = Arrays.asList(
            new Account(1L, "123456", "John Doe", "Savings", 5000.0),
            new Account(2L, "654321", "Jane Smith", "Checking", 8000.0)
    );

    @GetMapping
    public List<Account> getAccounts() {
        return accounts;
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accounts.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }
}

class Account {
    private Long id;
    private String accountNumber;
    private String ownerName;
    private String type;
    private double balance;

    public Account() {}

    public Account(Long id, String accountNumber, String ownerName, String type, double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.type = type;
        this.balance = balance;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}