package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.Deck;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcDeckDao implements DeckDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcDeckDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Boolean createDeck(int userId, String deckName, String commander){
        String deckInsert = "INSERT INTO decks (deck_name, commander) VALUES (?, ?) RETURNING deck_id;";
        int deckId = jdbcTemplate.update(deckInsert, deckName, commander);
        String userDeckMap = "INSERT INTO user_decks (user_id, deck_id), VALUES (?, ?);";
        jdbcTemplate.update(userDeckMap, userId, deckId);
        return true;
    }

    public List<Deck> searchForDeckByName(String deckName){
        String sql = "SELECT deck_name, commander FROM decks WHERE name LIKE '%?%';";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, deckName);
        List<Deck> decks = new ArrayList<>();

        while(results.next()){
            decks.add(mapRowToDeck(results));
        }

        return decks;
    }
    private Deck mapRowToDeck(SqlRowSet row){
        Deck deck = new Deck();
        deck.setDeckName(row.getString("deck_name"));
        deck.setCommander(row.getString("commander"));
        return deck;
    }
}
