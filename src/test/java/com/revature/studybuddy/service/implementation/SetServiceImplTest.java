package com.revature.studybuddy.service.implementation;

import com.revature.studybuddy.entity.Set;
import com.revature.studybuddy.repository.SetRepository;
import com.revature.studybuddy.service.SetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SetServiceImplTest {



    @Autowired
    private SetService setService;
    @Autowired
    private SetRepository setRepo;

    @Test

    void getAllSets() {
        Set testSet = new Set();
        testSet.setTitle("GetAll");
        testSet.setDescription("GetAllSets Test set");
        Set setToDelete = setService.addSet(testSet);
        List<Set> allSets = setService.getAllSets();
        assertNotNull(allSets);
        assertThat(setService.getAllSets().size()).isGreaterThan(0);
        setRepo.delete(setToDelete);

    }

    @Test
    void addSetThenFindById() {
        Set testSet = new Set();
        testSet.setTitle("GetAll");
        testSet.setDescription("GetAllSets Test set");
        Set setToDelete = setService.addSet(testSet);
        assertEquals(setToDelete, setService.getSetById(setToDelete.getSetId()));
        setRepo.delete(setToDelete);
    }

}