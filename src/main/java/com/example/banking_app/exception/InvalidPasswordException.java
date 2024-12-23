package com.example.banking_app.exception;

public class InvalidPasswordException extends RuntimeException {

    // Constructor that accepts a custom message
    public InvalidPasswordException(String message) {
        super(message);
    }
}
