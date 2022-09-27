package com.revature.studybuddy.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeckTest {

    @Test
    void builder() {
        Deck builderDeck = Deck.builder()
                .deckId(1L)
                .title("TestDeck")
                .description("TestDescription")
                .build();

        assertEquals(builderDeck.getDeckId(), 1L);
        assertEquals(builderDeck.getTitle(), "TestDeck");
        assertEquals(builderDeck.getDescription(), "TestDescription");
    }
}