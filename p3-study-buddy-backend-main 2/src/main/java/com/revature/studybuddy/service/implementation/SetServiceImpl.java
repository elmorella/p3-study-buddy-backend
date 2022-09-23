package com.revature.studybuddy.service.implementation;

import com.revature.studybuddy.entity.Note;
import com.revature.studybuddy.entity.Set;
import com.revature.studybuddy.repository.SetRepository;
import com.revature.studybuddy.service.SetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetServiceImpl implements SetService {

    @Autowired
    private SetRepository setRepository;

    @Override
    public List<Set> getAllSets() {
        return setRepository.findAll();
    }

    @Override
    public Set getSetById(long setId) {
        return setRepository.findById(setId).get();
    }

    @Override
    public Set addSet(Set set) {
        return setRepository.save(set);
    }
}
