package com.revature.studybuddy.repository;

import com.revature.studybuddy.entity.Card;
import com.revature.studybuddy.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("SELECT n FROM Note n WHERE n.title LIKE :keyword OR n.body LIKE :keyword")
    public List<Note> search(@Param("keyword") String keyword);
}
