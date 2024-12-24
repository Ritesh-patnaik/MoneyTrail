package com.example.banking_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.banking_app.dto.AccountDto;
import com.example.banking_app.entity.Account;
import com.example.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.example.banking_app.exception.InvalidPasswordException;



import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

   @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.saveAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id, @RequestParam String password) {
        AccountDto accountDto = accountService.getAccountById(id, password);
        if (accountDto != null) {
            return ResponseEntity.ok(accountDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
                                              @RequestParam double amount,
                                              @RequestParam String password) {
        if (password == null || password.isEmpty()) {
            throw new InvalidPasswordException("Password is required");
        }
        AccountDto accountDto = accountService.deposit(id, amount, password);
        return ResponseEntity.ok(accountDto);  // This will return the updated balance
    }


    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestParam double amount, @RequestParam String password) {
        AccountDto accountDto = accountService.withdraw(id, amount, password);
        return ResponseEntity.ok(accountDto);  // Return updated AccountDto with balance
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id, @RequestParam String password) {
        boolean isDeleted = accountService.deleteAccount(id, password);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }
}
