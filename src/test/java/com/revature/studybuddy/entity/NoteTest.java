package com.revature.studybuddy.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoteTest {

    @Test
    void builder() {
        Note builderNote = Note.builder()
                .noteId(1L)
                .title("TestNote")
                .body("TestDescription")
                .build();

        assertEquals(builderNote.getNoteId(), 1L);
        assertEquals(builderNote.getTitle(), "TestNote");
        assertEquals(builderNote.getBody(), "TestDescription");
    }
}