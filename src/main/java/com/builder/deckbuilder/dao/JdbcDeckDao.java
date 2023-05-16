package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.Card;
import com.builder.deckbuilder.model.Deck;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDeckDao implements DeckDao {

    private DeckDao deckDao;

    private CardDao cardDao;
    private final JdbcTemplate jdbcTemplate;

    public JdbcDeckDao(DeckDao deckDao, CardDao cardDao, JdbcTemplate jdbcTemplate){
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

    public List<Card> listCardsByDeckId(int deckId){
        String sql = "SELECT * FROM cards WHERE deck_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, deckId);

        List<Card> deck = new ArrayList<>();

        while(results.next()){
            Card card = new Card();
            mapRowToCard(results);
            deck.add(card);
        }
        return deck;
    }

    private Deck mapRowToDeck(SqlRowSet rowSet){
        Deck deck  = new Deck();
        deck.setDeckId(rowSet.getInt("deck_id"));
        deck.setCommander(rowSet.getString("commander"));
        return deck;
    }

    private Card mapRowToCard(SqlRowSet rowSet){
        Card card = new Card();
        card.setCardId(rowSet.getInt("card_id"));
        card.setCardName(rowSet.getString("card_name"));
        card.setScryfallLink(rowSet.getString("scryfall_link"));
        card.setImageLink(rowSet.getString("image_link"));
        card.setManaCost(rowSet.getString("mana_cost"));
        card.setCmc(rowSet.getString("cmc"));
        card.setCardType(rowSet.getString("card_type"));
        card.setOracleText(rowSet.getString("oracle_text"));
        card.setColors(rowSet.getString("colors"));
        card.setColorIdentity(rowSet.getString("color_identity"));
        card.setKeywords(rowSet.getString("keywords"));
        card.setLegal(rowSet.getBoolean("legal"));
        return card;
    }
}
