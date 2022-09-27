package com.revature.studybuddy.repository;

import com.revature.studybuddy.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findBySetSetId(long id);

    @Query("SELECT c FROM Card c WHERE c.term LIKE :keyword OR c.definition LIKE :keyword")
    public List<Card> search(@Param("keyword") String keyword);
}
