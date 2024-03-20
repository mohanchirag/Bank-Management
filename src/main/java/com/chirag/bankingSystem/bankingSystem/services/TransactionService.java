package com.chirag.bankingSystem.bankingSystem.services;

import com.chirag.bankingSystem.bankingSystem.Entity.BankAccount;
import com.chirag.bankingSystem.bankingSystem.repo.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class TransactionService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Transactional
    public BankAccount withdraw(Long accountNumber, Float amount) throws Exception {
        BankAccount account = bankAccountRepository.findByAccountNumber(accountNumber);
        if (account != null && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            return bankAccountRepository.save(account);
        } else {
            throw new Exception("Insufficient balance or invalid account number");
        }
    }

    @Transactional
    public BankAccount deposit(Long accountNumber, Float amount) throws Exception {
        BankAccount account = bankAccountRepository.findByAccountNumber(accountNumber);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            return bankAccountRepository.save(account);
        } else {
            throw new Exception("Invalid account number");
        }
    }

    @Transactional
    public BankAccount updateName(Long accountNumber, String newName) throws Exception {
        BankAccount account = bankAccountRepository.findByAccountNumber(accountNumber);
        if (account != null) {
            account.setHolderName(newName);
            return bankAccountRepository.save(account);
        } else {
            throw new Exception("Invalid account number");
        }
    }
}
