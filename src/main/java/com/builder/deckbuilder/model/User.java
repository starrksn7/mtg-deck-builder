package com.builder.deckbuilder.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
public class User {

    private int userId;
    private String username;
    private String password;
    private Set<Authority> authorities = new HashSet<>();

    public User() {}

    public User(int userId, String username, String password, String authorities) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public void setAuthorities(String authorities){
        String[] roles = authorities.split(",");
        for(String role : roles) {
            this.authorities.add(new Authority("ROLE_" + role));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(authorities, user.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, authorities);
    }

    @Override
    public String toString(){
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", authorities=" + authorities + "}";
    }
}
