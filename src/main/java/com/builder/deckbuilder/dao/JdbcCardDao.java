package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.Card;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class JdbcCardDao implements CardDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcCardDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    String scryfallUrl = "https://api.scryfall.com";
    public List<Card> searchForCardByName(String name) throws UnsupportedEncodingException {
            String encodedName = URLEncoder.encode(name, "UTF-8");
            String uri = scryfallUrl + "/cards/search?unique=prints&q=" + encodedName;

        try {
            return getCardsFromUri(uri);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Card> getCardsFromUri(String uri) throws IOException {
        List<Card> cards = new ArrayList<>();
        URL url = new URL(uri);

        URLConnection connection = url.openConnection();
    }

}
