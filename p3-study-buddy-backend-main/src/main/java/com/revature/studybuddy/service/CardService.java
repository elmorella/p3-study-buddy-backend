package com.revature.studybuddy.service;

import com.revature.studybuddy.entity.Card;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface CardService {
        List<Card> getCardBySetId(long setId);
        Card addCard(Card card);
    }
