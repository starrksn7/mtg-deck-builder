package com.builder.deckbuilder.model;

public class Card {

    private int cardId;
    private int deckId;
    private String cardName;
    private String scryfallLink;
    private String imageLink;
    private String manaCost;
    private String cmc;
    private String cardType;
    private String oracleText;
    private String colors;
    private String colorIdentity;
    private String keywords;
    private boolean legal;

    public Card(){};

    public Card(int cardId, int deckId, String cardName, String scryfallLink, String imageLink, String manaCost, String cmc, String cardType, String oracleText, String colors, String colorIdentity, String keywords, boolean legal){
        this.cardId = cardId;
        this.deckId = deckId;
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
        this.legal = legal;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getDeckId() {
        return deckId;
    }

    public void setDeckId(int deckId) {
        this.deckId = deckId;
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

    public String getCmc() {
        return cmc;
    }

    public void setCmc(String cmc) {
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

    public boolean isLegal() {
        return legal;
    }

    public void setLegal(boolean legal) {
        this.legal = legal;
    }
}
