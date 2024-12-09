package com.example.banking_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;
//
//@Data
//
//public class AccountDto {
//    private Long id;
//    private String accountHolderName;
//    private double balance;
//
//    public AccountDto(Long id, String accountHolderName, double balance) {
//        this.id = id;
//        this.accountHolderName = accountHolderName;
//        this.balance = balance;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setAccountHolderName(String accountHolderName) {
//        this.accountHolderName = accountHolderName;
//    }
//
//    public void setBalance(double balance) {
//        this.balance = balance;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getAccountHolderName() {
//        return accountHolderName;
//    }
//
//    public double getBalance() {
//        return balance;
//    }
//
//}

public record AccountDto(Long id, String accountHolderName, double balance) {}