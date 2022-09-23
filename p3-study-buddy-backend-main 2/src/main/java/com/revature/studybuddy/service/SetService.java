package com.revature.studybuddy.service;

import com.revature.studybuddy.entity.Note;
import com.revature.studybuddy.entity.Set;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SetService {
    List<Set> getAllSets();
    Set getSetById(long setId);
    Set addSet(Set set);

}
