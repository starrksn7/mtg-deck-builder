package com.builder.deckbuilder.dao;
import com.builder.deckbuilder.model.Card;
import java.util.List;
public interface CardDao {

    List<Card> listCardsByDeckId(int deckId);

    List<Card> listAllCards();

    List<Card> getByFunction(String oracleText);

    Card addCardToDeck(int deckId);

    Card populateDatabase();

}
