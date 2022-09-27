package com.revature.studybuddy.service.implementation;

import com.revature.studybuddy.entity.Card;
import com.revature.studybuddy.repository.CardRepository;
import com.revature.studybuddy.repository.SetRepository;
import com.revature.studybuddy.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;


    @Override
    public List<Card> getCardBySetId(long setId) {
        return cardRepository.findBySetSetId(setId);
    }

    @Override
    public Card addCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public List<Card> search(String keyword) {
        return cardRepository.search(keyword);
    }
}

