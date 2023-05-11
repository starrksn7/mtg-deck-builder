package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.Deck;
public interface DeckDao {

    Deck findDeckByUserId(int userId);

    Deck findDeckByDeckId(int deckId);

    Deck findDeckByUsername(String username);
}
