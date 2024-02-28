package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.Deck;
import com.builder.deckbuilder.model.Card;
import java.util.List;

public interface DeckDao {

    List<Deck> findDecksByUser(String username);

    Deck getDeckByName(String name);

    Deck getDeckById(int id);

    Boolean addCardToDeck(Card card);

    Boolean removeCardFromDeck(Card card);

    Boolean updateDeck(int id, String deckName, String commander);

    Boolean createDeck(String deckName, String commander);
}
