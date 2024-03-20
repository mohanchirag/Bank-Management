package com.chirag.bankingSystem.bankingSystem.repo;
import com.chirag.bankingSystem.bankingSystem.Entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
