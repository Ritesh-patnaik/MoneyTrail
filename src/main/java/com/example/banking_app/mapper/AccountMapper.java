package com.example.banking_app.mapper;

import com.example.banking_app.dto.AccountDto;
import com.example.banking_app.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto) {
        Account account = new Account(
                accountDto.getId(),               // Corrected to use getter methods
                accountDto.getAccountHolderName(), // Corrected to use getter methods
                accountDto.getBalance(),          // Corrected to use getter methods
                accountDto.getPassword()          // Corrected to use getter methods
        );
        return account;
    }

    public static AccountDto mapToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance(),
                account.getPassword() // Added password field to AccountDto
        );
        return accountDto;
    }
}
