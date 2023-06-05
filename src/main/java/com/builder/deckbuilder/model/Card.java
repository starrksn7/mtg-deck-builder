package com.builder.deckbuilder.model;

public class Card {

    private int cardId;
    private String cardName;
    private String scryfallLink;
    private String imageLink;
    private String manaCost;
    private Double cmc;
    private String cardType;
    private String oracleText;
    private String colors;
    private String colorIdentity;
    private String keywords;


    public Card(){};

    public Card(int cardId, String cardName, String scryfallLink, String imageLink, String manaCost, Double cmc, String cardType,
                String oracleText, String colors, String colorIdentity, String keywords){
        this.cardId = cardId;
        this.cardName = cardName;
        this.scryfallLink = scryfallLink;
        this.imageLink = imageLink;
        this.manaCost = manaCost;
        this.cmc = cmc;
        this.cardType = cardType;
        this.oracleText = oracleText;
        this.colors = colors;
        this.colorIdentity = colorIdentity;
        this.keywords = keywords;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getScryfallLink() {
        return scryfallLink;
    }

    public void setScryfallLink(String scryfallLink) {
        this.scryfallLink = scryfallLink;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    public Double getCmc() {
        return cmc;
    }

    public void setCmc(Double cmc) {
        this.cmc = cmc;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getOracleText() {
        return oracleText;
    }

    public void setOracleText(String oracleText) {
        this.oracleText = oracleText;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getColorIdentity() {
        return colorIdentity;
    }

    public void setColorIdentity(String colorIdentity) {
        this.colorIdentity = colorIdentity;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
