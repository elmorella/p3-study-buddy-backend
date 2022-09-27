package com.revature.studybuddy.service;

import com.revature.studybuddy.entity.Card;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CardService {
        List<Card> getCardByDeckId(long deckId);
        Card addCard(Card card);
        List<Card> search(String keyword);
    }
