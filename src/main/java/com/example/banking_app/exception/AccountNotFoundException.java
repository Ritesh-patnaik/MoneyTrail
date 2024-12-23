package com.example.banking_app.exception;

public class AccountNotFoundException extends RuntimeException {

    // Constructor that accepts a custom message
    public AccountNotFoundException(String message) {
        super(message);
    }
}
