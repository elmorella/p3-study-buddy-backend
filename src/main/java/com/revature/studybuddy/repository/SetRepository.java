package com.revature.studybuddy.repository;

import com.revature.studybuddy.entity.Card;
import com.revature.studybuddy.entity.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SetRepository extends JpaRepository<Set, Long> {

    @Query("SELECT s FROM Set s WHERE s.title LIKE :keyword OR s.description LIKE :keyword")
    public List<Set> search(@Param("keyword") String keyword);
}
