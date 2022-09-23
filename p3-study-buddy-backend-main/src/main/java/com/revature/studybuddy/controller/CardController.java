package com.revature.studybuddy.controller;

import com.revature.studybuddy.entity.Card;
import com.revature.studybuddy.entity.Set;
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

    @GetMapping("/{setId}")
    public ResponseEntity<List<Card>> getCardsBySetId(@PathVariable("setId") Long setId){
        List<Card> cardsBySetId = cardService.getCardBySetId(setId);
        return new ResponseEntity<>(cardsBySetId, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Card> addCard(@RequestBody Card newCard){
        Card returnCard = cardService.addCard(newCard);
        return new ResponseEntity<>(returnCard, HttpStatus.CREATED);
    }
}
