package com.cc.accountant.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cc.accountant.model.Account;

import java.util.List;

public interface AccountRepo extends JpaRepository<Account, Integer> {

    List<Account> findByAccountHolderName(String accountHolderName);

}
