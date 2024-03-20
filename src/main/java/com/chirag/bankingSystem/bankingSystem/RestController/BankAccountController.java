package com.chirag.bankingSystem.bankingSystem.RestController;
import com.chirag.bankingSystem.bankingSystem.Entity.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.chirag.bankingSystem.bankingSystem.services.BankAccountService;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping("/")
    public String RestApi(){
        return "Hello World";
    }

    @PostMapping("/addAccount")
    public ResponseEntity<BankAccount> createAccount(@RequestBody BankAccount account) {
        BankAccount createdAccount = bankAccountService.createAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getAccount(@PathVariable Long id) {
        BankAccount account = bankAccountService.getAccount(id);
        if (account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        bankAccountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
