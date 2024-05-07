package com.cc.accountant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cc.accountant.model.UserDetails;

public interface UserDetailsRepo extends JpaRepository<UserDetails, Integer> {
}
