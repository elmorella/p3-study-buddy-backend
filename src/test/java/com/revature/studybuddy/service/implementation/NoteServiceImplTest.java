package com.revature.studybuddy.service.implementation;

import com.revature.studybuddy.entity.Note;
import com.revature.studybuddy.repository.NoteRepository;
import com.revature.studybuddy.service.NoteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class NoteServiceImplTest {

    @Autowired
    private NoteService noteService;
    @Autowired
    private NoteRepository noteRepo;
    @Test
    void getAllNotes() {
        Note testNote = new Note();
        testNote.setTitle("TestNote");
        testNote.setBody("This is a note from testing. If its still here, there was a problem");
        Note noteToDelete = noteService.addNote(testNote);
        List<Note> allNotes = noteService.getAllNotes();
        assertNotNull(allNotes);
        assertThat(noteService.getAllNotes().size()).isGreaterThan(0);
        noteRepo.delete(noteToDelete);
    }

    @Test
    void addNoteThenFindById() {
            Note testNote = new Note();
            testNote.setTitle("TestNote");
            testNote.setBody("This is a note from testing. If its still here, there was a problem");
            Note noteToDelete = noteService.addNote(testNote);
            assertEquals(noteToDelete, noteService.getNoteById(noteToDelete.getNoteId()));
            noteRepo.delete(noteToDelete);
    }
}