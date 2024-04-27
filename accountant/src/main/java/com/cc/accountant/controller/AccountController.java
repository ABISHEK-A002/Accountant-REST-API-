package com.cc.accountant.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cc.accountant.model.Account;
import com.cc.accountant.service.AccountService;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/api/account")
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        Account createdAccount = accountService.create(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @GetMapping("/api/account/{accountIdOrName}")
    public ResponseEntity<?> getAccountByIdOrName(@PathVariable String accountIdOrName) {
        try {
            int accountId = Integer.parseInt(accountIdOrName);
            Account account = accountService.getById(accountId);
            if (account != null) {
                return new ResponseEntity<>(account, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
            }
        } catch (NumberFormatException e) {
            List<Account> accounts = accountService.getByAccountHolderName(accountIdOrName);
            if (!accounts.isEmpty()) {
                return new ResponseEntity<>(accounts, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
            }
        }
    }

    @PutMapping("/api/account/{accountId}")
    public ResponseEntity<Account> updateAccount(@PathVariable("accountId") int accountId, @RequestBody Account account) {
        if (accountService.updateDetails(accountId, account)) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/api/account/{accountId}")
    public ResponseEntity<Boolean> deleteAccount(@PathVariable("accountId") int accountId) {
        if (accountService.deleteAccount(accountId)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
