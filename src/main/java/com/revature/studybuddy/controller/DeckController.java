package com.revature.studybuddy.controller;

import com.revature.studybuddy.entity.Deck;
import com.revature.studybuddy.service.DeckService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deck")
public class DeckController {
    private final DeckService deckService;

    public DeckController(DeckService deckService) {this.deckService = deckService;}

    @GetMapping("/all")
    public ResponseEntity<List<Deck>> getAllDecks(){
        List<Deck> decks = deckService.getAllDecks();
        return new ResponseEntity<>(decks, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Deck> getDeckById(@PathVariable("id") Long id){
        Deck deckById = deckService.getDeckById(id);
        return new ResponseEntity<>(deckById, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Deck> addDeck(@RequestBody Deck newDeck){
        Deck returnDeck = deckService.addDeck(newDeck);
        return new ResponseEntity<>(returnDeck, HttpStatus.CREATED);
    }
    @GetMapping("/{keyword}")
    public ResponseEntity<List<Deck>> searchDecks(@PathVariable("keyword") String keyword){
        List<Deck> decks = deckService.search(keyword);
        return new ResponseEntity<>(decks, HttpStatus.OK);
    }
}
