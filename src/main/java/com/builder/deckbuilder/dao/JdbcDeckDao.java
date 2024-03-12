package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.Deck;
import com.builder.deckbuilder.model.exceptions.DeckNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcDeckDao implements DeckDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcDeckDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean createDeck(int userId, String deckName, String commander){
        String deckInsert = "INSERT INTO decks (deck_name, commander) VALUES (?, ?) RETURNING deck_id;";
        int deckId = jdbcTemplate.update(deckInsert, deckName, commander);
        String userDeckMap = "INSERT INTO user_decks (user_id, deck_id) VALUES (?, ?);";
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

    public List<Deck> findDecksByUser(String username){
        String sql = "SELECT deck_name, commander FROM decks d " +
                "JOIN user_decks ud ON ud.deck_id = d.deck_id " +
                "JOIN users u ON u.user_id = ud.user_id " +
                "WHERE u.username = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
        List<Deck> decks = new ArrayList<>();

        while(results.next()){
            decks.add(mapRowToDeck(results));
        }
        return decks;
    }

    public Deck getDeckById(int id){
        String sql = "SELECT deck_name, commander FROM decks WHERE deck_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

        if(result.next()){
            return mapRowToDeck(result);
        } else {
            throw new DeckNotFoundException();
        }
    }

    public boolean updateDeck(int id, String deckName, String commander){
        String sql = "UPDATE decks SET deck_name = ?, commander = ? " +
                "WHERE deck_id = ?;";

        try {
            if(jdbcTemplate.update(sql, deckName, commander, id) == 1){
                return true;
            } else {
                System.err.println("This deck could not be updated");
                return false;
            }
        } catch (DeckNotFoundException d) {
            throw new DeckNotFoundException();
        }
    }

    public boolean addCardToDeck(int deckId, int cardId){
        String sql = "INSERT INTO decks_cards (deck_id, card_id) VALUES (?, ?);";
        return jdbcTemplate.update(sql, deckId, cardId) == 1;
    }

    public boolean removeCardFromDeck(int deckId, int cardId){
        String sql = "DELETE FROM decks_cards WHERE deck_id = ? AND card_id = ?;";
        return jdbcTemplate.update(sql, deckId, cardId) == 1;
    }

    private Deck mapRowToDeck(SqlRowSet row){
        Deck deck = new Deck();
        deck.setDeckName(row.getString("deck_name"));
        deck.setCommander(row.getString("commander"));
        return deck;
    }
}
