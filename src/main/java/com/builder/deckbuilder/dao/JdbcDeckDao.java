package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.Deck;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDeckDao implements DeckDao {

    private final DeckDao deckDao;
    private final JdbcTemplate jdbcTemplate;

    public JdbcDeckDao(DeckDao deckDao, JdbcTemplate jdbcTemplate){
        this.deckDao = deckDao;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Deck> findDecksByUserId(int userId){
        List<Deck> decks = new ArrayList<>();

        String sql = "SELECT deck_id, commander FROM decks " +
                "JOIN users ON decks.deck_id = users.deck_id " +
                "WHERE userId = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        while(results.next()){
            Deck deck = mapRowToDeck(results);
            decks.add(deck);
        }

        return decks;
    }

    public Deck findDeckByDeckId(int deckId){
        String sql = "SELECT user_id, deck_id, commander FROM decks WHERE deck_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, Integer.class, deckId);

        Deck deck = new Deck();

        while(result.next()){
            deck = mapRowToDeck(result);
        }

        return deck;
    }

    public List<Deck> findDecksByUsername(String username){
        String sql = "SELECT deck_id, commander FROM decks " +
                "JOIN users ON decks.user_id = users.user_id " +
                "WHERE username = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, username);

        List<Deck> decks = new ArrayList<>();

        while(result.next()){
            Deck deck = mapRowToDeck(result);
            decks.add(deck);
        }

        return decks;
    }

    public int createDeck(int userId, String commander){
        String sql = "INSERT INTO decks (user_id, commander) VALUES (?, ?) RETURNING deck_id;";

        Integer newDeckId = jdbcTemplate.queryForObject(sql, Integer.class, userId, commander);

        return newDeckId;
    }

    public List<Deck> getDecksByCommander(String commander){
        String sql = "SELECT deck_id, commander FROM decks WHERE commander = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, commander);

        List<Deck> decks = new ArrayList<>();

        while(results.next()){
            Deck deck = mapRowToDeck(results);
            decks.add(deck);
        }

        return decks;
    }

    private Deck mapRowToDeck(SqlRowSet rowSet){
        Deck deck  = new Deck();
        deck.setDeckId(rowSet.getInt("deck_id"));
        deck.setCommander(rowSet.getString("commander"));
    }

}
