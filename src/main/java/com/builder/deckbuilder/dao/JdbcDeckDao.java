package com.builder.deckbuilder.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.builder.deckbuilder.model.Deck;

public class JdbcDeckDao implements DeckDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcDeckDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Boolean create(String deckName, String commander){
        String sql = "INSERT INTO decks (deck_name, commander) VALUES (?, ?);";
        jdbcTemplate.update(sql, deckName, commander);

        return true;
    }

    private Deck mapRowToDeck(SqlRowSet row){
        Deck deck = new Deck();
        deck.setDeckName(row.getString("deck_name"));
        deck.setCommander(row.getString("commander"));
        return deck;
    }
}
