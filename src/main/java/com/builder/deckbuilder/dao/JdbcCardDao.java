package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.Card;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

@Component
public class JdbcCardDao implements CardDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcCardDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    String scryfallUrl = "https://api.scryfall.com";
    public List<Card> searchForCardByName(String name) throws UnsupportedEncodingException {
            System.out.println(1);
            System.out.println(name);
            String encodedName = URLEncoder.encode(name, "UTF-8");
            String uri = scryfallUrl + "/cards/search?unique=prints&q=" + encodedName;
        System.out.println(2);
        try {
            return getCardsFromUri(uri);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Card> getCardsFromUri(String uri) throws IOException {
        System.out.println(3);
        URL url = new URL(uri);
        URLConnection connection = url.openConnection();
        System.out.println(4);
        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        Type listType = new TypeToken<List<Card>>(){}.getType();
        System.out.println(5);
        return new Gson().fromJson(reader, listType);
    }

}
