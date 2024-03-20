package com.chirag.bankingSystem.bankingSystem.RestController;
import com.chirag.bankingSystem.bankingSystem.Entity.BankAccount;
import com.chirag.bankingSystem.bankingSystem.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/withdraw")
    public ResponseEntity<BankAccount> withdraw(@RequestBody BankAccount withdrawRequest) {
        try {
            BankAccount withdrawn = transactionService.withdraw(withdrawRequest.getAccountNumber(), withdrawRequest.getAmount());
            return new ResponseEntity<>(withdrawn, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/deposit")
    public ResponseEntity<BankAccount> deposit(@RequestBody BankAccount depositRequest) {
        try {
            BankAccount account = transactionService.deposit(depositRequest.getAccountNumber(), depositRequest.getAmount());
            return new ResponseEntity<>(account, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/updateName")
    public ResponseEntity<Void> updateName(@RequestBody BankAccount updateNameRequest) {
        try {
            transactionService.updateName(updateNameRequest.getAccountNumber(), updateNameRequest.getNewName());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
