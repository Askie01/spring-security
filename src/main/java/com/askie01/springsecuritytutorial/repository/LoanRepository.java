package com.askie01.springsecuritytutorial.repository;

import com.askie01.springsecuritytutorial.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, String> {

    @Query("""
            SELECT l
            FROM Loan l
            WHERE l.account.accountNumber = :accountNumber
            ORDER BY l.createdAt DESC
            """)
    List<Loan> findByAccountNumber(@Param("accountNumber") Long accountNumber);
}
