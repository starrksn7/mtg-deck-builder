package com.builder.deckbuilder.dao;

import org.springframework.jdbc.core.JdbcTemplate;

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
}
