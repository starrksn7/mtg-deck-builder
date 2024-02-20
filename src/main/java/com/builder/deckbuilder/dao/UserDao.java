package com.builder.deckbuilder.dao;

import com.builder.deckbuilder.model.Authority;
import com.builder.deckbuilder.model.User;
import com.builder.deckbuilder.model.UserDTO;

import java.util.Set;

public interface UserDao {

    User updateUserProfile(int userId, UserDTO updatedUser);

    User findUserByEmail(String email);

    boolean create(String email, String userName, String password, Set<Authority> authorities);

}
