package com.revature.studybuddy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.studybuddy.entity.Note;
import com.revature.studybuddy.service.NoteService;
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
@WebMvcTest(NoteController.class)
class NoteControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @MockBean
    private NoteService noteService;
    @Test
    void getAllNotes() throws Exception {
        List<Note> noteList = new ArrayList<>();
        noteList.add(new Note(1L,"First","First description"));
        noteList.add(new Note(2L, "Second", "Second description"));
        Mockito.when(noteService.getAllNotes()).thenReturn(noteList);

        String url ="/note/all";


        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();
        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        String expectedJsonResponse = mapper.writeValueAsString(noteList);

        assertEquals(actualJsonResponse,expectedJsonResponse);
    }

    @Test
    void getNoteById() throws Exception {
        Note note = new Note(1L,"First","First description");
        Mockito.when(noteService.getNoteById(note.getNoteId())).thenReturn(note);

        String url ="/note/" + note.getNoteId();

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();
        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        String expectedJsonResponse = mapper.writeValueAsString(note);

        assertEquals(actualJsonResponse,expectedJsonResponse);
    }

    @Test
    void addNote() throws Exception {
        Note newNote = new Note();
        newNote.setTitle("New");
        newNote.setBody("If has id, was saved");
        Note savedNote =  new Note(1L,"New","If has id, was saved");
        Mockito.when(noteService.addNote(newNote)).thenReturn(savedNote);

        String url ="/note/add";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(newNote)))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn();
        String actualJsonResponse = mvcResult.getResponse().getContentAsString();
        String expectedJsonResponse = mapper.writeValueAsString(savedNote);

        assertEquals(actualJsonResponse,expectedJsonResponse);
    }
}