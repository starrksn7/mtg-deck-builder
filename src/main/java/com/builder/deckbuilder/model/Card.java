package com.builder.deckbuilder.model;

public class Card {
    private int id;
    private String name;
    private String scryfallURL;
    private String imageLink;
    private String manaCost;
    private String type;
    private String oracleText;
    private String[] colors;
    private String[] colorIdentity;
    private String[] keywords;

    public Card (int id, String name, String scryfallURL, String imageLink, String manaCost, String type, String oracleText, String[] colors, String[] colorIdentity, String[] keywords){
        this.id = id;
        this.name = name;
        this.scryfallURL = scryfallURL;
        this.imageLink = imageLink;
        this.manaCost = manaCost;
        this.type = type;
        this.oracleText = oracleText;
        this.colors = colors;
        this.colorIdentity = colorIdentity;
        this.keywords = keywords;
    }

    public Card(){
    };

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

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

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String image) {
        this.imageLink = imageLink;
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
