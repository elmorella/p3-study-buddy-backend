package com.revature.studybuddy.controller;

import com.revature.studybuddy.entity.Note;
import com.revature.studybuddy.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }

    @GetMapping("/note")
    public ResponseEntity<List<Note>> getAllNotes(){
        List<Note> notes = noteService.getAllNotes();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping("/{noteid}")
    public ResponseEntity<Note> getNoteById(@PathVariable("id") Long id){
        Note setNoteByID = noteService.getNoteById(id);
        return new ResponseEntity<>(setNoteByID, HttpStatus.OK);
    }

    @PostMapping("/addNote")
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        Note returnNote = noteService.addNote(note);
        return new ResponseEntity<>(returnNote,HttpStatus.CREATED);
    }

}

