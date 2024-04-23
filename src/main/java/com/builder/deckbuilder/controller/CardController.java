package com.builder.deckbuilder.controller;

import com.builder.deckbuilder.dao.CardDao;
import com.builder.deckbuilder.model.Card;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/card")
@CrossOrigin
public class CardController {
    private CardDao cardDao;

    private CardController(CardDao cardDao){
        this.cardDao = cardDao;
    }
    public List<Card> searchForCardByName(String name) throws UnsupportedEncodingException {
        return cardDao.searchForCardByName(name);
    }
}
