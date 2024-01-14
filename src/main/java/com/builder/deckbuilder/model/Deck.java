package com.builder.deckbuilder.model;

public class Deck {

    private int deckId;
    private String deckName;

    public Deck(int deckId, String deckName){
        this.deckId = deckId;
        this.deckName = deckName;
    }

    public Deck(){
    }
    public int getDeckId() {
        return deckId;
    }

    public void setDeckId(int deckId) {
        this.deckId = deckId;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }
}
