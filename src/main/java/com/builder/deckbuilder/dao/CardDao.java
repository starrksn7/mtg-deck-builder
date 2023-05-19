package com.builder.deckbuilder.dao;
import com.builder.deckbuilder.model.Card;
import java.util.List;
public interface CardDao {


    List<Card> listAllCards();

    List<Card> listCardsByColorIdentity(String colorIdentity);

    List<Card> findCardByName(String cardName);

    List<Card> advancedCardSearch(String cardName, String manaCost, String cmc, String cardType, String oracleText, String colors,
                          String colorIdentity, String keywords, String legal);

    List<Card> getCardsByKeyword(String keyword);

    boolean addCardToDeck(int cardId, int deckId);

    String populateDatabase();

}
