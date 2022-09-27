package com.revature.studybuddy.service.implementation;

import com.revature.studybuddy.entity.Card;
import com.revature.studybuddy.entity.Deck;
import com.revature.studybuddy.repository.CardRepository;
import com.revature.studybuddy.service.CardService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CardServiceImplTest {
    @Autowired
    private CardService cardService;
    @MockBean
    private CardRepository mockCardRepo;
    @Test
    void addCard(){
        Card testCard = new Card();
        Deck testDeck = new Deck(1L, "TestDeck", "TestDeck to test getCardByDeckId");
        testCard.setTitle("TestTerm");
        testCard.setDescription("Term created from testing. If still here there was an issue.");
        testCard.setDeck(testDeck);
        Card returnedCard = new Card();
        returnedCard.setCardId(1L);
        returnedCard.setTitle("TestTerm");
        returnedCard.setDescription("Term created from testing. If still here there was an issue.");
        returnedCard.setDeck(testDeck);

        Mockito.when(mockCardRepo.save(testCard)).thenReturn(returnedCard);
        Card savedCard = cardService.addCard(testCard)  ;
        assertEquals(savedCard, returnedCard);
    }
    @Test
    void FindByDeckId() {
        Card testCard = new Card();
        Deck testDeck = new Deck(1L, "TestDeck", "TestDeck to test getCardByDeckId");
        testCard.setTitle("TestTerm");
        testCard.setDescription("Term created from testing. If still here there was an issue.");
        testCard.setDeck(testDeck);
        List<Card> cardList = new ArrayList<>();
        cardList.add(testCard);
        Mockito.when(mockCardRepo.findByDeckDeckId(1L)).thenReturn(cardList);


        assertEquals(cardList, cardService.getCardByDeckId(1L));

    }
}