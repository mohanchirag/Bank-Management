package com.chirag.bankingSystem.bankingSystem.services;
import com.chirag.bankingSystem.bankingSystem.Entity.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chirag.bankingSystem.bankingSystem.repo.BankAccountRepository;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    public BankAccount createAccount(BankAccount account) {
        return bankAccountRepository.save(account);
    }

    public BankAccount getAccount(Long id) {
        return bankAccountRepository.findById(id).orElse(null);
    }

    public void deleteAccount(Long id) {
        bankAccountRepository.deleteById(id);
    }
}
