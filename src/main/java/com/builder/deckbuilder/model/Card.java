package com.builder.deckbuilder.model;

public class Card {

    private String name;
    private String scryfallURL;
    private String image;
    private String manaCost;
    private String type;
    private String oracleText;
    private String[] colors;
    private String[] colorIdentity;
    private String[] keywords;

    public Card (String name, String scryfallURL, String image, String manaCost, String type, String oracleText, String[] colors, String[] colorIdentity, String[] keywords){
        this.name = name;
        this.scryfallURL = scryfallURL;
        this.image = image;
        this.manaCost = manaCost;
        this.type = type;
        this.oracleText = oracleText;
        this.colors = colors;
        this.colorIdentity = colorIdentity;
        this.keywords = keywords;
    }

    public Card(){

    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScryfallURL() {
        return scryfallURL;
    }

    public void setScryfallURL(String scryfallURL) {
        this.scryfallURL = scryfallURL;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOracleText() {
        return oracleText;
    }

    public void setOracleText(String oracleText) {
        this.oracleText = oracleText;
    }

    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public String[] getColorIdentity() {
        return colorIdentity;
    }

    public void setColorIdentity(String[] colorIdentity) {
        this.colorIdentity = colorIdentity;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }
}
