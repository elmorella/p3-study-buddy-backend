package com.revature.studybuddy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.studybuddy.entity.Card;
import com.revature.studybuddy.entity.Set;
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
    void getCardsBySetId() throws Exception {
        List<Card> cardList = new ArrayList<>();
        Set searchedSet = new Set();
        searchedSet.setSetId(1L);
        cardList.add(new Card(1L,"First","The First",searchedSet));
        cardList.add(new Card(2L,"Second","Not The First",searchedSet));
        cardList.add(new Card(3L,"Third","Knot The First",searchedSet));
        Mockito.when(cardService.getCardBySetId(searchedSet.getSetId())).thenReturn(cardList);

        String url ="/card/" + searchedSet.getSetId();

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
        newCard.setTerm("First");
        newCard.setDefinition("The First");
        Set set = new Set();
        Card savedCard = new Card(1L, "First", "The First", set);
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