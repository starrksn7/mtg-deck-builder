package com.builder.deckbuilder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

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
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                active == user.active &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(authorities, user.authorities);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, email, password, active, authorities);
    }

    @Override
    public String toString(){
        return "User{id + " + id
                + ", email= " + email
                + ", userName=  " + userName
                + ", active= " + active
                + ", authorities= " + authorities
                + "}";
    }
}
