package com.askie01.springsecuritytutorial.repository;

import com.askie01.springsecuritytutorial.model.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, String> {

    @Query("""
            SELECT at
            FROM AccountTransaction at
            WHERE at.account.accountNumber = :accountNumber
            ORDER BY at.createdAt DESC
            """)
    List<AccountTransaction> findAccountTransactions(@Param("accountNumber") Long accountNumber);
}
