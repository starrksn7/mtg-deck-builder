package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.User;
import com.builder.deckbuilder.model.UserDTO;

public interface UserDao {

    User updateUserProfile(int userId, UserDTO updatedUser);

    User findUserByEmail(String email);

    boolean create(String email, String password, String role);

    User findUserByUsername(String userName);
}
