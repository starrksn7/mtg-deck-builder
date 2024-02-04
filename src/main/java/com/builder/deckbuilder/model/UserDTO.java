package com.builder.deckbuilder.model;

public class UserDTO {
    private int userId;
    private String email;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UpdateUserProfileDTO{" +
                "email='" + email + '\'' +
                '}';
    }
}
