package com.builder.deckbuilder.controller;

import com.builder.deckbuilder.dao.DeckDao;
import com.builder.deckbuilder.model.Deck;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path="/create")
    public boolean createDeck(int userId, String deckName, String commander){
        return deckDao.createDeck(userId, deckName, commander);
    }

    @PostMapping(path="/add")
    public boolean addCardToDeck(int deckId, int cardId){
        return deckDao.addCardToDeck(deckId, cardId);
    }

    @PostMapping(path="/update")
    public boolean updateDeck(int id, String deckName, String commander){
        return deckDao.updateDeck(id, deckName, commander);
    }

    @GetMapping(path="/search")
    public List<Deck> searchForDeckByName(String name){
        return deckDao.searchForDeckByName(name);
    }
}
