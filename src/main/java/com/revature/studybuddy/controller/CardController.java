package com.revature.studybuddy.controller;

import com.revature.studybuddy.entity.Card;
import com.revature.studybuddy.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/{deckId}")
    public ResponseEntity<List<Card>> getCardsByDeckId(@PathVariable("deckId") Long deckId){
        List<Card> cardsByDeckId = cardService.getCardByDeckId(deckId);
        return new ResponseEntity<>(cardsByDeckId, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Card> addCard(@RequestBody Card newCard){
        Card returnCard = cardService.addCard(newCard);
        return new ResponseEntity<>(returnCard, HttpStatus.CREATED);
    }

    @GetMapping("/{keyword}")
    public ResponseEntity<List<Card>> searchCards(@PathVariable("keyword") String keyword){
        List<Card> cards = cardService.search(keyword);
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }
}
