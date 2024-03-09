package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.Deck;

import java.util.List;

public interface DeckDao {

    List<Deck> findDecksByUser(String username);

    Deck getDeckById(int id);

    boolean addCardToDeck(int deckId, int cardId);

    boolean removeCardFromDeck(int deckId, int cardId);

    boolean updateDeck(int id, String deckName, String commander);

    boolean createDeck(int userId, String deckName, String commander);

    List<Deck> searchForDeckByName(String deckName);
}
