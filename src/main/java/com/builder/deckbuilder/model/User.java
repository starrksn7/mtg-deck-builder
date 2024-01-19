package com.builder.deckbuilder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class User {

    private int id;
    private String email;
    private String userName;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private boolean active;
    private Set<Authority> authorities = new HashSet<>();


    public User(int id, String email, String userName, String password, String authorities){
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.password = password;
        if(authorities != null){
            this.setAuthorities(authorities);
        }
        this.active = true;
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

    public Set<Authority> getAuthority() {
        return authorities;
    }

    public void setAuthority(Set<Authority> authority) {
        this.authorities = authority;
    }

    public void setAuthorities(String authorities){
        String[] roles = authorities.split(",");
        for(String role : roles){
            String authority = role.contains("ROLE_") ? role : "ROLE_" + role;
            this.authorities.add(new Authority(authority));
        }
    }
}
