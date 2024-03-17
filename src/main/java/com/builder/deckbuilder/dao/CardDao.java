package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.Card;

import java.io.UnsupportedEncodingException;
import java.util.List;


public interface CardDao {
    List<Card> getCardByName(String name) throws UnsupportedEncodingException;

    List<Card> getCardsFromUri(String uri);

    List<Card> findCardByType(String type);

    List<Card> getCardByManaCost(int manaCost);

    List<Card> getCardByKeyword(String keyword);

    List<Card> getCardByColors(String[] colors);

    List<Card> getCardByColorIdentity(String[] colorIdentity);

}
