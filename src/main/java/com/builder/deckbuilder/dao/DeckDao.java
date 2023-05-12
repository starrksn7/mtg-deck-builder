package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.Deck;


import java.util.List;


public interface DeckDao {

    List<Deck> findDecksByUserId(int userId);

    Deck findDecksByDeckId(int deckId);

    List<Deck> findDecksByUsername(String username);

    int createDeck(int userId, String commander);

    List<Deck> getDecksByCommander(String commander);

}
