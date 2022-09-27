package com.revature.studybuddy.service.implementation;

import com.revature.studybuddy.entity.Note;
import com.revature.studybuddy.repository.NoteRepository;
import com.revature.studybuddy.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
   @Autowired
   private NoteRepository noteRepository;

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(long noteId) {
        return noteRepository.findById(noteId).get();
    }

    @Override
    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Note> search(String keyword) {
        return noteRepository.search(keyword);
    }
}
