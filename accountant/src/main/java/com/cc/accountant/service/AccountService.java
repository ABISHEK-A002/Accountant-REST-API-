package com.cc.accountant.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.accountant.model.Account;
import com.cc.accountant.repository.AccountRepo;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepo accountRepo;

    public Account create(Account account) {
        return accountRepo.save(account);
    }

    public Account getById(int accountId) {
        return accountRepo.findById(accountId).orElse(null);
    }

    public List<Account> getByAccountHolderName(String accountHolderName) {
        return accountRepo.findByAccountHolderName(accountHolderName);
    }

    public boolean updateDetails(int accountId, Account account) {
        if (!accountRepo.existsById(accountId)) {
            return false;
        }
        try {
            accountRepo.save(account);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean deleteAccount(int accountId) {
        if (getById(accountId) == null) {
            return false;
        }
        accountRepo.deleteById(accountId);
        return true;
    }
}
