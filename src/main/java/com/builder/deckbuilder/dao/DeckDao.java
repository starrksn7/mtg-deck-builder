package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.Deck;
import com.builder.deckbuilder.model.Card;
import java.util.List;

public interface DeckDao {

    List<Deck> findDecksByUser(String username);

    Deck getDeckById(int id);

    boolean addCardToDeck(Card card);

    boolean removeCardFromDeck(Card card);

    boolean updateDeck(int id, String deckName, String commander);

    boolean createDeck(int userId, String deckName, String commander);

    List<Deck> searchForDeckByName(String deckName);
}
