package com.builder.deckbuilder.model;

public class Deck {

    private int deckId;
    private int userId;

    public Deck(){};

    public Deck(int deckId, int userId){
        this.deckId = deckId;
        this.userId = userId;
    }

    public int getDeckId() {
        return deckId;
    }

    public void setDeckId(int deckId) {
        this.deckId = deckId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
