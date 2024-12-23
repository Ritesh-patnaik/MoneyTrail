package com.example.banking_app.service.impl;
import java.util.List;  // Import the List class from java.util package
import java.util.stream.Collectors;
import com.example.banking_app.dto.AccountDto;
import com.example.banking_app.entity.Account;
import com.example.banking_app.repository.AccountRepository;
import com.example.banking_app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.banking_app.exception.AccountNotFoundException;
import com.example.banking_app.exception.InvalidPasswordException;
import com.example.banking_app.exception.InsufficientFundsException;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        // Create a new Account entity (assuming you're using an ORM like JPA or Hibernate)
        Account account = new Account();
        account.setAccountHolderName(accountDto.getAccountHolderName());
        account.setBalance(accountDto.getBalance());
        account.setPassword(accountDto.getPassword());

        // Save the account to the database (assuming accountRepository is autowired)
        Account savedAccount = accountRepository.save(account);

        // Convert the saved entity to a DTO and return it
        return new AccountDto(savedAccount.getId(), savedAccount.getAccountHolderName(), savedAccount.getBalance(), savedAccount.getPassword());
    }


    @Override
    public AccountDto getAccountById(Long id, String password) {
        Account account = accountRepository.findById(id).orElse(null);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }
        if (!account.getPassword().equals(password)) {
            throw new InvalidPasswordException("Incorrect password");
        }
        return new AccountDto(account.getId(), account.getAccountHolderName(), account.getBalance(), account.getPassword());
    }



    @Override
    public AccountDto deposit(Long id, double amount, String password) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id " + id));

        // Validate password
        if (!account.getPassword().equals(password)) {
            throw new InvalidPasswordException("Invalid password.");
        }

        // Deposit logic
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);

        // Return updated AccountDto
        return new AccountDto(account.getId(), account.getAccountHolderName(), account.getBalance(), account.getPassword());
    }


    @Override
    public AccountDto withdraw(Long id, double amount, String password) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id " + id));

        if (!account.getPassword().equals(password)) {
            throw new InvalidPasswordException("Invalid password.");
        }

        // Check if balance is sufficient
        if (account.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient balance.");
        }

        // Perform the withdrawal
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);

        // Return updated AccountDto
        return new AccountDto(account.getId(), account.getAccountHolderName(), account.getBalance(), account.getPassword());
    }


    @Override
    public boolean deleteAccount(Long id, String password) {
        Account account = accountRepository.findById(id).orElse(null);
        if (account == null || !account.getPassword().equals(password)) {
            return false;
        }
        accountRepository.delete(account);
        return true;
    }

    @Override
    public List<AccountDto> getAllAccount() {
        // Your logic to get all accounts
        return null;
    }
}
