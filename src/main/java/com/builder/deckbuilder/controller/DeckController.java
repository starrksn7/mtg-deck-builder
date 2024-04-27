package com.builder.deckbuilder.controller;

import com.builder.deckbuilder.dao.DeckDao;
import com.builder.deckbuilder.model.Deck;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/decks")
@CrossOrigin
public class DeckController {
    private DeckDao deckDao;

    private DeckController(DeckDao deckDao){
        this.deckDao = deckDao;
    }

    @GetMapping(path = "")
    public List<Deck> findDecksByUser(String username){
        return deckDao.findDecksByUser(username);
    }
}
