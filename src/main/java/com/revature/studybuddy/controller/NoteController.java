package com.revature.studybuddy.controller;

import com.revature.studybuddy.entity.Note;
import com.revature.studybuddy.entity.Set;
import com.revature.studybuddy.service.CardService;
import com.revature.studybuddy.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Note>> getAllNotes(){
        List<Note> notes = noteService.getAllNotes();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable("id") Long id){
        Note noteById = noteService.getNoteById(id);
        return new ResponseEntity<>(noteById, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Note> addNote(@RequestBody Note newNote){
        Note returnNote = noteService.addNote(newNote);
        return new ResponseEntity<>(returnNote, HttpStatus.CREATED);
    }



}
