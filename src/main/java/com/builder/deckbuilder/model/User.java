package com.builder.deckbuilder.model;

public class User {

    private int id;
    private String email;
    private String userName;
    private String password;
    private boolean active;

    public User(int id, String email, String userName, String password, boolean active){
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.active = active;
    }

    public User(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
