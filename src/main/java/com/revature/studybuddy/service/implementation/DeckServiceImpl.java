package com.revature.studybuddy.service.implementation;

import com.revature.studybuddy.entity.Deck;
import com.revature.studybuddy.repository.DeckRepository;
import com.revature.studybuddy.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckServiceImpl implements DeckService {

    @Autowired
    private DeckRepository deckRepository;

    @Override
    public List<Deck> getAllDecks() {
        return deckRepository.findAll();
    }

    @Override
    public Deck getDeckById(long deckId) {
        return deckRepository.findById(deckId).get();
    }

    @Override
    public Deck addDeck(Deck deck) {
        return deckRepository.save(deck);
    }

    @Override
    public List<Deck> search(String keyword) {
        return deckRepository.search("%" + keyword + "%");
    }
}
