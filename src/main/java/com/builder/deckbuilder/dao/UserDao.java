package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.User;
import com.builder.deckbuilder.model.UserDTO;

public interface UserDao {

    User updateUserProfile(int userId, UserDTO updatedUser);

    User findUserByEmail(String email);

    User getUserById(int userId);

    boolean create(String email, String userName, String password);

}
