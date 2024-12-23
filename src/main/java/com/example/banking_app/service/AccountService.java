package com.example.banking_app.service;

import com.example.banking_app.dto.AccountDto;
import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id, String password);
    AccountDto deposit(Long id, double amount, String password);
    AccountDto withdraw(Long id, double amount, String password);
    boolean deleteAccount(Long id, String password);
    List<AccountDto> getAllAccount();  // Correct return type is List<AccountDto>
}
