package com.revature.studybuddy.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void builder() {
        Card builderCard = Card.builder()
                .cardId(1L)
                .term("TestCard")
                .definition("TestDescription")
                .build();

        assertEquals(builderCard.getCardId(), 1L);
        assertEquals(builderCard.getTerm(), "TestCard");
        assertEquals(builderCard.getDefinition(), "TestDescription");
    }
}