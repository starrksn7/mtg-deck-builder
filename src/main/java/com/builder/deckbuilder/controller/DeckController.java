package com.builder.deckbuilder.controller;

import com.builder.deckbuilder.dao.DeckDao;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/decks")
@CrossOrigin
public class DeckController {
    private DeckDao deckDao;

    private DeckController(DeckDao deckDao){
        this.deckDao = deckDao;
    }
}
