package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.User;

public interface UserDao {

    User findByUsername(String username);

    boolean create(String username, String password);
}
