package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.Card;

import java.util.List;


public interface CardDao {
    List<Card> getCardByName(String name);

    List<Card> findCardByType(String type);

    List<Card> getCardByManaCost(int manaCost);

    List<Card> getCardByKeyword(String keyword);

    List<Card> getCardByColors(String[] colors);

    List<Card> getCardByColorIdentity(String[] colorIdentity);
}
