package com.revature.studybuddy.service.implementation;

import com.revature.studybuddy.entity.Card;
import com.revature.studybuddy.repository.CardRepository;
import com.revature.studybuddy.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;


    @Override
    public List<Card> getCardByDeckId(long deckId) {
        return cardRepository.findByDeckDeckId(deckId);
    }

    @Override
    public Card addCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public List<Card> search(String keyword) {
        return cardRepository.searchCard(keyword);
    }
}

