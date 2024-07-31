package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.Card;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
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
            String searchResults = getCardsFromUri(uri);

            JsonObject jsonObject = new JsonParser().parse(searchResults).getAsJsonObject();
            JsonArray jsonCards = (JsonArray) jsonObject.get("data");

            ArrayList<String> responseCards = new ArrayList<>();
            ArrayList<Card> result = new ArrayList<>();

            for(int i = 0; i < jsonCards.size(); i+=1){
                JsonObject tempObj = (JsonObject) jsonCards.get(i);
                result.add(mapResultToCard(tempObj));
//                responseCards.add(tempObj.get("name").getAsString());
            }

//            for(JsonObject item : responseCards)

            System.out.println(result);

            return result;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCardsFromUri(String uri) throws IOException {
        List<Card> list = new ArrayList<>();

        URL expansionsListUrl = new URL(uri);
        HttpURLConnection conn = (HttpURLConnection) expansionsListUrl.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responsecode = conn.getResponseCode();
        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        }

        StringBuilder body = new StringBuilder();
        Scanner scanner = new Scanner(expansionsListUrl.openStream());

        while (scanner.hasNext()) {
            body.append(scanner.nextLine());
        }
        scanner.close();
        return String.valueOf(body);
    }

    public Card mapResultToCard(JsonObject result){
        Card card = new Card();
        System.out.println(result);
        card.setName(result.get("name").getAsString());
        card.setScryfallURL(result.get("scryfall_uri").getAsString());
        JsonObject uris = (JsonObject) result.get("image_uris");
        card.setImageLink(uris.get("normal").getAsString());
        card.setManaCost(result.get("mana_cost").getAsString());
        card.setType(result.get("type_line").getAsString());
        card.setOracleText(result.get("oracle_text").getAsString());
        //Need to figure out why these next three variables are coming back null
        JsonArray colors = (JsonArray) result.get("colors");
        String[] colorsArray = new String[colors.size()];
        for(int i = 0; i < colors.size(); i++){
            colorsArray[i] = colors.get(i).getAsString();
        }

        JsonArray colorIdentity = (JsonArray) result.get("color_identity");
        String[] identityArray = new String[colorIdentity.size()];
        for (int i = 0; i < colorIdentity.size(); i++){
            identityArray[i] = colorIdentity.get(i).getAsString();
        }

        JsonArray keywords = (JsonArray) result.get("keywords");
        String[] keywordsArray = new String[keywords.size()];
        for (int i = 0; i < keywords.size(); i++){
            keywordsArray[i] = keywords.get(i).getAsString();
        }

        return card;
    }

}
