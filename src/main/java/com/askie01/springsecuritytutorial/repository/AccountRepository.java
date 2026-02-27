package com.askie01.springsecuritytutorial.repository;

import com.askie01.springsecuritytutorial.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findByCustomerId(String customerId);

    Optional<Account> findByAccountNumber(Long accountNumber);
}
