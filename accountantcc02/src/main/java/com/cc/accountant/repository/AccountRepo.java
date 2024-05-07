package com.cc.accountant.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cc.accountant.model.Account;

import java.util.List;

public interface AccountRepo extends JpaRepository<Account, Integer> {

    List<Account> findByAccountHolderName(String accountHolderName);

    @Query("SELECT a FROM Account a ORDER BY a.accountId")
    Page<Account> findAllOrderByAccountId(Pageable pageable);
}
