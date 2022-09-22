package com.revature.studybuddy.service;

import com.revature.studybuddy.entity.Card;
import com.revature.studybuddy.entity.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {
    List<Note> getAllNotes();
    Note getNoteById(long noteId);
    Note addNote(Note note);
}


