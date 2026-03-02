package com.askie01.springsecuritytutorial.repository;

import com.askie01.springsecuritytutorial.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {

    @Query("""
            SELECT c
            FROM Card c
            WHERE c.account.accountNumber = :accountNumber
            ORDER BY c.availableAmount DESC
            """)
    List<Card> findByAccountNumber(@Param("accountNumber") Long accountNumber);
}
