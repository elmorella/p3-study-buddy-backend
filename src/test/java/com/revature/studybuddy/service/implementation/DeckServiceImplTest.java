package com.revature.studybuddy.service.implementation;

import com.revature.studybuddy.entity.Deck;
import com.revature.studybuddy.repository.DeckRepository;
import com.revature.studybuddy.service.DeckService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DeckServiceImplTest {



    @Autowired
    private DeckService deckService;
    @Autowired
    private DeckRepository deckRepo;

    @Test

    void getAllDecks() {
        Deck testDeck = new Deck();
        testDeck.setTitle("GetAll");
        testDeck.setDescription("GetAllDecks Test deck");
        Deck deckToDelete = deckService.addDeck(testDeck);
        List<Deck> allDecks = deckService.getAllDecks();
        assertNotNull(allDecks);
        assertThat(deckService.getAllDecks().size()).isGreaterThan(0);
        deckRepo.delete(deckToDelete);

    }

    @Test
    void addDeckThenFindById() {
        Deck testDeck = new Deck();
        testDeck.setTitle("GetAll");
        testDeck.setDescription("GetAllDecks Test deck");
        Deck deckToDelete = deckService.addDeck(testDeck);
        assertEquals(deckToDelete, deckService.getDeckById(deckToDelete.getDeckId()));
        deckRepo.delete(deckToDelete);
    }

}