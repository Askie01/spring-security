package com.askie01.springsecuritytutorial.repository;

import com.askie01.springsecuritytutorial.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {

    @Query("""
            SELECT c
            FROM Contact c
            ORDER BY c.createdAt DESC
            """)
    List<Contact> findAllSortedByNewest();

    @Query("""
            SELECT c
            FROM Contact c
            WHERE c.subject = :subject
            """)
    List<Contact> findBySubjectSortedByNewest(String subject);
}
