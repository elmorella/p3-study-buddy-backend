package com.revature.studybuddy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.studybuddy.entity.Card;
import com.revature.studybuddy.entity.Deck;
import com.revature.studybuddy.service.CardService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(CardController.class)
class CardControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @MockBean
    private CardService cardService;
    @Test
    void getCardsByDeckId() throws Exception {
        List<Card> cardList = new ArrayList<>();
        Deck searchedDeck = new Deck();
        searchedDeck.setDeckId(1L);
        cardList.add(new Card(1L,"First","The First", searchedDeck));
        cardList.add(new Card(2L,"Second","Not The First", searchedDeck));
        cardList.add(new Card(3L,"Third","Knot The First", searchedDeck));
        Mockito.when(cardService.getCardByDeckId(searchedDeck.getDeckId())).thenReturn(cardList);

        String url ="/card/" + searchedDeck.getDeckId();

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();
        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        String expectedJsonResponse = mapper.writeValueAsString(cardList);

        assertEquals(actualJsonResponse,expectedJsonResponse);
    }

    @Test
    void addCard() throws Exception {
        Card newCard = new Card();
        newCard.setTitle("First");
        newCard.setDescription("The First");
        Deck deck = new Deck();
        Card savedCard = new Card(1L, "First", "The First", deck);
        Mockito.when(cardService.addCard(newCard)).thenReturn(savedCard);

        String url ="/card/add";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(newCard)))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();
        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        String expectedJsonResponse = mapper.writeValueAsString(savedCard);

        assertEquals(actualJsonResponse,expectedJsonResponse);
    }
}