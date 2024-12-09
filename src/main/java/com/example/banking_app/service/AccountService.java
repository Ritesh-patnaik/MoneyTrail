package com.example.banking_app.service;

import com.example.banking_app.dto.AccountDto;
import com.example.banking_app.entity.Account;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
    AccountDto deposit(Long id, double amount);
    AccountDto withdraw(Long id, double amount);
    void deleteAccount(Long id);
    List<AccountDto> getAllAccount();
}
