package com.revature.studybuddy.service;

import com.revature.studybuddy.entity.Deck;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeckService {
    List<Deck> getAllDecks();
    Deck getDeckById(long deckId);
    Deck addDeck(Deck deck);
    List<Deck> search(String keyword);
}
