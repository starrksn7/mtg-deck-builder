package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.Card;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;


public interface CardDao {
    List<Card> searchForCardByName(String name) throws UnsupportedEncodingException;

    List<Card> getCardsFromUri(String uri) throws IOException;

    List<Card> findCardByType(String type);

    List<Card> getCardByManaCost(int manaCost);

    List<Card> getCardByKeyword(String keyword);

    List<Card> getCardByColors(String[] colors);

    List<Card> getCardByColorIdentity(String[] colorIdentity);

}
