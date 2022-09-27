package com.revature.studybuddy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.studybuddy.entity.Deck;
import com.revature.studybuddy.service.DeckService;
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

@WebMvcTest(DeckController.class)
class DeckControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @MockBean
    private DeckService deckService;
    @Test
    public void testGetAllDeck() throws Exception {
        List<Deck> deckList = new ArrayList<>();
        deckList.add(new Deck(1L,"First","First description"));
        deckList.add(new Deck(2L, "Second", "Second description"));
        Mockito.when(deckService.getAllDecks()).thenReturn(deckList);

        String url ="/deck/all";


        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();
        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        String expectedJsonResponse = mapper.writeValueAsString(deckList);

        assertEquals(actualJsonResponse,expectedJsonResponse);

    }

    @Test
    void getDeckById() throws Exception {
        Deck deck = new Deck(1L,"First","First description");
        Mockito.when(deckService.getDeckById(deck.getDeckId())).thenReturn(deck);

        String url ="/deck/" + deck.getDeckId();

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();
        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        String expectedJsonResponse = mapper.writeValueAsString(deck);

        assertEquals(actualJsonResponse,expectedJsonResponse);

    }

    @Test
    void addDeck() throws Exception {
        Deck newDeck = new Deck();
        newDeck.setTitle("New");
        newDeck.setDescription("If has id, was saved");
        Deck savedDeck =  new Deck(1L,"New","If has id, was saved");
        Mockito.when(deckService.addDeck(newDeck)).thenReturn(savedDeck);

        String url ="/deck/add";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType("application/json")
                .content(mapper.writeValueAsString(newDeck)))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();
        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        String expectedJsonResponse = mapper.writeValueAsString(savedDeck);

        assertEquals(actualJsonResponse,expectedJsonResponse);
    }
}