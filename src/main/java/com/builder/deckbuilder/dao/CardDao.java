package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.Card;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;


public interface CardDao {
    List<Card> searchForCardByName(String name) throws UnsupportedEncodingException;

    String getCardsFromUri(String uri) throws IOException;

    Card mapResultToCard(JsonObject result);

    List<Card> findCardByType(String type);
//
//    List<Card> getCardByManaCost(int manaCost);
//
//    List<Card> getCardByKeyword(String keyword);
//
//    List<Card> getCardByColors(String[] colors);
//
//    List<Card> getCardByColorIdentity(String[] colorIdentity);

}
