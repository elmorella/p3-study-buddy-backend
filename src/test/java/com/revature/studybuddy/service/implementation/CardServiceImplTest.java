package com.revature.studybuddy.service.implementation;

import com.revature.studybuddy.entity.Card;
import com.revature.studybuddy.entity.Set;
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
        Set testSet = new Set(1L, "TestSet", "TestSet to test getCardBySetId");
        testCard.setTerm("TestTerm");
        testCard.setDefinition("Term created from testing. If still here there was an issue.");
        testCard.setSet(testSet);
        Card returnedCard = new Card();
        returnedCard.setCardId(1L);
        returnedCard.setTerm("TestTerm");
        returnedCard.setDefinition("Term created from testing. If still here there was an issue.");
        returnedCard.setSet(testSet);

        Mockito.when(mockCardRepo.save(testCard)).thenReturn(returnedCard);
        Card savedCard = cardService.addCard(testCard)  ;
        assertEquals(savedCard, returnedCard);
    }
    @Test
    void FindBySetId() {
        Card testCard = new Card();
        Set testSet = new Set(1L, "TestSet", "TestSet to test getCardBySetId");
        testCard.setTerm("TestTerm");
        testCard.setDefinition("Term created from testing. If still here there was an issue.");
        testCard.setSet(testSet);
        List<Card> cardList = new ArrayList<>();
        cardList.add(testCard);
        Mockito.when(mockCardRepo.findBySetSetId(1L)).thenReturn(cardList);


        assertEquals(cardList, cardService.getCardBySetId(1L));

    }
}