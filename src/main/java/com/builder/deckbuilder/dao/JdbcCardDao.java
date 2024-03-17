package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.Card;
import org.json.simple.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class JdbcCardDao implements CardDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcCardDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    String scryfallUrl = "https://api.scryfall.com";
    public List<Card> getCardByName(String name) throws UnsupportedEncodingException {
            String encodedName = URLEncoder.encode(name, "UTF-8");
            String uri = scryfallUrl + "/cards/search?unique=prints&q=" + encodedName;

            return getCardsFromUri(uri);
    }


}
