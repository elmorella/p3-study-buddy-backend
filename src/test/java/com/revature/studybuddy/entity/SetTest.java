package com.revature.studybuddy.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SetTest {

    @Test
    void builder() {
        Set builderSet = Set.builder()
                .setId(1L)
                .title("TestSet")
                .description("TestDescription")
                .build();

        assertEquals(builderSet.getSetId(), 1L);
        assertEquals(builderSet.getTitle(), "TestSet");
        assertEquals(builderSet.getDescription(), "TestDescription");
    }
}