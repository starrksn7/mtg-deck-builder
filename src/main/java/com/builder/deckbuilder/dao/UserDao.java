package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.User;
import java.util.List;
public interface UserDao {

    int findIdByUsername(String username);

    int createUser(String username, String password);

    User findByUsername(String username);

    List<User> listAllUsers();
}
