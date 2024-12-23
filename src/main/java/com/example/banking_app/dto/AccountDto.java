package com.example.banking_app.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AccountDto {
    private Long id;

    @NotNull(message = "Account Holder Name cannot be null")
    private String accountHolderName;

    @NotNull(message = "Balance cannot be null")
    private Double balance; // Change to Double instead of double

    private String password;

    // Default constructor for deserialization
    public AccountDto() {}

    // Constructor to initialize the object
    public AccountDto(Long id, String accountHolderName, Double balance, String password) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.password = password;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
