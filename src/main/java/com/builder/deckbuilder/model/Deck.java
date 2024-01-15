package com.builder.deckbuilder.model;

public class Deck {

    private int id;
    private String deckName;

    public Deck(int deckId, String deckName){
        this.id = deckId;
        this.deckName = deckName;
    }

    public Deck(){
    }
    public int getDeckId() {
        return id;
    }

    public void setDeckId(int deckId) {
        this.id = deckId;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }
}
