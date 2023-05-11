package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.User;
import java.util.List;
public interface UserDao {

    int findIdByUsername(String username);

    boolean createUser(String username, String password);

    List<User> listAllUsers();
}
