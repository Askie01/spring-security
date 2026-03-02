package com.askie01.springsecuritytutorial.repository;

import com.askie01.springsecuritytutorial.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, String> {

    @Query("""
            SELECT n
            FROM Notice n
            ORDER BY n.createdAt DESC
            """)
    List<Notice> findAllSortedByNewest();
}
