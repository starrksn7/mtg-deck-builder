package com.builder.deckbuilder.model;

public class Deck {

    private int deckId;
    private int userId;
    private String commander;

    public Deck(){};

    public Deck(int deckId, int userId, String commander){
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

    public String getCommander(){
        return commander;
    }

    public void setCommander(String commander){
        this.commander = commander;
    }
}
