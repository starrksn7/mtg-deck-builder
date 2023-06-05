package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.Card;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCardDao implements CardDao{

    private CardDao cardDao;
    private final JdbcTemplate jdbcTemplate;

    public JdbcCardDao(CardDao cardDao, JdbcTemplate jdbcTemplate){
        this.cardDao = cardDao;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Card> listAllCards(){
        String sql = "SELECT * FROM cards;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        List<Card> cards = new ArrayList<>();

        while(results.next()){
            Card card = mapRowToCard(results);
            cards.add(card);
        }
        return cards;
    }

    public List<Card> listCardsByColorIdentity(String colorIdentity){
        String sql = "SELECT * FROM cards WHERE color_identity = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, colorIdentity);

        List<Card> cards = new ArrayList<>();

        while(results.next()){
            Card card = mapRowToCard(results);
            cards.add(card);
        }
        return cards;
    }

    public List<Card> findCardByName(String name){
        String sql = "SELECT * FROM cards WHERE card_name ILIKE ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);

        List<Card> cards = new ArrayList<>();

        while(results.next()){
            Card card = mapRowToCard(results);
            cards.add(card);
        }
        return cards;
    }

    public List<Card> advancedCardSearch(String cardName, String manaCost, String cmc, String cardType, String oracleText, String colors,
                                 String colorIdentity, String keywords, String legal){
        String sql = "SELECT card_name, mana_cost, cmc, card_type, oracle_text, colors, color_identity, keywords, legal" +
                " FROM cards WHERE card_name ILIKE ? AND mana_cost = ? AND cmc = ? AND card_type = ? AND oracle_text ILIKE ? " +
                "AND colors = ? AND color_identity = ? AND keywords = ? AND legal = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, cardName, manaCost, cmc, cardType, oracleText, colors, colorIdentity, keywords, legal);

        List<Card> cards = new ArrayList<>();

        while(results.next()){
            Card card = mapRowToCard(results);
            cards.add(card);
        }
        return cards;
    }

    public List<Card> getCardsByKeyword(String keyword){
        String sql = "SELECT * FROM cards WHERE keywords = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, keyword);

        List<Card> cards = new ArrayList<>();

        while(results.next()){
            Card card = mapRowToCard(results);
            cards.add(card);
        }
        return cards;
    }

    public boolean addCardToDeck(int cardId, int deckId){
        String sql = "INSERT INTO deck_cards (deck_id, card_id) VALUES ?, ?;";
        try {
            jdbcTemplate.update(sql, deckId, cardId);
            return true;
        } catch (DataAccessException e) {
            System.out.println("Either the deck_id or the card_id does not exist");
        }
        return false;
    }


    public String populateDatabase() {
        JSONParser jsonParser = new JSONParser();

        try{
            Object object = jsonParser.parse(new FileReader("E:/card-list.json"));

            JSONArray jsonObjects = (JSONArray) object;

            for(Object entry : jsonObjects){
                JSONObject jsonObject = (JSONObject) entry;
                String name = (String) jsonObject.get("name");
                String scryfallLink = (String) jsonObject.get("scryfall_uri");
                String imageLink = (String) jsonObject.get("image");
                String manaCost = (String) jsonObject.get("mana_cost");
                Double cmc = (Double) jsonObject.get("cmc");
                String cardType = (String) jsonObject.get("type");
                String oracleText = (String) jsonObject.get("oracle_text");
                String colors = (String) jsonObject.get("colors");
                String colorIdentity = (String) jsonObject.get("color_identity");
                String keywords = (String) jsonObject.get("keywords");

                String sql = "INSERT INTO cards (card_name, scryfall_link, image_link, mana_cost, " +
                        "cmc, card_type, oracle_text, colors, color_identity, keywords) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

                jdbcTemplate.update(sql, name, scryfallLink, imageLink, manaCost, cmc, cardType, oracleText, colors, colorIdentity, keywords);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e){
            e.printStackTrace();
        }

        return "Cards added to database";

    }

    private Card mapRowToCard(SqlRowSet rowSet){
        Card card = new Card();
        card.setCardId(rowSet.getInt("card_id"));
        card.setCardName(rowSet.getString("card_name"));
        card.setScryfallLink(rowSet.getString("scryfall_link"));
        card.setImageLink(rowSet.getString("image_link"));
        card.setManaCost(rowSet.getString("mana_cost"));
        card.setCmc(rowSet.getDouble("cmc"));
        card.setCardType(rowSet.getString("card_type"));
        card.setOracleText(rowSet.getString("oracle_text"));
        card.setColors(rowSet.getString("colors"));
        card.setColorIdentity(rowSet.getString("color_identity"));
        card.setKeywords(rowSet.getString("keywords"));
        return card;
    }
}
