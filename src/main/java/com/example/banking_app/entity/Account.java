package com.example.banking_app.entity;

import jakarta.persistence.*;
import lombok.*;

//@NoArgsConstructor
@Data
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_holder_name")
    private String accountHolderName;

    private double balance;

    @Column(name = "password")
    private String password;

    public Account() {}

    public Account(Long id, String accountHolderName, double balance, String password) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.password = password;
    }

    // Getters and setters for all fields
}
