package com.revature.studybuddy.repository;

import com.revature.studybuddy.entity.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeckRepository extends JpaRepository<Deck, Long> {

    @Query("SELECT d FROM Deck d WHERE d.title LIKE :keyword OR d.description LIKE :keyword")
    public List<Deck> search(@Param("keyword") String keyword);
}
