package com.revature.studybuddy.repository;

import com.revature.studybuddy.entity.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetRepository extends JpaRepository<Set, Long> {
}
